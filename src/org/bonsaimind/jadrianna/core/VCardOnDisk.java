package org.bonsaimind.jadrianna.core;

import java.io.File;

import ezvcard.VCard;

public class VCardOnDisk {
	
	private VCard card;
	private File file;
	
	public VCardOnDisk(VCard card, File file) {
		super();
		this.card = card;
		this.file = file;
	}
	
	public VCard getCard() {
		return card;
	}
	
	public File getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		return file.getName();
	}
}
