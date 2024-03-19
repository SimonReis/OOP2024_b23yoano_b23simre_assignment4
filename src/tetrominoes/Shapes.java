package tetrominoes;

import java.awt.Color;

/**
 * This enum defines the different shapes and its color
 */
public enum Shapes {
	I("cyan"), J("blue"), L("orange"), O("yellow"), S("green"), T("purple"), Z("red");
	
	private String colorName;
	private Color color;
	
	private Shapes(String colorName) {
		this.colorName = colorName;
	}
	
	public Color color() {
		return null;
	}
}
