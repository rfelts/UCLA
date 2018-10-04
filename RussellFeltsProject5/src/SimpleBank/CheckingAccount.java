/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBank;

/**
 * CheckingAccount class.
 * 
 * Is derived from the BankAccount class. It overrides the applyInterest method
 * to accrue 2% for any amount in excess of $10000
 * 
 * For example, if there is $11000 in the checking account, the interest is 
 * only applied to $1000
 * 
 * @author rfelts
 */
public class CheckingAccount extends BankAccount{
    
    private final float fINTEREST;
    
    /* CheckingAccount constructor calls the BankAccount constructor and sets 
    the CheckingAccount's interest rate.
    @param sFirstName is a String representing the customer's first name
    @param sLastName is a String representing the customer's last name
    @param sSocSecNum is a String, formated: xxx-xx-xxxx where 'x' is 
    a digit between 0-9, representing the customer's social security number
    @param fAccBalance is a float respresenting the current account balance, 
    that is set to 0 on initiziation by the constructor */
    
    public CheckingAccount(String sFirstName, String sLastName, 
            String sSocSecNum, float fDeposit){
        // calls the super class constructor
        super(sFirstName, sLastName, sSocSecNum, fDeposit);
        this.fINTEREST = .02f;
    }
    
    /* Overides the BankAccount method and only adds 2% interest to the account 
    for any amount in excess of $10000.  For example, if there is $11000 in the 
    checking account, the interest is only applied to $1000 */

    @Override    
    public void applyInterest(){
        float fX1K = fAccBalance - 10000f;
        fAccBalance += fX1K * this.fINTEREST;
    }
}