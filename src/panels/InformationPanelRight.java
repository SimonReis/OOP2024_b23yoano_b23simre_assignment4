package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.Grid;

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
	private JLabel highScoreLabelNumber, scoreLabelNumber, linesLabelNumber;
	private Grid nextGrid;
	private Font font;
	private Color color;

	/**
	 * Changeable variables during the game
	 */
	private int highScore, score, clearedLines;

	public InformationPanelRight(Color color) {

		this.color = color;
		initPanel();
		highScoreLabelNumber = createInformation("Lines");
		scoreLabelNumber = createInformation("Score");
		linesLabelNumber = createInformation("Lines");
		nextGrid = createNextGrid("Next");
		
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


	private JLabel createInformation(String name) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(color);
		
		JLabel labelText = new JLabel(name + ":");
		labelText.setLayout(null);
		labelText.setFont(font);
		labelText.setHorizontalAlignment(JLabel.CENTER);
		labelText.setVerticalAlignment(JLabel.BOTTOM);
		panel.add(labelText);

		JLabel labelNumber = new JLabel(Integer.toString(0));
		labelNumber.setLayout(null);
		labelNumber.setFont(font);
		labelNumber.setHorizontalAlignment(JLabel.CENTER);
		labelNumber.setVerticalAlignment(JLabel.TOP);
		panel.add(labelNumber);
		this.add(panel);
		
		return labelNumber;
	}
	
	private Grid createNextGrid(String name) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(color);
		
		JLabel labelText = new JLabel(name + ":");
		labelText.setLayout(null);
		labelText.setFont(font);
		labelText.setHorizontalAlignment(JLabel.CENTER);
		labelText.setVerticalAlignment(JLabel.BOTTOM);
		panel.add(labelText);

		JPanel nextPanel = new JPanel();
		nextPanel.setBackground(color);
		//nextPanel.setLayout(null);
		Grid nextGrid = new Grid(4,4);
		nextPanel.add(nextGrid);
		panel.add(nextPanel);
		this.add(panel);
		
		return nextGrid;
	}


}
