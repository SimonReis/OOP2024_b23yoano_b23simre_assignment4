package tetris;

import java.util.TimerTask;

public class Block extends TimerTask {
	
	private GridTable table;
	private int row;
	private int col;
	
	public Block(GridTable table, int row, int col) {
		this.table = table;
		this.row = row;
		this.col = col;
		table.setValueAt(1, row, col);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Action performed at: " + new java.util.Date());
		if (row < 19) {
			table.setValueAt(0, row, col);
			row++;
			table.setValueAt(1, row, col);
		} else {
			System.out.println("Action exit");
			cancel();
		}
		
	}
	
	
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}

}
