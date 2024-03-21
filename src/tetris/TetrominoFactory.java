package tetris;

import javax.swing.Timer;

import listeners.FactoryListener;
import tetrominoes.Tetromino;

/**
 * This class represents the process that makes new Tetrominos.
 */
public class TetrominoFactory {

	/**
	 * This is the instance of the tetromino factory.
	 */
	private static TetrominoFactory factoryInstance;
	
	/**
	 * The next Tetromino that is displayed in the right side panel.
	 */
	private static Tetromino storedTetromino;

	/**
	 * The moving Tetromino that is displayed in the Tetris Grid.
	 */
	private static Tetromino currentTetromino;

	/**
	 * The moving Tetromino that is displayed in the Tetris Grid.
	 */
	private Timer tetrominoFactoryTimer;

	/**
	 * This is the factory listener
	 */
	FactoryListener factoryListener;

	/**
	 * This constructor stores the next Tetromino.
	 */
	public TetrominoFactory() {
		factoryInstance = this;
		storedTetromino = new Tetromino();
		factoryListener = new FactoryListener(this);
	}

	/**
	 * This method starts the process of making new Tetromino.
	 */
	public void startProduction() {
		// Sets and starts the timer for repeated action.
		tetrominoFactoryTimer = new Timer(10, factoryListener);
		tetrominoFactoryTimer.start();
		System.out.println("Strart Production");
	}

	/**
	 * This method stops the production and spawning of tetrominoes.
	 */
	public void stopProduction() {
		tetrominoFactoryTimer.stop();
		System.out.println("Stop Production");
	}
	
	/**
	 * This method stops the current Tetromino.
	 */
	public void stopTetromino() {
		currentTetromino.stopTetromino();
	}
	
	/**
	 * This method starts the timer of the current Tetromino, and it will move again.
	 */
	public void startTetromino() {
		currentTetromino.startTetromino();
	}


	/**
	 * This method returns next Tetromino.
	 * 
	 * @return storedTetromino
	 */
	public static Tetromino getStoredTetromino() {
		return storedTetromino;
	}

	/**
	 * This method returns the current Tetromino.
	 * 
	 * @return currentTetromino
	 */
	public static Tetromino getCurrentTetromino() {
		return currentTetromino;
	}
	
	/**
	 * This method sets the current Tetromino.
	 */
	public Tetromino setCurrentTetromino(Tetromino tetromino) {
		return tetromino;
	}

	/**
	 * This method produces a Tetromino, if possible.
	 */
	public void produce() {
		System.out.println(currentTetromino);
		// Change to spawn if is not movable anymore?s
		if (currentTetromino == null || !currentTetromino.canMoveDown()) {

			// Puts the stored Tetromino in the current one.
			currentTetromino = storedTetromino;

			// Stores a new Tetromino.
			storedTetromino = new Tetromino();
			// Place the stored tetromino in the next grid
			TetrisGame.getFrame().getInfoRight().setNextTetromino(storedTetromino);
			TetrisGame.getFrame().pack();

			// Destroys full lines
			GameRules.clearLines();

			// Spawns the current Tetromino.
			currentTetromino.playingTetromino();
		}
	}
	
	public void clearTetromino() {
		currentTetromino = null;
	}
}