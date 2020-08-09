package swing.ex1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Ex2 {

	private JFrame frame;
	private final JPanel pNextPage = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2 window = new Ex2();
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
	public Ex2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pStartPage = new JPanel();
		pStartPage.setBounds(0, 0, 494, 478);
		frame.getContentPane().add(pStartPage);
		pStartPage.setLayout(null);
		
		JButton btnNext = new JButton("Go To Next");
		btnNext.setBounds(35, 55, 117, 29);
		pStartPage.add(btnNext);
		pNextPage.setBounds(6, 6, 488, 466);
		frame.getContentPane().add(pNextPage);
		pNextPage.setLayout(null);
		
		JButton btnBack = new JButton("Go To Back");
		btnBack.setBounds(170, 166, 117, 29);
		pNextPage.add(btnBack);
		
		pNextPage.setVisible(false);
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pStartPage.setVisible(false);
				pNextPage.setVisible(true);
				
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pStartPage.setVisible(true);
				pNextPage.setVisible(false);
				
			}
		});
	}
}
