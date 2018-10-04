/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

import java.util.Scanner;

/**
 * Squirrel Class.
 * 
 * Squirrel shall be represented by the “@” symbol in the maze and is able to 
 * move up, down, left and right. The initial location of the squirrel shall be 
 * determined by prompting the user for the starting row and column. It cannot 
 * move over a wall (i.e. ‘*’). However, the squirrel can over move a nut. Once 
 * the squirrel moves over a nut, it eats the nut and collects points.
 * The Squirrel class is inherited from the Entity abstract super class and it 
 * implements the Movable interface. 
 * 
 * The Squirrel class contains two attributes:
 * pointsCollected: This attribute provides the total points a squirrel has 
 *   accumulated when eating nuts.
 * totalNutsEaten: This attribute provides the total number of nuts eaten.
 * 
 * @author rfelts
 */

public class Squirrel extends Entity implements MovableInterface{
    
    private int iPointsCollected, iTotalNutsEaten;
    
    public Squirrel(){
        cSymbol = '@';
        iPointsCollected = 0;
        iTotalNutsEaten = 0;
        create();
    }
    
    /**
     * Adds the point value for eating the nut and increments the total nuts 
     * eaten count.
     * Ends the game if all the nuts are eaten or the squirrel dies from eating
     * too many poisonous cashews.
     * @param nut A nut object representing the nut being eaten.
     * @return A boolean value true if the game is over false if not.
     */
    
    private boolean eat(Nut nut){
        iPointsCollected += nut.iNutritionPoints;
        // Did the squirrel eat an almond or peanut
        if(nut.cSymbol != 'C'){
            iTotalNutsEaten +=1;
            if(iTotalNutsEaten == Nut.TOTAL_NUTS){
                System.out.println("Squirrel successfully collected all the "
                        + "nuts. Total points: " + iPointsCollected + ".\n"
                        + "Thank you for playing this game.");
                return true;
            }
            else{
                System.out.println("Squirrel ate an " + nut.sNutName + " and "
                        + "gained " + nut.iNutritionPoints + " points.(Total: " 
                        + iPointsCollected + ")");
                return false;
            }
        }
        else{
            System.out.println("The squirrel ate a poisonous cashew. It lost "
                    + nut.iNutritionPoints + " points. (Total: " + 
                    iPointsCollected + ")");
            if(iPointsCollected < 0){
                System.out.println("The squirrel died. Game over.");
                return true;
            }                
        }
        return false;
    }
    
    /**
     * Provides the implementation of the abstract method in the Entity 
     * superclass.  
     * 
     * Prompt the user to enter the initial location of the squirrel in the 
     * maze. Verify the location provided by the user is valid and available. 
     * If the user provides an invalid (e.g. row 200, column 200) or unavailable 
     * location where there is already a wall (‘*’), the program must ask the 
     * user to input a new set of row and column. This continues until the user 
     * provides a position that squirrel can start from. Again, keep in mind 
     * that a squirrel cannot be placed where there is a wall ‘*’.
     */
    
    @Override
    public void create(){
        String userPrompt = "Enter the Squirrel position (row , column) or "
                + "quit:";
        String inputError = "Position not available. Try again!";
        
        // Setup for and request user input
        Scanner keyboard = new Scanner(System.in);
        System.out.println(userPrompt);
        
        // Read the user input
        while(keyboard.hasNextLine()){
            String sInput = keyboard.nextLine();
            // Quit end the program.
            if(sInput.equalsIgnoreCase("quit"))
                System.exit(0);
            else{
                // Store and verify the input data
                String sData[] = sInput.split(",");
                iRow = Integer.parseInt(sData[0]);
                iCol = Integer.parseInt(sData[1]);
                if(!Maze.available(iRow,iCol)){
                System.out.println(inputError + "\n" + userPrompt);
                }
                else{
                    put(iRow,iCol);
                    break;
                }
            }
        }
    }
    
    /**
     * Provides the implementation for the abstract method in the 
     * MoveableInterface.
     * 
     * Prompts the user for movement input. Validates the input then moves the 
     * entity.
     */
    
    @Override
    public void movePrompt(){
        
        int iTempRow, iTempCol;
        
        // Setup for and request user input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Move: u,d,l,r OR quit to exit.");
        
        // Read the user input
        while(keyboard.hasNextLine()){
            String sInput = keyboard.nextLine();
            if(sInput.equalsIgnoreCase("quit") || iTotalNutsEaten == 
                    Nut.TOTAL_NUTS)
                break;
            else{
                switch(sInput.toLowerCase()){
                    case "u": 
                        if(iRow == 0){
                            System.out.println("Invalid move. The squirrel can "
                                    + "not go up.");
                        }
                        else{
                            System.out.println("Move the squirrel to: " + 
                                    (iRow - 1) + " " + iCol);
                            move((iRow - 1), iCol);
                        }
                        break;
                    case "d":
                        if(iRow == 49){
                            System.out.println("Invalid move. The squirrel can "
                                    + "not go down.");
                        }
                        else{
                            System.out.println("Move the squirrel to: " + 
                                    (iRow + 1) + " " + iCol);
                            move((iRow + 1), iCol);
                        }
                        break;
                    case "l":
                        if(iCol == 0){
                            System.out.println("Invalid move. The squirrel can "
                                    + "not go left.");
                        }
                        else{
                            System.out.println("Move the squirrel to: " + 
                                    iRow + " " + (iCol - 1));
                            move(iRow, (iCol - 1));
                        }
                        break;
                    case "r":
                        if(iCol == 0){
                            System.out.println("Invalid move. The squirrel can "
                                    + "not go right.");
                        }
                        else{
                            System.out.println("Move the squirrel to: " + 
                                    iRow + " " + (iCol + 1));
                            move(iRow, (iCol + 1));
                        }
                        break;
                    default: 
                        System.out.println("Invalid Input. Move: u,d,l,r OR "
                                + "quit to exit.");
                }
            }
        }
    }
    
    /**
     * Provides the implementation for the abstract method in the 
     * MoveableInterface.
     * 
     * Moves the entity the request direction, removes the previous occurrence 
     * of the entity, and displays the maze.
     * @param iTempRow An int representing the row to move too
     * @param iTempCol An int representing the column to move too
     */

    @Override
    public void move(int iTempRow, int iTempCol){
        if(!Maze.available(iTempRow, iTempCol)){
            System.out.println("Invalid move. The squirrel can not go through "
                    + "walls.");
        }
        else{
            if(get(iTempRow,iTempCol) == null){
                delete(iRow,iCol);
                put(iTempRow, iTempCol);                                    
                Maze.display();                                   
            }
            else{
                boolean bGameOver = eat((Nut)Maze.maze[iTempRow][iTempCol]);
                delete(iRow,iCol);
                put(iTempRow, iTempCol);
                Maze.display();
                if(bGameOver)
                    System.exit(0);
            }
        }    
    }
}