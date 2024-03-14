package tetris;

import javax.swing.table.DefaultTableModel;

public class GridModel extends DefaultTableModel {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 */
	public GridModel(int numRow, int numCols) {
		Object[][] data = new Object[numRow][numCols];
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCols; j++) {
				data[i][j] = 0;
			}
		}

		String[] columns = new String[numCols];
		for (int i = 0; i < numCols; i++) {
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
