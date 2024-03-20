package tetris;

import java.awt.Color;

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
	 * This is the high score of the application.
	 */
	private static int highScore;
	
	/**
	 * This is the used background color.
	 */
	private static Color backgroundColor;
	
	/**
	 * This is the constructor, where all required parts for using the tetris
	 * application and playing a game is initialized.
	 */
	public TetrisGame() {
		gameInstance = this;
		highScore = 0; //TODO Maybe Save this variable
		backgroundColor = new Color(138, 146, 174);
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
	 * This method returns the high score of the game.
	 */
	public static Color getBackgroundColor() {
		return backgroundColor;
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

		// Start Falling blocks
		TetrominoFactory tetrominoFactory = new TetrominoFactory();
		tetrominoFactory.startProduction();

	}

	public void pauseGame() {
		// TODO Implement method
		// stop thread
	}

	/**
	 * This method is called, when the game round should end. The 		view will change
	 * and the high score is set.
	 */
	public void endGame() {
		// Change View
		frame.setMenuView();
		refreshHighScore();
		frame.getMenuPanel().setNewHighScore(highScore);
		frame.setFocusable(true);
		frame.pack();

		// TODO SET HIGHSCORE, maybe already included, nope 
	}
	
	/**
	 * This method returns the number of points to be awarded.
	 * 
	 * @param numberOfClearedLines Number of the lines cleared at one time
	 * @return Number of points which the player will recive
	 */
	public int calculateScore(int numberOfClearedLines) {
		if (numberOfClearedLines == 1) {
			return 100;
		} else if (numberOfClearedLines == 2) {
			return 300;
		} else if (numberOfClearedLines == 3) {
			return 500;
		} else if (numberOfClearedLines >= 4) {
			return 800;
		} else {
			return 0;
		}
	}
	
}
