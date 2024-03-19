package tetris;

/**
 * This class is the entry point for the Tetris application.
 * 
 * @author Yoann Normand
 * @author Simon Rainer Reis
 */
<<<<<<<< HEAD:src/tetris/Main.java
public class Main {
========
public class TetrisMain {
>>>>>>>> simon:src/tetris/TetrisMain.java

	/**
	 * This is the main method which creates the Tetris application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
<<<<<<<< HEAD:src/tetris/Main.java
		Main application = new Main();
========
		TetrisMain application = new TetrisMain();
>>>>>>>> simon:src/tetris/TetrisMain.java
		application.execute();
	}

	/**
	 * This method executes the Tetris Game
	 */
	private void execute() {
		new TetrisGame();
	}
	
}
