package tetris;

/**
 * This class runs the Tetris game.
 * 
 * @author Yoann Normand
 * @author Simon Rainer Reis
 */
public class Main {

	/**
	 * This is the main method which creates the Tetris application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main application = new Main();
		application.execute();
	}

	/**
	 * This method executes the Tetris Game
	 */
	private void execute() {
		new Game();
	}
	
}
