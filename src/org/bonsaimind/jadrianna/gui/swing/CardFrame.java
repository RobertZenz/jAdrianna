package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.bonsaimind.jadrianna.core.VCardOnDisk;

import ezvcard.VCard;
import ezvcard.property.FormattedName;

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
		
		if (cardOnDisk != null) {
			VCard card = cardOnDisk.getCard();
			
			if (cardOnDisk.getCard() != null) {
				FormattedName name = card.getFormattedName();
				
				if (name != null) {
					setTitle(name.getValue());
				}
			}
		}
	}
}
