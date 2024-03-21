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
	private Shapes[] tetrominoShapeDuo;
	
	private Shapes tetrominoShape;

	/**
	 * Timer to set repeated down movement of the Tetromino.
	 */
	private Timer tetrominoTimer;

	/**
	 * Boolean field to tell whether the Tetromino can move down or not.
	 */
	private boolean canMoveDown;
	private boolean canMoveLeft;
	private boolean canMoveRight;

	private int offsetTop = 0;
	private int offsetBottom = 0;
	private int offsetLeft = 0;
	private int offsetRight = 0;

	/**
	 * This constructor creates a random Tetromino. Sets its canMoveDown value to
	 * false because the Tetromino is stored for now.
	 * 
	 * @param color Background color
	 */
	public Tetromino() {
		gameGrid = TetrisGame.getGameGrid();
		canMoveDown = true;
		canMoveLeft = true;
		canMoveRight = true;
		tetrominoShapeDuo = getRandomTetrominoShapeDuo();
		tetrominoShape = tetrominoShapeDuo[0];
		System.out.println(tetrominoShape);
		matrix = tetrominoShape.getMatrix();
		color = tetrominoShape.getColor();

		// Gets the first row with a "1" in the Tetromino Shape.
		outerloop: for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					offsetTop = rowMatrix;
					break outerloop;
				}
			}
		}

		// Gets the last row with a "1" in the Tetromino Shape.
		outerloop: for (int rowMatrix = matrix.length - 1; rowMatrix >= 0; rowMatrix--) {
			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					offsetBottom = rowMatrix;
					break outerloop;
				}
			}
		}
		
		outerloop: for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
			for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					offsetLeft = colMatrix;
					break outerloop;
				}
			}
		}
		
		outerloop: for (int colMatrix = matrix[0].length - 1; colMatrix >= 0; colMatrix--) {
			for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					offsetRight = colMatrix;
					break outerloop;
				}
			}
		}
		System.out.println(offsetLeft);
		System.out.println(offsetRight);

	}

	/**
	 * This method spawns the Tetromino. It makes the Tetromino moving down each X
	 * milliseconds (defined in the timer setting).
	 */
	public void spawnTetromino() {

		// Sets the spawning position of the Tetromino (coordinates of its top left
		// corner).
		row = 0;
		col = 3;

		// Fills the cells in the game grid with the Tetromino Shape.
		for (int rowMatrix = offsetTop; rowMatrix <= offsetBottom; rowMatrix++) {
			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					gameGrid.setValueAt(tetrominoShape, row + rowMatrix - offsetTop, col + colMatrix);
				}
			}
		}

