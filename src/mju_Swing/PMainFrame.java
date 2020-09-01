package mju_Swing;

import javax.swing.JFrame;

public class PMainFrame extends JFrame {

	private static final long serialVersionUID = 1L; // 버전명
	
	private PMenuBar pMenuBar;
	
	// Constructor
	public PMainFrame() {
		// set attributes
		this.setSize(
				Constants.EMainFrame.WIDTH.getSize(),
				Constants.EMainFrame.HEIGHT.getSize()
				);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // X 버튼 누르면 프로그램을 종료해라
		
		// create and register components
		pMenuBar = new PMenuBar();
		this.setJMenuBar(pMenuBar);
		
	}

}