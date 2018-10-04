/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BoatNames Class.
 * 
 * Read the boat names from a text file “boats.txt”. For testing, use the 
 * following boat names in the boats.txt file: Sea Monkey, Backdraft, Cast Away, 
 * Nautifish, Destiny.
 * 
 * @author rfelts
 */
public class BoatNames {
    
    private final Scanner fileIn;
    private final ArrayList<String> aNames;
    private int iCounter = 0;
    
    public BoatNames() throws FileNotFoundException{
        this.fileIn = new Scanner(new File("boats.txt"));
        this.aNames = new ArrayList<>();
        this.readFIle();
    }
    
    /* Read the file and add the boat names to an arraylist for easy comparison 
    with user input*/
    
    private void readFIle(){
        while(fileIn.hasNextLine()){
            aNames.add(iCounter, fileIn.nextLine());
            iCounter ++;
        }
        fileIn.close();
    }
    
    /** 
    * Verifies the name passed in is in the array
    * @param sTempName is a string containing the name to find in the arraylist
    * @throws InvalidNameException
    */

    protected void validName(String sTempName) throws InvalidNameException{
        if(!aNames.stream().anyMatch((sTemp) -> 
                (sTemp.equalsIgnoreCase(sTempName)))){
            InvalidNameException exception = new InvalidNameException(sTempName, 
                    aNames);
            throw exception;        
        }
    }
    
    // Overrides the toString method to always return the names in the arraylist  
    @Override
    public String toString(){
        return String.join(", ", aNames);
    }

}
