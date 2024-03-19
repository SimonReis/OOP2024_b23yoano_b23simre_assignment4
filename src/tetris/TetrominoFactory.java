package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

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

					// Destroys full lines
					clearLines();

					// Spawns the current Tetromino.
					currentTetromino.spawnTetromino();
				}
			}
		};

		// Sets and starts the timer for repeated action.
		tetrominoFactoryTimer = new Timer(10, actionListener);
		tetrominoFactoryTimer.start();

	}

	/**
	 * This method clears the lines full of Tetrominos cells.
	 */
	public void clearLines() {
		
		// Gets the game grid.
		Grid gameGrid = TetrisGame.getGameGrid();
		
		// Gets the numer of rows and columns of the game grid.
		int numRows = gameGrid.getRowCount();
		int numCols = gameGrid.getColumnCount();
		
		// Variable to count the number of null values in a row.
		int nullCount;
		
		// Variable 
		int clearedRow;
		for (int i = numRows - 1; i >= 0; i--) {
			nullCount = 0;
			for (int j = 0; j < numCols; j++) {
				Object value = gameGrid.getValueAt(i, j);
				if (value == null) {
					nullCount++;
				}
			}
			if (nullCount == 0) {
				//clearedRow = i;
				for (int k = i - 1; k >= 0; k--) {
					for (int l = 0; l < numCols; l++) {
						Object valueToMove = gameGrid.getValueAt(k, l);
						gameGrid.setValueAt(valueToMove, k + 1, l);
					}
				}
				i++;
			}
		}
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

}
