package tetris;

/**
 * This class runs the Tetris game.
 * 
 * @author Yoann Normand
 * @author Simon Rainer Reis
 */
public class Tetris {

	/**
	 * This is the main method which creates the Tetris application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Tetris application = new Tetris();
		application.execute();
	}

	/**
	 * This method executes the Tetris Game
	 */
	private void execute() {
		GameFrame frame = new GameFrame();
		frame.setVisible(true);
		frame.pack();
	}
}
