package panels;

import java.awt.Color;

import javax.swing.JPanel;

import listeners.GameFrameListener;
import tetris.MainFrame;
import tetris.Grid;

/**
 * This class represents the panel with the grid for the Tetris game.
 */
public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	Grid gameGrid;

	/**
	 * This constructor creates the grid panel where the Tetrominos are stored.
	 * 
	 * @param color Background color of the grid panel
	 */
	public GridPanel(MainFrame gameFrame, Grid gameGrid, Color color) {

		this.setBackground(color);
		this.add(gameGrid);
		
		// Add Listener to the frame
		GameFrameListener gameListener = new GameFrameListener();
		gameFrame.addKeyListener(gameListener);

	}
	
	/**
	 * This method returns the game grid.
	 * 
	 * @return Game grid
	 */
	public Grid getGameGrid() {
		return gameGrid;
	}

}
