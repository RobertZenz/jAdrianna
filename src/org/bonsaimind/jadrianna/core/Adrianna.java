package org.bonsaimind.jadrianna.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ezvcard.Ezvcard;
import ezvcard.VCard;

public class Adrianna {
	
	private static final Logger LOGGER = Logger.getLogger(Adrianna.class.getName());
	
	private File baseDirectory;
	private List<VCardOnDisk> cards = new ArrayList<VCardOnDisk>();
	private List<Adrianna> children = new ArrayList<Adrianna>();
	
	public Adrianna(File baseDirectory) {
		this.baseDirectory = baseDirectory;
	}
	
	public void createChildren(String name) {
		File child = new File(baseDirectory, name);
		
		if (!child.exists()) {
			child.mkdir();
		}
	}
	
	public File getBaseDirectory() {
		return baseDirectory;
	}
	
	public List<Adrianna> getChildren() {
		if (children.isEmpty()) {
			readChildren();
		}
		
		return children;
	}
	
	public List<VCardOnDisk> getCards() {
		if (cards.isEmpty()) {
			readCards();
		}
		
		return cards;
	}
	
	public void saveCard(VCard card, String filename) {
		File file = new File(baseDirectory, filename);
		
		try {
			card.write(file);
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Could not write to file " + file.getAbsolutePath(), e);
		}
	}
	
	@Override
	public String toString() {
		return baseDirectory.getName();
	}
	
	private void readCards() {
		cards.clear();
		
		for (File child : baseDirectory.listFiles()) {
			if (child.isFile() && child.getName().endsWith(".vcard")) {
				try {
					VCard card = Ezvcard.parse(child).first();
					VCardOnDisk cardOnDisk = new VCardOnDisk(card, child);
					cards.add(cardOnDisk);
				} catch (IOException e) {
					LOGGER.log(Level.WARNING, "Could not read from file " + child.getAbsolutePath(), e);
				}
			}
		}
	}
	
	private void readChildren() {
		children.clear();
		
		for (File child : baseDirectory.listFiles()) {
			if (child.isDirectory()) {
				Adrianna adrianna = new Adrianna(child);
				children.add(adrianna);
			}
		}
	}
}
