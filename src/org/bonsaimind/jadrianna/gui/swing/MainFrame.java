package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	
	public MainFrame() throws HeadlessException {
		super();
		
		setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(new Overview());
		splitPane.setRightComponent(new CardView());
		
		add(splitPane, BorderLayout.CENTER);
		
		validate();
		pack();
	}
}
