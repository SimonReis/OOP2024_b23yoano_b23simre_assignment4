package tetris;

import java.util.TimerTask;

public class GameEngine extends TimerTask {
	
	private GridTable table;
	private Object oldValue;
	private int newValue;

	public GameEngine(GridTable table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Action performed at: " + new java.util.Date());
		oldValue = table.getValueAt(1, 1);
		if ((int) oldValue == 0) {
			newValue = 1;
		} else {
			newValue = 0;
		}
		table.setValueAt(newValue, 1, 1);
	}

}
