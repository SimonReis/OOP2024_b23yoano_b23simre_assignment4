package tetrominoes;

import java.awt.Color;
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

	// delete soon
	int n = 0;
	int m = 3;

	/**
	 * Shape of the tetromino in a 4x4 matrix.
	 */
	private int[][] matrix;

	/**
	 * Color of the tetromino.
	 */
	private Color color;

	/**
	 * Tetromino type defined by a letter.
	 */
	private Shapes tetrominoShape;

	/**
	 * Timer to set repeated down movement of the Tetromino.
	 */
	private Timer tetrominoTimer;

	/**
	 * Boolean field to tell whether the Tetromino can move down or not.
	 */
	private boolean canMoveDown;

	/**
	 * This constructor creates a random Tetromino. Sets its canMoveDown value to
	 * false because the Tetromino is stored for now.
	 * 
	 * @param color Background color
	 */
	public Tetromino() {
		gameGrid = TetrisGame.getGameGrid();
		canMoveDown = false;
		tetrominoShape = getRandomTetrominoShape();
		matrix = tetrominoShape.getMatrix();
		color = tetrominoShape.getColor();

	}

	/**
	 * This method spawns the Tetromino. It makes the Tetromino moving down each X
	 * milliseconds (defined in the timer setting).
	 */
	public void spawnTetromino() {

		row = 0;
		col = 3;
//		int offset = 0;
//		outerloop:
//		for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
//			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
//				if (matrix[rowMatrix][colMatrix] == 1) {
//					offset = rowMatrix;
//					break outerloop;
//				}
//			}
//		}
//
//		for (int rowMatrix = offset; rowMatrix < matrix.length; rowMatrix++) {
//			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
//				if (matrix[rowMatrix][colMatrix] == 1) {
//					gameGrid.setValueAt(tetrominoShape, row + rowMatrix - offset, col + colMatrix);
//				}
//			}
//		}
		gameGrid.setValueAt(tetrominoShape, row, col);

		ActionListener actionListener = new ActionListener() {

			// This action will be repeated each X milliseconds (defined in the timer
			// setting).
			@Override
			public void actionPerformed(ActionEvent e) {

				// Moves the Tetromino one row down.
				System.out.println("The Tetromino moves one step down.");
				moveDown();
			}
		};

		// Sets and starts the timer for repeated action.
		tetrominoTimer = new Timer(500, actionListener);
		tetrominoTimer.start();
	}

	/**
	 * This method moves the Tetromino one row down. It stops it when it reached the
	 * bottom of the grid or another Tetromino.
	 */
	public void moveDown() {
		//Changed to test clear lines
		// If the Tetromino can is move down.
		if (canMoveDown()) {
//			System.out.println(matrix.length);
//
//			// Replaces the Tetromino cells values by null in its current location.
//			for (int rowMatrix = matrix.length - 1; rowMatrix >= 0; rowMatrix--) {
//				for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
//					int rowToMove = row + rowMatrix;
//					int colToMove = col + colMatrix;
//					if (gameGrid.getValueAt(rowToMove, colToMove) == tetrominoShape) {
//						gameGrid.setValueAt(null, rowToMove, colToMove);
//						gameGrid.setValueAt(tetrominoShape, rowToMove + 1, colToMove);
//					}
//				}
//			}
//
//			// Rebuilds the Tetromino in its new location one row below.
//			row++;
			gameGrid.setValueAt(null, row, col);
			gameGrid.setValueAt(tetrominoShape, row +1, col);
			row++;
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
			gameGrid.setValueAt(tetrominoShape, row, col);
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
			gameGrid.setValueAt(tetrominoShape, row, col);
		}
	}

	/**
	 * This method rotates the Tetromino by +90 degrees in mathematically
	 * orientation.
	 */
	public void rotate() {
		// Create 4x4 rotation matrix for a 90 degree rotation
		int[][] rotationMatrix = new int[][] { { 1, 0, 0, 0 }, { 0, 0, -1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 } };

		matrix = matrixMultiplication(rotationMatrix, matrix);

		// set new grid value
	}
	
	/**
	 * This method place a tetromino a the lowest possible position in the game grid.
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
		canMoveDown = row < 19 && gameGrid.getValueAt(row + 1, col) == null;
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

}