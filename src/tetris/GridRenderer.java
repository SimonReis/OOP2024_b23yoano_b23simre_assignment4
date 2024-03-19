package tetris;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GridRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, "", false, false, row, column);

		if (value == null) {
			setBackground(Color.DARK_GRAY);
		} else if (value == "I") {
			setBackground(Color.CYAN);
		} else if (value == "J") {
			setBackground(Color.BLUE);
		} else if (value == "L") {
			setBackground(Color.ORANGE);
		} else if (value == "O") {
			setBackground(Color.YELLOW);
		} else if (value == "S") {
			setBackground(Color.GREEN);
		} else if (value == "T") {
			setBackground(Color.MAGENTA);
		} else if (value == "Z") {
			setBackground(Color.RED);
		}

		// setBorder(BorderFactory.createLineBorder(Color.black));
		return this;
	}

}
