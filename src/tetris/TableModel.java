package tetris;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 */
	public TableModel(int numRow, int numCol) {
		Object[][] data = new Object[numRow][numCol];
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				data[i][j] = 0;
			}
		}

		String[] columns = new String[numCol];
		for (int i = 0; i < numCol; i++) {
			columns[i] = "Column" + i;
		}
		this.setDataVector(data, columns);
	}

	@Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }

}
