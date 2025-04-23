package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;

public class Game {

    private Grid grid;
    private Random random;

    //constructor for greating a game
	public Game(Grid grid) {
        this.grid = grid;
        this.random = new Random();
	}
    
    //constructor for creating a new game with the grid size specified
    public Game(int size){
        this.random = new Random();
        if(size >= 3 && size <= 7){
            this.grid = createRandomGrid(size);
        }
    }

    //returns the grid that the game is being played on
	public Grid getGrid() {
		return grid;
	}

    //sets the grid for the game by passing in a grid that is already made
	public void setGrid(Grid grid) {
	    this.grid = grid;	
	}
	
	public Object play(Object object, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

    //logic to create a random grid
	public Grid createRandomGrid(int gridSize) {
        //make sure that the grid size fits within the parameters
        if(gridSize < 3 || gridSize > 7){
            return null; //grid size is not valid
        }

        ArrayList<Row> rows = new ArrayList<>();

        //now time to actually create the grid using a double for loop
        for(int i = 0; i < gridSize; i++){ //create all the rows
            ArrayList<Cell> cells = new ArrayList<>();
            for(int j = 0; j < gridSize; j++){ //fill in the colums for each row using cells
                //logic is as follows --> if it is on the edge the the left, right, up, or down needs to be a wall, otherwise it can be an aperature
                CellComponents left;
                if(j == 0){ //this will be on the left side so it needs to be a wall
                    left = CellComponents.WALL;
                }
                else{
                    left = CellComponents.APERTURE;
                }

                //right components
                CellComponents right;
                if(j == gridSize - 1){ //this will be on the right side so it needs to be a wall
                    right = CellComponents.WALL;
                }
                else{
                    right = CellComponents.APERTURE; //anywhere else the right side will be an aperature
                }

                //up components
                CellComponents up;
                if(i == 0){ //this will be on the top so it needs to be a wall
                    up = CellComponents.WALL;
                }
                else{
                    up = CellComponents.APERTURE; //anywhere else the top side will be an aperature
                }

                //down components
                CellComponents down;
                if(j == gridSize - 1){ //this will be on the bottom of the grid so they have to be walls
                    down = CellComponents.WALL;
                }
                else{
                    down = CellComponents.APERTURE; //anywhere elss the down side going to be an aperature
                }
                cells.add(new Cell(left, right, up, down));
            }
            rows.add(new Row(cells));
        }

        //add the exit to a random spot on the left side of the grid
        int randomRow = new Random().nextInt(gridSize);
        for(int i = 0; i < gridSize; i++){
            Cell leftCell = rows.get(i).getCells().get(0);
            if(i == randomRow){
                leftCell.setLeft(CellComponents.EXIT);
            }
            else{
                leftCell.setLeft(CellComponents.WALL); //pretty sure this is redundant since i already made them walls if they are on the left up above
            }
        }

		return new Grid(rows);
	}

	

}
