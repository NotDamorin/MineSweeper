package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.GameBoard;
import src.GridSquare;

/**
 * @author Damien
 * 
 */
public class GameBoardTests {

	private static final int NO_OF_MINES = 10;
	private static final int Y_SIZE = 10;
	private static final int X_SIZE = 10;
	private static final int USER_NO_OF_MINES = 15;
	private static final int USER_Y_SIZE = 15;
	private static final int USER_X_SIZE = 15;
	private GameBoard gameBoard;

	@Before
	public void setUp() {

		gameBoard = new GameBoard();
	}

	@After
	public void tearDown() {

		gameBoard = null;
	}

	@Test
	public final void createBoardTest() {

		assertNotNull(gameBoard);
	}

	@Test
	public final void defaultBoardSetupTest() {

		gameBoard.createBoard();

		assertEquals(X_SIZE, gameBoard.getXSize());
		assertEquals(Y_SIZE, gameBoard.getYSize());
		assertEquals(NO_OF_MINES, gameBoard.getNoOfMines());

	}
	
	@Test
	public final void setUpUserDefinedBoardTest() {

		gameBoard.setXSize(USER_X_SIZE);
		gameBoard.setYSize(USER_Y_SIZE);
		gameBoard.setNoOfMines(USER_NO_OF_MINES);
		gameBoard.createBoard();

		assertEquals(USER_X_SIZE, gameBoard.getXSize());
		assertEquals(USER_Y_SIZE, gameBoard.getYSize());
		assertEquals(USER_NO_OF_MINES, gameBoard.getNoOfMines());
	}

	@Test
	public final void placeAllMinesTest() {

		gameBoard.createBoard();
		gameBoard.placeAllMines();

		assertEquals(NO_OF_MINES, gameBoard.getRemainingMines());
	}

	@Test
	public final void checkAdjacentSquaresOnSquareWithMineTest() {

		gameBoard.setXSize(1);
		gameBoard.setYSize(1);
		gameBoard.setNoOfMines(1);
		gameBoard.createBoard();
		gameBoard.placeAllMines();
		GridSquare randomGridSquare = gameBoard.selectRandomGridSquare();
		assertEquals(-1, gameBoard.noOfMinesAdjacent(randomGridSquare));
	}

	@Test
	public final void checkAdjacentSquaresOnSquareWithoutMineTest() {

		gameBoard.setXSize(1);
		gameBoard.setYSize(1);
		gameBoard.setNoOfMines(0);
		gameBoard.createBoard();
		gameBoard.placeAllMines();
		GridSquare randomGridSquare = gameBoard.selectRandomGridSquare();
		assertEquals(0, gameBoard.noOfMinesAdjacent(randomGridSquare));

	}

	@Test
	public final void checkSquareWithSeveralAdjacentMinesTest() {

		gameBoard.setXSize(2);
		gameBoard.setYSize(2);
		gameBoard.setNoOfMines(2);
		gameBoard.createBoard();
		gameBoard.placeAllMines();

		GridSquare selectRandomGridSquare = gameBoard.selectRandomGridSquare();
		while (selectRandomGridSquare.hasMine()) {
			selectRandomGridSquare = gameBoard.selectRandomGridSquare();
		}
		assertTrue(gameBoard.noOfMinesAdjacent(selectRandomGridSquare) >= 1);
	}
}
