/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 * MovabelInterface.
 * 
 * This holds the abstract interface methods for moving the squirrel. The 
 * methods will be implemented in the squirrel class.
 * 
 * @author rfelts
 */

public interface MovableInterface {

    abstract void movePrompt();
    
    abstract void move(int iTempRow, int iTempCol);
    
}
