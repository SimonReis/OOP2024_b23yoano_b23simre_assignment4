package tetris;

import java.util.Timer;

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
		
		GridTable table = new GridTable();
		GameFrame frame = new GameFrame(table);
		frame.setVisible(true);
		frame.pack();
        Timer timer = new Timer();
        long delay = 100; // Delay in milliseconds
        try {
            timer.scheduleAtFixedRate(new Block(table, 0, 5), 0, delay);
        } catch (RuntimeException e) {
        	e.printStackTrace();
            System.out.println("Action stopped!");
            timer.cancel();
        }
	}

}
