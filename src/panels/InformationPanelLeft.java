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
		this.setBounds(0, 0, 300, 200);
		this.setBackground(color);

		JLabel titleLabel = new JLabel("Tetris");
//		titleLabel.setFont(new Font("Arial", Font.BOLD, 65));
//		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setBounds(1000,100, 100,1000); 
		this.add(titleLabel, BorderLayout.NORTH);

		JButton pauseButton = new JButton("Pause Game");
		this.add(pauseButton, BorderLayout.SOUTH);
	}

}
