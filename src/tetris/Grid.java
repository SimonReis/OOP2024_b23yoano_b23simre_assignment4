package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * This class creates a grid with cells in form of a square.
 */
public class Grid extends JTable {

	private static final long serialVersionUID = 1L;

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
	public Grid(int numRows, int numCols) {
		
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
		
		
		//This is necessary to not loose the focus of the key board listener
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TetrisGame.getFrame().requestFocusInWindow();// Do nothing
			}
		});
	}
	
	/**
	 * This method returns the number of rows of the grid.
	 * 
	 * @return Number of rows
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * This method returns the number of columns of the grid.
	 * 
	 * @return Number of Columns
	 */
	public int getNumCols() {
		return numCols;
	}
	
	
	public void refreshGrid() {
		model.fireTableDataChanged();
	}
	
	
	
}
