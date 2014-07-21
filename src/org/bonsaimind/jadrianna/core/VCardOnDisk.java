package org.bonsaimind.jadrianna.core;

import java.io.File;
import java.io.IOException;

import ezvcard.Ezvcard;
import ezvcard.VCard;

public class VCardOnDisk {
	
	private VCard card;
	private File file;
	
	public VCardOnDisk(File file) {
		super();
		
		this.card = new VCard();
		this.file = file;
	}
	
	public VCard getCard() {
		return card;
	}
	
	public File getFile() {
		return file;
	}
	
	public void readFromDisk() throws IOException {
		card = Ezvcard.parse(file).first();
	}
	
	@Override
	public String toString() {
		return file.getName();
	}
	
	public void writeToDisk() throws IOException {
		Ezvcard.write(card).go(file);
	}
}
