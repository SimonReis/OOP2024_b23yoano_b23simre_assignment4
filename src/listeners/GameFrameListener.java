package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import tetris.TetrominoFactory;

public class GameFrameListener implements KeyListener {

    boolean processingKey = false;
    Timer timer;

    @Override
    public void keyPressed(KeyEvent e) {
    	
        int keyCode = e.getKeyCode();
        
        if (!processingKey) {
            processingKey = true;
            TetrominoFactory.stopTimer();
            handleKeyAction(keyCode);  // Handle the key action immediately
            TetrominoFactory.restartTimer();
            timer = new Timer(100, (e1) -> {  // Delay 500 milliseconds
                processingKey = false;
            });
            timer.setRepeats(false);  // Run only once
            timer.start();
        }
    }

    private void handleKeyAction(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                TetrominoFactory.getCurrentTetromino().rotate();
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                TetrominoFactory.getCurrentTetromino().moveDown();
                System.out.println("down");
                break;
            case KeyEvent.VK_LEFT:
                TetrominoFactory.getCurrentTetromino().moveLeft();
                System.out.println("left");
                break;
            case KeyEvent.VK_RIGHT:
                TetrominoFactory.getCurrentTetromino().moveRight();
                System.out.println("right");
                break;
            default:
                System.out.println("other");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}