/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBank;

/**
 * SavingAccount class.
 * 
 * Is derived from the BankAccount class. It overrides the applyInterest method
 * to accrue a standard 5% interest.
 * 
 * @author rfelts
 */
public class SavingAccount extends BankAccount{
    
    private final float fINTEREST;
    
    /* SavingAccount constructor calls the BankAccount constructor and sets the 
    SavingAccount's interest rate.
    @param sFirstName is a String representing the customer's first name
    @param sLastName is a String representing the customer's last name
    @param sSocSecNum is a String, formated: xxx-xx-xxxx where 'x' is 
    a digit between 0-9, representing the customer's social security number
    @param fAccBalance is a float respresenting the current account balance, 
    that is set to 0 on initiziation by the constructor */
    
    public SavingAccount(String sFirstName, String sLastName, 
            String sSocSecNum, float fDeposit){        
        // calls the super class constructor
        super(sFirstName, sLastName, sSocSecNum, fDeposit);
        this.fINTEREST = .05f;
    }
    
    // Overides the BankAccount method and only adds 5% interest to the account
    @Override    
    public void applyInterest(){
        fAccBalance += fAccBalance * this.fINTEREST;
    }
   
}
