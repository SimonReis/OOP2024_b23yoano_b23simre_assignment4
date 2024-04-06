package listeners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tetris.TetrisGame;
import tetris.TetrominoFactory;

/**
 * This class implements the listener for the game view of the tetris game.
 */
public class GameOverListener implements ActionListener {
	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;
	
	/**
	 * This is the tetromino factory of the game.
	 */
	private TetrominoFactory factory;

	/**
	 * This constructor initializes the game over listener
	 * 
	 * @param game The tetris game
	 */
	public GameOverListener(TetrisGame game, TetrominoFactory factory) {
		this.game = game;
		this.factory = factory;
	}

	/**
	 * The method implements the actions that should happen when the game is over.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (factory.gameOver()) {
			// There are two options. The user can choose between resuming or ending the
			// current game round
			String[] options = { "New Game", "Back to menu" };

			// This code displays the pop-up windows and returns an integer for the selected
			// button
			int result = JOptionPane.showOptionDialog(game.getFrame(), "Do you want to play a new game or go back to menu?",
					"Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (result == 0) { // New game button is pressed
				game.startGame();
			} else { // Back to menu or close option pane is pressed
				game.endGame();
			}
		}

	}

}