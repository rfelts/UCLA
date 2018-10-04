/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBank;
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

public class BankAccount {
    protected float fAccBalance;
    private final Customer CUST;
    private boolean newAccount = false;
    private final float fINTEREST;
    private long lAccountNum;
    
    // formating for floats to always have two decimal places
    DecimalFormat df = new DecimalFormat("0.00");
    
    /* BankAccount constructor creates a new customer object, sets the defaul 
    interest rate, and enters the initial deposit.
    @param sFirstName is a String representing the customer's first name
    @param sLastName is a String representing the customer's last name
    @param sSocSecNum is a String, formated: xxx-xx-xxxx where 'x' is 
    a digit between 0-9, representing the customer's social security number */
    
    public BankAccount(String sFirstName, String sLastName, String sSocSecNum,
            float fDeposit){
        this.fAccBalance = 0f;
        this.fINTEREST = .1f;
        this.newAccount = true;
        this.CUST = new Customer(sFirstName, sLastName, sSocSecNum);
        this.deposit(fDeposit);
    }
        
    /* For new accounts create an account and a randomw 10 digit account number. 
    Instantiate the account balance with the deposit. For existing accounts it 
    adds the deposit value to the current balance value. Finally prints out the 
    results.
    @param fDeposit is a float respresenting the total ammount to be added to 
    account balance */
    
    public void deposit(float fDeposit){
        fAccBalance += fDeposit;
        if(newAccount){
            /* Generate a random 10 digit number. This number is not guaranteed 
            to be unique */
            lAccountNum = 1000000000L + (long)(Math.random() * 
                    (9000000000L - 1000000000L));
            // Set the defaul account creation string.
            String sInitMessage = "Successfully created account for " + CUST;
            // Verify the social security number
            if(!CUST.verifySSN()){
                System.out.println(sInitMessage + ". Invalid SSN!"); 
                System.out.println(sInitMessage + " Account Number " +
                        lAccountNum + ".");
            }
            else{
                System.out.println(sInitMessage + " Account Number " + 
                        lAccountNum + ".");
            }
            checkBalance();
            // reset the new account flag
            newAccount = false;
        }
        // for existing accounts just print out a deposit message
        else{
            System.out.println(CUST + " deposited $" + df.format(fDeposit) + 
                    ". Current balance $" + df.format(fAccBalance) + ".");            
        }
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
            System.out.println(CUST + " withdrew $" + df.format(fWithdrawal) + 
                    ". Current balance $" + df.format(fAccBalance) +".");
        }
    }
    
    // Adds 10% interest to the account
    public void applyInterest(){
        fAccBalance += fAccBalance * fINTEREST;
    }
    
    // Prints out the current account balance
    public void checkBalance(){
        System.out.println(CUST + ", Balance $" + df.format(fAccBalance) + ".");
    }
}
