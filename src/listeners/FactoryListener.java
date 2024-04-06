package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetris.TetrominoFactory;

/**
 * This Listener is for producing tetrominoes.
 */
public class FactoryListener implements ActionListener {

	private TetrominoFactory tetrominoFactory;
	
	public FactoryListener(TetrominoFactory tetrominoFactory){
		this.tetrominoFactory = tetrominoFactory;
	}
	/**
	 * If the action is performed, the tetromino factory produce a new tetromino.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		tetrominoFactory.produce();
	}

}
