package listeners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tetris.TetrisGame;
import tetris.TetrominoFactory;
import tetrominoes.Tetromino;

/**
 * This class implements the listener for the game view of the tetris game.
 */
public class GameOverListener implements ActionListener {
	/**
	 * This is the tetris game.
	 */
	private TetrisGame game;
	
	/**
	 * This is the tetromino factory of the game.
	 */
	private Tetromino tetromino;

	/**
	 * This constructor initializes the game over listener
	 * 
	 * @param game The tetris game
	 */
	public GameOverListener(TetrisGame game, Tetromino tetromino) {
		this.game = game;
		this.tetromino = tetromino;
	}

	/**
	 * The method implements the actions that should happen when the game is over.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (tetromino.notSpawnable()) {
			
		}

	}

}