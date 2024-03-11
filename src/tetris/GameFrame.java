package tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public GameFrame() {
		initFrame();
	
	}
	
	/**
	 * 
	 */
	private void initFrame() {
		this.setTitle("Tetris");
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //Place the JFrame in the middle of the screen

	}

}
