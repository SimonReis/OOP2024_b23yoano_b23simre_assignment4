package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Block {

	private Grid table;
	private int row;
	private int col;
	private Object shape;
	private Timer timer;

	public Block(Grid table) {
		this.table = table;
		shape = generateRandomShapeType();
	}

	// Implement your task logic here
	public void performTask() {
		// Your code to be executed repeatedly
		moveDown();
	}

	public void spawnBlock() {
		row = 0;
		col = 4;
		table.setValueAt(shape, row, col);
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				performTask();
			}
		};
		timer = new Timer(100, actionListener);
		timer.start();
	}
	
	public void moveDown() {
		if (canMove()) {
			table.setValueAt(null, row, col);
			row++;
			table.setValueAt(shape, row, col);
		} else {
			timer.stop();
			Block block = new Block(table);
			block.spawnBlock();
		}
	}
	
	public boolean canMove() {
		return row < 19 && table.getValueAt(row + 1, col) == null;
	}
	
	
	public Object generateRandomShapeType() {
		Object[] shapeTypes = {"I", "J", "L", "O", "S", "T", "Z"};
		Random random = new Random();
		shape = shapeTypes[random.nextInt(shapeTypes.length)];
		return shape;
	}

}
