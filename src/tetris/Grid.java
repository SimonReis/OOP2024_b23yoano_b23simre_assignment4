package tetris;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * This class creates a grid with cells in form of a square.
 */
public class Grid extends JTable {

	private static final long serialVersionUID = 1L;

	/**
	 * Properties of the grid
	 */
	private int numRows, numCols, cellSize;

	/**
	 * This constructor create a grid by a given number of rows and columns.
	 * 
	 * @param numRows Number of rows
	 * @param numCols Number of columns
	 */
	public Grid(int numRows, int numCols) {

		DefaultTableModel model = new DefaultTableModel(numRows, numCols) {

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
	}

	/**
	 * This method sets the size of the table by a given cell size. Whereas one cell
	 * is a square.
	 * 
	 * @param cellSize Number of pixels for the cell height and width
	 */
	private void setTableSize(int cellSize) {
		this.cellSize = cellSize;
		Dimension prefferedSize = new Dimension(this.cellSize * numCols, this.cellSize * numRows);
		this.setPreferredSize(prefferedSize);
		this.setRowHeight(this.cellSize);

		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(this.cellSize);
		}

	}

	/**
	 * Not needed yet.
	 */
//	public int getCellSize() {
//		return cellSize;
//	}
//
//	public void setCellSize(int cellSize) {
//		this.cellSize = cellSize;
//		setTableSize(this.cellSize);
//		
//	}

	/**
	 * Not needed yet.
	 */
//	public int getTableHeight() {
//		return numRows*cellSize;
//	}
}
