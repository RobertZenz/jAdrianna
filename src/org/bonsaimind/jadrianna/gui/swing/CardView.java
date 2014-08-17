package org.bonsaimind.jadrianna.gui.swing;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.bonsaimind.jadrianna.core.Adrianna;
import org.bonsaimind.jadrianna.core.VCardOnDisk;
import org.bonsaimind.jadrianna.gui.swing.components.AddressComponent;
import org.bonsaimind.jadrianna.gui.swing.components.NameComponent;

import ezvcard.VCard;

public class CardView extends JPanel implements DisplayComponentChangeListener {
	
	private static final Logger LOGGER = Logger.getLogger(Adrianna.class.getName());
	
	private VCardOnDisk cardOnDisk;
	private List<DisplayComponent> displayComponents = new ArrayList<DisplayComponent>();
	private JButton toolbarSave;
	private JButton toolbarRefresh;
	
	public CardView() {
		super(new BorderLayout());
		
		JToolBar toolbar = new JToolBar();
		
		toolbarRefresh = new JButton("Refresh");
		toolbarRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (cardOnDisk != null) {
					refreshDisplay(cardOnDisk.getCard());
				}
			}
		});
		toolbar.add(toolbarRefresh);
		
		toolbarSave = new JButton("Save");
		toolbarSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (cardOnDisk != null) {
					for (DisplayComponent displayComponent : displayComponents) {
						displayComponent.setToCard(cardOnDisk.getCard());
					}
					
					try {
						cardOnDisk.writeToDisk();
					} catch (IOException e) {
						LOGGER.log(Level.SEVERE, "Failed to write card to disk.", e);
					}
					
					refreshDisplay(cardOnDisk.getCard());
				}
			}
		});
		toolbar.add(toolbarSave);
		
		add(toolbar, BorderLayout.PAGE_START);
		
		Panel innerPanel = new Panel(new BorderLayout());
		
		NameComponent name = new NameComponent();
		name.setChangeListener(this);
		displayComponents.add(name);
		innerPanel.add(name, BorderLayout.NORTH);
		
		AddressComponent address = new AddressComponent();
		name.setChangeListener(this);
		displayComponents.add(address);
		innerPanel.add(address, BorderLayout.CENTER);
		
		add(innerPanel, BorderLayout.CENTER);
	}
	
	public VCardOnDisk getCardOnDisk() {
		return cardOnDisk;
	}
	
	public void setCardOnDisk(VCardOnDisk cardOnDisk) {
		this.cardOnDisk = cardOnDisk;
		
		if (cardOnDisk != null) {
			refreshDisplay(cardOnDisk.getCard());
		} else {
			refreshDisplay(null);
		}
	}
	
	private void refreshDisplay(VCard vcard) {
		if (vcard != null) {
			try {
				cardOnDisk.readFromDisk();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Failed to read card from disk.", e);
			}
		}
		
		for (DisplayComponent displayComponent : displayComponents) {
			displayComponent.setFromCard(vcard);
		}
		
		toolbarSave.setEnabled(false);
	}
	
	@Override
	public void change() {
		toolbarSave.setEnabled(true);
	}
}
