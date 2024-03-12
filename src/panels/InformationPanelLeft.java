package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public InformationPanelLeft(Color color) {
		
		this.setLayout(new BorderLayout());
		this.setBackground(color);
		
		ImageIcon image = new ImageIcon("/Users/simonreis/Downloads/aaa_tetris_logo.jpg");
		
		JLabel logo = new JLabel(image);
//		JLabel titleLabel = new JLabel("Tetris");
//		titleLabel.setFont(new Font("Arial", Font.BOLD, 65));
//        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(logo, BorderLayout.NORTH);
        
        JButton pauseButton = new JButton("Pause Game");
        this.add(pauseButton, BorderLayout.SOUTH);
	}
	
	
}
