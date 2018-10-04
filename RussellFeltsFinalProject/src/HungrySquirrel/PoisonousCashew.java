/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 * PoisonousCashew Class.
 * 
 * Type of a Nut hence inherited from the Nut super class. Represented by the 
 * character symbol ‘C’ in the maze and carries -15 nutritional points.
 * 
 * Poisonous cashews are bad for the squirrel and carry negative nutrition 
 * points (-15 points).  If a squirrel eats a poisonous cashew and its total 
 * points become negative, the squirrel dies and the game is over. There are 
 * total of 5 poisonous cashews in the maze.
 * 
 * @author rfelts
 */


public class PoisonousCashew extends Nut{
    
    public PoisonousCashew(){
        iNutritionPoints = -15;
        sNutName = "PoisonousCashew";
        cSymbol = 'C';
        create();
    }
}