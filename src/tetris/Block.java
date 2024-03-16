package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Block {

	private Grid gameGrid;
	private int row;
	private int col;
	private Object shapeType;
	private Timer blockTimer;
	private boolean canMove;

	public Block() {
		gameGrid = Game.getGameGrid();
		canMove = false;
	}

	public void spawnBlock() {
		System.out.println("spawnBlock");
		row = 0;
		col = 4;
		gameGrid.setValueAt(shapeType, row, col);
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDown();
			}
		};
		blockTimer = new Timer(500, actionListener);
		blockTimer.start();
	}

	public void moveDown() {
		if (canMove()) {
			gameGrid.setValueAt(null, row, col);
			row++;
			gameGrid.setValueAt(shapeType, row, col);
		} else {
			blockTimer.stop();
		}
	}
	
	public void moveLeft() {
		if (col > 0) {
			gameGrid.setValueAt(null, row, col);
			col--;
			gameGrid.setValueAt(shapeType, row, col);
		}
	}
	
	public void moveRight() {
		if (col < 9) {
			gameGrid.setValueAt(null, row, col);
			col++;
			gameGrid.setValueAt(shapeType, row, col);
		}
	}

	public boolean canMove() {
		canMove = row < 19 && gameGrid.getValueAt(row + 1, col) == null;
		return canMove;
	}

	public Object setShapeType(Object shapeType) {
		return this.shapeType = shapeType;
	}

}
