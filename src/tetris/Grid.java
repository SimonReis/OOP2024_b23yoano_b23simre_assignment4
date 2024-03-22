package tetris;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * This class creates a grid with cells in form of a square.
 */
public class Grid extends JTable {

	private static final long serialVersionUID = 1L;

	/**
	 * Number of rows and Columns of the Grid.
	 */
	private int numRows, numCols;
	
	/**
	 * Table model, which contains the properties of a JTabel;
	 */
	private DefaultTableModel model;
	
	/**
	 * This constructor create a grid by a given number of rows and columns.
	 * 
	 * @param numRows Number of rows
	 * @param numCols Number of columns
	 */
	public Grid(int numRows, int numCols) {
		
		this.numRows = numRows;
		this.numCols = numCols;

		model = new DefaultTableModel(numRows, numCols) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		this.setModel(model);
		this.setGridColor(Color.LIGHT_GRAY);
		this.setRowHeight(24); // TODO Maybe add resize later
		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(24);
		}
		this.setDefaultRenderer(Object.class, new GridRenderer());
		
		
		/**
		 * This sets the focus back to the frame if the focus is Lost. This could
		 * happen e.g. by clicking on the game grid, even if the functions to edit a
		 * cell are deactivated.
		 */
		this.addMouseListener(new MouseAdapter() {
			/**
			 * This method request the focus to the main frame.
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				TetrisGame.getGameInstance().getFrame().requestFocusInWindow();
			}
		});
	}
	
	/**
	 * This method returns the number of columns of the grid.
	 * 
	 * @return Number of Columns
	 * This method clears the lines full of Tetrominos cells.
	 */
	public int getNumCols() {
		return numCols;
	}
	
	/**
	 * This method returns the number of rows of the grid.
	 * 
	 * @return Number of rows
	 * This method clears the grid.
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * This method clears the grid.
	 */
	public void clearGrid() {
		for(int m = 0; m < numRows; m++) {
			for(int n = 0; n < numCols; n++) {
				this.setValueAt(null, m, n);
			}
		}
	}
	
	/**
	 * This method clears the lines full of Tetrominos cells.
	 */
	public void clearLines() {

		// Number of cleared lines after one placed tetromino
		int clearedLines = 0;

		// Variable to tell if the line is full. Set to true
		boolean isLineFull = false;

		// Iterate through the game grid and start in the under left corner.
		for (int row = numRows - 1; row >= 0; row--) {
			for (int col = 0; col < numCols; col++) {
				isLineFull = true;
				// Checks if the value at the intersection of this row and column is null.
				// Pass the full line checker to false and exits the for loop when it is the
				// case.
				Object value = this.getValueAt(row, col);
				if (value == null) {
					isLineFull = false;
					break;
				}
			}
			// If the line is full of Tetrominos values, clear line and refresh game grid
			if (isLineFull) {
				// Increment the number of cleared lines
				clearedLines++;
				// Moves each value to the cell below
				for (int rowToMove = row - 1; rowToMove >= 0; rowToMove--) {
					for (int colToMove = 0; colToMove < numCols; colToMove++) {
						Object valueToMove = this.getValueAt(rowToMove, colToMove);
						this.setValueAt(valueToMove, rowToMove + 1, colToMove);
					}
				}
				// Goes back to previous row because it contains new values and might be full as
				// well.
				row++;
			}
		}
		// Set lines
		TetrisGame.getGameInstance().getFrame().getInfoRight().addClearedLines(clearedLines);
		// Set score
		TetrisGame.getGameInstance().getFrame().getInfoRight().setScore(calculateScore(clearedLines));
	}
	
	/**
	 * This method returns the number of points to be awarded.
	 * 
	 * @param numberOfClearedLines Number of the lines cleared at one time
	 * @return Number of points which the player will recive
	 */
	private int calculateScore(int numberOfClearedLines) {
		if (numberOfClearedLines == 1) {
			return 100;
		} else if (numberOfClearedLines == 2) {
			return 300;
		} else if (numberOfClearedLines == 3) {
			return 500;
		} else if (numberOfClearedLines >= 4) {
			return 800;
		} else {
			return 0;
		}
	}
		
	public void refreshGrid() {
		model.fireTableDataChanged();
	}
	
	
	
}
