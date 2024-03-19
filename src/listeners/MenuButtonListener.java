package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.MenuPanel;
import tetris.TetrisGame;

/**
 * This class implements the listener for the menu view of the tetris game.
 */
public class MenuButtonListener implements ActionListener {

	/**
	 * Menu panel, where the buttons are placed.
	 */
	private MenuPanel menuPanel;

	/**
	 * The constructor initializes the menu panel for the listener.
	 * 
	 * @param menuPanel Panel, where the buttons are placed.
	 */
	public MenuButtonListener(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * The method implements the actions that should happen when the specific button
	 * is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (menuPanel.getNewGameButton() == e.getSource()) {	
			TetrisGame.getGameInstance().startGame();
		} else if (menuPanel.getQuitGameButton() == e.getSource()) {
			System.exit(0);
		}
	}

}
