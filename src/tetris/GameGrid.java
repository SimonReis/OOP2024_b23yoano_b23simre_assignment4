package tetris;

/**
 * This class is a grid and represents the game grid where the game takes part.
 */
public class GameGrid extends Grid {
	
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates the game grid with a size of 20 x 10.
	 */
	public GameGrid() {
		super(20, 10);
	}

	/**
	 * This method clears the lines full of Tetrominos cells.
	 */
	public void clearLines() {

		// Number of cleared lines after one placed tetromino
		int clearedLines = 0;

		// Variable to tell if the line is full. Set to true
		boolean isLineFull = false;

		// Iterate through the game grid and start in the under left corner.
		for (int row = getNumRows() - 1; row >= 0; row--) {
			for (int col = 0; col < getNumCols(); col++) {
				isLineFull = true;
				// Checks if the value at the intersection of this row and column is null.
				// Pass the full line checker to false and exits the for loop when it is the
				// case.
				Object value = this.getValueAt(row, col);
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
					for (int colToMove = 0; colToMove < getNumCols(); colToMove++) {
						Object valueToMove = this.getValueAt(rowToMove, colToMove);
						this.setValueAt(valueToMove, rowToMove + 1, colToMove);
					}
				}
				// Goes back to previous row because it contains new values and might be full as
				// well.
				row++;
			}
		}
		// Set lines
		TetrisGame.getGameInstance().getFrame().getInfoRight().addClearedLines(clearedLines);
		// Set score
		TetrisGame.getGameInstance().getFrame().getInfoRight().setScore(calculateScore(clearedLines));
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
