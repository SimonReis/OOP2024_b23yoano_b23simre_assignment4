package tetris;

public class Game {

	private static Grid gameGrid;

	public Game() {
		gameGrid = new Grid(20, 10);
		GameFrame frame = new GameFrame();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.pack();
	}

	public static Grid getGameGrid() {
		return gameGrid;
	}

	public static void setGameGrid(Grid grid) {
		gameGrid = grid;
	}
	
	

}
