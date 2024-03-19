package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import tetrominoes.Tetromino;

/**
 * This class represents the process that makes new Tetrominos.
 */
public class TetrominoFactory {

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
	 * This constructor stores the next Tetromino.
	 */
	public TetrominoFactory() {
		storedTetromino = new Tetromino();
	}

	/**
	 * This method starts the process of making new Tetromino.
	 */
	public void startProduction() {
		
		ActionListener actionListener = new ActionListener() {

			// This action will be repeated each X seconds (defined in the timer setting).
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Checks if there is no current Tetromino (production starting case)
				// and checks if this Tetromino can't move down.
				if (currentTetromino == null || !currentTetromino.canMoveDown()) {

					// Puts the stored Tetromino in the current one.
					currentTetromino = storedTetromino;

					// Stores a new Tetromino.
					storedTetromino = new Tetromino();
					// Place the stored tetromino in the next grid
					TetrisGame.getFrame().getInfoRight().setNextTetromino(storedTetromino);
					TetrisGame.getFrame().pack();
					// Spawns the current Tetromino.
					currentTetromino.spawnTetromino();
					System.out.println("Spawn");
				}
			}
		};

		// Sets and starts the timer for repeated action.
		tetrominoFactoryTimer = new Timer(10, actionListener);
		tetrominoFactoryTimer.start();

	}

	/**
	 * This method returns the next Tetromino.
	 * 
	 * @return storedTetromino
	 */
	//TODO why should this be static
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

}
