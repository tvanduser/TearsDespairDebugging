package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;
import hw4.player.Movement;

/**
 * This class represents a Game which manages a grid-based maze and the player's movement through it.
 */
public class Game {

    //--------------helper functions------------

    /**
     * Moves the player to the specified cell and row using.
     *
     * @param player The player to move.
     * @param newRow The new row the player will move to.
     * @param newCell The new cell the player will occupy.
     * @return true returns true if the move was successful.
     */
    private boolean movePlayer(Player player, Row newRow, Cell newCell){
        player.setCurrentRow(newRow);
        player.setCurrentCell(newCell);
        return true;
    }

    /**
     * Displays the current state of the grid with indicators for the player's position and the exit.
     *
     * @param player The player whose position will be marked.
     */
    public void displayGrid(Player player){
        for(Row row: this.grid.getRows()){
            for(Cell cell: row.getCells()){
                if(player.getCurrentCell() == cell){
                    System.out.print(" A ");
                }
                else if(cell.getLeft() == CellComponents.EXIT){
                    System.out.print(" E ");
                }
                else{
                    System.out.print(" S ");
                }
            }
            System.out.println();
        }
    }

    //------------end of helper functions------------

    private Grid grid;
    private Random random;

    /**
     * Constructs a Game with a pre-existing Grid.
     *
     * @param grid The grid to use for this game.
     */
    public Game(Grid grid) {
        this.grid = grid;
        this.random = new Random();
    }

    /**
     * Constructs a Game and generates a random grid of the specified size.
     *
     * @param size The size of the grid, must be between 3 and 7 inclusive.
     */
    public Game(int size){
        this.random = new Random();
        if(size >= 3 && size <= 7){
            this.grid = createRandomGrid(size);
        }
    }

    /**
     * Gets the current Grid object.
     *
     * @return The grid for this game.
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Sets the grid for this game.
     *
     * @param grid The grid to be used.
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Executes a move action for the player based on the specified movement direction.
     *
     * @param movement The direction in which to move.
     * @param player The player making the move.
     * @return true if the move was successful; false otherwise.
     */
    public boolean play(Movement movement, Player player) {
        if(movement == null || player == null){
            return false;
        }

        Row currentRow = player.getCurrentRow();
        Cell currentCell = player.getCurrentCell();
        ArrayList<Row> rows = grid.getRows();
        int rowIndex = rows.indexOf(currentRow);
        int cellIndex = currentRow.getCells().indexOf(currentCell);

        switch (movement) {
            case UP:
                if(currentCell.getUp() != CellComponents.APERTURE || rowIndex <= 0){
                    return false;
                }
                Row upRow = rows.get(rowIndex - 1);
                Cell upCell = upRow.getCells().get(cellIndex);
                return movePlayer(player, upRow, upCell);

            case DOWN:
                if(currentCell.getDown() != CellComponents.APERTURE || rowIndex >= rows.size() - 1){
                    return false;
                }
                Row downRow = rows.get(rowIndex + 1);
                Cell downCell = downRow.getCells().get(cellIndex);
                return movePlayer(player, downRow, downCell);

            case LEFT:
                if(currentCell.getLeft() == CellComponents.WALL){
                    return false;
                }
                if(cellIndex <= 0){
                    if(currentCell.getLeft() == CellComponents.EXIT){
                        return true;
                    }
                }
                Cell leftCell = currentRow.getCells().get(cellIndex - 1);
                return movePlayer(player, currentRow, leftCell);

            case RIGHT:
                if(currentCell.getRight() != CellComponents.APERTURE || cellIndex >= rows.size() - 1){
                    return false;
                }
                Cell rightCell = currentRow.getCells().get(cellIndex + 1);
                return movePlayer(player, currentRow, rightCell);

            default:
                return false;
        }
    }

    /**
     * Creates and returns a randomly generated Grid of the specified size.
     *
     * @param gridSize The size of the grid, between 3 and 7 inclusive.
     * @return A new Grid object with randomly placed walls and an exit.
     */
    public Grid createRandomGrid(int gridSize) {
        if (gridSize < 3 || gridSize > 7) {
            return null;
        }

        ArrayList<Row> rows = new ArrayList<>();
        ArrayList<ArrayList<Cell>> allCells = new ArrayList<>();

        for (int i = 0; i < gridSize; i++) {
            ArrayList<Cell> rowCells = new ArrayList<>();
            for (int j = 0; j < gridSize; j++) {
                CellComponents left, right, up, down;
                if (j == 0) {
                    left = CellComponents.WALL;
                } else {
                    left = rowCells.get(j - 1).getRight();
                }
                if (i == 0) {
                    up = CellComponents.WALL;
                } else {
                    up = allCells.get(i - 1).get(j).getDown();
                }
                right = (j == gridSize - 1) ? CellComponents.WALL : CellComponents.APERTURE;
                down = (i == gridSize - 1) ? CellComponents.WALL : CellComponents.APERTURE;
                rowCells.add(new Cell(left, right, up, down));
            }
            allCells.add(rowCells);
            rows.add(new Row(rowCells));
        }

        int randomRow = new Random().nextInt(gridSize);
        for (int i = 0; i < gridSize; i++) {
            Cell leftCell = rows.get(i).getCells().get(0);
            if (i == randomRow) {
                leftCell.setLeft(CellComponents.EXIT);
            } else {
                leftCell.setLeft(CellComponents.WALL);
            }
        }

        Random rand = new Random();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = allCells.get(i).get(j);
                boolean hasWall = cell.getLeft() == CellComponents.WALL ||
                    cell.getRight() == CellComponents.WALL ||
                    cell.getUp() == CellComponents.WALL ||
                    cell.getDown() == CellComponents.WALL;

                if (!hasWall) {
                    int side = rand.nextInt(4);
                    switch (side) {
                        case 0:
                            cell.setLeft(CellComponents.WALL);
                            if (j > 0) allCells.get(i).get(j - 1).setRight(CellComponents.WALL);
                            break;
                        case 1:
                            cell.setRight(CellComponents.WALL);
                            if (j < gridSize - 1) allCells.get(i).get(j + 1).setLeft(CellComponents.WALL);
                            break;
                        case 2:
                            cell.setUp(CellComponents.WALL);
                            if (i > 0) allCells.get(i - 1).get(j).setDown(CellComponents.WALL);
                            break;
                        case 3:
                            cell.setDown(CellComponents.WALL);
                            if (i < gridSize - 1) allCells.get(i + 1).get(j).setUp(CellComponents.WALL);
                            break;
                    }
                }
            }
        }

        return new Grid(rows);
    }

    /**
     * Returns a string representation of the Game object.
     *
     * @return A string showing the current grid.
     */
    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }

}
