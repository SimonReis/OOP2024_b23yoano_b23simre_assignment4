package tetris;

/**
 * This class is a grid and represents the next grid where the next tetromino is displayed.
 */
public class NextGrid extends Grid {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates the game grid with a size of 20 x 10.
	 */
	public NextGrid( TetrisGame tetrisGame) {
		super(tetrisGame, 4, 4);
	}

}
