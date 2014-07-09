package org.bonsaimind.jadrianna.gui.swing.models;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import ezvcard.property.Address;

public class AddressListCellRenderer extends DefaultListCellRenderer {
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		setText(((Address) value).getLabel());
		
		return this;
	}
	
}
