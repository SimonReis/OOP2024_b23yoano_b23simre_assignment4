package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.Grid;


/**
 * This class represents the right information panel, where high score, score,
 * cleared lines and the next tetromino is displayed.
 */
public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Similar properties of the labels of the right information panel.
	 */
	private Font font;
	private Color color;
	
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
	 * This constructor creates the right information panel of the game panel.
	 * 
	 * @param color Background color
	 */
	public InformationPanelRight(Color color) {

		this.color = color;
		initPanel();
		
		// Create the panels and return the labels/grid on which the value is stored
		scoreLabelNumber = createInformation("Score");
		highScoreLabelNumber = createInformation("Highscore");
		nextGrid = createNextGrid("Next");
		linesLabelNumber = createInformation("Lines");
		
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
	 * This method creates a panel in which a text and the corresponding value are displayed.
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
	 * This method creates a panel in which a text and grid for the next tetromino are displayed.
	 * 
	 * @param text Text that should be displayed 
	 * @return Grid that displays the next tetromino
	 */
	private Grid createNextGrid(String text) {
		
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
		Grid nextGrid = new Grid(4,4);
		nextPanel.add(nextGrid);
		panel.add(nextPanel);
		
		this.add(panel);
		
		return nextGrid;
	}
	
	//TODO implement methods for changeing block and numbers


}
