package tetrominoes;

import java.awt.Color;

/**
 * This enum defines the different shapes, its color and its mobility.
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
		}, true),
	
	// Ix shape in cyan and not movable
	Ix(Color.cyan, new int[][]{
		{0, 0, 0, 0}, 
		{0, 0, 0, 0}, 
		{1, 1, 1, 1}, 
		{0, 0, 0, 0}
		}, false),
	
	// Jx shape in blue and not movable
	Jx(Color.blue, new int[][]{
		{0, 0, 1, 0}, 
		{0, 0, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, false),
	
	// Lx shape in orange and not movable
	Lx(Color.orange, new int[][]{
		{0, 1, 0, 0}, 
		{0, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, false),
	
	// Ox shape in yellow and not movable
	Ox(Color.yellow, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, false),
		
	// Sx shape in green and not movable
	Sx(Color.green, new int[][]{
		{0, 0, 0, 0}, 
		{0, 1, 1, 0}, 
		{1, 1, 0, 0}, 
		{0, 0, 0, 0}
		}, false),
	
	// Tx shape in pink and not movable
	Tx(Color.pink, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 1, 0}, 
		{0, 1, 0, 0}, 
		{0, 0, 0, 0}
		}, false),

	// Zx shape in red and not movable
	Zx(Color.red, new int[][]{
		{0, 0, 0, 0}, 
		{1, 1, 0, 0}, 
		{0, 1, 1, 0}, 
		{0, 0, 0, 0}
		}, false);

	/**
	 * Properties of a Tetromino shape.
	 */
	private Color color;
	private int[][] matrix;
	private boolean movable;

	/**
	 * This constructor gives each Tetromino shape its color and matrix.
	 * 
	 * @param color Color of the Tetromino
	 * @param matrix 4x4 Matrix where the Tetromino is stored
	 * @param movable Mobility state of the Tetromino
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
	 * This method returns the mobility state of the shape.
	 * 
	 * @return movable which tells if the shape can be move.
	 */
	public boolean isMovable() {
		return movable;
	}

	/**
	 * This method returns all shape duos in an array.
	 * 
	 * @return All shape duos stored in an array.
	 */
	public static Shapes[][] getAllShapeDuos() {
		return new Shapes[][] { {I, Ix}, {J, Jx}, {L, Lx}, {O, Ox}, {S, Sx}, {T, Tx}, {Z, Zx} };
	}
}
	
