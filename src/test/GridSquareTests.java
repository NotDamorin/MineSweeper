package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import src.GridSquare;
import src.GridSquareImpl;

/**
 * A Test suite to ensure that the GridSquare interface is tested fully.
 * 
 * @author Damien
 * 
 */
public class GridSquareTests {

	private GridSquare gridSquare;

	@Before
	public void setUp() {

		gridSquare = new GridSquareImpl();
	}

	@Test
	public void placeMineTest() {

		gridSquare.placeMine();
		assertTrue(gridSquare.hasMine());
	}
	
}
