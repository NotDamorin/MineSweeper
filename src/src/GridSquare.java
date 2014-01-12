package src;

/**
 * The interface which represents a single grid square on the board.
 * 
 * @author Damien
 * 
 */
public interface GridSquare {

	/**
	 * Places a mine on an implementation of a {@link GridSquare}.
	 * @return 
	 */
	void placeMine();

	/**
	 * @return True if the {@link GridSquare} has a mine, false otherwise
	 */
	Boolean hasMine();

}
