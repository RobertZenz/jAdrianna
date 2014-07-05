package org.bonsaimind.jadrianna.gui.swing;

import ezvcard.VCard;

public interface DisplayComponent {
	
	public void setFromCard(VCard card);
	
	public void setToCard(VCard card);
}
