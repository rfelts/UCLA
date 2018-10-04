/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 * Almond Class.
 * Type of a Nut hence inherited from the Nut super class. Represented by the 
 * character symbol ‘A’ in the maze and carries 5 nutritional points.
 * 
 * The Almond class defines the following attribute:
 * Nutrition Points: represents the nutrition points an almond carries.
 * Name: represents the name of the nut
 * Symbol: represents the symbol of the nut
 * 
 * @author rfelts
 */


public class Almond extends Nut{
    
    public Almond(){
        iNutritionPoints = 5;
        sNutName = "Almond";
        cSymbol = 'A';
        create();
    }
}
