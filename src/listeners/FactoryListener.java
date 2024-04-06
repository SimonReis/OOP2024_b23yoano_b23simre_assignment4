package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetris.factory;

/**
 * This Listener is for producing tetrominoes.
 */
public class FactoryListener implements ActionListener {

	private factory tetrominoFactory;
	
	public FactoryListener(factory tetrominoFactory){
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
