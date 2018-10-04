/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;
        
import java.util.Arrays;

/**
 * Boat Class.
 * 
 * Has the following attributes: name, speed, angle, and power. Along with
 * methods for adjusting them.
 * 
 * @author rfelts
 */
public class Boat {
    
    protected String sName;
    private int iSpeed;
    private int iAngle;
    private boolean bPower;
    private final String aCommands[] = {"Power On", "Power Off", "Speed Up", 
        "Slow Down", "Turn Left", "Turn Right"};
    
    /* Basic constructor for the boat object */
    public Boat(String sName){
        this.sName = sName;
        this.bPower = false;
        this.iSpeed = 0;
        this.iAngle = 0;
    }
    
    /**
    * Verify the name passed in is in the array.
    * @param sCommand is a string containing the command to find in the array 
    * @throws BoatPackage.InvalidCommandException 
    */
    
    public void verifyCommand(String sCommand) throws InvalidCommandException{
        // Could do some better checking to ignore case too
        if(!Arrays.asList(aCommands).contains(sCommand)){
            InvalidCommandException exception = 
                    new InvalidCommandException(sCommand, aCommands);
            throw exception;        
        }
    }
    
    /** 
    * Verify the request doesn't match the current power state then adjust the
    * power accordingly.
    * @param bPwr is a boolean representing the desired power state. True is on
    * false is off. 
    */
    
    public void power(boolean bPwr){
        if(bPower == bPwr && bPower){
            System.out.println(sName + "'s power is already on.");
        }
        else if(bPower == bPwr && !bPower){
            System.out.println(sName + "'s powers is already off.");
        }
        else if(bPwr){
            System.out.println("Turning on " + sName + "'s power");
            bPower = bPwr;
        }
        else{
            System.out.println("Turning off " + sName + "'s power.");
            bPower = bPwr;
        }
    }
    
    /** 
    * Increases or decreases the speed by the minimum speed increment 2 mph. 
    * @param bSpeed is a boolean representing the desired speed change. True is up
    * false is down. 
    */
    
    public void speed(boolean bSpeed){
        // Make sure the boat is on
        if(!bPower)
            power(true);
        if(bSpeed){
            iSpeed += 2;
            System.out.println(sName + " increased speed. It's current speed "
                    + "is " + iSpeed + " mph and it's traveling in the "
                            + "direction " + iAngle + " degrees.");
        }
        else{
            if(iSpeed == 0)
                System.out.println("Can not slow down. " + sName + " is "
                        + "stopped.");
            else if(iSpeed < 2){
                iSpeed = 0;
                System.out.println(sName + " slowed down and is now stopped.");
            }
            else{
                iSpeed -= 2;
                System.out.println(sName + " slowed down. It's current speed "
                        + "is " + iSpeed + " mph and it's traveling in the "
                                + "direction " + iAngle + " degrees.");
            }
        }
    }

    /** 
    * Turns the boat left or right by a minimum of 5 degree.
    * @param bTurn is a boolean representing the desired speed change. True is up
    * false is down. 
    */
    
    public void turn(boolean bTurn){
        // Make sure the boat is on
        if(!bPower)
            power(true);
        if(bTurn){
            iAngle += 5;
            System.out.println(sName + " turned right by 5 degrees. It's "
                    + "current angle is " + iAngle + " degrees and it's current "
                            + "speed is " + iSpeed + " mph.");
        }
        else{
            iAngle -= 5;
            System.out.println(sName + " turned left by 5 degrees. It's "
                    + "current angle is " + iAngle + " degrees and it's current "
                            + "speed is " + iSpeed + " mph.");
        }
    }
    
    // Overrides the toString method to always return the commands in the arraylist  
    @Override
    public String toString(){
        return String.join(", ", aCommands);
    }
    
}
