package tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GridTable table;

	public GameFrame(GridTable table) {
		this.table = table;
		initFrame();
		initGridPanel();
	}

	private void initFrame() {
		this.setTitle("Tetris");
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Place the JFrame in the middle of the screen
	}

	private void initGridPanel() {
		JPanel gridPanel = new JPanel();
		gridPanel.add(table);
		this.add(gridPanel);
	}

}
