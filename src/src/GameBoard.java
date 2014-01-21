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

	static ArrayList<ArrayList<GridSquare>> gridSquares;
	private int remainingMines = 0;

	/**
	 * The length of the board for x axis.
	 */
	private int xSize = 0;

	/**
	 * The length of the board for y axis.
	 */
	private int ySize = 0;

	/**
	 * The number of mines to place on the board.
	 */
	private int noOfMines = 0;

	/**
	 * Default Constructor.
	 */
	public GameBoard() {

	}

	public void createBoard() {

		if (getXSize() == 0) {
			setXSize(DEFAULT_X);
			setYSize(DEFAULT_Y);
			setNoOfMines(DEFAULT_NO_OF_MINES);
		}

		gridSquares = new ArrayList<>();

		for (int i = 0; i < getYSize(); i++) {
			gridSquares.add(new ArrayList<GridSquare>());
		}

		for (int i = 0; i < getXSize(); i++) {
			for (int j = 0; j < DEFAULT_Y; j++) {
				gridSquares.get(i).add(new GridSquareImpl(i, j));
			}
		}
	}

	public GridSquare selectRandomGridSquare() {

		return gridSquares.get((int) (Math.random() * getXSize())).get(
				(int) (Math.random() * getYSize()));
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

	public void setRemainingMines(int remainingMines) {

		this.remainingMines = remainingMines;
	}

	public int noOfMinesAdjacent(GridSquare gridSquare) {

		int noMines = 0;
		if (gridSquare.hasMine()) {
			return -1;
		} else {
			GridLocation location = gridSquare.getLocation();
			int x = location.getFirstIndex();
			int y = location.getSecondIndex();

			if (MineFinder.checkMineIsInValidPosition(x - 1, y - 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x - 1).get(y - 1).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x, y - 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x).get(y - 1).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x + 1, y - 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x + 1).get(y - 1).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x - 1, y)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x - 1).get(y).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x + 1, y)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x + 1).get(y).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x - 1, y + 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x - 1).get(y + 1).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x, y + 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x).get(y + 1).getLocation())) {
					noMines++;
				}
			}

			if (MineFinder.checkMineIsInValidPosition(x + 1, y + 1)) {
				if (MineFinder.checkIfMineAt(gridSquares.get(x).get(y + 1).getLocation())) {
					noMines++;
				}
			}

		}
		return noMines;
	}

	public final int getXSize() {

		return xSize;
	}

	public final void setXSize(final int size) {

		if (size > 0) {
			this.xSize = size;
		} else {
			System.out.println("The size " + size + " is too small for the X axis");
		}
	}

	public final int getYSize() {

		return ySize;
	}

	public final void setYSize(final int size) {

		if (size > 0) {
			this.ySize = size;
		} else {
			System.out.println("The size " + size + " is too small for the Y axis");
		}
	}

	public final int getNoOfMines() {

		return noOfMines;
	}

	public final void setNoOfMines(final int noMines) {

		this.noOfMines = noMines;
	}
}