package mju_Swing;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PEditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public PEditMenu() {
		this.setText(Constants.EMenuBar.EDIT.getText());
		
		JMenuItem copyItem = new JMenuItem(Constants.EEditMenu.COPY.getText());
		this.add(copyItem);
		JMenuItem cutItem = new JMenuItem(Constants.EEditMenu.CUT.getText());
		this.add(cutItem);
		JMenuItem pasteItem = new JMenuItem(Constants.EEditMenu.PASTE.getText());
		this.add(pasteItem);
		JMenuItem deleteItem = new JMenuItem(Constants.EEditMenu.DELETE.getText());
		this.add(deleteItem);
	}

}
