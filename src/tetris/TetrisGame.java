package tetris;

/**
 * This class represents the whole teris game including the GUI, the core game
 * logic, including rules and scorekeeping.
 */
public class TetrisGame {

	/**
	 * This is the instance of the one running tetris game.
	 */
	private static TetrisGame gameInstance;

	/**
	 * This is the game grid, where the actual game takes place.
	 */
	private static Grid gameGrid;

	/**
	 * This is the main frame, where all information and the game is displayed.
	 */
	private static MainFrame frame;

	/**
	 * This is the constructor, where all required parts for using the tetris
	 * application and playing a game is initialized.
	 */
	public TetrisGame() {
		gameInstance = this;
		gameGrid = new Grid(20, 10);
		frame = new MainFrame();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.pack();
	}

	/**
	 * This method returns the game instance.
	 * 
	 * @return Game instance
	 */
	public static TetrisGame getGameInstance() {
		return gameInstance;
	}

	/**
	 * This method returns the game grid. 
	 *
	 * @return Game grid
	 */
	public static Grid getGameGrid() {
		return gameGrid;
	}

	/**
	 * This method returns the main frame.
	 * 
	 * @return Main frame
	 */
	public MainFrame getFrame() {
		return frame;
	}

	/**
	 * This method is called, when a new game round should start. The view will change,
	 * the production of Tetrominos start and they will spawned in the game frame.
	 */
	public void startGame() {
		// Change View
		frame.setGameView();
		frame.setFocusable(true);
		frame.pack();

		// Start Falling blocks
		BlockFactory blockFactory = new BlockFactory();
		blockFactory.startProduction();
	}
	
	public void pauseGame() {
		//TODO Implement method
		//stop thread 
	}
	
	/**
	 * This method is called, when the game round should end. The view will change and the high score is set.
	 */
	public void endGame() {
		// Change View
		frame.setMenuView();
		frame.setFocusable(true);
		frame.pack();
		
		//TODO SET HIGHSCORE
	}
	
	/**
	 * This method refreshes the high score, if the new high score is higher than the older one.
	 */
	public void refreshHighScore() {
		//TODO Implement method
		//Get current highscore
		// Compare with old highscore
		// set label if neccesarry
	}

}