// Activate later!!		

		ActionListener actionListener = new ActionListener() {

			// This action will be repeated each X milliseconds (defined in the timer
			// setting).
			@Override
			public void actionPerformed(ActionEvent e) {

				// Moves the Tetromino one row down.
				moveDown();
			}
		};

		// Sets and starts the timer for repeated action.
		tetrominoTimer = new Timer(1000, actionListener);
		tetrominoTimer.start();
	}

	/**
	 * This method moves the Tetromino one row down. It stops it when it reached the
	 * bottom of the grid or another Tetromino.
	 */
	public void moveDown() {

		// If the Tetromino can is move down.
		if (canMoveDown()) {

			// Replaces the Tetromino cells values by null in its current location.
			for (int rowMatrix = offsetBottom; rowMatrix >= offsetTop; rowMatrix--) {

				for (int colMatrix = offsetLeft; colMatrix <= offsetRight; colMatrix++) {

					int rowToMove = row + rowMatrix - offsetTop;
					int colToMove = col + colMatrix;

					if (gameGrid.getValueAt(rowToMove, colToMove) == tetrominoShape) {
						gameGrid.setValueAt(null, rowToMove, colToMove);
						gameGrid.setValueAt(tetrominoShape, rowToMove + 1, colToMove);
					}
				}
			}

			// Sets the new location of the Tetromino.
			row++;

		// If the Tetromino cannot move down.
		} else {

			for (int rowMatrix = offsetBottom; rowMatrix >= offsetTop; rowMatrix--) {

				for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {

					int rowToMove = row + rowMatrix - offsetTop;
					int colToMove = col + colMatrix;

					if (gameGrid.getValueAt(rowToMove, colToMove) != null) {
						Shapes cellValue = (Shapes) gameGrid.getValueAt(rowToMove, colToMove);
						if (cellValue.isMovable() == true) {
							gameGrid.setValueAt(tetrominoShapeDuo[1], rowToMove, colToMove);
						}
					}

				}

			}

			// Stops the timer so the Tetromino stops moving.
			tetrominoTimer.stop();
		}
	}

	/**
	 * This method moves the Tetromino one row column left.
	 */
	public void moveLeft() {

		// If the Tetromino will not collide a block or a grid edge.
		if (canMoveLeft()) {
			
			//System.out.println("Can move left ? true");

			for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
				
				// For each column of the matrix.
				for (int colMatrix = offsetLeft; colMatrix <= offsetRight; colMatrix++) {
					
					// Gets the corresponding cell location on the grid
					int rowToMove = row + rowMatrix;
					int colToMove = col + colMatrix;
					
					System.out.println(rowToMove + " ; " + colToMove);
					
					if (gameGrid.getValueAt(rowToMove, colToMove) == tetrominoShape) {
						gameGrid.setValueAt(null, rowToMove, colToMove);
						gameGrid.setValueAt(tetrominoShape, rowToMove, colToMove - 1);
					}
					
				}
			}
			col--;
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

	// REMINDER : ADD A 2ND FIELD THAT RETURNS THE SIDE MOBILITY WITH A TIME DELAY
	// (last chance move).
	/**
	 * This method returns canMoveDown value.
	 * 
	 * @return canMoveDown
	 */
	public boolean canMoveDown() {

		// For each non empty row of the matrix.
		overloop: for (int rowMatrix = offsetBottom; rowMatrix >= offsetTop; rowMatrix--) {
			
			// For each column of the matrix.
			for (int colMatrix = offsetLeft; colMatrix <= offsetRight; colMatrix++) {
				
				// Gets the corresponding cell location on the grid
				int rowToMove = row + rowMatrix - offsetTop;
				int colToMove = col + colMatrix;
				
				// If there is no cell below (it reached the bottom of the grid)
				// Sets the Tetromino mobility checker to false. 
				if (rowToMove + 1 >= gameGrid.getRowCount()) {

					canMoveDown = false;
					break overloop;

				} else {
					
					Object valueCurrentCell = gameGrid.getValueAt(rowToMove, colToMove);
					Object valueBelowCell = gameGrid.getValueAt(rowToMove + 1, colToMove);

					if (valueCurrentCell != null && valueBelowCell != null) {

						Shapes shapeCurrentCell = (Shapes) valueCurrentCell;
						Shapes shapeBelowCell = (Shapes) valueBelowCell;

						if (shapeCurrentCell.isMovable() == true && shapeBelowCell.isMovable() == false) {
							canMoveDown = false;
							break overloop;
						}
					}
				}

			}
		}
		return canMoveDown;
	}
	
	public boolean canMoveLeft() {

		// For each non empty row of the matrix.
		overloop: for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
			
			// For each column of the matrix.
			for (int colMatrix = offsetRight; colMatrix >= offsetLeft; colMatrix--) {
				
				// Gets the corresponding cell location on the grid
				int rowToMove = row + rowMatrix;
				int colToMove = col + colMatrix - offsetLeft;
				
				// If there is no cell below (it reached the bottom of the grid)
				// Sets the Tetromino mobility checker to false. 
				if (colToMove - 1 < 0) {

					canMoveLeft = false;
					break overloop;

				} else {
					
					Object valueCurrentCell = gameGrid.getValueAt(rowToMove, colToMove);
					Object valueLeftCell = gameGrid.getValueAt(rowToMove, colToMove - 1);

					if (valueCurrentCell != null && valueLeftCell != null) {

						Shapes shapeCurrentCell = (Shapes) valueCurrentCell;
						Shapes shapeLeftCell = (Shapes) valueLeftCell;

						if (shapeCurrentCell.isMovable() == true && shapeLeftCell.isMovable() == false) {
							canMoveLeft = false;
							break overloop;
						}
					}
				}

			}
		}
		return canMoveLeft;
	}

	/**
	 * This method returns a random Tetromino shape defined by a color and matrix
	 * for each shape.
	 * 
	 * @return Random Tetromino shape
	 */
	private Shapes[] getRandomTetrominoShapeDuo() {
		// Create randomizer
		Random random = new Random();

		// Create array with all shapes
		Shapes[][] allShapes = Shapes.getAllShapeDuos();

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
	public Shapes[] getShapeDuo() {
		return tetrominoShapeDuo;
	}
	
	public Shapes getShape() {
		return tetrominoShape;
	}

}