package tetris;

import tetrominoes.Tetromino;

/**
 * This class implements the game rules of the tetris game.
 */
public class GameRules {
				
	
	
	/**
	 * This method computes a matrix-matrix multiplication.
	 * 
	 * @param matrix1 First matrix
	 * @param matrix2 Second matrix
	 * @return Multiplied matrix
	 */
	public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
		//TODO implement method from tetromino
		return null;
	}
	
//	/**
//	 * This method checks if the game is over, by a non movable block in the first row of the game grid.
//	 * 
//	 * @return True if the game is over.
//	 */
//	public static boolean isGameOver() {
//		for (int col = 0; col < TetrisGame.getGameInstance().getFrame().getGameGrid().getColumnCount(); col++) {
//			// Check if there is a non movable block in the first row
//			if (Tetromino.class.cast(TetrisGame.getGameInstance().getFrame().getGameGrid().getValueAt(0, col)).getPlaced()) {
//				return true;
//			}
//		}
//		return false;
//	}
}
