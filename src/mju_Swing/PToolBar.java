package mju_Swing;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class PToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	public PToolBar() {
				
		for(Constants.ETOOLBAR toolBar : Constants.ETOOLBAR.values()) {
			String toolBarName = toolBar.getText();
			JButton btnToolBar = new JButton(toolBarName);
			ImageIcon icon = new ImageIcon(getClass().getResource("images/" + toolBarName + ".png"));
			btnToolBar.setIcon(icon);
			this.add(btnToolBar);
		}
		
	}
	
}
