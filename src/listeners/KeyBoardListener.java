package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import tetris.TetrominoFactory;

/**
 * This class implements the listener for the key board.
 */
public class KeyBoardListener implements KeyListener {

	/**
	 * This is the tetromino factory.
	 */
	private TetrominoFactory factory;

	private boolean processingKey = false;
	private Timer timer;

	/**
	 * This constructor over gives the tetromino factory to the the listener
	 * @param factory
	 */
	public KeyBoardListener(TetrominoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (!processingKey) {
			processingKey = true;

			handleKeyAction(keyCode);

			// Add a delay of X milliseconds before being able to process the action again.
			// Prevents bugs that happen when a key is pressed continuously.
			timer = new Timer(100, (e1) -> {
				processingKey = false;
			});
			timer.setRepeats(false);
			timer.start();
		}
	}

	private void handleKeyAction(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			factory.getCurrentTetromino().rotate();
			break;
		case KeyEvent.VK_DOWN:
			factory.getCurrentTetromino().moveDown();
			break;
		case KeyEvent.VK_LEFT:
			factory.getCurrentTetromino().moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			factory.getCurrentTetromino().moveRight();
			break;
		case KeyEvent.VK_SPACE:
			factory.getCurrentTetromino().dropToBottom();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}