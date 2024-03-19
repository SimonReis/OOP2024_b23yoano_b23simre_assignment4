package tetrominoes;

import java.awt.Color;

/**
 * This enum defines the different shapes and its color
 */
public enum Shapes {
	
	// I shape in cyan
	I(Color.cyan, new int[][]{
		{0, 0, 0, 0}, 
		{0, 0, 0, 0}, 
		{1, 1, 1, 1}, 
		{0, 0, 0, 0}
		},
		3, 3),
	
	// J shape in blue
	J(Color.blue, new int[][]{
		{0, 0, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		},
		3, 1),
	
	// L shape in orange
	L(Color.orange, new int[][]{
		{0, 1, 0, 0}, 
		{0, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		},
		3, 3),
	
	// O shape in yellow
	O(Color.yellow, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		},
		3,  2),
		
	// S shape in green
	S(Color.green, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{1, 1, 0, 0}, 
		{0, 0, 0, 0}
		},
		3, 2),
	
	// T shape in pink
	T(Color.pink, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 1, 0}, 
		{0, 1, 0, 0}, 
		{0, 0, 0, 0}
		},
		3, 2),
	
	// Z shape in red
	Z(Color.red, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		},
		3, 2);
	
	/**
	 * Properties of a Tetromino shape.
	 */
	private Color color;
	private int[][] matrix;
	private int startRow, startCol;
	
	/**
	 * This constructor gives each Tetromino shape its color and matrix.
	 * 
	 * @param color Color of the Tetromino
	 * @param matrix 4x4 Matrix where the Tetromino is stored
	 */
	private Shapes(Color color, int[][] matrix, int startCol,  int startRow) {
		this.color = color;
		this.matrix = matrix;
	}
	
	/**
	 * This method returns the color of the Tetromino shape.
	 * 
	 * @return Color of the Shape
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * This method returns the matrix of the Tetromino shape.
	 * 
	 * @return 4x4 Matrix where the shape is stored
	 */
	public int[][] getMatrix(){
		return matrix;
	}
	
	/**
	 * This method returns the row where the program should start to increment for spawn the tetromino.
	 * 
	 * @return Number of row of matrix
	 */
	public int getStartRow() {
		return startRow;
	}
	
	/**
	 * This method returns the column where the program should start to increment for spawn the tetromino.
	 * 
	 * @return Number of row of matrix
	 */
	public int getStartCol() {
		return startCol;
	}
	
	/**
	 * This method returns all shapes in an array;
	 * 
	 * @return All shapes stored in an array
	 */
	public static Shapes[] getAllShapes() {	
		return new Shapes[]{I, J, L, O, S, T, Z};		
	}

}
