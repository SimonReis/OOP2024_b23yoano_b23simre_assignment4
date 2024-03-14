package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

import tetris.GridCellRenderer;
import tetris.Block;
import tetris.Grid;
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
	public GridPanel(Color color) {
		this.setBackground(color);
		gameGrid = new Grid(20,10);
		this.add(gameGrid);
		
		while (true) {
			Block block = new Block(gameGrid, 0, 4);
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
	
//	public Grid getGameGrid() {
//		return gameGrid;
//	}
}