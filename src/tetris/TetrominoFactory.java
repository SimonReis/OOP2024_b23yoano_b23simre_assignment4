package tetris;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Timer;

import listeners.FactoryListener;
import tetrominoes.Tetromino;

/**
 * This class represents the process that makes new Tetrominos.
 */
public class TetrominoFactory {
	
	/**
	 * This is the TetrisGame.
	 */
	private TetrisGame tetrisGame;
	
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
	private static FactoryListener factoryListener;


	
	/**
	 * This constructor stores the next Tetromino.
	 */
	public TetrominoFactory(TetrisGame tetrisGame) {
		this.tetrisGame = tetrisGame; 
		storedTetromino = new Tetromino();   
		factoryListener = new FactoryListener(this);
	}

	/**
	 * This method starts the process of making new Tetromino.
	 */
	public void startProduction() {
		// Sets and starts the timer for repeated action (>200 or canMoveDown() might bug).
		tetrominoFactoryTimer = new Timer(500, factoryListener);
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
	 * This method starts the timer of the current Tetromino, and it will move
	 * again.
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
	 * This method stops the TetrominoFactory timer.
	 */
	public void stopTimer() {
		//tetrominoFactoryTimer.stop();
	}
	
	/**
	 * This method restarts the TetrominoFactory timer.
	 */
	public void restartTimer() {
		//tetrominoFactoryTimer.restart();;
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
		// Change to spawn if is not movable anymore?s
		if (currentTetromino == null || !currentTetromino.canMoveDown()) {

			// Puts the stored Tetromino in the current one.
			currentTetromino = storedTetromino;
			// Stores a new Tetromino.
			storedTetromino = new Tetromino();

			// Place the stored tetromino in the next grid
			tetrisGame.getFrame().getInfoRight().setNextTetromino(storedTetromino);
			tetrisGame.getFrame().pack();

			// Destroys full lines
			tetrisGame.getFrame().getGameGrid().clearLines();
			
			// Spawns the current Tetromino. 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			System.out.println("A " + currentTetromino.getShape() + "-Tetromino will spawn (" + dtf.format(LocalDateTime.now()) + ")");
			currentTetromino.playingTetromino();
		}
	}

	/**
	 * This method sets the value of the current tetromino to null.
	 */
	public void clearTetromino() {
		currentTetromino = null;
	}
	
	/**
	 * This method checks if the game is over, if the tetromino can be spawned.
	 * 
	 * @return True if tetromino is spawnable
	 */
	public boolean isSpawnable() {
		System.out.println("is spawnable:" + storedTetromino.isSpawnable());
		return storedTetromino.isSpawnable();
	}
	
	/**
	 * This method checks if the game is over, by a non movable block in the first row of the game grid.
	 * 
	 * @return True if the game is over.
	 */
	public boolean isGameOver() {
		for (int col = 0; col < tetrisGame.getFrame().getGameGrid().getColumnCount(); col++) {
			// Check if there is a non movable block in the first row
			if (!Tetromino.class.cast(tetrisGame.getFrame().getGameGrid().getValueAt(0, col)).getShape().isMovable()) {
				return true;
			}
		}
		return false;
	}
	
	
}