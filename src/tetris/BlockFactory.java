package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class BlockFactory {

	private Block storedBlock;
	private static Block currentBlock;
	private static Object shapeType;
	private Timer blockFactoryTimer;

	public BlockFactory() {
		storedBlock = new Block();
		storedBlock.setShapeType(getRandomShapeType());
	}

	public void startProduction() {

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentBlock == null || !currentBlock.canMove()) {
					currentBlock = storedBlock;
					storedBlock = new Block();
					storedBlock.setShapeType(getRandomShapeType());
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

	public static void setCurrentBlock(Block block) {
		currentBlock = block;
	}

	public static Object getRandomShapeType() {
		Object[] shapeTypes = { "I", "J", "L", "O", "S", "T", "Z" };
		Random random = new Random();
		shapeType = shapeTypes[random.nextInt(shapeTypes.length)];
		return shapeType;
	}

}
