package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.bonsaimind.jadrianna.core.VCardOnDisk;

public class CardFrame extends JFrame {
	
	private CardView cardView;
	
	public CardFrame() throws HeadlessException {
		super("Card");
		
		setLayout(new BorderLayout());
		
		cardView = new CardView();
		add(cardView, BorderLayout.CENTER);
		
		pack();
	}
	
	public VCardOnDisk getCardOnDisk() {
		return cardView.getCardOnDisk();
	}
	
	public void setCardOnDisk(VCardOnDisk cardOnDisk) {
		cardView.setCardOnDisk(cardOnDisk);
		
		if (cardOnDisk != null && cardOnDisk.getCard() != null) {
			setTitle(cardOnDisk.getCard().getFormattedName().getValue());
		}
	}
}
