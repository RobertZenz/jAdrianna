package org.bonsaimind.jadrianna.gui.swing.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.bonsaimind.jadrianna.gui.swing.DisplayComponent;
import org.bonsaimind.jadrianna.gui.swing.models.AddressListCellRenderer;
import org.bonsaimind.jadrianna.gui.swing.models.AddressListModel;

import ezvcard.VCard;
import ezvcard.property.Address;

public class AddressComponent extends JPanel implements DisplayComponent {
	
	private JList<Address> addressList;
	private AddressListModel addressListModel;
	private JTextField countryField;
	private JTextField extendedAddressField;
	private JTextField localityField;
	private JTextField postalCodeField;
	private JTextField postOfficeBoxField;
	private JTextField regionField;
	private JTextField streetAddressField;
	
	public AddressComponent() {
		super(new BorderLayout());
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Addresses"));
		
		JSplitPane splitPane = new JSplitPane();
		
		addressListModel = new AddressListModel();
		
		addressList = new JList<Address>(addressListModel);
		addressList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				setFromAddress(addressList.getSelectedValue());
			}
		});
		addressList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addressList.setCellRenderer(new AddressListCellRenderer());
		splitPane.setLeftComponent(addressList);
		
		JPanel detailPanel = new JPanel(new GridLayout(14, 1));
		
		detailPanel.add(new JLabel("Post Office Box"));
		
		postOfficeBoxField = new JTextField(5);
		detailPanel.add(postOfficeBoxField);
		
		detailPanel.add(new JLabel("Extended Address"));
		
		extendedAddressField = new JTextField(5);
		detailPanel.add(extendedAddressField);
		
		detailPanel.add(new JLabel("Street"));
		
		streetAddressField = new JTextField(15);
		detailPanel.add(streetAddressField);
		
		detailPanel.add(new JLabel("Locality"));
		
		localityField = new JTextField(5);
		detailPanel.add(localityField);
		
		detailPanel.add(new JLabel("Region"));
		
		regionField = new JTextField(5);
		detailPanel.add(regionField);
		
		detailPanel.add(new JLabel("Postal Code"));
		
		postalCodeField = new JTextField(5);
		detailPanel.add(postalCodeField);
		
		detailPanel.add(new JLabel("Country"));
		
		countryField = new JTextField(5);
		detailPanel.add(countryField);
		
		splitPane.setRightComponent(detailPanel);
		
		panel.add(splitPane, BorderLayout.CENTER);
		
		add(panel, BorderLayout.CENTER);
	}
	
	@Override
	public void setFromCard(VCard card) {
		addressList.removeAll();
		
		if (card == null) {
			return;
		}
		
		if (card.getAddresses() == null) {
			return;
		}
		
		addressListModel.setAddresses(card.getAddresses());
		addressList.updateUI();
	}
	
	@Override
	public void setToCard(VCard card) {
		
	}
	
	private void setFromAddress(Address address) {
		countryField.setText("");
		extendedAddressField.setText("");
		localityField.setText("");
		postalCodeField.setText("");
		postOfficeBoxField.setText("");
		regionField.setText("");
		streetAddressField.setText("");
		
		if (address == null) {
			return;
		}
		
		countryField.setText(address.getCountry());
		extendedAddressField.setText(address.getExtendedAddress());
		localityField.setText(address.getLocality());
		postalCodeField.setText(address.getPostalCode());
		postOfficeBoxField.setText(address.getPoBox());
		regionField.setText(address.getRegion());
		streetAddressField.setText(address.getStreetAddress());
	}
}
