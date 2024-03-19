package tetrominoes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import tetris.Grid;
import tetris.TetrisGame;

/**
 * This class represents the shapes from the game Tetris.
 */
public class Tetromino {
	
	/**
	 * Grid in which Tetrominos spawn and move.
	 */
	private Grid gameGrid;
	
	/**
	 * Tetromino coordinates in the grid.
	 */
	private int row;
	private int col;
	
	/**
	 * Tetromino type defined by a letter.
	 */
	private Object tetrominoType;
	
	/**
	 * Timer to set repeated down movement of the Tetromino.
	 */
	private Timer tetrominoTimer;
	
	/**
	 * Boolean field to tell whether the Tetromino can move down or not.
	 */
	private boolean canMoveDown;
	
	/**
	 * This constructor creates a random Tetromino.
	 * Sets its canMoveDown value to false because the Tetromino is stored for now.
	 * 
	 * @param color Background color
	 */
	public Tetromino() {
		gameGrid = TetrisGame.getGameGrid();
		canMoveDown = false;
		tetrominoType = getRandomTetrominoType();
	}
	
	/**
	 * This method spawns the Tetromino.
	 * It makes the Tetromino moving down each X milliseconds (defined in the timer setting).
	 */
	public void spawnTetromino() {
		
		System.out.println("A new Tetromino just spawned!");
		
		// Sets the spawning location of the Tetromino.
		row = 0;
		col = 4;
		gameGrid.setValueAt(tetrominoType, row, col);
		
		ActionListener actionListener = new ActionListener() {
			
			// This action will be repeated each X milliseconds (defined in the timer setting).
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Moves the Tetromino one row down.
				moveDown();
			}
		};
		
		// Sets and starts the timer for repeated action.
		tetrominoTimer = new Timer(500, actionListener);
		tetrominoTimer.start();
	}

	/**
	 * This method moves the Tetromino one row down.
	 * It stops it when it reached the bottom of the grid or another Tetromino.
	 */
	public void moveDown() {
		
		// If the Tetromino can is move down.
		if (canMoveDown()) {
			
			// Replaces the Tetromino cells values by null in its current location.
			gameGrid.setValueAt(null, row, col);
			
			// Rebuilds the Tetromino in its new location one row below.
			row++;
			gameGrid.setValueAt(tetrominoType, row, col);
			
		// If the Tetromino cannot move down.
		} else {
			
			// Stops the timer so the Tetromino stops moving.
			tetrominoTimer.stop();
		}
	}
	
	/**
	 * This method moves the Tetromino one row column left.
	 */
	public void moveLeft() {
		
		// If the Tetromino will not collide a block or a grid edge.
		if (col > 0 && gameGrid.getValueAt(row, col - 1) == null) {
			
			// Replaces the Tetromino cells values by null in its current location.
			gameGrid.setValueAt(null, row, col);
			
			// Rebuilds the Tetromino in its new location one column left.
			col--;
			gameGrid.setValueAt(tetrominoType, row, col);
		}
	}
	
	/**
	 * This method moves the Tetromino one row column right.
	 */
	public void moveRight() {
		
		// If the Tetromino will not collide a block or a grid edge.
		if (col < 9 && gameGrid.getValueAt(row, col + 1) == null) {
			
			// Replaces the Tetromino cells values by null in its current location.
			gameGrid.setValueAt(null, row, col);
			
			// Rebuilds the Tetromino in its new location one column left.
			col++;
			gameGrid.setValueAt(tetrominoType, row, col);
		}
	}

	// REMINDER : ADD A 2ND FIELD THAT RETURNS THE SIDE MOBILITY WITH A TIME DELAY (last chance move).
	/**
	 * This method returns canMoveDown value.
	 * 
	 * @return canMoveDown
	 */
	public boolean canMoveDown() {
		canMoveDown = row < 19 && gameGrid.getValueAt(row + 1, col) == null;
		return canMoveDown;
	}
	
	/**
	 * This method returns a random Tetromino type defined by a letter for each shape.
	 * 
	 * @return tetrominoType
	 */
	public Object getRandomTetrominoType() {
		// Stores the Tetromino types.
		Object[] tetrominoTypes = { "I", "J", "L", "O", "S", "T", "Z" };
		
		// Chooses randomly one of these types.
		Random random = new Random();
		tetrominoType = tetrominoTypes[random.nextInt(tetrominoTypes.length)];
		
		return tetrominoType;
	}

}
