package hw4.maze;

/**
 * Represents the possible components of a cell in the maze.
 * Each component determines how the player interacts with that side of the cell.
 */
public enum CellComponents {
    
    /**
     * A solid wall that cannot be passed through.
     */
    WALL,

    /**
     * An open passage that can be traversed.
     */
    APERTURE,

    /**
     * The exit point of the maze.
     */
    EXIT
}
