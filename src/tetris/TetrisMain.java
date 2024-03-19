package tetris;

/**
 * This class is the entry point for the Tetris application.
 * 
 * @author Yoann Normand
 * @author Simon Rainer Reis
 */
public class TetrisMain {

	/**
	 * This is the main method which creates the Tetris application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TetrisMain application = new TetrisMain();
		application.execute();
	}

	/**
	 * This method executes the Tetris Game
	 */
	private void execute() {
		new TetrisGame();
	}
	
}
