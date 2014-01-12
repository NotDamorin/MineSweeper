package src;

/**
 * An implementation of {@link GridSquare}.
 * 
 * @author Damien
 * 
 */
public class GridSquareImpl implements GridSquare {

	private Boolean hasMine = false;

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

}
