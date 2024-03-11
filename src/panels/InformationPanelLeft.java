package panels;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public InformationPanelLeft(Color color) {
		this.setLayout(new BorderLayout());
		this.add(new JLabel("Tetris"), BorderLayout.NORTH);
		this.setBackground(color);
	}
	
}
