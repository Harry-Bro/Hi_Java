package swing.ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class Ex1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1 window = new Ex1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Ex1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(309, 23, 117, 51);
		
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(26, 34, 109, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 34, 109, 26);
		frame.getContentPane().add(textField_1);
	}
}
