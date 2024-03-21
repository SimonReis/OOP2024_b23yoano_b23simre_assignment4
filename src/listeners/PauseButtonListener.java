package listeners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import panels.InformationPanelLeft;
import tetris.TetrisGame;

/**
 * This class implements the listener for the game view of the tetris game.
 */
public class PauseButtonListener implements ActionListener {

	/**
	 * Information left panel, where the button is placed.
	 */
	private InformationPanelLeft infoLeft;

	/**
	 * The constructor initializes the information left panel for the listener.
	 * 
	 * @param InformationPanelLeft Panel, where the button is placed.
	 */
	public PauseButtonListener(InformationPanelLeft infoLeft) {
		this.infoLeft = infoLeft;
	}

	/**
	 * The method implements the actions that should happen when the button is
	 * pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (infoLeft.getPauseButton() == e.getSource()) {

			// Pause Game in the Background
			TetrisGame.getGameInstance().pauseGame();

			// There are two options. The user can choose between resuming or ending the
			// current game round
			String[] options = { "End Game", "Resume Game" };

			// This code displays the pop-up windows and returns an integer for the selected
			// button
			int result = JOptionPane.showOptionDialog(infoLeft.getParent(), "Do you want to resume or end the game?",
					"Game is paused", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

			// End game button is pressed
			if (result == 0) {
				TetrisGame.getGameInstance().endGame();

			// Resume game or close option pane is pressed
			} else {
				TetrisGame.getFrame().requestFocus();
				TetrisGame.getGameInstance().resumeGame();
			}

		}

	}

}