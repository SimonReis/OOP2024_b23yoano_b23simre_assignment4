package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel highscoreLabel, scoreLabel, linesLabel, nextTetrominoLabel;

	public InformationPanelRight(Color color) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(color);
		
		highscoreLabel = new JLabel("Highscore: 0");
		highscoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(highscoreLabel);
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(scoreLabel);
		
		linesLabel = new JLabel("Lines: 0");
		linesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(linesLabel);
		
		nextTetrominoLabel = new JLabel("Next:");
		nextTetrominoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(nextTetrominoLabel);
		
		
		
		
		
		
		
	}

}
