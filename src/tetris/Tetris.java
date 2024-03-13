package tetris;

import java.util.Timer;

/**
 * This class runs the Tetris game.
 * 
 
 * @author Yoann Normand
 * @author Simon Rainer Reis
 */
public class Tetris {

	public static void main(String[] args) {
		System.out.println("Implement Tetris!");
		Tetris application = new Tetris();
		application.execute();
	}
	
	private void execute() {
		System.out.println("Execute");
		GridTable table = new GridTable();
		GameFrame frame = new GameFrame(table);
		frame.setVisible(true);
		frame.pack();
        Timer timer = new Timer();
        long delay = 100; // Delay in milliseconds
        timer.scheduleAtFixedRate(new Block(table, 0, 5), 0, delay);
	}

}
