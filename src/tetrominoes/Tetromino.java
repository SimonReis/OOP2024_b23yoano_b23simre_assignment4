package tetrominoes;

import java.util.Random;

import javax.swing.Timer;

import listeners.TetrominoListener;
import tetris.TetrisGame;

/**
 * This class represents the shapes from the game Tetris.
 */
public class Tetromino {

	/**
	 * Tetromino coordinates in the game grid.
	 */
	private int row;
	private int col;

	/**
	 * Shape of the tetromino in a 4x4 matrix.
	 */
	private int[][] matrix;

	/**
	 * Tetromino type defined by a letter.
	 */
	private Shapes tetrominoShape;

	/**
	 * Timer to set repeated down movement of the Tetromino.
	 */
	private Timer fallingTimer;

	/**
	 * Boolean field to tell whether the Tetromino can move down or not.
	 */
	private boolean canMoveDown;

	/**
	 * True if the tetromino is placed and cannot be moved anymore.
	 */
	private boolean placed;

	/**
	 * This is the listener for each individual Tetromino.
	 */
	TetrominoListener tetrominoListener;

	/**
	 * This constructor creates a random Tetromino. Sets its canMoveDown value to
	 * false because the Tetromino is stored for now.
	 */
	public Tetromino() {
		canMoveDown = false;
		placed = false;
		tetrominoShape = getRandomTetrominoShape();
		matrix = tetrominoShape.getMatrix();
		tetrominoListener = new TetrominoListener(this);
		
		// Sets and starts the timer for repeated action.
		fallingTimer = new Timer(500, tetrominoListener);
	}

	/**
	 * This method spawn an moves a tetromino.
	 */
	public void playingTetromino() {
		//Tetromino is spawned in at game grid
		spawnTetromino();
		startTetromino();
		
	}
	
	/**
	 * This method starts the timer of the falling interval of one tetromino.
	 */
	public void startTetromino() {
		fallingTimer.start();
	}
	
	/**
	 * This method stops the timer of the falling interval of one tetromino.
	 */
	public void stopTetromino() {
		fallingTimer.stop();
	}

	/**
	 * This method spawns the Tetromino. It makes the Tetromino moving down each X
	 * milliseconds (defined in the timer setting).
	 */
	private void spawnTetromino() {

		//TODO implement method for one Tetromino
		row = 0;
		col = 3;
		TetrisGame.getGameGrid().setValueAt(tetrominoShape, row, col);
		//
		
	}

	/**
	 * This method moves the Tetromino one row down. It stops it when it reached the
	 * bottom of the grid or another Tetromino.
	 */
	public void moveDown() {
		// If the Tetromino can is move down.
		if (canMoveDown()) {
			//TODO implement method for one Tetromino
			TetrisGame.getGameGrid().setValueAt(null, row, col);
			TetrisGame.getGameGrid().setValueAt(tetrominoShape, row + 1, col);
			row++;
			//TODO implement method for one Tetromino
		// If the Tetromino cannot move down.
		} else {
			// Stops the timer so the Tetromino stops moving.
			fallingTimer.stop();
		}
	}

	/**
	 * This method moves the Tetromino one row column left.
	 */
	public void moveLeft() {
		//TODO implement method for one Tetromino
		// If the Tetromino will not collide a block or a grid edge.
		if (col > 0 && TetrisGame.getGameGrid().getValueAt(row, col - 1) == null) {

			// Replaces the Tetromino cells values by null in its current location.
			TetrisGame.getGameGrid().setValueAt(null, row, col);

			// Rebuilds the Tetromino in its new location one column left.
			col--;
			TetrisGame.getGameGrid().setValueAt(tetrominoShape, row, col);
		}
		//
	}

	/**
	 * This method moves the Tetromino one row column right.
	 */
	public void moveRight() {
		//TODO implement method for one Tetromino
		// If the Tetromino will not collide a block or a grid edge.
		if (col < 9 && TetrisGame.getGameGrid().getValueAt(row, col + 1) == null) {

			// Replaces the Tetromino cells values by null in its current location.
			TetrisGame.getGameGrid().setValueAt(null, row, col);

			// Rebuilds the Tetromino in its new location one column left.
			col++;
			TetrisGame.getGameGrid().setValueAt(tetrominoShape, row, col);
		}
		//
	}

	/**
	 * This method rotates the Tetromino by +90 degrees in mathematically
	 * orientation.
	 */
	public void rotate() {
		// Create 4x4 rotation matrix for a 90 degree rotation
		int[][] rotationMatrix = new int[][] { { 1, 0, 0, 0 }, { 0, 0, -1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 } };
		matrix = matrixMultiplication(rotationMatrix, matrix);

		//TODO implement method for one Tetromino
	}

	/**
	 * This method place a tetromino a the lowest possible position in the game
	 * grid.
	 */
	public void dropToBottom() {
		for (int i = 0; i < 20; i++) {
			moveDown();
		}

	}

	// REMINDER : ADD A 2ND FIELD THAT RETURNS THE SIDE MOBILITY WITH A TIME DELAY
	// (last chance move).
	/**
	 * This method returns canMoveDown value.
	 * 
	 * @return canMoveDown
	 */
	public boolean canMoveDown() {
		canMoveDown = row < 19 && TetrisGame.getGameGrid().getValueAt(row + 1, col) == null;
		return canMoveDown;
	}

	/**
	 * This method returns a random Tetromino shape defined by a color and matrix
	 * for each shape.
	 * 
	 * @return Random Tetromino shape
	 */
	private Shapes getRandomTetrominoShape() {
		// Create randomizer
		Random random = new Random();

		// Create array with all shapes
		Shapes[] allShapes = Shapes.getAllShapes();

		// Use one random Shape
		return allShapes[random.nextInt(allShapes.length)];
	}

	/**
	 * This method computes a matrix-matrix multiplication.
	 * 
	 * @param matrix1 First matrix
	 * @param matrix2 Second matrix
	 * @return Multiplied matrix
	 */
	private int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
		int mtx1rows = matrix1.length;
		int mtx2rows = matrix2.length;
		int mtx1cols = matrix1[0].length;
		int mtx2cols = matrix2[0].length;

		// Check if both matrices can be multiplied
		if (mtx1cols == mtx2rows) {

			// Create result matrix with the new dimensions
			int[][] result = new int[mtx1rows][mtx2cols];

			// Execute matrix multiplication
			for (int i = 0; i < mtx1rows; i++) {
				for (int j = 0; j < mtx2cols; j++) {
					for (int k = 0; k < mtx1cols; k++) {
						result[i][j] += matrix1[i][k] * matrix2[k][j];
					}
				}
			}

			return result;

		} else {
			throw new IllegalArgumentException("Wrong matrix dimensions!");
		}
	}

	/**
	 * This method returns the shape of the tetromino.
	 */
	public Shapes getShape() {
		return tetrominoShape;
	}

	/**
	 * This method returns if the teromino is placed final on the game grid. Then the tetromino is not movable anymore.
	 * 
	 * @return true, if the tetromino is placed in the game grid
	 */
	public boolean getPlaced() {
		return placed;
	}

}