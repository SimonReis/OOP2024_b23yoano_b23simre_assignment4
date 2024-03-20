package tetris;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import tetrominoes.Shapes;


/**
 * This class represents the grid renderer.
 * It defines the rules to render each cell depending on their content.
 */
public class GridRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This method sets the behavior to follow for each possible cell value.
	 */
	public Component getTableCellRendererComponent(JTable table, Object tetrominoShape, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, "", false, false, row, column);
		
		if (tetrominoShape == null) {
			setBackground(Color.DARK_GRAY);
		} else if (tetrominoShape == Shapes.I || tetrominoShape == Shapes.Ix) {
			setBackground(Shapes.I.getColor());
		} else if (tetrominoShape == Shapes.J || tetrominoShape == Shapes.Jx) {
			setBackground(Shapes.J.getColor());
		} else if (tetrominoShape == Shapes.L || tetrominoShape == Shapes.Lx) {
			setBackground(Shapes.L.getColor());
		} else if (tetrominoShape == Shapes.O || tetrominoShape == Shapes.Ox) {
			setBackground(Shapes.O.getColor());
		} else if (tetrominoShape == Shapes.S || tetrominoShape == Shapes.Sx) {
			setBackground(Shapes.S.getColor());
		} else if (tetrominoShape == Shapes.T || tetrominoShape == Shapes.Tx) {
			setBackground(Shapes.T.getColor());
		} else if (tetrominoShape == Shapes.Z || tetrominoShape == Shapes.Zx) {
			setBackground(Shapes.Z.getColor());
		}

		return this;
	}

}
