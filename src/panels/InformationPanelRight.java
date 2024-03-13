package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//TODO This can be simplified!!! 

/**
 * This class represents the right information Panel, where high score, score,
 * cleared lines is stored.
 */
public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * All components to build the panel
	 */
	private JPanel highScorePanel, scorePanel, linesPanel, nextTetrominoPanel;
	private JLabel highScoreLabelText, highScoreLabelNumber, scoreLabelText, scoreLabelNumber, linesPanelText, linesPanelNumber;
	private Font font;
	private Color color;

	/**
	 * Changeable variables during the game
	 */
	private int highScore, score, clearedLines;

	public InformationPanelRight(Color color) {

		this.color = color;
		initPanel();
		initHighScore();
		initScore();
		initLines();
		initNextTetromino();

	}

	/**
	 * This method initializes the grid in which all four displayed elements are
	 * stored. A default font is defined too.
	 */
	private void initPanel() {
		this.setLayout(new GridLayout(4, 1));
		this.setBackground(color);
		font = new Font("Arial", Font.BOLD, 20);
	}

	/**
	 * This method initializes the panel where the information for the current high
	 * score are stored.
	 */
	private void initHighScore() {

		highScore = 0;

		//Create panel where text and value can be stored underneath
		highScorePanel = new JPanel();
		highScorePanel.setLayout(new GridLayout(2, 1));
		highScorePanel.setBackground(color);
		
		highScoreLabelText = new JLabel("Highscore:");
		highScoreLabelText.setLayout(null);
		highScoreLabelText.setFont(font);
		highScoreLabelText.setHorizontalAlignment(JLabel.CENTER);
		highScoreLabelText.setVerticalAlignment(JLabel.BOTTOM);
		highScorePanel.add(highScoreLabelText);

		highScoreLabelNumber = new JLabel(Integer.toString(highScore));
		highScoreLabelNumber.setLayout(null);
		highScoreLabelNumber.setFont(font);
		highScoreLabelNumber.setHorizontalAlignment(JLabel.CENTER);
		highScoreLabelNumber.setVerticalAlignment(JLabel.TOP);
		highScorePanel.add(highScoreLabelNumber);

		this.add(highScorePanel);

	}
	
	/**
	 * This method initializes the panel where the information for the current high
	 * score are stored.
	 */
	private void initScore() {

		score = 0;

		//Create panel where text and value can be stored underneath
		scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(2, 1));
		scorePanel.setBackground(color);
		
		scoreLabelText = new JLabel("Score:");
		scoreLabelText.setLayout(null);
		scoreLabelText.setFont(font);
		scoreLabelText.setHorizontalAlignment(JLabel.CENTER);
		scoreLabelText.setVerticalAlignment(JLabel.BOTTOM);
		scorePanel.add(scoreLabelText);

		scoreLabelNumber = new JLabel(Integer.toString(score));
		scoreLabelNumber.setLayout(null);
		scoreLabelNumber.setFont(font);
		scoreLabelNumber.setHorizontalAlignment(JLabel.CENTER);
		scoreLabelNumber.setVerticalAlignment(JLabel.TOP);
		scorePanel.add(scoreLabelNumber);

		this.add(scorePanel);

	}
	
	/**
	 * This method initializes the panel where the information for the current high
	 * score are stored.
	 */
	private void initLines() {

		clearedLines = 0;

		//Create panel where text and value can be stored underneath
		linesPanel = new JPanel();
		linesPanel.setLayout(new GridLayout(2, 1));
		linesPanel.setBackground(color);
		
		linesPanelText = new JLabel("Lines:");
		linesPanelText.setLayout(null);
		linesPanelText.setFont(font);
		linesPanelText.setHorizontalAlignment(JLabel.CENTER);
		linesPanelText.setVerticalAlignment(JLabel.BOTTOM);
		linesPanel.add(linesPanelText);

		linesPanelNumber = new JLabel(Integer.toString(clearedLines));
		linesPanelNumber.setLayout(null);
		linesPanelNumber.setFont(font);
		linesPanelNumber.setHorizontalAlignment(JLabel.CENTER);
		linesPanelNumber.setVerticalAlignment(JLabel.TOP);
		linesPanel.add(linesPanelNumber);

		this.add(linesPanel);

	}
	
	
	/**
	 * This method initializes the panel where the information for the current high
	 * score are stored.
	 */
	private void initNextTetromino() {

		//Grid

		//Create panel where text and value can be stored underneath
		linesPanel = new JPanel();
		linesPanel.setLayout(new GridLayout(2, 1));
		linesPanel.setBackground(color);
		
		linesPanelText = new JLabel("Next:");
		linesPanelText.setLayout(null);
		linesPanelText.setFont(font);
		linesPanelText.setHorizontalAlignment(JLabel.CENTER);
		linesPanelText.setVerticalAlignment(JLabel.BOTTOM);
		linesPanel.add(linesPanelText);

		linesPanelNumber = new JLabel("Insert 4x4 Grid here");
		linesPanelNumber.setLayout(null);
		linesPanelNumber.setFont(font);
		linesPanelNumber.setHorizontalAlignment(JLabel.CENTER);
		linesPanelNumber.setVerticalAlignment(JLabel.TOP);
		linesPanel.add(linesPanelNumber);

		this.add(linesPanel);

	}

}
