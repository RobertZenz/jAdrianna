package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.bonsaimind.jadrianna.core.Adrianna;
import org.bonsaimind.jadrianna.core.VCardOnDisk;

public class MainFrame extends JFrame {
	
	private CardView cardView;
	private Overview overview;
	
	public MainFrame() throws HeadlessException {
		super();
		
		setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		overview = new Overview(new Adrianna(new File("/home/robert/Documents/Contacts/")));
		overview.addSelectionListener(new OverviewSelectionListener() {
			
			@Override
			public void cardChanged(VCardOnDisk cardOnDisk) {
				cardView.setCardOnDisk(cardOnDisk);
			}
		});
		splitPane.setLeftComponent(overview);
		
		cardView = new CardView();
		splitPane.setRightComponent(cardView);
		
		add(splitPane, BorderLayout.CENTER);
		
		validate();
		pack();
	}
}
