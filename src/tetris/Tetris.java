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
		
		int i = 0;
		
		while (i < 10) {
			Timer timer = new Timer();
			Block block = new Block(table, 0, 5);
	        timer.scheduleAtFixedRate(block, 0, 100);
	        while (block.isMoving()) {
	        	
	        }
	        i++;
		}
	}

}
