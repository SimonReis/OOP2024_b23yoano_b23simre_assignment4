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

					// Destroys full lines
					clearLines();

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
	 * This method clears the lines full of Tetrominos cells.
	 */
	public void clearLines() {

		// Gets the game grid.
		Grid gameGrid = TetrisGame.getGameGrid();

		// Number of cleared lines after one placed tetromino
		int clearedLines = 0;

		// Variable to tell if the line is full. Set to true
		boolean isLineFull = false;

		// Iterate through the game grid and start in the under left corner.
		for (int row = gameGrid.getRowCount() - 1; row >= 0; row--) {
			for (int col = 0; col < gameGrid.getColumnCount(); col++) {
				isLineFull = true;
				// Checks if the value at the intersection of this row and column is null.
				// Pass the full line checker to false and exits the for loop when it is the
				// case.
				Object value = gameGrid.getValueAt(row, col);
				if (value == null) {
					isLineFull = false;
					break;
				}
			}

			// If the line is full of Tetrominos values, clear line and refresh game grid
			if (isLineFull) {
				// Increment the number of cleared lines
				clearedLines++;
				
				// Moves each value to the cell below
				for (int rowToMove = row - 1; rowToMove >= 0; rowToMove--) {
					for (int colToMove = 0; colToMove < gameGrid.getColumnCount(); colToMove++) {
						Object valueToMove = gameGrid.getValueAt(rowToMove, colToMove);
						gameGrid.setValueAt(valueToMove, rowToMove + 1, colToMove);
					}
				}
				// Goes back to previous row because it contains new values and might be full as
				// well.
				row++;
			}

		}
	
		// Set lines
		TetrisGame.getFrame().getInfoRight().addClearedLines(clearedLines);
		
		// Set score
		
	}

	/**
	 * This method returns next Tetromino.
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
