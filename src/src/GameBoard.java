package src;

import java.util.ArrayList;

/**
 * This class creates the play area for users of the game.
 * 
 * @author Damien
 * 
 */
public class GameBoard {

	private static final int DEFAULT_NO_OF_MINES = 10;
	private static final int DEFAULT_Y = 10;
	private static final int DEFAULT_X = 10;
	private static ArrayList<GridSquare> gridSquares;

	/**
	 * The length of the board for x axis.
	 */
	private int xSize;

	/**
	 * The length of the board for y axis.
	 */
	private int ySize;

	/**
	 * The number of mines to place on the board.
	 */
	private int noOfMines;

	/**
	 * Default Constructor.
	 */
	public GameBoard() {

		setXSize(DEFAULT_X);
		setYSize(DEFAULT_Y);
		setNoOfMines(DEFAULT_NO_OF_MINES);

	}

	public final int getXSize() {

		return xSize;
	}

	public final void setXSize(final int size) {

		this.xSize = size;
	}

	public final int getYSize() {

		return ySize;
	}

	public final void setYSize(final int size) {

		this.ySize = size;
	}

	public final int getNoOfMines() {

		return noOfMines;
	}

	public final void setNoOfMines(final int noMines) {

		this.noOfMines = noMines;
	}

	public GridSquare selectRandomLocation() {

		return null;
	}

}