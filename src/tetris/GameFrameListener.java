package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrameListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			// handle up
			System.out.println("up");
			break;
		case KeyEvent.VK_DOWN:
			// handle down
			TetrominoFactory.getCurrentTetromino().moveDown();
			System.out.println("down");
			break;
		case KeyEvent.VK_LEFT:
			// handle left
			TetrominoFactory.getCurrentTetromino().moveLeft();
			System.out.println("left");
			break;
		case KeyEvent.VK_RIGHT:
			// handle right
			TetrominoFactory.getCurrentTetromino().moveRight();
			System.out.println("right");
			break;
		default:
			System.out.println("other");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
