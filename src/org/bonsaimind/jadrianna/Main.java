package org.bonsaimind.jadrianna;

import javax.swing.WindowConstants;

import org.bonsaimind.jadrianna.gui.swing.MainFrame;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
}
