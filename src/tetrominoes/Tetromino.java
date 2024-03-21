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

	private boolean canMoveDownDelayed;

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

		// Gets the first row with a "1" in the Tetromino Shape.
		outerloop: for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					offsetTop = rowMatrix;
					break outerloop;
				}
			}
		}

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
		for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
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
		tetrominoTimer = new Timer(500, actionListener);
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
			for (int rowGrid = gameGrid.getRowCount() - 1; rowGrid >= 0; rowGrid--) {

				for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {

					if (gameGrid.getValueAt(rowGrid, colGrid) == tetrominoShape) {

						gameGrid.setValueAt(null, rowGrid, colGrid);
						gameGrid.setValueAt(tetrominoShape, rowGrid + 1, colGrid);
					}
				}
			}

			// If the Tetromino cannot move down.
		} else {

			for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {

				for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {

					if (gameGrid.getValueAt(rowGrid, colGrid) == tetrominoShape) {

						gameGrid.setValueAt(tetrominoShapeDuo[1], rowGrid, colGrid);
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
		if (canMoveLeft()) {

			// Replaces the Tetromino cells values by null in its current location.
			for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {

				for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {

					if (gameGrid.getValueAt(rowGrid, colGrid) == tetrominoShape) {

						gameGrid.setValueAt(null, rowGrid, colGrid);
						gameGrid.setValueAt(tetrominoShape, rowGrid, colGrid - 1);
					}
				}
			}
		}
	}

	/**
	 * This method moves the Tetromino one row column right.
	 */
	public void moveRight() {
		if (canMoveRight()) {

			// Replaces the Tetromino cells values by null in its current location.
			for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {

				for (int colGrid = gameGrid.getColumnCount() - 1; colGrid >= 0; colGrid--) {

					if (gameGrid.getValueAt(rowGrid, colGrid) == tetrominoShape) {

						gameGrid.setValueAt(null, rowGrid, colGrid);
						gameGrid.setValueAt(tetrominoShape, rowGrid, colGrid + 1);
					}
				}
			}
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

		overloop: for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {
				Object valueCurrentCell = gameGrid.getValueAt(rowGrid, colGrid);
				if (valueCurrentCell == tetrominoShape) {
					if (rowGrid == gameGrid.getRowCount() - 1) {
						canMoveDown = false;
						break overloop;
					} else {
						Object valueBelowCell = gameGrid.getValueAt(rowGrid + 1, colGrid);
						if (valueBelowCell != null && valueBelowCell != tetrominoShape) {
							canMoveDown = false;
							break overloop;
						}
					}
				}
			}
		}
		return canMoveDown;
	}
	
	public boolean canMoveDownDelayed() {
		
		ActionListener actionListener = new ActionListener() {

			// This action will be repeated each X milliseconds (defined in the timer
			// setting).
			@Override
			public void actionPerformed(ActionEvent e) {

				// Moves the Tetromino one row down.
				canMoveDownDelayed = canMoveDown;
			}
		};

		// Sets and starts the timer for repeated action.
		tetrominoTimer = new Timer(1000, actionListener);
		tetrominoTimer.start();
		return canMoveDownDelayed;
	}

	public boolean canMoveLeft() {
		overloop: for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {
				Object valueCurrentCell = gameGrid.getValueAt(rowGrid, colGrid);
				if (valueCurrentCell == tetrominoShape) {
					if (colGrid == 0) {
						canMoveLeft = false;
						break overloop;
					} else {
						Object valueLeftCell = gameGrid.getValueAt(rowGrid, colGrid - 1);
						if (valueLeftCell != null && valueLeftCell != tetrominoShape) {
							canMoveLeft = false;
							break overloop;
						}
					}
				}
			}
		}
		return canMoveLeft;
	}
	
	public boolean canMoveRight() {
		overloop: for (int rowGrid = 0; rowGrid < gameGrid.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < gameGrid.getColumnCount(); colGrid++) {
				Object valueCurrentCell = gameGrid.getValueAt(rowGrid, colGrid);
				if (valueCurrentCell == tetrominoShape) {
					System.out.println(colGrid);
					if (colGrid == gameGrid.getColumnCount() - 1) {
						canMoveRight = false;
						break overloop;
					} else {
						Object valueLeftCell = gameGrid.getValueAt(rowGrid, colGrid + 1);
						if (valueLeftCell != null && valueLeftCell != tetrominoShape) {
							canMoveRight = false;
							break overloop;
						}
					}
				}
			}
		}
		return canMoveRight;
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
	public Shapes getShape() {
		return tetrominoShape;
	}

}