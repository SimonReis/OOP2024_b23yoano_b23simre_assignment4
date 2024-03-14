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
		GameListener gameListener = new GameListener();
		frame.addKeyListener(gameListener);
		while (true) {
			Block block = new Block(table, 0, 4);
	        while (block.isMoving()) {
	        	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		}
	}

}
