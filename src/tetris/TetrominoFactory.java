package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		factoryListener = new FactoryListener();
	}

	/**
	 * This method starts the process of making new Tetromino.
	 */
	public void startProduction() {
		// Sets and starts the timer for repeated action.
		tetrominoFactoryTimer = new Timer(10, factoryListener);
		tetrominoFactoryTimer.start();
	}

	/**
	 * This method stops the production and spawning of tetrominoes.
	 */
	public void stopProduction() {
		System.out.print("Pause!");
		tetrominoFactoryTimer.removeActionListener(factoryListener);
	}
	
	/**
	 * This method returns the factory instance.
	 * 
	 * @return Tetromino factory instance
	 */
	public static TetrominoFactory getFactoryInstance() {
		return factoryInstance;
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
	 * This method produces a Tetromino, if possible.
	 */
	public void produce() {
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
			currentTetromino.spawnTetromino();
			System.out.println("Spawn");
		}
	}

}
