package panels;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationPanelRight extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel score, lines, nextTetromino;

	public InformationPanelRight() {
		
		this.setLayout(new BorderLayout());
		this.add(new JLabel("Score"), BorderLayout.NORTH);
		this.add(new JLabel("Lines"), BorderLayout.CENTER);
		this.add(new JLabel("Next"), BorderLayout.SOUTH	);
		
	}

}