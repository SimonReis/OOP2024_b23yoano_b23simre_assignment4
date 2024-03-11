package tetris;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import tetris.GridCellRenderer;
import tetris.GridTableModel;

public class GridPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridPanel() {
		
		GridTableModel model = new GridTableModel();
		JTable table = new JTable(model);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setRowHeight(24);
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = table.getColumnModel().getColumn(i);
	        column.setPreferredWidth(24);
	    }
		table.setDefaultRenderer(Object.class, new GridCellRenderer());
		model.setValueAt(0, 2, 1);
		this.add(table);
	
	}

}
