package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Block {

	private Grid gameGrid;
	private int row;
	private int col;
	private Object shapeType;
	private Timer blockTimer;
	private boolean canMove;

	public Block() {
		gameGrid = TetrisGame.getGameGrid();
		canMove = false;
		shapeType = getRandomShapeType();
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
		if (canMoveDown()) {
			gameGrid.setValueAt(null, row, col);
			row++;
			gameGrid.setValueAt(shapeType, row, col);
		} else {
			blockTimer.stop();
		}
	}
	
	public void moveLeft() {
		if (col > 0 && gameGrid.getValueAt(row, col - 1) == null) {
			gameGrid.setValueAt(null, row, col);
			col--;
			gameGrid.setValueAt(shapeType, row, col);
		}
	}
	
	public void moveRight() {
		if (col < 9 && gameGrid.getValueAt(row, col + 1) == null) {
			gameGrid.setValueAt(null, row, col);
			col++;
			gameGrid.setValueAt(shapeType, row, col);
		}
	}

	// Ajouter une 2ème variable qui retourne la mobilité latérale avec un délai
	public boolean canMoveDown() {
		canMove = row < 19 && gameGrid.getValueAt(row + 1, col) == null;
		if (canMove) {
			return canMove;
		} else {
			return canMove;
		}
	}
	
	public Object getRandomShapeType() {
		Object[] shapeTypes = { "I", "J", "L", "O", "S", "T", "Z" };
		Random random = new Random();
		shapeType = shapeTypes[random.nextInt(shapeTypes.length)];
		return shapeType;
	}

}
