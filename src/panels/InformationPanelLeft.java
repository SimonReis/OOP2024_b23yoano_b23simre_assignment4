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
		titleLabel.setFont(new Font("Arial", Font.BOLD, 65));
		//titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//titleLabel.setBounds(50,100, 100,100); 
		this.add(titleLabel);
		
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
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
