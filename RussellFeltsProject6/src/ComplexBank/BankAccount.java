/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexBank;
import java.text.DecimalFormat;
/**
 * BankAccount class. 
 * 
 * A BankAccount has a customer, account number, and a balance. A bank account 
 * can be opened with any amount of initial deposit. For each bank account, a 
 * 10 digit random account number must be created. Bank account shall define 
 * the following methods: deposit, withdraw. applyInterest, and checkBalance.
 * 
 * Every time there is a deposit or withdrawal, the amount and current balance 
 * should be displayed. One cannot withdraw more than the funds available in 
 * the account.
 * 
 * @author rfelts
 */

public abstract class BankAccount implements Comparable <BankAccount>{
    protected float fAccBalance;
    protected final Customer CUST;
    protected final long lAccountNum;
    
    // formating for floats to always have two decimal places
    DecimalFormat df = new DecimalFormat("0.00");
    
    /* BankAccount constructor creates a new customer object, creates a 
    nonunique 10 digit account number (is not guaranteed  to be unique), and 
    enters the initial deposit.
    @param sFirstName is a String representing the customer's first name
    @param sLastName is a String representing the customer's last name
    @param sSocSecNum is a String, formated: xxx-xx-xxxx where 'x' is 
    a digit between 0-9, representing the customer's social security number */
    
    public BankAccount(String sFirstName, String sLastName, String sSocSecNum,
            float fDeposit){
        this.CUST = new Customer(sFirstName, sLastName, sSocSecNum);
        lAccountNum = (long)(Math.random() * 9e9 + 1e9);
        this.fAccBalance = fDeposit;
        System.out.println("Successfully created account for " + CUST + 
                " Account Number " + lAccountNum + ".");
        checkBalance();
    }
        
    /* Adds the deposit value to the current balance value. Finally prints out 
    the results.
    @param fDeposit is a float respresenting the total ammount to be added to 
    account balance */
    
    public void deposit(float fDeposit){
        fAccBalance += fDeposit;
        System.out.println(CUST + " deposited $" + df.format(fDeposit) + ".");
        checkBalance();            
    }
    
    /* Subtracts the withdrawal value from the current account balance value 
    and prints out the account's balance total. Do not allow the customer to 
    withdraw more than the funds available in the account.
    @param fWithdrawal is a float respresenting the ammount to be subtracted 
    from the account balance */
    
    public void withdraw(float fWithdrawal){
        if(fAccBalance < fWithdrawal){
            System.out.println("Unable to withdraw $" + df.format(fWithdrawal) 
                    + " for " + CUST + " due to insufficient funds.");
        }
        else{
            fAccBalance -= fWithdrawal;
            System.out.println(CUST + " withdrew $" + df.format(fWithdrawal) 
                    + ".");
            checkBalance();
        }
    }
    
    // Prints out the current account balance
    
    public void checkBalance(){
        System.out.println(CUST + ", Balance $" + df.format(fAccBalance) + ".");
    }

    /* Overrides the compareTo method of the Comparable interface to provide 
    the means to sort the bank accounts using Collections.sort */
    
    @Override
    public int compareTo(BankAccount oBankAcc){
        if(fAccBalance < oBankAcc.fAccBalance){
            return -1;
        }
        else if(fAccBalance > oBankAcc.fAccBalance){
            return 1;
        }
        else
            return 0;
    }
    
    // Abstract method(s) that need to be implemented in subclasses
    abstract void applyInterest();

}
