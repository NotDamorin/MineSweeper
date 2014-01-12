package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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

	@Test
	public final void createBoardTest() {

		gameBoard = new GameBoard();
		assertNotNull(gameBoard);
	}

	@Test
	public final void defaultBoardSetupTest() {

		gameBoard = new GameBoard();

		assertEquals(gameBoard.getXSize(), X_SIZE);
		assertEquals(gameBoard.getYSize(), Y_SIZE);
		assertEquals(gameBoard.getNoOfMines(), NO_OF_MINES);

	}

	@Test
	public final void setUpUserDefinedBoardTest() {

		gameBoard = new GameBoard();
		gameBoard.setXSize(USER_X_SIZE);
		gameBoard.setYSize(USER_Y_SIZE);
		gameBoard.setNoOfMines(USER_NO_OF_MINES);

		assertEquals(gameBoard.getXSize(), USER_X_SIZE);
		assertEquals(gameBoard.getYSize(), USER_Y_SIZE);
		assertEquals(gameBoard.getNoOfMines(), USER_NO_OF_MINES);
	}

	@Test
	public final void placeMineTest() {

		GridSquare gridSquare = mock(GridSquare.class);
		gridSquare.placeMine();
		when(gridSquare.hasMine()).thenReturn(true);
		
		assertTrue(gridSquare.hasMine());
	}

}
