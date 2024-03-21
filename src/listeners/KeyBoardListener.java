package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tetris.TetrisGame;
import tetris.TetrominoFactory;

/**
 * This Listener calls required method for each event from the key board to
 * control the tetris game.
 */
public class KeyBoardListener implements KeyListener, FocusListener {

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
		case KeyEvent.VK_SPACE:
			// handle space bar
			TetrominoFactory.getCurrentTetromino().dropToBottom();
			System.out.println("bottom");
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

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * This method sets the focus back to the frame if the focus is Lost. This could
	 * happen e.g. by clicking on the game grid, even if the functions to edit a
	 * cell are deactivated
	 */
	@Override
	public void focusLost(FocusEvent e) {
		TetrisGame.getFrame().requestFocusInWindow();
	}

}
