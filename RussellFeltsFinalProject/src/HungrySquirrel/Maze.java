/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Maze Class.
 * The maze is a 20 x 50 matrix represented by a 2-dimensional Entity array 
 * (The Entity Class is defined in the next paragraph).   Walls in the maze are 
 * represented by ‘*’ and empty positions by blank spaces. The maze shall be 
 * read from a text file “Maze.txt” (The Maze.txt file is provided). A squirrel 
 * is able to move to empty spaces in the maze.
 * 
 * Max_Maze_Row: A constant variable that defines the maximum number of rows in 
 *   the maze (it should be set to 20 rows).
 * Max Maze Column: A constant variable that defines the maximum number of
 *   columns in the maze (it should be set to 50 columns).
 * Maze[][] : A 2-dimentional Entity array that contains the full maze and the 
 *   entities.
 * 
 * @author rfelts
 */

public class Maze {
    
    private static final int MAX_MAZE_ROW = 20;
    private static final int MAX_MAZE_COL = 50;
    static Entity maze[][];
    private static BufferedReader brFile;
    
    /* Default constructor initialized private varibales and calls the create 
    method to read the file containing the maze. */
    
    public Maze(){
        maze = new Entity[MAX_MAZE_ROW][MAX_MAZE_COL];
        create("maze.txt");
    }
    
    /** 
     * Reads the file passed to the method and initializes the 
     * 2-dimentional array with the maze content provided in the file. 
     * @param fileName The file being read 
     */
    
    public static void create(String fileName){
        // Open the file containing the maze
        try{
            brFile = new BufferedReader(new FileReader(fileName));
        }
        catch(FileNotFoundException noFile){
            System.out.println("The file containing the maze does not exist. \n"
                    + noFile + "\nThe program will now quit.");
            return;
        }
        
        try {
            int iRow = 0;
            String sLine;

            /* Read each line/row of the file and cycle over each character in a
            line/row. Storing each chararcter in the array by [row] [column]. */
            while((sLine = brFile.readLine()) != null){
                for(int iColumn = 0; iColumn < MAX_MAZE_COL; iColumn++){
                    if(sLine.charAt(iColumn) == '*')
                        maze[iRow][iColumn] = new Wall(iRow,iColumn);
                    else
                        maze[iRow][iColumn] = null;
                }
                iRow++;
            }
            brFile.close();
        }
        catch (IOException ex) {
            System.out.println("There was a problem reading or closing the file:"
                    + " " + fileName + ".\n" + ex);
        }
        addNuts();
    }
    
    /** Randomly create the type of nut (almond or peanut) and add them to the
     * maze. 
     */
    
    public static void addNuts(){
        Random randBool = new Random();
        for(int iLoop = 0; iLoop < Nut.TOTAL_NUTS ; iLoop++){
            /* Use a random boolean value to determine what nut type to create
            and add the nut to the maze. */
            if(randBool.nextBoolean()){
                Almond tempNut = new Almond();
                tempNut.put(tempNut.iRow, tempNut.iCol);
            }
            else{
                Peanut tempNut = new Peanut();
                tempNut.put(tempNut.iRow, tempNut.iCol);
            }
        }
        for(int iLoop = 0; iLoop < 5; iLoop++){
            PoisonousCashew tempNut = new PoisonousCashew();
            tempNut.put(tempNut.iRow, tempNut.iCol);
        }
    }
    
    /** Displays the maze structure and the containing entities. */
    
    public static void display(){
        // Loop over the array by row then column printing out the values
        for(int iRow = 0; iRow < MAX_MAZE_ROW; iRow++){
            for(int iColumn = 0; iColumn < MAX_MAZE_COL; iColumn++){
                if(maze[iRow][iColumn] != null)
                    System.out.print(maze[iRow][iColumn].cSymbol);
                else
                   System.out.print(' ');
            }
            System.out.print("\n");
        }
    }
    
    /**
     * Takes a row and a column and determines if the location is available to 
     * use. 
     * @param iRow  An integer representing the row location in the maze.
     * @param iCol An integer representing the column location in the maze.
     * @return If the space is empty/available true otherwise false is returned.
     */
    
    public static boolean available(int iRow, int iCol){
//        System.out.println("Maze available method.");
        if(iRow > MAX_MAZE_ROW || iCol > MAX_MAZE_COL || iRow == 0 || 
                iCol == 0){
            // Potentially throw a custom exception here
            System.out.println("The row or column value entered was invalid.");
            return false;
        }
        else 
            return maze[iRow][iCol] == null || maze[iRow][iCol].cSymbol != '*';
    }
}
