package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import panels.GridPanel;
import panels.InformationPanelLeft;
import panels.InformationPanelRight;

/**
 * This class represents the Tetris game frame.
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Possibility to change frame size
	 */
	private static final int WIDTH = 800;
	private static final int HEIGHT = 520;

	/**
	 * Possibility to change background color
	 */
	private Color backgroundColor = new Color(0, 0, 255);

	/**
	 * For the game there are three different views. The menu, the game itself and
	 * the view if the game is paused.
	 */
	private JPanel menuPanel, gamePanel, pausePanel;
	
	private GridTable table;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public GameFrame(GridTable table) {
	
		this.table = table;
		initFrame();
		initMenuPanel();

		// Call later if Game is started
		initGamePanel();
	
	}

	private void initFrame() {
		this.setTitle("Tetris Game");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen
	}

	/**
	 * This method initialize the panels
	 */
	private void initGamePanel() {

		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(1, 3));

		//TODO Add Background color
		JPanel gridPanel = new JPanel();
		gridPanel.add(table);
		this.add(gridPanel);
		
		JPanel leftPanel = new InformationPanelLeft(backgroundColor);
		JPanel rightPanel = new InformationPanelRight(backgroundColor);

		
		
		gamePanel.add(leftPanel);
		gamePanel.add(gridPanel);
		gamePanel.add(rightPanel);
		
		gridPanel.add(table);
		
		this.add(gamePanel);
		this.pack();
		
	}



	/**
	 * This method initialize the panel with the menu view
	 */
	private void initMenuPanel() {
		// TODO
		menuPanel = new JPanel();
		this.add(menuPanel);
	}
}
