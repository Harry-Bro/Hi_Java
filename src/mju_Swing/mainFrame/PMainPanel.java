package mju_Swing.mainFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import mju_Swing.sugangSincheong.PContentPanel;
import mju_Swing.sugangSincheong.PFooterPanel;
import mju_Swing.sugangSincheong.PHeaderPanel;

public class PMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	
	public PMainPanel() {
		this.setLayout(new BorderLayout());
		this.pHeaderPanel = new PHeaderPanel();
		this.add(pHeaderPanel, BorderLayout.NORTH);
		
		this.pContentPanel = new PContentPanel();
		this.add(pContentPanel, BorderLayout.CENTER);
		
		this.pFooterPanel = new PFooterPanel();
		this.add(pFooterPanel, BorderLayout.SOUTH);
	}
	
}
