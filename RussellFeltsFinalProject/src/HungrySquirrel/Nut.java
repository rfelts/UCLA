/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

import java.util.Random;

/**
 * Nut Class.
 * 
 * There are two types of nuts available: Almond and Peanut. When a squirrel 
 * eats a nut, it gains points. A nut shall be removed from the maze once it is 
 * eaten. There shall be total of 5 nuts in the maze. The nuts locations shall 
 * be random and have to be placed in valid locations, meaning that a nut 
 * cannot be put in a position that is already occupied by a wall (*), a 
 * squirrel (@) or a previously created nut. The type of nut (peanut or almond) 
 * is random based on 50% probability.
 * 
 * Total Nuts: A constant variable that represents the total number of nuts 
 *   that will be created for this game (5 nuts).
 * NutritionPoints: Stores the nutrition points of a nut.
 * Name: The name of the nut (“Almond” or “Peanut”)
 * 
 * @author rfelts
 */
abstract public class Nut extends Entity {
    
    static final int TOTAL_NUTS = 5;
    int iNutritionPoints;
    String sNutName;
    
    /**
     * Implements the abstract method in the Entity superclass.  
     * This method randomly generated the location of the nut.  Keep in mind 
     * that a nut cannot be placed over a wall (*), a squirrel (@) or a 
     * previously created nut. In other words, it can only be placed where 
     * there is a blank space.
     */

    @Override
    public void create(){
        
        /* Use a random value from 1 to 18 for rows and 1 to 48 for columns to
        prevent trying to put a nut on an exterior wall. */ 
        Random rand = new Random();
        int iMin = 1;
        int iRowMax = 18;
        int iColMax = 48;
        iRow = rand.nextInt((iRowMax - iMin) + 1) + iMin;
        iCol = rand.nextInt((iColMax - iMin) + 1) + iMin;
        
        while(!Maze.available(iRow,iCol)){
            iRow = rand.nextInt((iRowMax - iMin) + 1) + iMin;
            iCol = rand.nextInt((iColMax - iMin) + 1) + iMin;
        }
    }
}
