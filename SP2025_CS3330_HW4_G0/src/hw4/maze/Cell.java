package hw4.maze;

public class Cell {
	
	private CellComponents up, down, left, right;
	
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = checkComponentNotNull(left);
		this.right = checkComponentNotNull(right);
		this.up = checkComponentNotNull(up);
		this.down = checkComponentNotNull(down);
	}
	
	
	//helper function to make sure that the component being added is not null, if it is then it will be assigned to a wall
	private CellComponents checkComponentNotNull(CellComponents component) {
		if(component == null) {
			return CellComponents.WALL;
		}
		else {
			return component;
		}
	}

	public CellComponents getLeft() {
		return this.left;
	}

	public CellComponents getRight() {
		return this.right;
	}

	public CellComponents getUp() {
		return this.up;
	}

	public CellComponents getDown() {
		return this.down;
	}

	public void setUp(CellComponents wall) {
		// TODO Auto-generated method stub
	    this.up = checkComponentNotNull(wall);
	}

	public void setDown(CellComponents object) {
		// TODO Auto-generated method stub
	    this.down = checkComponentNotNull(object);	
	}

	public void setLeft(CellComponents object) {
		// TODO Auto-generated method stub
	    this.left = checkComponentNotNull(object);
	}

	public void setRight(CellComponents exit) {
		// TODO Auto-generated method stub
	    this.right = checkComponentNotNull(exit);
	}
	
    public String toString() {
        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
    }
}
