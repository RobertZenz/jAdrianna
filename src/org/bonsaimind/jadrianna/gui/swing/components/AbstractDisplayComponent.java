package org.bonsaimind.jadrianna.gui.swing.components;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.bonsaimind.jadrianna.gui.swing.DisplayComponent;
import org.bonsaimind.jadrianna.gui.swing.DisplayComponentChangeListener;

public abstract class AbstractDisplayComponent extends JPanel implements DisplayComponent {
	
	protected DisplayComponentChangeListener changeListener;
	
	public AbstractDisplayComponent(LayoutManager layout) {
		super(layout);
	}
	
	public void fireChange() {
		if (changeListener != null) {
			changeListener.change();
		}
	}
	
	public void monitorChange(JTextField textField) {
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				fireChange();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				fireChange();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				fireChange();
			}
		});
	}
	
	@Override
	public void setChangeListener(DisplayComponentChangeListener changeListener) {
		this.changeListener = changeListener;
	}
	
}
