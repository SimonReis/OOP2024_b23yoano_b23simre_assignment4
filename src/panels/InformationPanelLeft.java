package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represent the left information panel with the logo and the pause
 * button of tetris.
 */
public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * All components to build the information left panel.
	 */
	private JLabel titleLabel;
	private JPanel buttonPanel;
	private JButton pauseButton;

	/**
	 * Color which should used for the background.
	 */
	private Color color;

	/**
	 * This constructor creates the left information panel of the game panel.
	 * 
	 * @param color Background color
	 */
	public InformationPanelLeft(Color color) {
		this.color = color;
		initPanel();
		initLogo();
		initButton();
		
	}

	/**
	 * This method sets the layout and background color for the panel.
	 */
	private void initPanel() {
		this.setLayout(new GridLayout(2, 1));
		this.setBackground(color);
	}

	/**
	 * This method initializes the logo text of the game.
	 */
	private void initLogo() {

		titleLabel = new JLabel("Tetris");
		titleLabel.setLayout(null);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 65)); //Set a font for logo text
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		this.add(titleLabel);

	}

	/**
	 * This method initializes the pause button in the center of its under left
	 * corner.
	 * 
	 * @param color Background color
	 */
	private void initButton() {

		buttonPanel = new JPanel();
		buttonPanel.setBackground(color);
		buttonPanel.setLayout(new GridBagLayout());
		pauseButton = new JButton("Pause Game");
		buttonPanel.add(pauseButton, new GridBagConstraints());
		this.add(buttonPanel);

	}
	
	/**
	 * This method returns the pause button.
	 * 
	 * @return Pause button
	 */
	public JButton getPauseButton() {
		return pauseButton;
	}

}
