package mju_Swing.sugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mju_Swing.valueObject.VUserInfo;

public class PHeaderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblWelcome;
	
	public PHeaderPanel() {
		String userName = VUserInfo.userName;
		this.lblWelcome = new JLabel(userName + "님 안녕하세요");
		this.add(this.lblWelcome);
	}
	
}
