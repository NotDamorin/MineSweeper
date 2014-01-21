package src;


public class MineFinder {
	
	private MineFinder() {
		
	}

	public static boolean checkIfMineAt(GridLocation location) {
	
		return GameBoard.gridSquares.get(location.getFirstIndex()).get(location.getSecondIndex()).hasMine();
	}

	public static boolean checkMineIsInValidPosition(int xPos, int yPos) {
	
		return (MineFinder.checkMineXPosIsNotOutOfBoard(xPos) && MineFinder.checkMineYPosIsNotOutOfBoard(yPos));
	}

	private static boolean checkMineYPosIsNotOutOfBoard(int yPos) {
	
		return (yPos >= 0 && yPos < GameBoard.gridSquares.get(0).size());
	
	}

	private static boolean checkMineXPosIsNotOutOfBoard(int xPos) {
	
		return (xPos >= 0 && xPos < GameBoard.gridSquares.size());
	}



}
