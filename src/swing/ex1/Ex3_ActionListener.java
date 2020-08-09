package swing.ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Ex3_ActionListener implements ActionListener {

	private JLabel label;
	private JButton button;
	
	public Ex3_ActionListener(JLabel label, JButton button) {
		this.label = label;
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String curr = label.getText();
		String num = button.getText();
		if(curr.equals("0")) {
			label.setText(num);
		} else {
			label.setText(curr + num);
		}
		
	}

}
