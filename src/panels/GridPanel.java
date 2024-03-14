package panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

import tetris.GridCellRenderer;
import tetris.GridTable;
import tetris.GridTableModel;

/**
 * This class represents the panel with the grid for the Tetris game.
 */
public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int numbRows = 20;
	private static final int numbColumns = 10;

	/**
	 * This constructor creates the grid panel where the Tetrominos are stored.
	 * 
	 * @param color Background color of the grid panel
	 */
	public GridPanel(Color color, GridTable table) {
		GridTableModel model = new GridTableModel();
		//table = new JTable(model);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setRowHeight(24);
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(24);
		}
		table.setDefaultRenderer(Object.class, new GridCellRenderer());
		model.setValueAt(0, 2, 1);
		this.add(table);
		this.setBackground(color);
	}
}