package org.bonsaimind.jadrianna.gui.swing.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ezvcard.VCard;
import ezvcard.property.StructuredName;

public class NameComponent extends AbstractDisplayComponent {
	
	private JTextField additionalNamesField;
	private JTextField familyNameField;
	private JTextField givenNameField;
	private JTextField honoricPrefixesField;
	private JTextField honoricSuffixesField;
	
	public NameComponent() {
		super(new BorderLayout());
		
		setBorder(BorderFactory.createTitledBorder("Name"));
		
		JPanel panel = new JPanel(new GridLayout(2, 5));
		
		panel.add(new JLabel("Honoric Prefixes"));
		panel.add(new JLabel("Family Name"));
		panel.add(new JLabel("Name"));
		panel.add(new JLabel("Additional Names"));
		panel.add(new JLabel("Honoric Suffixes"));
		
		honoricPrefixesField = new JTextField(5);
		panel.add(honoricPrefixesField);
		
		familyNameField = new JTextField(15);
		monitorChange(familyNameField);
		panel.add(familyNameField);
		
		givenNameField = new JTextField(10);
		monitorChange(givenNameField);
		panel.add(givenNameField);
		
		additionalNamesField = new JTextField(10);
		panel.add(additionalNamesField);
		
		honoricSuffixesField = new JTextField(5);
		panel.add(honoricSuffixesField);
		
		add(panel, BorderLayout.CENTER);
	}
	
	@Override
	public void setFromCard(VCard card) {
		additionalNamesField.setText("");
		familyNameField.setText("");
		givenNameField.setText("");
		honoricPrefixesField.setText("");
		honoricSuffixesField.setText("");
		
		if (card == null) {
			return;
		}
		
		StructuredName name = card.getStructuredName();
		
		if (name == null) {
			return;
		}
		
		familyNameField.setText(name.getFamily());
		givenNameField.setText(name.getGiven());
	}
	
	@Override
	public void setToCard(VCard card) {
		StructuredName name = card.getStructuredName();
		
		if (name == null) {
			name = new StructuredName();
		}
		
		name.setFamily(familyNameField.getText());
		name.setGiven(givenNameField.getText());
		
		card.setStructuredName(name);
	}
}
