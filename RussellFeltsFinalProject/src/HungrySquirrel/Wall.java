/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 * Wall Class.
 * 
 * The walls positions are taken from the reading in the file. They have a 
 * symbol of '*' and are not moveable.
 * 
 * @author rfelts
 */

public class Wall extends Entity{
    
    public Wall(int iRow, int iCol){
        cSymbol = '*';
        this.iRow = iRow;
        this.iCol = iCol;
//        create();
    }

    @Override
    public void create(){
        /* Since I'm getting them from the file. I'm not sure what to do about 
        creating walls. */
    }    
}
