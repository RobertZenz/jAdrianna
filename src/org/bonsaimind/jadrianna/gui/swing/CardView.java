package org.bonsaimind.jadrianna.gui.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.bonsaimind.jadrianna.core.VCardOnDisk;
import org.bonsaimind.jadrianna.gui.swing.components.AddressComponent;
import org.bonsaimind.jadrianna.gui.swing.components.NameComponent;

public class CardView extends JPanel {
	
	private VCardOnDisk cardOnDisk;
	private List<DisplayComponent> displayComponents = new ArrayList<DisplayComponent>();
	
	public CardView() {
		super(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		NameComponent name = new NameComponent();
		displayComponents.add(name);
		add(name, constraints);
		
		constraints.gridy = 1;
		
		AddressComponent address = new AddressComponent();
		displayComponents.add(address);
		add(address, constraints);
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
