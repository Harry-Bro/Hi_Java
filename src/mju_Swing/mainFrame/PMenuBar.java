package mju_Swing.mainFrame;

import javax.swing.JMenuBar;

public class PMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private PFileMenu pFileMenu;
	private PEditMenu pEditMenu;
	
	public PMenuBar() {
		// create and register components
		pFileMenu = new PFileMenu();
		this.add(pFileMenu);
		pEditMenu = new PEditMenu();
		this.add(pEditMenu);
	}
	
}
