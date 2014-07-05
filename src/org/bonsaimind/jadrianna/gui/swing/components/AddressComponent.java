package org.bonsaimind.jadrianna.gui.swing.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bonsaimind.jadrianna.gui.swing.DisplayComponent;

import ezvcard.VCard;

public class AddressComponent extends JPanel implements DisplayComponent {
	
	private JTextField countryField;
	private JTextField extendedAddressField;
	private JTextField localityField;
	private JTextField postalCodeField;
	private JTextField postOfficeBoxField;
	private JTextField regionField;
	private JTextField streetAddressField;
	
	public AddressComponent() {
		super();
	}
	
	@Override
	public void setFromCard(VCard card) {
		if (card == null) {
			return;
		}
		
	}
	
	@Override
	public void setToCard(VCard card) {
		
	}
	
}
