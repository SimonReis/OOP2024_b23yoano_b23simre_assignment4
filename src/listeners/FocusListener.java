package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tetris.TetrisGame;

/**
 * This class implements the listener for the grid to set the focus back to main frame.
 */
public class FocusListener implements MouseListener {

	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;
	
	/**
	 * This constructor initializes the tetris game to the focus listener
	 * 
	 * @param game The tetris game
	 */
	public FocusListener(TetrisGame game) {
		this.game = game;
	}
	
	private void setFoucusToFrame() {
		System.out.println("Focus Lost");
		game.getFrame().requestFocusInWindow();
		game.getFrame().setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		setFoucusToFrame();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setFoucusToFrame();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setFoucusToFrame();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setFoucusToFrame();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setFoucusToFrame();
	}

}
