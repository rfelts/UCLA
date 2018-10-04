/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

/**
 * InvalidCommandException class.
 * 
 * Throw an exception when a user enters an invalid command.
 * 
 * @author rfelts
 */

public class InvalidCommandException extends Exception {
    
   private final String tempCommands;
   private final String sCommand;
   
   public InvalidCommandException(String sCommand, String[] aCommands){
       super();
       this.sCommand = sCommand;
       this.tempCommands = String.join(", ", aCommands);
   }
   
   @Override
   public String getMessage(){
       return sCommand + " is not valid. Valid commands are:\n" + tempCommands 
               + "\nPlease try again:"; 
   }     
}
