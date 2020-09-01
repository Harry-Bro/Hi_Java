package mju_Swing;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PFileMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public PFileMenu() {
		// set attribute
		this.setText(Constants.EMenuBar.FILE.getText());
		
		// create and register components
		JMenuItem newItem = new JMenuItem(Constants.EFileMenu.NEW.getText());
		this.add(newItem);
		JMenuItem openItem = new JMenuItem(Constants.EFileMenu.OPEN.getText());
		this.add(openItem);
		JMenuItem saveItem = new JMenuItem(Constants.EFileMenu.SAVE.getText());
		this.add(saveItem);
		JMenuItem SaveAsItem = new JMenuItem(Constants.EFileMenu.SaveAs.getText());
		this.add(SaveAsItem);
		JMenuItem printItem = new JMenuItem(Constants.EFileMenu.PRINT.getText());
		this.add(printItem);
		JMenuItem ExitItem = new JMenuItem(Constants.EFileMenu.EXIT.getText());
		this.add(ExitItem);
		
	}

}