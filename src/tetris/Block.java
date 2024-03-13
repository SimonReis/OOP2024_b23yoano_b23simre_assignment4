package tetris;

import java.util.TimerTask;

public class Block extends TimerTask {

	private GridTable table;
	private int row;
	private int col;
	private boolean isMoving;

	public Block(GridTable table, int row, int col) {
		this.table = table;
		this.row = row;
		this.col = col;
		table.setValueAt(1, row, col);
		isMoving = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Action performed at: " + new java.util.Date());

//		System.out.println("row " + row + " = " + table.getValueAt(row, col));
//		System.out.println("row " + row+2 + " = " + table.getValueAt(row+1, col));
		if (row < 19 && (int) table.getValueAt(row + 1, col) != 1) {
			table.setValueAt(0, row, col);
			row++;
			table.setValueAt(1, row, col);
		} else {
			System.out.println("Blocage");
			isMoving = false;
			cancel();
		}

	}
	
	public boolean isMoving() {
		return isMoving;
		
	}

}
