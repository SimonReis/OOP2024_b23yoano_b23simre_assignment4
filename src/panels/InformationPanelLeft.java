package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;

	public InformationPanelLeft(Color color) {

		this.setLayout(new GridLayout(2,1));
		this.setBackground(color);

		JLabel titleLabel = new JLabel("Tetris");
		titleLabel.setLayout(null);
		
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 65));
		this.add(titleLabel);
		
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.setBackground(color);
		
		
		
		
		JButton pauseButton = new JButton("Pause Game");
		Dimension sizeButton = pauseButton.getPreferredSize();
		
		//TODO How to get the Lable Size, they are 0,0 ?
		pauseButton.setBounds(50, 50, sizeButton.width, sizeButton.height);
	
		

		buttonPanel.add(pauseButton); 
	
		this.add(titleLabel);
		this.add(buttonPanel);
	}

}
