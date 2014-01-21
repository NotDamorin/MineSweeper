package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.GridLocation;

public class GridLocationTests {

	@Test
	public final void checkLocationIsCorrectTest() {

		GridLocation gridLocation = new GridLocation(0, 1);

		assertEquals(0, gridLocation.getFirstIndex());
		assertEquals(1, gridLocation.getSecondIndex());
	}

}
