package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up
	        	System.out.println("up");
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	        	System.out.println("down");
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	System.out.println("left");
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	System.out.println("right");
	            break;
	     }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
