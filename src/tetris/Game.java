package tetris;

public class Game {

	private static Game gameInstance;
	private static Grid gameGrid;
	private static GameFrame frame;

	public Game() {
		
		gameGrid = new Grid(20, 10);
		frame = new GameFrame();
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.pack();
		gameInstance = this;
	}
	
	public static Game getGameInstance() {
		return gameInstance;
	}

	public static Grid getGameGrid() {
		return gameGrid;
	}

	public static void setGameGrid(Grid grid) {
		gameGrid = grid;
	}
	
	public GameFrame getFrame() {
		return frame;
	
	}

	/**
	 * This method is called, when a new game should start. The view will change,
	 * the production of Tetrominos start and they will spawned in the game frame.
	 */
	public void startGame() {
		// Change View
		frame.setGameView();
		frame.setFocusable(true);
		frame.pack();

		// Start Falling blocks
		TetrominoFactory blockFactory = new TetrominoFactory();
		blockFactory.startProduction();

	}
	
	public void endGame() {
		// Change View
		frame.setMenuView();
		frame.setFocusable(true);
		frame.pack();
	}

}
