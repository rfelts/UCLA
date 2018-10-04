/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexBank;

/**
 * Customer class. 
 * 
 * A customer has a first name, last name, and social security number. The 
 * social security number is a String variable and must comply with this 
 * format: xxx-xx-xxxx where 'x' is a digit between 0-9. 
 * 
 * If a customer is supplied an invalid SSN, a message must be printed stating
 * the SSN of the customer is invalid. However, it will create the bank account 
 * regardless.
 * 
 * @author rfelts
 */

public class Customer {
    
    private String sFirstName, sLastName, sSocSecNum;
    
    /* The Customer constructor 
    @param sFirstName is a String variable representing the customer's first 
    name
    @param sLastName is a String variable representing the customer's last name
    @param sSocSecNum is a String variable representing the customer's social 
    security number. It must comply with this format: xxx-xx-xxxx where 'x' is 
    a digit between 0-9.*/

    public Customer(String sFirstName, String sLastName, String sSocSecNum){
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        if(!verifySSN(sSocSecNum)){
            this.sSocSecNum = "xxx-xx-xxxx";
            System.out.println("Invalid SSN provided for " + sFirstName + " "
                    + sLastName);
        } 
        else 
            this.sSocSecNum = sSocSecNum;
    }
    
    /* Uses a regex to verify the social security number complies with the 
    format: xxx-xx-xxxx where 'x' is a digit between 0-9. */
    
    private boolean verifySSN(String sSocSecNum){
        return sSocSecNum.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }
    
    // Overrides the toString method to always return the customer's full name
    
    @Override
    public String toString(){
        return sFirstName + " " + sLastName;
    }
}
