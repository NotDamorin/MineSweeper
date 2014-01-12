package src;

import java.util.ArrayList;
import java.util.Random;

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
	private static final int TOTAL_SQUARES = DEFAULT_X * DEFAULT_Y;

	private static ArrayList<GridSquare> gridSquares;
	private static int remainingMines = 0;

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

		gridSquares = new ArrayList<GridSquare>();

		for (int i = 0; i < TOTAL_SQUARES; i++) {
			gridSquares.add(new GridSquareImpl());
		}

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

	public GridSquare selectRandomGridSquare() {

		return gridSquares.get((int) (Math.random() * TOTAL_SQUARES));
	}

	public void placeAllMines() {

		for (int i = 0; i < getNoOfMines(); i++) {
			GridSquare gridSquare = selectRandomGridSquare();
			while (gridSquare.hasMine()) {
				gridSquare = selectRandomGridSquare();
			}

			setRemainingMines(getRemainingMines() + 1);
			gridSquare.placeMine();
		}
	}

	public int getRemainingMines() {

		return remainingMines;
	}

	public static void setRemainingMines(int remainingMines) {

		GameBoard.remainingMines = remainingMines;
	}

}