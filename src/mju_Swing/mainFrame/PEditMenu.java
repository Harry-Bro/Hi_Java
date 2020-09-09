package mju_Swing.mainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import mju_Swing.constants.Constants;

public class PEditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public PEditMenu() {
		this.setText(Constants.EMenuBar.EDIT.getText());
		
		for(Constants.EEditMenu eFileMenu: Constants.EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eFileMenu.getText());
			this.add(menuItem);
		}
	}

}
