/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoatPackage;

import java.util.ArrayList;

/**
 * BoatList Class.
 * 
 * Store the boats in a list to prevent multiple boats with the same name being
 * created. This allows multiple commands to be given to a single boat object.
 * 
 * @author rfelts
 */
public class BoatList {
    
    private final ArrayList<Boat> boatList;
    
    public BoatList(){
        boatList = new ArrayList<>();
    }
    
    /**
    * Check to see if the boat exists. If it does return the boat object from 
    * the list. If the list is empty or the boat is not in it create a new boat 
    * object and return it.
    * @param sBoatName is a string that is used to search for the boat.
    * @return Boat object is returned
    */
    
    protected Boat BoatExists(String sBoatName){
        if(boatList.isEmpty()){
            return CreateBoat(sBoatName);
        }
        else{
            // Cycel over the boat list and return the boat if it's found
            for(Boat b: boatList){
                if(b.sName.equalsIgnoreCase(sBoatName)){
                    return b;
                }
            }
            return CreateBoat(sBoatName);
        }
    }
    
    /**
    * Create a new boat object, add it to the list, and return the new object. 
    * @param sBoatName is a string that is used to create the boat object.
    * @return Boat object is returned.
    */
    
    private Boat CreateBoat(String sBoatName){
        boatList.add(new Boat(sBoatName));
        return boatList.get(boatList.size()-1);
    }
    
    // Overrides the toString method to always return the names in the arraylist  
    @Override
    public String toString(){
        ArrayList<String> tempNames = new ArrayList<>();
        boatList.forEach((b) -> {tempNames.add(b.sName);});
        return String.join(", ",tempNames );
    }
    
    
    
}
