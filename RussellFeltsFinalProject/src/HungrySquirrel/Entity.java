/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;


/**
 * Entity Class.
 * 
 * Four types of entities exist in the Maze: Nut, Squirrel, Poisonous Cashew 
 * and Wall.  
 * Each entity has three attributes:
 * 1. symbol: This instance variable is a character symbol by which an entity 
 * is identified on the Maze.  For example, a squirrel is represented by ‘@’. 
 * Each nut will be represented by the first character of its name (e.g. Almond 
 * will be represented by ‘A’).
 * 2. row: This instance variable is the row position of the entity in the maze.
 * 3. column: This instance variable is the column position of the entity in 
 * the maze.

 * @author rfelts
 */
abstract public class Entity{
    
    char cSymbol;
    int iRow;
    int iCol;
    
    /**
     * Classes must override this method with specifics for creating their 
     * object types.
    */
    
    abstract public void create();
    
    /**
     * Puts an entity at location (newRow, newCol) in the maze.
     * @param newRow
     * @param newCol
    */
    
    public void put(int newRow, int newCol){
        update(newRow,newCol);
        Maze.maze[newRow][newCol] = this;
    }

    /**
     * Takes a row and a column and updates the current.
     * @param iRow  An integer representing the row location in the maze.
     * @param iCol An integer representing the column location in the maze.
    */
    
    public void update(int iRow, int iCol){
        this.iRow = iRow;
        this.iCol = iCol;
    }
    
    /**
     * Takes a row and a column and returns the item in the location.
     * @param iRow  An integer representing the row location in the maze.
     * @param iCol An integer representing the column location in the maze.
     * @return An entity or null depending on what is stored.
    */

    public static Entity get(int iRow, int iCol){
        return Maze.maze[iRow][iCol];
    }

    /**
     * Takes a row and a column and deletes the item in the location.
     * @param iRow  An integer representing the row location in the maze.
     * @param iCol An integer representing the column location in the maze.
    */
    
    public void delete(int iRow, int iCol){
        Maze.maze[iRow][iCol] = null;
    }
    
}
