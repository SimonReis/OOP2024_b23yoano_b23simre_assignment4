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
 * This class represent the left information panel with the logo and the pause button of tetris.
 */
public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel titleLabel;
	JPanel buttonPanel;
	JButton pauseButton;
	
	private Color color;

	public InformationPanelLeft(Color color) {
		this.color = color;
		initPanel(color);
		initLogo();
		initButton(color);

	}
	
	private void initPanel(Color color) {
		this.setLayout(new GridLayout(2,1));
		this.setBackground(color);
	}
	
	/**
	 * This method initializes the logo text of the game.
	 */
	private void initLogo() {
		
		titleLabel = new JLabel("Tetris");
		titleLabel.setLayout(null);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 65));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(titleLabel);
		
	}
	
	/**
	 * This method initializes the pause button in the center of its under left corner.
	 * 
	 * @param color Background color
	 */
	private void initButton(Color color) {
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(color);
		buttonPanel.setLayout( new GridBagLayout() );
		pauseButton = new JButton("Pause Game");
		
		// TODO Resize not possible
		//pauseButton.setSize(200, 100);
		
		buttonPanel.add(pauseButton, new GridBagConstraints());
		this.add(buttonPanel);

	}

}
