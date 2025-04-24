package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Represents a player in the maze, tracking their current row and cell.
 */
public class Player {

    /** The current cell the player is located in. */
    private Cell currentCell;

    /** The current row the player is located in. */
    private Row currentRow;

    /**
     * Constructs a Player at the specified row and cell.
     *
     * @param currentRow the row the player is in
     * @param currentCell the cell the player is in
     */
    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }

    /**
     * Returns the current row of the player.
     *
     * @return the current row
     */
    public Row getCurrentRow() {
        return currentRow;
    }

    /**
     * Returns the current cell of the player.
     *
     * @return the current cell
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Sets the player's current row.
     *
     * @param row the new row
     */
    public void setCurrentRow(Row row) {
        this.currentRow = row;
    }

    /**
     * Sets the player's current cell.
     *
     * @param cell the new cell
     */
    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }

    /**
     * Returns a string representation of the player, including the current cell and row.
     *
     * @return a string describing the player
     */
    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
