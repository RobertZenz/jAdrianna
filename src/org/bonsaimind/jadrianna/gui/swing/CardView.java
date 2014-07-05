package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardView extends JPanel {
	
	public CardView() {
		super(new BorderLayout());
		
		add(new JLabel("Card goes here"), BorderLayout.CENTER);
	}
}
