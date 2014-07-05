package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.bonsaimind.jadrianna.core.Adrianna;

public class MainFrame extends JFrame {
	
	public MainFrame() throws HeadlessException {
		super();
		
		setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(new Overview(new Adrianna(new File("/home/robert/Documents/Contacts/"))));
		splitPane.setRightComponent(new CardView());
		
		add(splitPane, BorderLayout.CENTER);
		
		validate();
		pack();
	}
}
