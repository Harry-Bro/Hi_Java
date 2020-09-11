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
			System.out.println(toolBarName);
			ImageIcon icon = new ImageIcon("images/" + toolBarName + ".png");
			System.out.println(icon);
//			Image originImg = originIcon.getImage();
//			Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//			ImageIcon icon = new ImageIcon(changedImg);
			JButton btnToolBar = new JButton(toolBarName, icon);
			this.add(btnToolBar);
		}
		
	}
	
}
