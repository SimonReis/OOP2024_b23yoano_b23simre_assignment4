package tetris;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	    model.setValueAt(1, 2, 1);
		table.setDefaultRenderer(Object.class, new GridTableRenderer());
		this.add(table);
	
	}

}
