package hw4.maze;

import java.util.ArrayList;

/**
 * Represents a single row in the maze, which is composed of multiple cells.
 */
public class Row {

    /** The list of cells that make up this row. */
    private ArrayList<Cell> cells;

    /**
     * Constructs a Row with the specified list of cells.
     *
     * @param cells the cells that make up the row
     */
    public Row(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    /**
     * Returns the list of cells in the row.
     *
     * @return the list of cells
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * Sets the list of cells in the row.
     *
     * @param cellList the new list of cells
     */
    public void setCells(ArrayList<Cell> cellList) {
        this.cells = cellList;
    }

    /**
     * Returns a string representation of the row.
     *
     * @return a string describing the row
     */
    @Override
    public String toString() {
        return "Row [cells=" + cells + "]";
    }
}
