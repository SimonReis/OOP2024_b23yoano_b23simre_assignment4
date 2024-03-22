package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import tetris.TetrominoFactory;

public class KeyBoardListener implements KeyListener {

    boolean processingKey = false;
    Timer timer;

    @Override
    public void keyPressed(KeyEvent e) {
    	
        int keyCode = e.getKeyCode();
        
        if (!processingKey && !TetrominoFactory.isPerformingAction()) {
            processingKey = true;
            
            // Stops the TetrominoFactory timer, processes the action and restarts the timer.
            TetrominoFactory.stopTimer();
            handleKeyAction(keyCode);
            TetrominoFactory.restartTimer();
            
            // Add a delay of X milliseconds before being able to process the action again.
            // Prevents bugs that happen when a key is pressed continuously.
            timer = new Timer(100, (e1) -> {
                processingKey = false;
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void handleKeyAction(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                TetrominoFactory.getCurrentTetromino().rotate();
                break;
            case KeyEvent.VK_DOWN:
            		TetrominoFactory.getCurrentTetromino().moveDown();
                break;
            case KeyEvent.VK_LEFT:
            		TetrominoFactory.getCurrentTetromino().moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            		TetrominoFactory.getCurrentTetromino().moveRight();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}