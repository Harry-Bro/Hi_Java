package swing.ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex3 {

	private JFrame frmCalculator;
	private int firstNum;
	private String calcMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex3 window = new Ex3();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ex3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 319, 464);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		frmCalculator.setLocationRelativeTo(null);
		
		JLabel lblNumView = new JLabel("0");
		lblNumView.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumView.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNumView.setBounds(6, 23, 307, 74);
		frmCalculator.getContentPane().add(lblNumView);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(22, 212, 60, 60);
		frmCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(93, 212, 60, 60);
		frmCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(164, 212, 60, 60);
		frmCalculator.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(22, 284, 60, 60);
		frmCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(93, 284, 60, 60);
		frmCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(164, 284, 60, 60);
		frmCalculator.getContentPane().add(btn3);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(22, 144, 60, 60);
		frmCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(93, 144, 60, 60);
		frmCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(164, 144, 60, 60);
		frmCalculator.getContentPane().add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(93, 353, 60, 60);
		frmCalculator.getContentPane().add(btn0);
		
		JButton btnMul = new JButton("*");
		btnMul.setBounds(235, 284, 60, 60);
		frmCalculator.getContentPane().add(btnMul);
		
		JButton btnDot = new JButton(".");
		btnDot.setBounds(22, 353, 60, 60);
		frmCalculator.getContentPane().add(btnDot);
		
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(235, 144, 60, 60);
		frmCalculator.getContentPane().add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentNum = Integer.parseInt(lblNumView.getText());
				firstNum = currentNum;
				lblNumView.setText("0");
				calcMode = "ADD";
			}
		});
		
		JButton btnSub = new JButton("-");
		btnSub.setBounds(235, 212, 60, 60);
		frmCalculator.getContentPane().add(btnSub);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentNum = Integer.parseInt(lblNumView.getText());
				firstNum = currentNum;
				lblNumView.setText("0");
				calcMode = "SUB";
			}
		});
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(calcMode == "ADD") {
					
				} else if(calcMode == "Minus") {
					currentNum = Integer.parseInt(lblNumView.getText());
					total -= currentNum;
					lblNumView.setText(String.valueOf(total));
				}
				
			}
		});
		btnEquals.setBounds(164, 353, 60, 60);
		frmCalculator.getContentPane().add(btnEquals);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setBounds(235, 353, 60, 60);
		frmCalculator.getContentPane().add(btnDiv);
		
		
		
		btn0.addActionListener(new Ex3_ActionListener(lblNumView, btn0));
		btn1.addActionListener(new Ex3_ActionListener(lblNumView, btn1));
		btn2.addActionListener(new Ex3_ActionListener(lblNumView, btn2));
		btn3.addActionListener(new Ex3_ActionListener(lblNumView, btn3));
		btn4.addActionListener(new Ex3_ActionListener(lblNumView, btn4));
		btn5.addActionListener(new Ex3_ActionListener(lblNumView, btn5));
		btn6.addActionListener(new Ex3_ActionListener(lblNumView, btn6));
		btn7.addActionListener(new Ex3_ActionListener(lblNumView, btn7));
		btn8.addActionListener(new Ex3_ActionListener(lblNumView, btn8));
		btn9.addActionListener(new Ex3_ActionListener(lblNumView, btn9));
		
	}
}
