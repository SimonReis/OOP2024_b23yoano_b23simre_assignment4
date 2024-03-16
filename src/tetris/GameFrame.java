package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.MenuPanel;
import panels.GridPanel;
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
	private Color backgroundColor = new Color(138, 146, 174);

	/**
	 * For the game there are three different views. The menu, the game itself and
	 * the view if the game is paused.
	 */
	private JPanel menuPanel, gamePanel, pausePanel;

	/**
	 * The game grid is the grid where the game takes part.
	 */
	private Grid gameGrid;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public GameFrame(Grid gameGrid) {

		this.gameGrid = gameGrid;

		initFrame();
		initMenuPanel();
		//initGamePanel();

		GameListener gameListener = new GameListener();
		this.addKeyListener(gameListener);

	}

	/**
	 * This method initialize the frame. The size of the frame is fixed to one size.
	 */
	private void initFrame() {
		this.setTitle("Tetris Game");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen
	}

	/**
	 * This method initialize the game panel including three panels with elements
	 * required for the Tetris game.
	 */
	private void initGamePanel() {
		// Create the three different panels
		JPanel gridPanel = new GridPanel(gameGrid, backgroundColor);
		JPanel leftPanel = new InformationPanelLeft(this, backgroundColor);
		JPanel rightPanel = new InformationPanelRight(backgroundColor);

		// Add the panels in the game panels, which is added to the frame.
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(1, 3));
		gamePanel.add(leftPanel);
		gamePanel.add(gridPanel);
		gamePanel.add(rightPanel);
		
		this.add(gamePanel);
	}

	/**
	 * This method initialize the panel with the menu view
	 */
	private void initMenuPanel() {
		// TODO
		menuPanel = new MenuPanel(this, backgroundColor);
		this.add(menuPanel);
	}

	/**
	 * This method is called, when a new game should start. The view will change
	 * from the menu panel to the game panel.
	 */
	public void startGame() {
		this.remove(menuPanel);
		initGamePanel();
		this.pack();
	}
	
	/**
	 * This method is called, when a game should be ended. The view will change
	 * from the game panel to the menu panel.
	 */
	public void endGame() {
		this.remove(gamePanel);
		initMenuPanel();
		this.pack();
	}

}
