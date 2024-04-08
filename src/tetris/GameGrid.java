package tetris;

/**
 * This class is a grid and represents the game grid where the game takes part.
 */
public class GameGrid extends Grid {
	
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates the game grid with a size of 20 x 10.
	 */
	public GameGrid(TetrisGame game) {
		super(game, 20, 10);
	}

	/**
	 * This method clears the lines full of Tetrominos cells.
	 */
	public void clearLines() {

		// Number of cleared lines after one placed tetromino
		int clearedLines = 0;

		// Iterate through the game grid and start in the under left corner.
		for (int row = getNumRows() - 1; row >= 0; row--) {
			
			// If the line is full of Tetrominos values, clear line and refresh game grid
			if (isRowFull(row)) {
				
				// Increment the number of cleared lines
				clearedLines++;
				
				// Shift the values of the row by one
				shiftRow(row);
				// Goes back to previous row because it contains new values and might be full as
				// well.
				row++;
			}
		}
		// Set lines
		getGame().getFrame().getInfoRight().addClearedLines(clearedLines);
		// Set score
		getGame().getFrame().getInfoRight().setScore(calculateScore(clearedLines));
	}
	
	/**
	 * This method checks if a row is full of blocks.
	 * 
	 * @param row Row which should be checked
	 * @return True, if the line is full of blocks and can be cleared
	 */
	private boolean isRowFull(int row) {
	    for (int col = 0; col < getNumCols(); col++) {
	    	// Checks if the value at the intersection of this row and column is null.
	        Object value = this.getValueAt(row, col);
	        if (value == null) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * This method shifts the row down.
	 * 
	 * @param row The row which will me shifted down
	 */
	private void shiftRow(int row) {
		// Moves each value to the cell below
		for (int rowToMove = row - 1; rowToMove >= 0; rowToMove--) {
			for (int colToMove = 0; colToMove < getNumCols(); colToMove++) {
				// Set the value to the row underneath
				Object valueToMove = getValueAt(rowToMove, colToMove);
				setValueAt(valueToMove, rowToMove + 1, colToMove);
			}
		}
	}

	
	/**
	 * This method returns the number of points to be awarded.
	 * 
	 * @param numberOfClearedLines Number of the lines cleared at one time
	 * @return Number of points which the player will recive
	 */
	private int calculateScore(int numberOfClearedLines) {
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
