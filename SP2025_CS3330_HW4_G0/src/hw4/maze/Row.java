package hw4.maze;

import java.util.ArrayList;

public class Row {

    private ArrayList<Cell> cells;

	public Row(ArrayList<Cell> cells) {
		// TODO Auto-generated constructor stub
        this.cells = cells;
	}

	public ArrayList<Cell> getCells() {
		// TODO Auto-generated method stub
		return cells;
	}

	public void setCells(ArrayList<Cell> cellList) {
		// TODO Auto-generated method stub
	    this.cells = cellList;	
	}

    @Override
    public String toString(){
        return "Row [cells=" + cells + "]";
    }
}
