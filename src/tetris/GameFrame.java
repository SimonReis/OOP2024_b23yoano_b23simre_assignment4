package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import panels.GridPanel;
import panels.InformationPanelLeft;
import panels.InformationPanelRight;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Color backgroundColor;

	/**
	 * The constructor creates the Frame for the game.
	 */
	public GameFrame() {
		initFrame();
		
		//Set custom color
		backgroundColor = new Color(255, 100, 50);
		
		this.add(new GridPanel(backgroundColor), BorderLayout.CENTER);
		this.add(new InformationPanelLeft(backgroundColor), BorderLayout.WEST);
		this.add(new InformationPanelRight(backgroundColor), BorderLayout.EAST);
	
	}

	/**
	 * This method initialize the Main Frame.
	 */
	private void initFrame() {
		this.setTitle("Tetris Game");
		this.setMinimumSize(new Dimension(700, 400));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen

	}

}



