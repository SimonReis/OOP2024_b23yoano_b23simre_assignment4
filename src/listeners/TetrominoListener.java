package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetrominoes.Tetromino;

public class TetrominoListener implements ActionListener {

	/**
	 * The Tetromino which is connected to the Listener.
	 */
	private Tetromino tetromino;

	/**
	 * This constructor hands over the tetromino to the listener.
	 * 
	 * @param tetromino Tetromino block
	 */
	public TetrominoListener(Tetromino tetromino) {
		this.tetromino = tetromino;
	}

	/**
	 * This method tells, that each time the listener is called, the tetromino
	 * should move down.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("The Tetromino moves one step down.");
		tetromino.moveDown();
	}

}
