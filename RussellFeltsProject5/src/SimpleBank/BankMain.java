/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBank;

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
        
        CheckingAccount acct1 = new CheckingAccount("Alin", "Parker", 
                "123-45-6789", 1000.0f);

        CheckingAccount acct2 = new CheckingAccount("Mary", "Jones", 
                "987-65-4321", 500.0f);

        SavingAccount acct3 = new SavingAccount("John", "Smith", 
                "1233-45-6789", 200.0f);

        acct1.deposit(22000.00f);

        acct2.deposit(12000.00f);

        acct1.withdraw(2000.00f);

        acct2.withdraw(1000.00f);

        acct1.applyInterest();

        acct2.applyInterest();

        acct1.checkBalance();

        acct2.checkBalance();

        acct1.withdraw(30000.00f);
        
        acct3.deposit(800.00f);
        
        acct3.applyInterest();
        
        acct3.checkBalance();
        
        acct3.withdraw(200f);
        
        acct3.checkBalance();
    } 
}
