package tetris;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Grid extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Grid(int numRows, int numCols) {
		GridModel model = new GridModel(numRows, numCols);
		this.setModel(model);
		this.setGridColor(Color.LIGHT_GRAY);
		this.setRowHeight(24); //TODO Maybe add resize later
		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(24);
		}
		this.setDefaultRenderer(Object.class, new GridRenderer());
	}

}
