package src;

/**
 * A parameter object for holding the location information of a
 * {@link GridSquare}.
 * 
 * @author Damien
 * 
 */
public class GridLocation {

	private int firstIndex;
	private int secondIndex;

	public GridLocation(int first, int second) {

		setFirstIndex(first);
		setSecondIndex(second);
	}

	public void setFirstIndex(int firstIndex) {

		this.firstIndex = firstIndex;

	}

	public void setSecondIndex(int secondIndex) {

		this.secondIndex = secondIndex;

	}

	public int getFirstIndex() {

		return firstIndex;
	}

	public int getSecondIndex() {

		return secondIndex;
	}

}
