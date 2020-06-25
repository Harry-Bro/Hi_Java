package swing;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("안녕하세요")); // Label을 추가해
		frame.add(panel); // Panel을 생성함
		
		frame.setVisible(true); // 화면이 처음에는 보이지 않기 때문에 true로 설정해
		frame.setPreferredSize(new Dimension(840, 840/12*9)); // 좋아하는 크기 설
		frame.setSize(840, 840/12*9); // 크기 설정
		frame.setResizable(false); // 사이즈 변경불가능 하도
		frame.setLocationRelativeTo(null); // 출력 위치 설정 null값으로 넣으면 자동으로 가운데 정렬
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼을 누르면 종료

	}
	
}
