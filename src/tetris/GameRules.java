package tetris;

import tetrominoes.Tetromino;

/**
 * This class implements the game rules of the tetris game.
 */
public class GameRules {
		
	/**
	 * This method clears the lines full of Tetrominos cells.
	 */
	public static void clearLines() {

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
		TetrisGame.getFrame().getInfoRight().setScore(calculateScore(clearedLines));
	}
	
	/**
	 * This method returns the number of points to be awarded.
	 * 
	 * @param numberOfClearedLines Number of the lines cleared at one time
	 * @return Number of points which the player will recive
	 */
	public static int calculateScore(int numberOfClearedLines) {
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
	
	/**
	 * This method clears the next grid.
	 */
	public static void clearNextGrid(Grid nextGrid) {
		for(int m = 0; m < 4; m++) {
			for(int n = 0; n < 4; n++) {
				nextGrid.setValueAt(null, m, n);
			}
		}
	}
	
	/**
	 * This method checks if the game is over, by a non movable block in the first row of the game grid.
	 * 
	 * @return True if the game is over.
	 */
	public static boolean isGameOver() {
		for (int col = 0; col < TetrisGame.getGameGrid().getColumnCount(); col++) {
			// Check if there is a non movable block in the first row
			if (!Tetromino.class.cast(TetrisGame.getGameGrid().getValueAt(0, col)).getPlaced()) {
				return true;
			}
		}
		return false;
	}
}
