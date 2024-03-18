package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TetrominoFactory {

	private Tetromino storedTetromino;
	private static Tetromino currentTetromino;
	//private static Object shapeType;
	private Timer tetrominoFactoryTimer;

	public TetrominoFactory() {
		storedTetromino = new Tetromino();
		//storedBlock.setShapeType(getRandomShapeType());
	}

	public void startProduction() {

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentTetromino == null || !currentTetromino.canMoveDown()) {
					currentTetromino = storedTetromino;
					storedTetromino = new Tetromino();
					//storedBlock.setShapeType(getRandomShapeType());
					currentTetromino.spawnBlock();
				}
			}
		};
		tetrominoFactoryTimer = new Timer(10, actionListener);
		tetrominoFactoryTimer.start();

	}

	public static Tetromino getCurrentTetromino() {
		return currentTetromino;
	}
	
	public static Tetromino getStoredTetromino() {
		return currentTetromino;
	}



}
