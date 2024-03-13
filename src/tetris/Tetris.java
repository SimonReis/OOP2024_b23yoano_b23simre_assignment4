package tetris;

import java.util.Random;
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
		Timer timer = new Timer();
		while (true) {
			Random r = new Random();
			int low = 0;
			int high = 10;
			int col = r.nextInt(high-low) + low;
			Block block = new Block(table, 0, col);
	        timer.scheduleAtFixedRate(block, 0, 100);
	        while (block.isMoving()) {
	        	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        i++;
		}
	}

}
