/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Boat application.  
 * Each Boat has the following attributes: name, speed, angle, and power. The 
 * Boat names should be read from a text file “boats.txt”.
 * For testing, use the following boat names in the boats.txt file:
 * Sea Monkey, Backdraft, Cast Away, Nautifish, Destiny
 * 
 * The application should be able to accept commands from the user.  The user 
 * has to provide the commands in the following format: (Boat name, command>)
 * 
 * A message should be displayed if the user enters: an invalid command, a boat 
 * name that does not exist, a command that is not in the correct format 
 * (boatname, command).
 * 
 * @author rfelts
 */

public class BoatApp {
    
    public static void main (String[] args){
        
        BoatNames namesList;
        BoatList boatList = new BoatList();
        Boat currBoat = null;
                
        try{
            namesList = new BoatNames();
        } 
        catch(FileNotFoundException ex){
            System.out.println("The file containing the boat name could not be "
                    + "found. The program will now quit. \n" + ex);
            return;
        }
        
        // Setup for and request user input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter: <Boat Name, Command> or quit");       
        
        // Read the user input
        while(keyboard.hasNextLine()){
            String sInput = keyboard.nextLine();
            if(sInput.equalsIgnoreCase("quit"))
                break;
            // Store and verfiy the input data
            String sData[] = sInput.split(",");
            if(sData.length !=2){
                System.out.println("Invalid data entered.\nPlease enter: "
                        + "<Boat Name, Command> or quit ");
            }
            else{
                /* Trim the whitespace from the boat name and command. To reduce 
                chance of input errors I should probably do more formating of 
                the command strings. I.E. Make them noncase sensitive and remove 
                all whitespace. */ 

                sData[0] = sData[0].trim();
                sData[1] = sData[1].trim();

                // Verify the boat name is valid and create a new boat object
                try{
                    namesList.validName(sData[0]);
                    currBoat = boatList.BoatExists(sData[0]);
                    // Verify the command is valid
                    try{
                        currBoat.verifyCommand(sData[1]);
                    }
                    catch(InvalidCommandException exception){
                        System.out.println(exception.getMessage());                
                    }
                }
                catch(InvalidNameException exception){
                    System.out.println(exception.getMessage());
                }

                //System.out.println("The current list of boats is: " + boatList);
            
                switch(sData[1]){
                    case "Power On": currBoat.power(true);
                    break;
                    case "Power Off": currBoat.power(false);
                    break;
                    case "Speed Up": currBoat.speed(true);
                    break;
                    case "Slow Down": currBoat.speed(false);
                    break;
                    case "Turn Right": currBoat.turn(true);
                    break;
                    case "Turn Left": currBoat.turn(false);
                    break;
                }
            }
        }
    }
}       
