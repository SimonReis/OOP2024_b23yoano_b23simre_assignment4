package tetris;

import javax.swing.table.DefaultTableModel;

public class GridTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridTableModel(int numbRows, int numbColumns) {
		this.setRowCount(numbRows);
		this.setColumnCount(numbColumns);
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }

}
