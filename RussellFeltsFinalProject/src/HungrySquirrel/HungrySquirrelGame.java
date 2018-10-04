/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;


/**
 * In this game, there is a Squirrel in a maze looking for nuts.  
 * You will guide the squirrel to find and eat the nuts. There are two types of 
 * nuts available in the maze, Almonds and Peanuts.  The squirrel gains 
 * nutritional points as it finds and eats the nuts. Once it finds all the nuts 
 * in the maze, the game is over.
 * 
 * Call the create method of the Maze class to create the maze. 
 * Create a Squirrel object. This creates the squirrel and puts the squirrel in 
 *   the maze based on the user input.
 * Instantiate an array of Nut objects and determine and create the type of nut 
 *   (almond or peanut).
 * Display the maze with all the entities created.
 * Accept user input to move the squirrel.
 * For every move the full maze with all the entities should be displayed.
 * Every time the squirrel eats a nut, program prints the points collected for 
 * the new nut and total points collected thus far.
 *   !!! Squirrel ate Almond and gained 5 points (Total 15 points) !!!
 * Once the squirrel collects all the nuts, a message must be displayed and the 
 *   game is over.
 *   “Squirrel successfully collected all the nuts. Total points 30.”
 *   “Thank you for playing this game”
 * 
 * @author rfelts
 */

public class HungrySquirrelGame {
    
    public static void main(String[] args){
        
        /* Call the create method of the Maze class to create the maze. */
        Maze mazeObject = new Maze();

        /* Create the squirrel and put it in the maze based onuser input. */
        Squirrel mySquirrel = new Squirrel();
        
        /* Display the maze with all the entities created. */
        Maze.display();

        /* Accept user input to move the squirrel. */
        mySquirrel.movePrompt();
    }
    
}
