package mju_Swing.mainFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mju_Swing.constants.Constants.ELoginDialog;

public class PLoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JButton btnOk;
	private JButton btnCancel;
	
	private ActionHandler actionHandler;
	
	public PLoginDialog() {
		
		this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
        
        this.actionHandler = new ActionHandler();
		
		JPanel line1 = new JPanel();
			this.lblName = new JLabel(ELoginDialog.nameLabel.getText());
			this.txtName = new JTextField(10);
			line1.add(lblName);
			line1.add(txtName);
		this.add(line1);
		
		JPanel line2 = new JPanel();
			lblPassword = new JLabel(ELoginDialog.passwordLabel.getText());
			txtPassword = new JTextField(10);
			line2.add(lblPassword);
			line2.add(txtPassword);
		this.add(line2);
		
		JPanel line3 = new JPanel();
			btnOk = new JButton(ELoginDialog.okButtonLabel.getText());
			btnCancel = new JButton("Cancle");
			btnOk.addActionListener(this.actionHandler);
			btnOk.setActionCommand(ELoginDialog.okButtonLabel.getText());
			btnCancel.addActionListener(this.actionHandler);
			btnCancel.setActionCommand(ELoginDialog.cancelButtonLabel.getText());
			line3.add(btnOk);
			line3.add(btnCancel);
		this.add(line3);
			
	}
	
	private void validateUser() {
		CLogin cLogin = new CLogin();
		VuserInfo vUserInfo = cLogin.validateUser(this.txtName.getText(), this.txtPassword.getText());
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getActionCommand().equals(ELoginDialog.okButtonLabel.getText())) {
				validateUser();
			}
			
		}
		
	}
	
}
