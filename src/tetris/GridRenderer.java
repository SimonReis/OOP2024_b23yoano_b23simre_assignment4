package tetris;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import tetrominoes.Shapes;

public class GridRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object tetrominoShape, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, "", false, false, row, column);

		if (tetrominoShape == null) {
			setBackground(Color.DARK_GRAY);
		} else if (tetrominoShape == Shapes.I) {
			setBackground(Shapes.I.getColor());
		} else if (tetrominoShape == Shapes.J) {
			setBackground(Shapes.J.getColor());
		} else if (tetrominoShape == Shapes.L) {
			setBackground(Shapes.L.getColor());
		} else if (tetrominoShape == Shapes.O) {
			setBackground(Shapes.O.getColor());
		} else if (tetrominoShape == Shapes.S) {
			setBackground(Shapes.S.getColor());
		} else if (tetrominoShape == Shapes.T) {
			setBackground(Shapes.T.getColor());
		} else if (tetrominoShape == Shapes.Z) {
			setBackground(Shapes.Z.getColor());
		}

		// setBorder(BorderFactory.createLineBorder(Color.black));
		return this;
	}

}
