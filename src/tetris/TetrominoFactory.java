package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private static Timer tetrominoFactoryTimer;
	
	/**
	 * 
	 */
	private static boolean isPerformingAction = false;
	
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
					
					isPerformingAction = true;
					
					currentTetromino = storedTetromino;
					storedTetromino = new Tetromino();
					
					// Place the stored Tetromino in the next grid.
					TetrisGame.getFrame().getInfoRight().setNextTetromino(storedTetromino);
					TetrisGame.getFrame().pack();

					clearLines();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					System.out.println("A " + currentTetromino.getShape() + "-Tetromino will spawn (" + dtf.format(LocalDateTime.now()) + ")");
					currentTetromino.spawnTetromino();

				}
				
				isPerformingAction = false;
			}
		};

		// Sets and starts the timer for repeated action (>200 or canMoveDown() might bug).
		tetrominoFactoryTimer = new Timer(500, actionListener);
		tetrominoFactoryTimer.start();

	}

	/**
	 * This method clears the full lines.
	 */
	public void clearLines() {
		
		Grid gameGrid = TetrisGame.getGameGrid();
		
		int numRows = gameGrid.getRowCount();
		int numCols = gameGrid.getColumnCount();
		
		// Variable to tell if the line is full.
		boolean isLineFull;

		for (int row = numRows - 1; row >= 0; row--) {
			
			// Sets the full line checker to true.
			// The value will remain true if no null is found in the row.
			isLineFull = true;
			
			for (int col = 0; col < numCols; col++) {

				// Pass isLineFull to false and exits the for loop is a null is found.
				Object value = gameGrid.getValueAt(row, col);
				if (value == null) {
					isLineFull = false;
					break;
				}
			}
			
			// If the line is full of Tetrominos values,
			// Moves each value to the cell below.
			// It starts from bottom (line above the full one) to top, in order to prevent value suppression.
			if (isLineFull) {
				for (int rowToMove = row - 1; rowToMove >= 0; rowToMove--) {
					for (int colToMove = 0; colToMove < numCols; colToMove++) {
						Object valueToMove = gameGrid.getValueAt(rowToMove, colToMove);
						gameGrid.setValueAt(valueToMove, rowToMove + 1, colToMove);
					}
				}
				
				// Goes back to previous row because it contains new values and might be full as well.
				row++;
			}
		}
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
	
	/**
	 * This method returns the current Tetromino.
	 * 
	 * @return currentTetromino
	 */
	public static boolean isPerformingAction() {
		return isPerformingAction;
	}
	
	/**
	 * This method stops the TetrominoFactory timer.
	 */
	public static void stopTimer() {
		tetrominoFactoryTimer.stop();
	}
	
	/**
	 * This method restarts the TetrominoFactory timer.
	 */
	public static void restartTimer() {
		tetrominoFactoryTimer.restart();;
	}

}
