package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import panels.InformationPanelLeft;
import panels.MenuPanel;

public class ButtonHandler implements ActionListener {

	private MenuPanel menuPanel;
	private InformationPanelLeft infoLeft;

	int option;

	public ButtonHandler(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
		option = 1;
	}

	public ButtonHandler(InformationPanelLeft infoLeft) {
		this.infoLeft = infoLeft;
		option = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (option == 1) {
			if (menuPanel.getNewGameButton() == e.getSource()) {
				System.out.println("New Game Button is clicked!");
				// TODO implement Action
				Game.getGameInstance().startGame();
		
				
			} else if (menuPanel.getQuitGameButton() == e.getSource()) {
				System.out.println("Quit Game Button is clicked!");
				// TODO implement Action
				System.exit(0);
			}
		}

		if (option == 2) {
			if (infoLeft.getPauseButton() == e.getSource()) {
				System.out.println("Pause Button is clicked!");
				// TODO implement Action
				String[] options = { "End Game", "Resume Game" };
				int result = JOptionPane.showOptionDialog(infoLeft.getParent(),
						"Do you want to resume or end the game?", "Game is paused", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
				
				
				// result == 1: Resume Game
				// result == 0: End Game
				
				if (result == 1) {
					System.out.println("You selected: Resume Game");
					// TODO implement Action
					
				} else if (result == 0) {
					System.out.println("You selected: End Game");
					// TODO implement Action
					Game.getGameInstance().endGame();
					
				}
			}
		}

	}

}
