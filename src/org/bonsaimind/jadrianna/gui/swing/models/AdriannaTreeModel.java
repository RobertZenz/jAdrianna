package org.bonsaimind.jadrianna.gui.swing.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.bonsaimind.jadrianna.core.Adrianna;
import org.bonsaimind.jadrianna.core.VCardOnDisk;

public class AdriannaTreeModel implements TreeModel {
	
	private Adrianna adrianna;
	private List<TreeModelListener> listeners = new ArrayList<TreeModelListener>();
	
	public AdriannaTreeModel(Adrianna adrianna) {
		this.adrianna = adrianna;
	}
	
	@Override
	public Object getRoot() {
		return adrianna;
	}
	
	@Override
	public Object getChild(Object parent, int index) {
		if (parent instanceof Adrianna) {
			Adrianna parentAdrianna = (Adrianna) parent;
			
			if (index < parentAdrianna.getChildren().size()) {
				return parentAdrianna.getChildren().get(index);
			}
			
			return parentAdrianna.getCards().get(index - parentAdrianna.getChildren().size());
		}
		
		return null;
	}
	
	@Override
	public int getChildCount(Object parent) {
		if (parent instanceof Adrianna) {
			Adrianna parentAdrianna = (Adrianna) parent;
			return parentAdrianna.getChildren().size() + parentAdrianna.getCards().size();
		}
		
		return 0;
	}
	
	@Override
	public boolean isLeaf(Object node) {
		return node instanceof VCardOnDisk;
	}
	
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent instanceof Adrianna) {
			Adrianna parentAdrianna = (Adrianna) parent;
			
			if (child instanceof Adrianna) {
				return parentAdrianna.getChildren().indexOf(child);
			} else if (child instanceof VCardOnDisk) {
				int idx = parentAdrianna.getCards().indexOf(child);
				if (idx > -1) {
					return parentAdrianna.getChildren().size() + idx;
				}
			}
		}
		
		return -1;
	}
	
	@Override
	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
	}
	
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}
}
