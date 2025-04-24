package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
    private Cell currentCell;
    private Row currentRow;
    
    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }
    
    public Row getCurrentRow() {
        return currentRow;
    }
    
    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentRow(Row row){
       this.currentRow = row; 
    }

    public void setCurrentCell(Cell cell){
        this.currentCell = cell;
    }
    
    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
