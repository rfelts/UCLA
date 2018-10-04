/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayDemoPackage;

import java.util.Scanner;

/**
 * Write a program (ArrayDemo.java) that prompts the user to enter 5 integer 
 * numbers. Once the user enters the 5 numbers, the program must determine and 
 * output the average, the largest, and smallest of 5 numbers.
 * 
 * @author rfelts
 */
public class ArrayDemo {
    
    public static void main(String[] args) {
        
        // initialize the array
        int[] aData = new int[5];
        // Needed to get user input from the terminal
        Scanner input = new Scanner(System.in);
       
        /*Get input from the user. Should probably check to verify input is 
        valid. But not neccessary for this exercise.*/
        for(int iLoop = 0; iLoop < aData.length; iLoop++)
        {
            // Print message to console
            System.out.println("Enter a whole number");
             // Insert the data into the array
             aData[iLoop] = input.nextInt();
        }
        
        // Call the averaging method
        float fAvg = getAverage(aData);
        // Call the get lagest value method
        int iMax = getLargest(aData);
        // Call the get smallest value method
        int iMin = getSmallest(aData);
        
        // Print out the results
        System.out.print("The average, largest, and smallest of the numbers: ");
        for(int iValue: aData)
        {
            System.out.print(iValue);
            System.out.print(" ");
        }
        System.out.println("is average = " + fAvg + " largest = " + iMax + 
                " and smallest = " + iMin);     
    }
    
    // Receives an array of ints. Sums the array subscripts and returns a float
    static float getAverage(int[] aData) {
        int iSum = 0;
        float fCounter = 0f;
        //cycle over the array suming the values
        for(int iLoop : aData)
        {
           iSum += iLoop;
           fCounter++;
        }
        /* Divide the sum by the total number of items. Also most likely need 
        to cast the int to a float. So the result will match the required
        output. */
        float fAvg = (float)iSum/fCounter;
        return fAvg;
    }
    
    /* Receives an array of ints and cycles over the array returning the
    largest value*/
    static int getLargest(int[] aData) {
        int iMax = 0;
        // Cycle over the array finding the largest value
        for(int iLoop : aData)
        {
            if(iMax < iLoop)
                iMax = iLoop;
        }
        // Return the max value
        return iMax;
    }
    
    /* Receives an array of ints and cycles over the array returning the
    smallest value*/
    static int getSmallest(int[] aData) {
        int iMin = 0;
        // Cycle over the array finding the smallest value
        for(int iLoop = 0; iLoop < aData.length; iLoop++)
        {
            /* Verify that the current array value is less than the current 
            minimum value. Also if this is the first pass through the loop 
            just set the value to the current array value.*/
            if(iMin > aData[iLoop] || iLoop == 0)
                iMin = aData[iLoop];
        }
        // Return the max value
        return iMin;
        
    }
}
