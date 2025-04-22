package hw4.maze;

import java.util.ArrayList;

public class Grid {

    private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {
        this.rows = rows;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		// TODO Auto-generated method stub    	
        this.rows = rows; 
	}

    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }

}
