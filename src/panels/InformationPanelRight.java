package panels;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.TetrisGame;
import tetrominoes.Tetromino;
import tetris.Grid;
import tetris.MainFrame;

/**
 * This class represents the right information panel, where high score, score,
 * cleared lines and the next tetromino is displayed.
 */
public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This is the TetrisGame.
	 */
	private TetrisGame tetrisGame;

	/**
	 * Similar properties of the labels of the right information panel.
	 */
	private Font font;

	/**
	 * Labels, which display the current high score, score and cleared lines.
	 */
	private JLabel highScoreLabelNumber, scoreLabelNumber, linesLabelNumber;

	/**
	 * Changeable variables during the game.
	 */
	private int highScore, score, clearedLines;

	/**
	 * Grid where the next tetromino is displayed.
	 */
	private Grid nextGrid;
	
	/**
	 * This is the background color of the panel.
	 */
	private Color color;

	/**
	 * This constructor creates the right information panel of the game panel.
	 * 
	 * @param color Background color
	 */
	public InformationPanelRight(TetrisGame tetrisGame, Grid nextGrid) {
		
		this.tetrisGame = tetrisGame; 
		this.highScore = tetrisGame.getHighScore();
		this.color = MainFrame.getBackgroundColor();
		this.nextGrid = nextGrid;
		score = 0;
		clearedLines = 0;
		initPanel();

		// Create the panels and return the labels/grid on which the value is stored
		scoreLabelNumber = createInformation("Score");
		highScoreLabelNumber = createInformation("Highscore");
		createNextGrid("Next", this.nextGrid);
		linesLabelNumber = createInformation("Lines");
		
		// Use the high score from the application in the information panel
		setHighScore(highScore);
	}

	/**
	 * This method initializes the grid in which all four displayed elements are
	 * stored. A default font is defined too.
	 */
	private void initPanel() {
		this.setLayout(new GridLayout(2, 2));
		this.setBackground(color);
		font = new Font("Arial", Font.BOLD, 20);
	}

	/**
	 * This method converts a numerical value into a string and adds it to a label.
	 * 
	 * @param label Label where text should be displayed
	 * @param number Number for the text field
	 */
	private void setNumber(JLabel label, int number) {
		label.setText(Integer.toString(number));
	}
	
	/**
	 * This method sets the high score value.
	 * 
	 * @param number Number of the current high score
	 */
	private void setHighScore(int number) {
		highScore = number;
		setNumber(highScoreLabelNumber, highScore);
	}
	
	/**
	 * This method returns the high score of the game.
	 */
	public int getHighScore() {
		return highScore;
	}

	/**
	 * This method sets the current score; if this overwrites the current high
	 * score, it will be updated otherwise.
	 * 
	 * @param number Number of the current high score
	 */
	public void setScore(int number) {
		score = score + number;
		setNumber(scoreLabelNumber, score);


		
		if (score >= highScore) {
			setHighScore(score);
		}

		tetrisGame.getFrame().pack();
	}
	
	/**
	 * This method creates a panel in which a text and the corresponding value are
	 * displayed.
	 * 
	 * @param text Text that should be displayed
	 * @return Label in which the value is stored
	 */
	private JLabel createInformation(String text) {

		// Set panel layout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(color);

		// Create text label
		JLabel labelText = new JLabel(text + ":");
		labelText.setLayout(null);
		labelText.setFont(font);
		labelText.setHorizontalAlignment(JLabel.CENTER);
		labelText.setVerticalAlignment(JLabel.BOTTOM);
		panel.add(labelText);

		// Create number label
		JLabel labelNumber = new JLabel(Integer.toString(0));
		labelNumber.setLayout(null);
		labelNumber.setFont(font);
		labelNumber.setHorizontalAlignment(JLabel.CENTER);
		labelNumber.setVerticalAlignment(JLabel.TOP);
		panel.add(labelNumber);

		this.add(panel);

		return labelNumber;
	}

	/**
	 * This method creates a panel in which a text and grid for the next tetromino
	 * are displayed.
	 * 
	 * @param text Text that should be displayed
	 * @return Grid that displays the next tetromino
	 */
	private void createNextGrid(String text, Grid grid) {

		// Set panel layout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(color);

		// Create text label
		JLabel labelText = new JLabel(text + ":");
		labelText.setLayout(null);
		labelText.setFont(font);
		labelText.setHorizontalAlignment(JLabel.CENTER);
		labelText.setVerticalAlignment(JLabel.BOTTOM);
		panel.add(labelText);

		// Create grid
		JPanel nextPanel = new JPanel();
		nextPanel.setBackground(color);
		nextPanel.add(grid);
		panel.add(nextPanel);

		this.add(panel);
	}
	
	/**
	 * This method sets the number of cleared lines.
	 * 
	 * @param number Number of cleared lines
	 */
	public void addClearedLines(int number) {
		
		if (number >= 0) {
			clearedLines = clearedLines + number;
			setNumber(linesLabelNumber, clearedLines);
			tetrisGame.getFrame().pack();
		} else {
			throw new IllegalArgumentException("Number of cleared lines cannot be negative.");
		}
	}
	
	/**
	 * This method sets the next tetromino in the next grid.
	 * 
	 * @param tetromino The tetromino which shoukld displayed
	 */
	public void setNextTetromino(Tetromino tetromino) {
		
		// Clear next grid at first.
		nextGrid.clearGrid();
	
		// Matrix of the tetromino
		int[][] matrix = tetromino.getShape().getMatrix();
		
		// Draw a colored block for each one in the matrix
		for(int m = 0; m < nextGrid.getNumRows(); m++) {
			for(int n = 0; n < nextGrid.getNumCols(); n++) {
				if(matrix[m][n] == 1) {
					nextGrid.setValueAt(tetromino.getShape(), m, n);
				}
			}
		}
	}
}