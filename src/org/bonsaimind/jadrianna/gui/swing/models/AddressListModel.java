package org.bonsaimind.jadrianna.gui.swing.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import ezvcard.property.Address;

public class AddressListModel implements ListModel<Address> {
	
	private List<Address> addresses = new ArrayList<Address>();
	private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();
	
	public AddressListModel() {
		super();
	}
	
	@Override
	public void addListDataListener(ListDataListener l) {
		dataListeners.add(l);
	}
	
	@Override
	public Address getElementAt(int index) {
		return addresses.get(index);
	}
	
	@Override
	public int getSize() {
		return addresses.size();
	}
	
	@Override
	public void removeListDataListener(ListDataListener l) {
		dataListeners.remove(l);
	}
	
	public void setAddresses(Collection<Address> addresses) {
		this.addresses.clear();
		this.addresses.addAll(addresses);
	}
}
