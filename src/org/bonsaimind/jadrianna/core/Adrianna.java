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
	
	public Adrianna(File baseDirectory) {
		this.baseDirectory = baseDirectory;
	}
	
	public void createChildren(String name) {
		File child = new File(baseDirectory, name);
		
		if (!child.exists()) {
			child.mkdir();
		}
	}
	
	public List<Adrianna> getChildren() {
		List<Adrianna> children = new ArrayList<Adrianna>();
		
		for (File child : baseDirectory.listFiles()) {
			if (child.isDirectory()) {
				Adrianna adrianna = new Adrianna(child);
				children.add(adrianna);
			}
		}
		
		return children;
	}
	
	public List<VCard> getCards() {
		List<VCard> cards = new ArrayList<VCard>();
		
		for (File child : baseDirectory.listFiles()) {
			if (child.isFile()) {
				try {
					VCard card = Ezvcard.parse(child).first();
					cards.add(card);
				} catch (IOException e) {
					LOGGER.log(Level.WARNING, "Could not read from file " + child.getAbsolutePath(), e);
				}
			}
		}
		
		return cards;
	}
	
	public void saveCard(VCard card) {
		
	}
}
