package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;

import org.bonsaimind.jadrianna.core.Adrianna;
import org.bonsaimind.jadrianna.core.VCardOnDisk;
import org.bonsaimind.jadrianna.gui.swing.models.AdriannaTreeModel;

public class Overview extends JPanel {
	
	private Adrianna adrianna;
	private JButton browseButton;
	private AdriannaTreeModel model;
	private JTextField pathField;
	private List<OverviewSelectionListener> selectionListeners = new ArrayList<OverviewSelectionListener>();
	
	public Overview(Adrianna adrianna) {
		super(new BorderLayout());
		
		this.adrianna = adrianna;
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
		
		topPanel.add(new JLabel("Directory"));
		topPanel.add(Box.createHorizontalBox());
		pathField = new JTextField(adrianna.getBaseDirectory().getAbsolutePath(), 10);
		topPanel.add(pathField);
		browseButton = new JButton("Browse...");
		topPanel.add(browseButton);
		
		add(topPanel, BorderLayout.NORTH);
		
		model = new AdriannaTreeModel(adrianna);
		
		final JTree tree = new JTree(model);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				Object selectedComponent = e.getNewLeadSelectionPath().getLastPathComponent();
				
				if (selectedComponent instanceof VCardOnDisk) {
					VCardOnDisk selectedCard = (VCardOnDisk) selectedComponent;
					
					for (OverviewSelectionListener listener : selectionListeners) {
						listener.cardChanged(selectedCard);
					}
				} else {
					for (OverviewSelectionListener listener : selectionListeners) {
						listener.cardChanged(null);
					}
				}
			}
		});
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// Nothing to do.
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// Nothing to do.
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// Nothing to do.
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// Nothing to do.
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Object selectedComponent = tree.getSelectionPath().getLastPathComponent();
					
					if (selectedComponent instanceof VCardOnDisk) {
						CardFrame cardFrame = new CardFrame();
						cardFrame.setCardOnDisk((VCardOnDisk) selectedComponent);
						cardFrame.setVisible(true);
					}
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(tree);
		
		add(scrollPane, BorderLayout.CENTER);
		
		validate();
	}
	
	public void addSelectionListener(OverviewSelectionListener listener) {
		selectionListeners.add(listener);
	}
	
	public void removeSelectionListener(OverviewSelectionListener listener) {
		selectionListeners.remove(listener);
	}
}
