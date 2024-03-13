package tetris;

import javax.swing.table.DefaultTableModel;

public class GridTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 */
	public GridTableModel() {
		Object[][] data = new Object[20][10];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				data[i][j] = 0;
			}
		}
		String[] columns = new String[10];
		for (int i = 0; i < 10; i++) {
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
