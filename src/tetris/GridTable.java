package tetris;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class GridTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridTable() {
		TableModel model = new TableModel(20, 10);
		this.setModel(model);
		this.setGridColor(Color.LIGHT_GRAY);
		this.setRowHeight(24);
		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(24);
		}
		this.setDefaultRenderer(Object.class, new TableRenderer());
	}

}
