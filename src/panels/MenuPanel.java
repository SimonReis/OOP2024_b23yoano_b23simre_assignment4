package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**.
	 * Color which should used for the background
	 */
	private Color color;
	
	/**
	 * Buttons for starting a new game or quit the game.
	 */
	private JButton newGameButton, quitGameButton;
	
	/**
	 * JLabel for displaying the current highscore.
	 */
	private JLabel highScore;
	
	/**
	 * This class represents the menu panel. 
	 * @param color
	 */
	public MenuPanel(Color color) {
		this.color = color;
		initPanel();
		intitUpperPanel();
		intitLowerPanel();
	}
	
	/**
	 * This method sets the layout and background color for the panel.
	 */
	private void initPanel() {
		this.setLayout(new GridLayout(2, 1));
		this.setBackground(color);
	}
	
	private void intitUpperPanel() {
		
		// Set panel layout
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(2, 1));
		upperPanel.setBackground(color);
		
		// Create headline
		JLabel headlineLabel = new JLabel("Tetris");
		headlineLabel.setLayout(null);
		headlineLabel.setFont(new Font("Arial", Font.BOLD, 100)); //Set a font for logo text
		headlineLabel.setHorizontalAlignment(JLabel.CENTER);
		headlineLabel.setVerticalAlignment(JLabel.BOTTOM);
		upperPanel.add(headlineLabel);
		
		// Create sub headline
		JLabel subHeadlineLabel = new JLabel("created by Yoann and Simon");
		subHeadlineLabel.setLayout(null);
		subHeadlineLabel.setFont(new Font("Arial", Font.BOLD, 13)); //Set a font for logo text
		subHeadlineLabel.setHorizontalAlignment(JLabel.CENTER);
		subHeadlineLabel.setVerticalAlignment(JLabel.TOP);
		upperPanel.add(subHeadlineLabel);

		this.add(upperPanel);
	}

	private void intitLowerPanel() {
		
		// Set panel layout
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridBagLayout());
		upperPanel.setBackground(color);
		
//		highScore = new JLabel("Highscore: 0");
//		upperPanel.add(highScore);
		newGameButton = new JButton("New Game");
		upperPanel.add(newGameButton);
		quitGameButton = new JButton("Quit Game");
		upperPanel.add(quitGameButton);
		

		this.add(upperPanel);
	}
	
	public void setNewHighScore(int number) {
		
	}
}
