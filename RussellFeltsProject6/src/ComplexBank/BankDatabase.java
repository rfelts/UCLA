/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexBank;
import java.util.*;


/**
 * BankDatabase class.
 * 
 * Contains the bank account information for all accounts. The customer name is 
 * passed in as “firstname lastname”. Then split into two separate strings: 
 * first name and last name. The accounts created are stored in an ArrayList.
 * 
 * @author rfelts
 */

public class BankDatabase {
    
    private String sCustName, sSSN;
    private float fDeposit;
    protected final ArrayList<BankAccount> aBankAccount;
    
    // BankDatabase constructor initializes an array list
    BankDatabase(){
        aBankAccount = new ArrayList<>();
    }
    
    /* Creates a checking account and adds it to the array list. 
    @param sCustName sting representing the full customer name.
    @param sSSN is a String, formated: xxx-xx-xxxx 
    @param fDeposit is a float respresenting the amount to add to the account */
    
    void createCheckingAccount(String sCustName, String sSSN, float fDeposit){
        // Splits the name string into two strings and stores them in an array
        String [] aName = splitString(sCustName);
        aBankAccount.add(new CheckingAccount(aName[0], aName[1], sSSN, 
                fDeposit));
    }
    
    /* Creates a saving account and adds it to the array list.
    @param sCustName sting representing the full customer name.
    @param sSSN is a String, formated: xxx-xx-xxxx 
    @param fDeposit is a float respresenting the amount to add to the account */

    void createSavingAccount(String sCustName, String sSSN, float fDeposit){
        // Splits the name string into two strings and stores them in an array
        String [] aName = splitString(sCustName);
        aBankAccount.add(new SavingAccount(aName[0], aName[1], sSSN, fDeposit));
        
    }
    
    /* This method prints the bank account information in the database in 
    ascending order of the account balances.*/
    
    void print(){
        // Needed to use Collections.sort because I used an ArrayList
        Collections.sort(aBankAccount);
        for(BankAccount tempObj : aBankAccount){
            System.out.println(tempObj.CUST + ", accn #: " + tempObj.lAccountNum 
                    + ", Balance $" + tempObj.fAccBalance);
        }
    }
    // Applies interest to all bank accounts.    
    
    void applyInterest(){
        for(BankAccount tempObj : aBankAccount){
            tempObj.applyInterest();
        }
    }
    
    // Method used to reduce redundant code for splitting the name string
    
    private String [] splitString(String sCustName){
        String[] aName = sCustName.split("\\s+");
        return aName;
    }
    
}
