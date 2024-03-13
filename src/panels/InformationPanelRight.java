package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel highscorePanel, scorePanel, linesPanel, nextTetrominoPanel;
	private JLabel highscoreLabelText, highscoreLabelNumber;
	private int highscore, score, lines;
	private Font font;
	private Color color;

	public InformationPanelRight(Color color) {
		
		this.color = color;
		initPanel();
		initHighscore();
//		initScore(color);
//		initLines(color);
//		initNextTetromino(color);
		
		
		
		
		
		
		
	}
	
	private void initPanel() {
		
		this.setLayout(new GridLayout(4,1));
		this.setBackground(color);
		font = new Font("Arial", Font.BOLD, 20);
	}
	
	
	private void initHighscore() {
		
		highscore = 0;
		
		highscorePanel = new JPanel();
		highscorePanel.setLayout(new GridLayout(2,1));
		highscorePanel.setBackground(color);
	
		highscoreLabelText = new JLabel("Highscore:");
		highscoreLabelText.setLayout(null);
		highscoreLabelText.setFont(font);
		highscoreLabelText.setHorizontalAlignment(JLabel.CENTER);
		highscoreLabelText.setVerticalAlignment(JLabel.BOTTOM);
		highscorePanel.add(highscoreLabelText);

		highscoreLabelNumber = new JLabel(Integer.toString(highscore));
		highscoreLabelNumber.setLayout(null);
		highscoreLabelNumber.setFont(font);
		highscoreLabelNumber.setHorizontalAlignment(JLabel.CENTER);
		highscoreLabelNumber.setVerticalAlignment(JLabel.TOP);
		highscorePanel.add(highscoreLabelNumber);
	
		this.add(highscorePanel);
		
		
		
		///
		
		
//		
//		
//		highscoreLabelText = new JLabel("<html><body> Highscore: <br>" + Integer.toString(highscore));
//		highscoreLabelText.setLayout(null);
//		highscoreLabelText.setFont(font);
//		highscoreLabelText.setHorizontalAlignment(JLabel.CENTER);
//		highscorePanel.add(highscoreLabelText);
//		

//		
//		highscorePanel.add(highscoreLabelText);

		//highscoreLabel.setVerticalAlignment(JLabel.CENTER);
		//highscorePanel.add(new JLabel(Integer.toString(highscore)));

		
		
	}
	

	
//	highscoreLabel = new JLabel("Highscore: 0");
//	highscoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//	this.add(highscoreLabel);
//	
//	scoreLabel = new JLabel("Score: 0");
//	scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//	this.add(scoreLabel);
//	
//	linesLabel = new JLabel("Lines: 0");
//	linesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//	this.add(linesLabel);
//	
//	nextTetrominoLabel = new JLabel("Next:");
//	nextTetrominoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//	this.add(nextTetrominoLabel);
//	
	
	
	
	
//	private JLabel customLayout(JLabel label) {
//		label.setLayout(null);
//		label.setFont(font);
//		label.setHorizontalAlignment(JLabel.CENTER);
//		label.setVerticalAlignment(JLabel.BOTTOM);
//		return label;
//		

}
