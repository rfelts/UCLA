/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 * Peanut Class.
 * 
 * Type of a Nut hence inherited from the Nut super class. Represented by the 
 * character symbol ‘P’ in the maze and carries 10 nutritional points.
 * 
 * The Peanut class defines the following attribute:
 * Nutrition Points: represents the nutrition points a peanut carries.
 * Name: represents the name of the nut
 * Symbol: represents the symbol of the nut
 * 
 * @author rfelts
 */


public class Peanut extends Nut{
    
    public Peanut(){
        iNutritionPoints = 10;
        sNutName = "Peanut";
        cSymbol = 'P';
        create();
    }
}
