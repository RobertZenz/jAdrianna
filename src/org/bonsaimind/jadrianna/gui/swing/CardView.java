package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.bonsaimind.jadrianna.core.VCardOnDisk;
import org.bonsaimind.jadrianna.gui.swing.components.NameComponent;

public class CardView extends JPanel {
	
	private VCardOnDisk cardOnDisk;
	private List<DisplayComponent> displayComponents = new ArrayList<DisplayComponent>();
	
	public CardView() {
		super(new BorderLayout());
		
		NameComponent name = new NameComponent();
		displayComponents.add(name);
		add(name, BorderLayout.CENTER);
	}
	
	public VCardOnDisk getCardOnDisk() {
		return cardOnDisk;
	}
	
	public void setCardOnDisk(VCardOnDisk cardOnDisk) {
		this.cardOnDisk = cardOnDisk;
		
		if (cardOnDisk != null) {
			for (DisplayComponent displayComponent : displayComponents) {
				displayComponent.setFromCard(cardOnDisk.getCard());
			}
		} else {
			for (DisplayComponent displayComponent : displayComponents) {
				displayComponent.setFromCard(null);
			}
		}
	}
	
}
