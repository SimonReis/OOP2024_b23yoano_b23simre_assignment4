package tetrominoes;

import java.awt.Color;

/**
 * This enum defines the different shapes and its color.
 */
public enum Shapes {
	
	// I shape in cyan
	I(Color.cyan, new int[][]{
		{0, 0, 0, 0}, 
		{0, 0, 0, 0}, 
		{1, 1, 1, 1}, 
		{0, 0, 0, 0}
		}, true),
	
	// J shape in blue
	J(Color.blue, new int[][]{
		{0, 0, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, true),
	
	// L shape in orange
	L(Color.orange, new int[][]{
		{0, 1, 0, 0}, 
		{0, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, true),
	
	// O shape in yellow
	O(Color.yellow, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, true),
		
	// S shape in green
	S(Color.green, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{1, 1, 0, 0}, 
		{0, 0, 0, 0}
		}, true),
	
	// T shape in pink
	T(Color.pink, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 1, 0}, 
		{0, 1, 0, 0}, 
		{0, 0, 0, 0}
		}, true),

	// Z shape in red
	Z(Color.red, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, true);

	/**
	 * Properties of a Tetromino shape.
	 */
	private Color color;
	private int[][] matrix;
	private boolean movable;

	/**
	 * This constructor gives each Tetromino shape its color and matrix.
	 * 
	 * @param color  Color of the Tetromino
	 * @param matrix 4x4 Matrix where the Tetromino is stored
	 */
	private Shapes(Color color, int[][] matrix, boolean movable) {
		this.color = color;
		this.matrix = matrix;
		this.movable = movable;
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
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * This method returns all shapes in an array;
	 * 
	 * @return All shapes stored in an array
	 */
	public static Shapes[] getAllShapes() {
		return new Shapes[] { I, J, L, O, S, T, Z };
	}
	
	/**
	 * This method returns the mobility of the shape.
	 * 
	 * @return True if shape is movable
	 */
	public boolean isMovable() {
		return movable;
	}
	
	/**
	 * This method changes the mobility of the shape.
	 */
	public void setToNotMovable() {
		movable = false;
	}
}
	
