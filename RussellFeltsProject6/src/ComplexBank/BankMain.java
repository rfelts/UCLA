/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexBank;

/**
 * BankMain class.
 * 
 * Is used to execute the program. It instantiates CheckingAccount and 
 * SavingAccount objects. Then calls their methods to make deposits, 
 * withdrawals, and check account balances
 * 
 * @author rfelts
 */

public class BankMain {
     
    public static void main (String[] args){
        
        BankDatabase acctDatabase = new BankDatabase();
        
        acctDatabase.createCheckingAccount("Alin Parker", "123-45-6789", 
                20000.0f);
        
        acctDatabase.createSavingAccount("Mary Jones", "987-65-4321", 15000.0f);
        
        acctDatabase.createSavingAccount("John Smith", "123-45-6789", 12000.0f);
        
        acctDatabase.print();
        
        acctDatabase.applyInterest();
        
        acctDatabase.print();
        
        /* Deposit 500 into the account associated with the first object in the 
        array list */
        acctDatabase.aBankAccount.get(0).deposit(500f);

        /* Withdraw 500 from the account associated with the second object in 
        the array list */
        acctDatabase.aBankAccount.get(1).withdraw(500f);
        
        acctDatabase.print();
    } 
}