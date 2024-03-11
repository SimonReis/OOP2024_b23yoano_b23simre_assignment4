package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import panels.GridPanel;
import panels.InformationPanelLeft;
import panels.InformationPanelRight;

/**
 * This class represents the Tetris game frame.
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Possibility to change frame size
	private static final int WIDTH = 700;
	private static final int HEIGHT = 400;
	
	//Possibility to change background color
	private Color backgroundColor = new Color(255, 100, 50);;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public GameFrame() {
		initFrame();
		initPanels();
	}

	/**
	 * This method initialize the main frame.
	 */
	private void initFrame() {
		this.setTitle("Tetris Game");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen

	}
	
	/**
	 * This method initialize the panels
	 */
	private void initPanels() {
		this.add(new GridPanel(backgroundColor), BorderLayout.CENTER);
		this.add(new InformationPanelLeft(backgroundColor), BorderLayout.WEST);
		this.add(new InformationPanelRight(backgroundColor), BorderLayout.EAST);
	}
}



