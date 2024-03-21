package listeners;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tetris.TetrisGame;

/**
 * This class implements the listener for the game view of the tetris game.
 */
public class GameOverListener implements ActionListener {
	/**
	 * The method implements the actions that should happen when the game is over.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// There are two options. The user can choose between resuming or ending the
		// current game round
		String[] options = { "Back to menu", "New Game" };

		// This code displays the pop-up windows and returns an integer for the selected
		// button
		int result = JOptionPane.showOptionDialog(TetrisGame.getFrame(),
				"Do you want to play a new game or go back to menu?", "Game Over", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

		if (result == 1) { // New game button is pressed
			// TODO implement Action
			TetrisGame.getGameInstance().startGame();
		} else { // Back to menu or close option pane is pressed
			TetrisGame.getGameInstance().endGame();
		}
	}

}