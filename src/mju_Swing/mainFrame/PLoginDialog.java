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
import mju_Swing.controls.CLogin;
import mju_Swing.valueObject.VUserInfo;

public class PLoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblName;
	private JTextField txtId;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JButton btnOk;
	private JButton btnCancel;
	
	private ActionHandler actionHandler;
	
	public PLoginDialog() {
		
		this.setLayout(new FlowLayout());
        this.setResizable(false);
		this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
        
        this.actionHandler = new ActionHandler();
		
		JPanel line1 = new JPanel();
			this.lblName = new JLabel(ELoginDialog.nameLabel.getText());
			this.txtId = new JTextField(10);
			line1.add(lblName);
			line1.add(txtId);
		
		JPanel line2 = new JPanel();
			lblPassword = new JLabel(ELoginDialog.passwordLabel.getText());
			txtPassword = new JTextField(10);
			line2.add(lblPassword);
			line2.add(txtPassword);
		
		JPanel line3 = new JPanel();
			btnOk = new JButton(ELoginDialog.okButtonLabel.getText());
			btnCancel = new JButton(ELoginDialog.cancelButtonLabel.getText());
			btnOk.addActionListener(this.actionHandler);
			btnOk.setActionCommand(ELoginDialog.okButtonLabel.getText());
			btnCancel.addActionListener(this.actionHandler);
			btnCancel.setActionCommand(ELoginDialog.cancelButtonLabel.getText());
			line3.add(btnOk);
			line3.add(btnCancel);
			
		this.add(line1);
		this.add(line2);
		this.add(line3);
			
	}
	
	private void validateUser() {
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.validateUser(this.txtId.getText(), this.txtPassword.getText());
		
		if(vUserInfo != null) {
			new PMainFrame();
			dispose();
		}
		
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getActionCommand().equals(ELoginDialog.okButtonLabel.getText())) {
				if(!txtId.getText().equals("") && !txtPassword.getText().equals("")) {
					validateUser();					
				} else {
					System.out.println("아이디와 패스워드를 입렵하세요.");
				}
			}
			
		}
		
	}
	
}
