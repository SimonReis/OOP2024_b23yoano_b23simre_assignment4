package panels;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationPanelLeft extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public InformationPanelLeft() {
		this.setLayout(new BorderLayout());
		this.add(new JLabel("Tetris"), BorderLayout.NORTH);
	}
	
}
