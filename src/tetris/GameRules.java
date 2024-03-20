package tetris;

import tetrominoes.Shapes;
import tetrominoes.Tetromino;

/**
 * This class implements the game rules of the tetris game.
 */
public class GameRules {

	public GameRules() {
		
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
		TetrisGame.getFrame().getInfoRight().setScore(TetrisGame.getGameInstance().calculateScore(clearedLines));
	}
	
	/**
	 * This method checks if the game is over, by a non movable block in the first row of the game grid.
	 * 
	 * @return True if the game is over.
	 */
	public boolean isGameOver() {
		for (int col = 0; col < TetrisGame.getGameGrid().getColumnCount(); col++) {
			// Check if there is a non movable block in the first row
			if (Shapes.class.cast(TetrisGame.getGameGrid().getValueAt(0, col)).isMovable()) {
				return true;
			}
		}
		return false;
	}
}
