package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tetris.TetrisGame;
import tetris.TetrominoFactory;

/**
 * This Listener is for producing tetrominoes.
 */
public class FactoryListener implements ActionListener {

	/**
	 * This is the TetrisGame.
	 */
	private TetrisGame tetrisGame;
	
	/**
	 * This is the Tetromino Factory
	 */
	private TetrominoFactory tetrominoFactory;
	
	public FactoryListener(TetrisGame tetrisGame, TetrominoFactory tetrominoFactory){
		this.tetrisGame = tetrisGame;
		this.tetrominoFactory = tetrominoFactory;
	}
	/**
	 * If the action is performed, the tetromino factory produce a new tetromino.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		tetrominoFactory.produce();
		
		if (tetrominoFactory.isGameOver()) {
			System.out.println("Not spawnable");
			
			// There are two options. The user can choose between resuming or ending the
			// current game round
			String[] options = { "New Game", "Back to menu" };

			// This code displays the pop-up windows and returns an integer for the selected
			// button
			int result = JOptionPane.showOptionDialog(tetrisGame.getFrame(),
					"Do you want to play a new game or go back to menu?", "Game Over", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (result == 0) { // New game button is pressed
				tetrisGame.startGame();
			} else { // Back to menu or close option pane is pressed
				tetrisGame.endGame();
			}
			
			
		}
	}

}
