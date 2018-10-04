/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

/**
 * Write a Java application that instantiates Boat objects. 
 * Instantiate a boat object and call it's methods to speed up and slow down 
 * the boat. Verify the boat does exceed it max speed or go below it's min 
 * speed. As well as, determine the position of the sail.
 * 
 * @author rfelts
 */

public class SimpleBoatApp {

    public static void main (String[] args) {
        
        // Create object using basic constructor
        Boat simpleBoat = new Boat("Destinty");
        
        /*Verify the speed can be increased and decreased. As well as, the sail 
        position is reported. */
        try{
            simpleBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        
        try{
            simpleBoat.goSlow();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        simpleBoat.whereIsTheSail();

        try{
            simpleBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        simpleBoat.whereIsTheSail();

        try{
            simpleBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        
        // Create object using the advanced constructor to test max speed
        Boat maxSpeedBoat = new Boat("MaxBoat", 89.0f);
        
        /* Verify speed is increased but does not go over the prdefined max 
        speed.*/
        try{
            maxSpeedBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        try{
            maxSpeedBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
         try{
            maxSpeedBoat.goFast();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
         
        maxSpeedBoat.whereIsTheSail();
   
        // Create object using the advanced constructor to test max speed
        Boat minSlowBoat = new Boat("MinBoat", 9.0f);
        
        /* Verify speed is increased but does not go below the prdefined min 
        speed.*/
        try{
            minSlowBoat.goSlow();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        try{
            minSlowBoat.goSlow();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        try{
            minSlowBoat.goSlow();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        
        minSlowBoat.whereIsTheSail();
    }
}
