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
public class CustomerMain {
    
    public static void main (String[] args){
        
        try{
            Customer customer1 = new Customer("Joe", "Blow", "567-3i-5678");
             System.out.println(customer1 + ": account was created");
       }
        catch(InvalidCustomerException e){
            System.out.println("Exception: " + e.getMessage());
        }
        try{
            Customer customer2 = new Customer("Sue", "Clue", "765-43-8765");
            System.out.println(customer2 + ": account was created");
        }
        catch(InvalidCustomerException e){
            System.out.println("Exception: " + e.getMessage());
        }
     }    
}
