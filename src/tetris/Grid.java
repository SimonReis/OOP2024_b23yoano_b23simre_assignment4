package tetris;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import listeners.FocusListener;

/**
 * This abstract class creates a grid with cells in form of a square.
 */
public abstract class Grid extends JTable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;

	/**
	 * Number of rows and Columns of the Grid.
	 */
	private int numRows, numCols;
	
	/**
	 * Table model, which contains the properties of a JTabel;
	 */
	private DefaultTableModel model;
	
	/**
	 * This constructor create a grid by a given number of rows and columns.
	 * 
	 * @param numRows Number of rows
	 * @param numCols Number of columns
	 */
	public Grid(TetrisGame game, int numRows, int numCols) {
		this.game = game;
		this.numRows = numRows;
		this.numCols = numCols;
		
		

		model = new DefaultTableModel(numRows, numCols) {

			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		this.setModel(model);
		this.setGridColor(Color.LIGHT_GRAY);
		this.setRowHeight(24); // TODO Maybe add resize later
		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(24);
		}
		this.setDefaultRenderer(Object.class, new GridRenderer());
		
		
		/**
		 * This sets the focus back to the frame if the focus is Lost. This could
		 * happen e.g. by clicking on the game grid, even if the functions to edit a
		 * cell are deactivated.
		 */
		this.addMouseListener(new FocusListener(game));
	}
	
	/**
	 * This method returns the number of columns of the grid.
	 * 
	 * @return Number of Columns
	 * This method clears the lines full of Tetrominos cells.
	 */
	public int getNumCols() {
		return numCols;
	}
	
	/**
	 * This method returns the number of rows of the grid.
	 * 
	 * @return Number of rows
	 * This method clears the grid.
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * This method clears the grid.
	 */
	public void clearGrid() {
		for(int m = 0; m < numRows; m++) {
			for(int n = 0; n < numCols; n++) {
				this.setValueAt(null, m, n);
			}
		}
	}
		
	public void refreshGrid() {
		model.fireTableDataChanged();
	}
	
	public TetrisGame getGame() {
		return game;
	}
	
	
	
}
