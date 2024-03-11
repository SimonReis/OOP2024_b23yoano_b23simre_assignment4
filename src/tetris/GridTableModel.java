package tetris;

import javax.swing.table.DefaultTableModel;

public class GridTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridTableModel() {
		this.setRowCount(20);
		this.setColumnCount(10);
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }

}
