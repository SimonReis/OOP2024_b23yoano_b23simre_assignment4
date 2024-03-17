package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BlockFactory {

	private Block storedBlock;
	private static Block currentBlock;
	//private static Object shapeType;
	private Timer blockFactoryTimer;

	public BlockFactory() {
		storedBlock = new Block();
		//storedBlock.setShapeType(getRandomShapeType());
	}

	public void startProduction() {

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentBlock == null || !currentBlock.canMoveDown()) {
					currentBlock = storedBlock;
					storedBlock = new Block();
					//storedBlock.setShapeType(getRandomShapeType());
					currentBlock.spawnBlock();
				}
			}
		};
		blockFactoryTimer = new Timer(10, actionListener);
		blockFactoryTimer.start();

	}

	public static Block getCurrentBlock() {
		return currentBlock;
	}
	
	public static Block getStoredBlock() {
		return currentBlock;
	}



}
