package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

public class Overview extends JPanel {
	
	public Overview() {
		super(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
		
		topPanel.add(new JLabel("Directory"));
		topPanel.add(Box.createHorizontalBox());
		topPanel.add(new JTextField(10));
		topPanel.add(new JButton("Browse..."));
		
		add(topPanel, BorderLayout.NORTH);
		
		JTree tree = new JTree();
		add(tree, BorderLayout.CENTER);
		
		validate();
	}
}
