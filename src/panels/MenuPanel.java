package panels;

import java.awt.Color;

import java.awt.Font;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.MenuButtonListener;
import tetris.MainFrame;
import tetris.TetrisGame;


/**
 * This class represents the menu panel, in which a new Tetris game can be
 * started, or the application can be closed.
 */
public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	
	/**
	 * This is the TetrisGame.
	 */
	private TetrisGame tetrisGame;
	
	/**
	 * Buttons for starting a new game or quit the game.
	 */
	private JButton newGameButton, quitGameButton;

	/**
	 * JLabel for displaying the current high score.
	 */
	private JLabel highScoreLabel;

	/**
	 * Number of the high score
	 */
	private int highScore;
	
	/**
	 * This is the background color of the panel.
	 */
	private Color color;

	/**
	 * This class represents the menu panel.
	 */
	public MenuPanel(TetrisGame tetrisGame) {
		this.tetrisGame = tetrisGame; 
		this.highScore = tetrisGame.getHighScore();
		this.color = MainFrame.getBackgroundColor();
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

	/**
	 * This method initializes the upper panel, which contains a headline and
	 * subhead line.
	 */
	private void intitUpperPanel() {

		// Set panel layout
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(2, 1));
		upperPanel.setBackground(color);

		// Create headline
		JLabel headlineLabel = new JLabel("Tetris");
		headlineLabel.setLayout(null);
		headlineLabel.setFont(new Font("Arial", Font.BOLD, 100));
		headlineLabel.setHorizontalAlignment(JLabel.CENTER);
		headlineLabel.setVerticalAlignment(JLabel.BOTTOM);
		upperPanel.add(headlineLabel);

		// Create sub headline
		JLabel subHeadlineLabel = new JLabel("created by Yoann and Simon");
		subHeadlineLabel.setLayout(null);
		subHeadlineLabel.setFont(new Font("Arial", Font.BOLD, 13));
		subHeadlineLabel.setHorizontalAlignment(JLabel.CENTER);
		subHeadlineLabel.setVerticalAlignment(JLabel.TOP);
		upperPanel.add(subHeadlineLabel);

		this.add(upperPanel);
	}

	/**
	 * This method initializes the lower panel, which contains a new game button and
	 * a quit game button.
	 */
	private void intitLowerPanel() {

		// Set panel layout
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(2, 1));
		upperPanel.setBackground(color);

		// Create high score label
		highScoreLabel = new JLabel("Highscore: " + highScore);
		highScoreLabel.setFont(new Font("Arial", Font.BOLD, 23));
		highScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		highScoreLabel.setVerticalAlignment(JLabel.BOTTOM);
		upperPanel.add(highScoreLabel);

		// Create button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(color);

		// Create new game button
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new MenuButtonListener(this));
		buttonPanel.add(newGameButton);

		// Create quit game button
		quitGameButton = new JButton("Quit Game");
		quitGameButton.addActionListener(new MenuButtonListener(this));
		buttonPanel.add(quitGameButton);

		upperPanel.add(buttonPanel);

		this.add(upperPanel);
	}

	/**
	 * This method returns the new game button.
	 * 
	 * @return New Game button
	 */
	public JButton getNewGameButton() {
		return newGameButton;
	}

	/**
	 * This method returns the quit game button.
	 * 
	 * @return Quit game button
	 */
	public JButton getQuitGameButton() {
		return quitGameButton;
	}

	/**
	 * This method sets the new high score.
	 * 
	 * @param number Value of the high score
	 */
	public void setNewHighScore(int number) {
		highScore = number;
		highScoreLabel.setText("Highscore: " + highScore);
		tetrisGame.getFrame().pack();
	}
}