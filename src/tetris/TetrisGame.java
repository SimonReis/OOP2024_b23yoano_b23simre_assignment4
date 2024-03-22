package tetris;

import listeners.GameOverListener;

/**
 * This class represents the whole teris game including the GUI, the core game
 * logic.
 */
public class TetrisGame {

	/**
	 * This is the instance of the one running tetris game.
	 */
	private static TetrisGame gameInstance;

	/**
	 * This is the main frame, where all information and the game is displayed.
	 */
	private MainFrame frame;


	/**
	 * This is the tetromino factory, where tetrominos were produced and spawned at
	 * the game grid.
	 */
	private TetrominoFactory tetrominoFactory;
	
	/**
	 * This is the Listener which checks if the game is over.
	 */
	//TODO Not implemented yet
	private static GameOverListener gameOverListener;


	/**
	 * This is the high score of the application.
	 */
	private int highScore;
	
	/**
	 * This is the constructor, where all required parts for using the tetris
	 * application and playing a game is initialized.
	 */
	public TetrisGame() {
		gameInstance = this;
		highScore = 0;
		tetrominoFactory = new TetrominoFactory();
		frame = new MainFrame();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.pack();

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
	
	/**
	 * This method returns the main frame.
	 * 
	 * @return Main frame
	 */
	public MainFrame getFrame() {
		return frame;
	}
	
	/**
	 * This method returns the tetromino factory.
	 * 
	 * @return Tetromino factory
	 */
	public TetrominoFactory getFactory() {
		return tetrominoFactory;
	}

	/**
	 * This method returns the high score of the game.
	 */
	public int getHighScore() {
		return highScore;
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
		frame.pack();

		// Start Tetromino factory
		tetrominoFactory.startProduction();
	}

	/**
	 * This method pause the game.
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
		// Refresh the high score to display correctly in menu view.
		highScore = frame.getInfoRight().getHighScore();
		
		// Change View
		frame.setMenuView();
		frame.getMenuPanel().setNewHighScore(highScore);
		frame.setFocusable(true);
		frame.pack();

		// Stop production and clear the last current tetromino
		tetrominoFactory.stopProduction();
		tetrominoFactory.clearTetromino();
	}
	
	/**
	 * This method starts a new game, if a game has already been played.
	 */
	public void newGame() {
		// Start the production of tetrominoes
		tetrominoFactory.startProduction();
		// Start the game
		startGame();
	}
}
