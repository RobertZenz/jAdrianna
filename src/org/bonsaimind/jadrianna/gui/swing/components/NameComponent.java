package org.bonsaimind.jadrianna.gui.swing.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bonsaimind.jadrianna.gui.swing.DisplayComponent;

import ezvcard.VCard;
import ezvcard.property.StructuredName;

public class NameComponent extends JPanel implements DisplayComponent {
	
	private JTextField additionalNamesField;
	private JTextField familyNameField;
	private JTextField givenNameField;
	private JTextField honoricPrefixesField;
	private JTextField honoricSuffixesField;
	
	public NameComponent() {
		super(new BorderLayout());
		
		JPanel panel = new JPanel(new GridLayout(2, 5));
		panel.setBorder(BorderFactory.createTitledBorder("Name"));
		
		panel.add(new JLabel("Honoric Prefixes"));
		panel.add(new JLabel("Family Name"));
		panel.add(new JLabel("Name"));
		panel.add(new JLabel("Additional Names"));
		panel.add(new JLabel("Honoric Suffixes"));
		
		honoricPrefixesField = new JTextField(5);
		panel.add(honoricPrefixesField);
		
		familyNameField = new JTextField(15);
		panel.add(familyNameField);
		
		givenNameField = new JTextField(10);
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
		
		additionalNamesField.setText("");
		familyNameField.setText(name.getFamily());
		givenNameField.setText(name.getGiven());
		honoricPrefixesField.setText("");
		honoricSuffixesField.setText("");
	}
	
	@Override
	public void setToCard(VCard card) {
		// TODO Auto-generated method stub
		
	}
	
}
