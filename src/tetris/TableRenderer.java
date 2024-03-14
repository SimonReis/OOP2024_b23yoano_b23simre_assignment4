package tetris;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, "", false, false, row, column);

		if (value != null) {
			if ((int) value == 0) {
				setBackground(Color.DARK_GRAY);
			} else {
				setBackground(Color.YELLOW);
			}
		} else {
			setBackground(Color.WHITE);
		}
		
		//setBorder(BorderFactory.createLineBorder(Color.black));
		return this;
	}
		
}
