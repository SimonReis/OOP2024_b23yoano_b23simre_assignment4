package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import tetris.TetrominoFactory;
import tetrominoes.Tetromino;

/**
 * This class implements the listener for the key board.
 */
public class KeyBoardListener implements KeyListener {

	/**
	 * This is the tetromino factory.
	 */
	private TetrominoFactory factory;

	private boolean processingKey;
	private Timer timer;

	/**
	 * This constructor over gives the tetromino factory to the the listener
	 * 
	 * @param factory
	 */
	public KeyBoardListener(TetrominoFactory factory) {
		this.factory = factory;
		processingKey = false;

		// Add a delay of X milliseconds before being able to process the action again.
		// Prevents bugs that happen when a key is pressed continuously.
		timer = new Timer(100, (e1) -> {
			processingKey = false;
		});
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (!processingKey) {
			processingKey = true;

			handleKeyAction(keyCode);

			timer.setRepeats(false);
			timer.start();
		}
	}

	private void handleKeyAction(int keyCode) {

		Tetromino tetromino = factory.getCurrentTetromino();

		// If the tetromino is null, e.g. because no game is started yet, nothing should
		// happen by using the keyboard.
		if (tetromino != null) {
			switch (keyCode) {
			case KeyEvent.VK_UP:
				tetromino.rotate();
				break;
			case KeyEvent.VK_DOWN:
				tetromino.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				tetromino.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				tetromino.moveRight();
				break;
			case KeyEvent.VK_SPACE:
				tetromino.dropToBottom();
				break;
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}