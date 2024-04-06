package tetris;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.KeyBoardListener;
import panels.MenuPanel;
import panels.InformationPanelLeft;
import panels.InformationPanelRight;

/**
 * This class represents the Tetris main frame of the tetris application.
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;

	/**
	 * Possibility to change frame size
	 */
	private static final int WIDTH = 800;
	private static final int HEIGHT = 520;

	/**
	 * Possibility to change background color
	 */
	private Color backgroundColor;

	/**
	 * For the game there are three different views. The menu, the game itself and
	 * the view if the game is paused.
	 */
	private MenuPanel menuPanel;
	private JPanel gamePanel;
	private InformationPanelRight rightPanel;

	/**
	 * The game grid is the grid where the game takes part.
	 */
	private GameGrid gameGrid;

	/**
	 * The next grid is the grid where the next tetromino is stored.
	 */
	private NextGrid nextGrid;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public MainFrame(TetrisGame game) {
		this.game = game;
		// Set the background color
		backgroundColor = new Color(138, 146, 174);
		//Init frames
		initFrame();
		initMenuPanel();
		// Create the game grid and the next grid
		gameGrid = new GameGrid(game);
		nextGrid = new NextGrid(game);
		// Add Listener to the frame
		this.addKeyListener(new KeyBoardListener(game.getFactory()));
	}

	/**
	 * This method initialize the frame. The size of the frame is fixed to one size.
	 */
	private void initFrame() {
		this.setTitle("Tetris Game");
		// The frame size is not changeable
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Place the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

	}

	/**
	 * This method initialize the game panel including three panels with elements
	 * required for the Tetris game.
	 */
	private void initGamePanel(Grid gameGrid, Grid nextGrid) {

		// Create the Information panels
		JPanel leftPanel = new InformationPanelLeft(game, backgroundColor);
		rightPanel = new InformationPanelRight(game, nextGrid, backgroundColor);

		// Create the game grid panel
		JPanel gridPanel = new JPanel();
		gridPanel.setBackground(backgroundColor);
		gridPanel.add(gameGrid);

		// Add the panels in the game panels, which is added to the frame.
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(1, 3));
		gamePanel.add(leftPanel);
		gamePanel.add(gridPanel);
		gamePanel.add(rightPanel);

		this.add(gamePanel);
	}

	/**
	 * This method initialize the panel with the menu view.
	 */
	private void initMenuPanel() {
		menuPanel = new MenuPanel(game, backgroundColor);
		this.add(menuPanel);
	}

	/**
	 * This method is called, when a new game should start. The view will change
	 * from the menu panel to the game panel.
	 */
	public void setGameView() {
		this.remove(menuPanel);
		// Set new grids
		gameGrid = new GameGrid(game);
		nextGrid = new NextGrid(game);
		initGamePanel(gameGrid, nextGrid);
	}

	/**
	 * The view will change from the game panel to the menu panel.
	 */
	public void setMenuView() {
		this.remove(gamePanel);
		initMenuPanel();
	}

	/**
	 * This method returns the right information panel.
	 * 
	 * @return Information panel right
	 */
	public InformationPanelRight getInfoRight() {
		return rightPanel;
	}

	/**
	 * This method returns the menu panel.
	 * 
	 * @return Menu panel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * This method returns the game grid.
	 * 
	 * @return Game grid
	 */
	public GameGrid getGameGrid() {
		return gameGrid;
	}

	/**
	 * This method sets the game grid.
	 */
	public void setGameGrid(GameGrid grid) {
		gameGrid = grid;
	}

	/**
	 * This method returns the next grid.
	 * 
	 * @return Next grid
	 */
	public NextGrid getNextGrid() {
		return nextGrid;
	}

	/**
	 * This method sets the game grid.
	 */
	public void setNextGrid(NextGrid grid) {
		nextGrid = grid;
	}

}