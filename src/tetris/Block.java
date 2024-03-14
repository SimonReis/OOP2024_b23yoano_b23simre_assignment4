package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Block {

	private Grid table;
	private int row;
	private int col;
	private boolean isMoving;
	private Timer timer;

	public Block(Grid table, int row, int col) {
		this.table = table;
		this.row = row;
		this.col = col;
		table.setValueAt(1, row, col);
		isMoving = true;
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				performTask();
			}
		};
		timer = new Timer(100, actionListener);
		timer.start();
	}

	// Implement your task logic here
	public void performTask() {
		// Your code to be executed repeatedly
		if (row < 19 && (int) table.getValueAt(row + 1, col) != 1) {
			table.setValueAt(0, row, col);
			row++;
			table.setValueAt(1, row, col);
		} else {
			System.out.println("Blocage");
			isMoving = false;
			timer.stop();
		}
	}

	// Create a timer with a delay of 1 second (1000 millisecondsTimerimer timer =
	// new Timer(1000, actionListener);

	// Start the timer

	public boolean isMoving() {
		return isMoving;

	}


}
