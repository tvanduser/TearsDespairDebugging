package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Represents a player in a maze game.
 * The player has a current position defined by a row and cell.
 */
public class Player {
    private Cell currentCell;
    private Row currentRow;
    
    /**
     * Constructs a new Player at the specified row and cell.
     * 
     * @param currentRow the row where the player starts
     * @param currentCell the cell where the player starts
     */
    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }
    
    /**
     * Gets the current row where the player is located.
     * 
     * @return the current row
     */
    public Row getCurrentRow() {
        return currentRow;
    }
    
    /**
     * Gets the current cell where the player is located.
     * 
     * @return the current cell
     */
    public Cell getCurrentCell() {
        return currentCell;
    }
    
    /**
     * Returns a string representation of the player.
     * 
     * @return a string representing the player's current position
     */
    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
