package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.GridPanel;
import panels.InformationPanelLeft;
import panels.InformationPanelRight;

/**
 * This class represents the Tetris game frame.
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Possibility to change frame size
	private static final int WIDTH = 700;
	private static final int HEIGHT = 400;
	
	//Possibility to change background color
	private Color backgroundColor = new Color(255, 50, 50);
	
	private JPanel menuPanel, gamePanel, pausePanel;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public GameFrame() {
		initFrame();
		initMenuPanel();
		
		//Call later if Game is started
		initGamePanel();
	}

	/**
	 * This method initialize the main frame.
	 */
	private void initFrame() {
		this.setTitle("Tetris Game");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen

	}
	
	/**
	 * This method initialize the panels
	 */
	private void initGamePanel() {
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		
		//TODO How to keep the grid centered???
		JPanel gridPanel = new GridPanel(backgroundColor);
		JPanel leftPanel = new InformationPanelLeft(backgroundColor);
		JPanel rightPanel = new InformationPanelRight(backgroundColor);
		
		gamePanel.add(gridPanel, BorderLayout.CENTER);
		gamePanel.add(leftPanel, BorderLayout.WEST);
		gamePanel.add(rightPanel, BorderLayout.EAST);
		this.add(gamePanel);
		
	}
	
	/**
	 * This method initialize the panel with the menu view
	 */
	private void initMenuPanel() {
		//TODO
		menuPanel = new JPanel();
		this.add(menuPanel);
	}
}



