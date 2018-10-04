/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerPackage;

/**
 *
 * @author rfelts
 */

public class InvalidCustomerException extends Exception{
    
   private String sFirstName, sLastName, sSSN;
   
   public InvalidCustomerException(String sFirstName, String sLastName, 
           String sSocSecNum){
       super();
       this.sFirstName = sFirstName;
       this.sLastName = sLastName;
       this.sSSN = sSocSecNum;
   }
   
   @Override
   public String getMessage(){
       return "The Social Security Number: " + sSSN + " provided for customer: " 
               + sFirstName + " " + sLastName + " is invalid."; 
   }
   
}
