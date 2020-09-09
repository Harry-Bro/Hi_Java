package mju_Swing.mainFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import mju_Swing.constants.Constants;

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
