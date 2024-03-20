package panels;

import java.awt.Color;

import javax.swing.JPanel;

import listeners.KeyBoardListener;
import tetris.MainFrame;
import tetris.TetrisGame;
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
	public GridPanel(Grid gameGrid) {

		this.setBackground(TetrisGame.getBackgroundColor());
		this.add(gameGrid);
		
		// Add Listener to the frame
		KeyBoardListener gameListener = new KeyBoardListener();
		TetrisGame.getFrame().addKeyListener(gameListener);

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
