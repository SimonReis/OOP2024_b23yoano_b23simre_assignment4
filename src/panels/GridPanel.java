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
	public GridPanel(Color color, Grid gameGrid) {

		this.setBackground(color);
		this.add(gameGrid);


	}

}
