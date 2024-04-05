package tetrominoes;

import java.util.Random;

import javax.swing.Timer;

import listeners.TetrominoListener;
import tetris.TetrisGame;
import tetris.TetrominoFactory;

/**
 * This class represents the shapes from the game Tetris.
 */
public class Tetromino {
	
	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;

	/**
	 * This is the tetromino factory.
	 */
	private TetrominoFactory tetrominoFactory;

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
	 * Tetromino type both movable and not movable.
	 */
	private Shapes[] tetrominoShapeDuo;

	/**
	 * Tetromino type only movable.
	 */
	private Shapes tetrominoShape;

	/**
	 * Timer to set repeated down movement of the Tetromino.
	 */
	private Timer fallingTimer;

	/**
	 * Boolean fields to tell whether the Tetromino can move or not.
	 */
	private boolean canMoveDown;
	private boolean canMoveLeft;
	private boolean canMoveRight;

	/**
	 * This is the listener for each individual Tetromino.
	 */
	private TetrominoListener tetrominoListener;

	/**
	 * Variable to store the number of "free" rows (full of 0) in the top part of
	 * the shape matrix. Allows to spawn the Tetromino with its top on the first row
	 * of the grid.
	 */
	private int offsetTop = 0;

	private boolean isSpawnable;

	/**
	 * This constructor creates a random Tetromino.
	 */
	public Tetromino(TetrisGame game) {
		
		this.game = game;

		// gameGrid = TetrisGame.getGameInstance().getFrame().getGameGrid();
		tetrominoFactory = this.game.getFactory();

		canMoveDown = true;
		canMoveLeft = true;
		canMoveRight = true;

		tetrominoShapeDuo = getRandomTetrominoShapeDuo();
		tetrominoShape = tetrominoShapeDuo[0];
		matrix = tetrominoShape.getMatrix();

		tetrominoListener = new TetrominoListener(this);
		// Sets and starts the timer for repeated action.
		fallingTimer = new Timer(500, tetrominoListener);

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
	 * This method spawn an moves a tetromino.
	 */
	public void playingTetromino() {
		// Tetromino is spawned in at game grid
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
		// TODO ADD A isSpawnable() METHOD

		// Spawning coordinates (top left corner of the Tetromino).
		row = 0;
		col = 3;
		
		if (isSpawnable()) {
			
			for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
				for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
					if (matrix[rowMatrix][colMatrix] == 1) {

						System.out.println("(row, col) = (" + row + ", " + col + "); (rowMatrix, colMatrix) = (" + rowMatrix
								+ ", " + colMatrix + "); offsetTop = " + offsetTop);

						// TODO FIX THE ROW INDEX OUT OF BOUNDARIES BUG
						game.getFrame().getGameGrid().setValueAt(tetrominoShape,
								row + rowMatrix - offsetTop, col + colMatrix);
					}
				}
			}
			
		}

	}

	private boolean isSpawnable() {
		
		row = 0;
		col = 3;
		
		try {
		for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
			for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
				if (matrix[rowMatrix][colMatrix] == 1) {
					if (game.getFrame().getGameGrid().getValueAt(row + rowMatrix - offsetTop,
							col + colMatrix) != null) {
						return false;
					}
				}
			}
		}
		} catch (Exception e) {
			matrix = rotateMatrix(matrix);
			isSpawnable();
		}
		return true;
	}

	/**
	 * This method moves the Tetromino one row down.It stops it when it reached the
	 * bottom of the grid or a previous Tetromino.
	 */
	public void moveDown() {
		// If the Tetromino can is move down.
		// Pauses the Tetromino natural down movement and move it down.
		if (canMoveDown()) {

			fallingTimer.stop();
			// tetrominoFactory.stopTimer();

			for (int rowGrid = TetrisGame.getGameInstance().getFrame().getGameGrid().getRowCount()
					- 1; rowGrid >= 0; rowGrid--) {
				for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
						.getColumnCount(); colGrid++) {
					if (TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
							colGrid) == tetrominoShape) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(null, rowGrid, colGrid);
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(tetrominoShape, rowGrid + 1,
								colGrid);
					}
				}
			}
			row++;
			fallingTimer.restart();
			// tetrominoFactory.stopTimer();

			// If the Tetromino cannot move down.
			// Stops the Tetromino natural down movement.
		} else {

			fallingTimer.stop();
			// tetrominoFactory.stopTimer();

			for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getRowCount(); rowGrid++) {
				for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
						.getColumnCount(); colGrid++) {
					if (TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
							colGrid) == tetrominoShape) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(tetrominoShapeDuo[1], rowGrid,
								colGrid);
					}
				}
			}
			// tetrominoFactory.restartTimer();
		}
	}

	/**
	 * This method moves the Tetromino one column to the left.
	 */
	public void moveLeft() {

		// If the Tetromino can is move left.
		// Pauses the Tetromino natural down movement and move it to the left.
		if (canMoveLeft()) {

			fallingTimer.stop();

			for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getRowCount(); rowGrid++) {
				for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
						.getColumnCount(); colGrid++) {
					if (TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
							colGrid) == tetrominoShape) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(null, rowGrid, colGrid);
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(tetrominoShape, rowGrid,
								colGrid - 1);
					}
				}
			}
			col--;
			fallingTimer.restart();
			System.out.println("The Tetromino moved left");
		}
		canMoveLeft = true;
	}

	/**
	 * This method moves the Tetromino one row column to the right.
	 */
	public void moveRight() {

		// If the Tetromino can is move right.
		// Pauses the Tetromino natural down movement and move it to the right.
		if (canMoveRight()) {

			fallingTimer.stop();

			for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getRowCount(); rowGrid++) {
				for (int colGrid = TetrisGame.getGameInstance().getFrame().getGameGrid().getColumnCount()
						- 1; colGrid >= 0; colGrid--) {
					if (TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
							colGrid) == tetrominoShape) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(null, rowGrid, colGrid);
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(tetrominoShape, rowGrid,
								colGrid + 1);
					}
				}
			}
			col++;
			fallingTimer.restart();
			System.out.println("The Tetromino moved right");
		}
		canMoveRight = true;
	}

	/**
	 * This method rotates the Tetromino by 90° clockwise.
	 */
	public void rotate() {

		// If the Tetromino can rotate.
		// Pauses the Tetromino natural down movement and rotate it.
		if (col >= 0 && col + 3 <= TetrisGame.getGameInstance().getFrame().getGameGrid().getColumnCount() - 1) {

			fallingTimer.stop();

			matrix = rotateMatrix(matrix);

			// Remove the Tetromino from the grid.
			for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getRowCount(); rowGrid++) {
				for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
						.getColumnCount(); colGrid++) {
					if (TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
							colGrid) == tetrominoShape) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(null, rowGrid, colGrid);
					}
				}
			}

			// Add the Tetromino with new orientation to the grid.
			for (int rowMatrix = 0; rowMatrix < matrix.length; rowMatrix++) {
				for (int colMatrix = 0; colMatrix < matrix[0].length; colMatrix++) {
					if (matrix[rowMatrix][colMatrix] == 1) {
						TetrisGame.getGameInstance().getFrame().getGameGrid().setValueAt(tetrominoShape,
								row + rowMatrix, col + colMatrix);
					}
				}
			}
			fallingTimer.restart();
			System.out.println("The " + this.getShape() + "-Tetromino rotated");
		}
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

	/**
	 * This method returns canMoveDown value.
	 * 
	 * @return canMoveDown
	 */
	public boolean canMoveDown() {

		overloop: for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
				.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getColumnCount(); colGrid++) {
				Object valueCurrentCell = TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
						colGrid);
				if (valueCurrentCell == tetrominoShape) {
					if (rowGrid == TetrisGame.getGameInstance().getFrame().getGameGrid().getRowCount() - 1) {
						canMoveDown = false;
						break overloop;
					} else {
						Object valueBelowCell = TetrisGame.getGameInstance().getFrame().getGameGrid()
								.getValueAt(rowGrid + 1, colGrid);
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

	/**
	 * This method returns canMoveLeft value.
	 * 
	 * @return canMoveLeft
	 */
	public boolean canMoveLeft() {
		overloop: for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
				.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getColumnCount(); colGrid++) {
				Object valueCurrentCell = TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
						colGrid);
				if (valueCurrentCell == tetrominoShape) {
					if (colGrid == 0) {
						canMoveLeft = false;
						break overloop;
					} else {
						Object valueLeftCell = TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
								colGrid - 1);
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

	/**
	 * This method returns canMoveRight value.
	 * 
	 * @return canMoveRight
	 */
	public boolean canMoveRight() {
		overloop: for (int rowGrid = 0; rowGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
				.getRowCount(); rowGrid++) {
			for (int colGrid = 0; colGrid < TetrisGame.getGameInstance().getFrame().getGameGrid()
					.getColumnCount(); colGrid++) {
				Object valueCurrentCell = TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
						colGrid);
				if (valueCurrentCell == tetrominoShape) {
					if (colGrid == TetrisGame.getGameInstance().getFrame().getGameGrid().getColumnCount() - 1) {
						canMoveRight = false;
						break overloop;
					} else {
						Object valueLeftCell = TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(rowGrid,
								colGrid + 1);
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
	 * @return Random Tetromino shape duo
	 */
	private Shapes[] getRandomTetrominoShapeDuo() {
		Random random = new Random();
		Shapes[][] allShapes = Shapes.getAllShapeDuos();
		return allShapes[random.nextInt(allShapes.length)];
	}

	/**
	 * This method rotates a 4x4 matrix 90° clockwise.
	 * 
	 * @param matrix Matrix to rotate
	 * @return rotated matrix
	 */
	public int[][] rotateMatrix(int[][] matrix) {
		if (matrix.length != matrix[0].length || matrix.length != 4) {
			throw new IllegalArgumentException("Matrix must be a square 4x4 matrix");
		}
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
				matrix[j][matrix.length - 1 - i] = temp;
			}
		}
		return matrix;
	}

	/**
	 * This method returns the shape of the Tetromino.
	 */
	public Shapes getShape() {
		return tetrominoShape;
	}

}