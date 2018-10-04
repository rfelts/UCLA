/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

import java.util.ArrayList;

/**
 * InvalidNameException class.
 * 
 * Throw an exception when a user enters a boat name that is not in the file.
 * 
 * @author rfelts
 */

public class InvalidNameException extends Exception {
    
   private final String sName;
   private final ArrayList<String> aNames; 
   
   public InvalidNameException(String sName, ArrayList<String> aNames){
       super();
       this.sName = sName;
       this.aNames = aNames;
   }
   
   @Override
   public String getMessage(){
       return "The boat name " + sName + " is invalid. \nValid boat names are:"
               + "\n" + aNames + "\nPlease try again."; 
   } 
}
