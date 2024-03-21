package tetris;

import listeners.GameOverListener;

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
	 * This is the main frame, where all information and the game is displayed.
	 */
	private static MainFrame frame;

	/**
	 * This is the game grid, where the actual game takes place.
	 */
	private Grid gameGrid;

	/**
	 * This is the tetromino factory, where tetrominos were produced and spawned at
	 * the game grid.
	 */
	private static TetrominoFactory tetrominoFactory;
	
	/**
	 * This is the Listener which checks if the game is over.
	 */
	//private static GameOverListener gameOverListener;


	/**
	 * This is the high score of the application.
	 */
	private static int highScore;
	/**
	 * This is the constructor, where all required parts for using the tetris
	 * application and playing a game is initialized.
	 */
	public TetrisGame() {
		gameInstance = this;
		//tetrominoFactory = new TetrominoFactory();
		highScore = 0; // TODO Maybe Save this variable
		frame = new MainFrame();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.pack();
		
		tetrominoFactory = new TetrominoFactory();

		//TODO Maybe in another class?
		//gameOverListener = new GameOverListener();
	}

	/**
	 * This method returns the game instance.
	 * 
	 * @return Game instance
	 */
	public static TetrisGame getGameInstance() {
		return gameInstance;
	}

//	/**
//	 * This method returns the game grid.
//	 *
//	 * @return Game grid
//	 */
//	public static Grid getGameGrid() {
//		return gameGrid;
//	}

	/**
	 * This method returns the main frame.
	 * 
	 * @return Main frame
	 */
	public static MainFrame getFrame() {
		return frame;
	}

	/**
	 * This method returns the high score of the game.
	 */
	public static int getHighScore() {
		return highScore;
	}

	/**
	 * This method set the high score of the game.
	 */
	private void refreshHighScore() {
		highScore = frame.getInfoRight().getHighScore();
	}

	/**
	 * This method is called, when a new game round should start. The view will
	 * change, the production of Tetrominos start and they will spawned in the game
	 * frame.
	 */
	public void startGame() {
		// Change View
		frame.setGameView();
		frame.setFocusable(true);
		//frame.pack();

		// Start Falling blocks
		
		tetrominoFactory.startProduction();
		frame.pack();
		
	}

	/**
	 * This method stops the production and freezes the game.
	 */
	public void pauseGame() {
		tetrominoFactory.stopTetromino();
	}

	/**
	 * This method resumes the game.
	 */
	public void resumeGame() {
		tetrominoFactory.startTetromino();
	}

	/**
	 * This method is called, when the game round should end. The view will change
	 * and the high score is set.
	 */
	public void endGame() {
		// Change View
		frame.setMenuView();
		refreshHighScore();
		frame.getMenuPanel().setNewHighScore(highScore);
		frame.setFocusable(true);
		frame.pack();

		// Stop production
		
		//tetrominoFactory.stopProduction();
		//tetrominoFactory.setCurrentTetromino(null);
		GameRules.clearGrid(gameGrid);
	}
	
	public void newGame() {
		tetrominoFactory = null;
		startGame();
		//gameGrid.refreshGrid();
		
	}
}
