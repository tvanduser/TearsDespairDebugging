package hw4.maze;

/**
 * Represents a cell within the maze. 
 * Each cell has four sides (left, right, up, down), each represented by a {@link CellComponents} value.
 */
public class Cell {
	
	private CellComponents up, down, left, right;

	/**
	 * Constructs a Cell with specified components for each side.
	 * If any component is null, it is automatically set to WALL.
	 *
	 * @param left  the component on the left side
	 * @param right the component on the right side
	 * @param up    the component on the top side
	 * @param down  the component on the bottom side
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = checkComponentNotNull(left);
		this.right = checkComponentNotNull(right);
		this.up = checkComponentNotNull(up);
		this.down = checkComponentNotNull(down);
	}
	
	/**
	 * Helper method that ensures the component is not null.
	 * Defaults to WALL if the input is null.
	 *
	 * @param component the CellComponent to check
	 * @return the validated CellComponent
	 */
	private CellComponents checkComponentNotNull(CellComponents component) {
		if(component == null) {
			return CellComponents.WALL;
		}
		else {
			return component;
		}
	}

	/**
	 * Returns the left side component.
	 *
	 * @return the left CellComponent
	 */
	public CellComponents getLeft() {
		return this.left;
	}

	/**
	 * Returns the right side component.
	 *
	 * @return the right CellComponent
	 */
	public CellComponents getRight() {
		return this.right;
	}

	/**
	 * Returns the upper side component.
	 *
	 * @return the up CellComponent
	 */
	public CellComponents getUp() {
		return this.up;
	}

	/**
	 * Returns the bottom side component.
	 *
	 * @return the down CellComponent
	 */
	public CellComponents getDown() {
		return this.down;
	}

	/**
	 * Sets the component on the top side.
	 *
	 * @param wall the new component to set
	 */
	public void setUp(CellComponents wall) {
	    this.up = checkComponentNotNull(wall);
	}

	/**
	 * Sets the component on the bottom side.
	 *
	 * @param object the new component to set
	 */
	public void setDown(CellComponents object) {
	    this.down = checkComponentNotNull(object);	
	}

	/**
	 * Sets the component on the left side.
	 *
	 * @param object the new component to set
	 */
	public void setLeft(CellComponents object) {
	    this.left = checkComponentNotNull(object);
	}

	/**
	 * Sets the component on the right side.
	 *
	 * @param exit the new component to set
	 */
	public void setRight(CellComponents exit) {
	    this.right = checkComponentNotNull(exit);
	}

	/**
	 * Returns a string representation of this cell and its side components.
	 *
	 * @return a string detailing the components on all four sides
	 */
	public String toString() {
        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
    }
}
