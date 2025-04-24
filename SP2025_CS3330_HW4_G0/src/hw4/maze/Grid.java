package hw4.maze;

import java.util.ArrayList;

/**
 * Represents the entire maze grid, which is composed of multiple rows.
 */
public class Grid {

    /** The list of rows that make up the grid. */
    private ArrayList<Row> rows;

    /**
     * Constructs a Grid with the specified list of rows.
     *
     * @param rows the rows that make up the grid
     */
    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }

    /**
     * Returns the list of rows in the grid.
     *
     * @return the list of rows
     */
    public ArrayList<Row> getRows() {
        return rows;
    }

    /**
     * Sets the list of rows in the grid.
     *
     * @param rows the new list of rows
     */
    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    /**
     * Returns a string representation of the grid.
     *
     * @return a string describing the grid
     */
    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }

}
