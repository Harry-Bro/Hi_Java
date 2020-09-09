package mju_Swing.sugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PHeaderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblWelcome;
	
	public PHeaderPanel() {
		this.lblWelcome = new JLabel("님 안녕하세요");
		this.add(this.lblWelcome);
	}
	
}
