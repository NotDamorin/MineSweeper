package src;

/**
 * An implementation of {@link GridSquare}.
 * 
 * @author Damien
 * 
 */
public class GridSquareImpl implements GridSquare {

	private Boolean hasMine = false;
	private Boolean isFlagged = false;
	private Boolean isVisible = false;
	private GridLocation location;

	public GridSquareImpl(int firstIndex, int secondIndex) {

		location = new GridLocation(firstIndex, secondIndex);
	}

	@Override
	public final void placeMine() {

		setHasMine(true);
	}

	@Override
	public final Boolean hasMine() {

		return hasMine;
	}

	public void setHasMine(Boolean hasMine) {

		this.hasMine = hasMine;
	}

	public GridLocation getLocation() {

		return location;
	}

	@Override
	public Boolean isVisible() {

		return isVisible;
	}

	@Override
	public Boolean hasFlag() {

		return isFlagged;
	}

}
