package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			if(menuPanel.getNewGameButton() == e.getSource()) {
				System.out.println("New Game Button is clicked!");
				//TODO implement Action
			} else if (menuPanel.getQuitGameButton() == e.getSource()){
				System.out.println("Quit Game Button is clicked!");
				//TODO implement Action
			}
		}
		
		if (option == 2) {
			if (infoLeft.getPauseButton() == e.getSource()){
				System.out.println("Pause Button is clicked!");	
				//TODO implement Action
			}
		}
		
	
	}

}
