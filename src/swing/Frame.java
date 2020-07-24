package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("some text");
		JButton btn1 = new JButton("Click"); // create button
		JTextArea txtArea = new JTextArea(); // 많은 줄 작성할 때
//		JTextField txtField = new JTextField(200); // 20만큼 칠 수 있음
		
		panel.setLayout(new BorderLayout());
		
		panel.add(label, BorderLayout.NORTH);
//		panel.add(new JLabel("안녕하세요")); // Label을 추가해
		panel.add(btn1, BorderLayout.WEST );
		panel.add(txtArea, BorderLayout.CENTER);
		
		frame.add(panel); // Panel을 생성함
		
		frame.setVisible(true); // 화면이 처음에는 보이지 않기 때문에 true로 설정해
		frame.setPreferredSize(new Dimension(840, 840/12*9)); // 좋아하는 크기 설
		frame.setSize(840, 840/12*9); // 크기 설정
		frame.setResizable(false); // 사이즈 변경불가능 하도
		frame.setLocationRelativeTo(null); // 출력 위치 설정 null값으로 넣으면 자동으로 가운데 정렬
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼을 누르면 종료
		
	}
	
}
