/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

/**
 * Boat class
 * 
 * Should provide three fields/attributes: 
 * 1) name is a variable of type String,
 * 2) sail position is a variable of type boolean, 
 * 3) speed is a variable of type float.
 * 
 * It must also define a constructor and three methods:
 * goFast, goSlow, whereIsTheSail.
 * 
 * Note: The boat speed should not exceed 100 mph (max speed is 100 mph) 
 * and cannot go below 0 mph.
 * 
 * @author rfelts
 */

public class Boat {
    
    private float fSpeed;
    private String sBoatName;
    private boolean bSailPos;
    private static int iMinSpeed = 0;
    private static int iMaxSpeed = 100;
    
    /* Basic constructor for the boat object sets just the name
    @param sBoatName is a String variable that represents the boat name*/
    public Boat(String sBoatName){
        this.fSpeed = 0;
        this.sBoatName = sBoatName;
        this.bSailPos = false;
    }
    
    /* Advanced constructor for the Boat class sets the name and speed
    @param sBoatName is a String variable that represents the boat name
    @param fSpeed is a float variable that represents the speed of boat.*/
    public Boat(String sBoatName, float fSpeed){
        this.sBoatName = sBoatName;
        this.fSpeed = fSpeed;
        this.bSailPos = false;
    }
    
    /* Sets the position of the sail to true and verifies the boat is not 
    already traveling beyond the max speed. Throughs exceptions when increasing 
    the speed is not fully possible. Otherwise increases the speed of the boat 
    by 10 mph and prints the following text: "Boat's name" is raising the sail 
    at the speed of "##" mph.*/
    public void goFast(){
        bSailPos = true;
        if((int)fSpeed == iMaxSpeed){
            throw new IllegalArgumentException(sBoatName + " is already going "
                    + "the maximun speed of " + iMaxSpeed + "mph.");
        }
        else if((int)fSpeed > 90){
            fSpeed = 100f;
            throw new IllegalArgumentException(sBoatName + " can not increase "
                    + "speed beyond the maximun speed of " + iMaxSpeed + "mph."
                    + " Setting speed to max speed of " + iMaxSpeed + "mph.");           
        }
        else{
            fSpeed += 10;
            System.out.println(sBoatName + " is raising the sail at the speed "
                    + "of " + fSpeed + "mph.");
        }
        
        
    }
    
    /* Sets the position of the sail to true and verifies the boat is not 
    already traveling below the min speed. Throughs exceptions when decreasing 
    the speed is not fully possible. Otherwise decreases the speed of the boat 
    by 5 mph and prints the following text: "Boat's name" is lowering the sail 
    at the speed of "##" mph.*/
    public void goSlow(){
        bSailPos = false;
        if((int)fSpeed == iMinSpeed){
            throw new IllegalArgumentException(sBoatName + " is already going "
                    + "the minimun speed of " + iMinSpeed + "mph.");
        }
        else if((int)fSpeed < 5){
            fSpeed = 0f;
            throw new IllegalArgumentException(sBoatName + " can not decrease "
                    + "speed below the minimun speed of " + iMinSpeed + "mph."
                    + " Setting speed to min speed of " + iMinSpeed + "mph.");           
        }
        else{
            fSpeed = fSpeed - (float)5;
            System.out.println(sBoatName + " is lowering the sail at the speed"
                    + " of " + fSpeed + "mph."); 
        }      
    }
    
    /* whereIsTheSail prints the name of the boat and “sail is up” or 
    “sail is down” depending on the sail position: "Boat's name" sail is up.*/
    public void whereIsTheSail(){
        if(bSailPos == true)
            System.out.println("Sail is up.");
        else
            System.out.println("Sail is down.");
    }
}
