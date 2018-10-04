/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentGradePackage;

/**
 * Write a java program with the class name "StudentGrade" that generates a 
 * random number between 50 and 100 for a student grade and determines the 
 * letter grade of the student.
 * 
 * The student grade is determined based on the following criteria:
 * 90-100 = A
 * 80-89 = B
 * 70-79 = C
 * 60-69 = D
 * Less than 60 = F
 * 
 * @author rfelts
 */

public class StudentGrade {
    public static void main(String[] args) 
    {
        for(int iLoop = 0; iLoop < 5; iLoop++)
        {
            int grade = (int)(Math.random() * 50) + 50;
            if(grade >= 90)
            {
                System.out.println("Student grade is " + grade + " which is A");
            }
            else if(grade >= 80)
            {
                System.out.println("Student grade is " + grade + " which is B");
            }
            else if(grade >= 70)
            {
                System.out.println("Student grade is " + grade + " which is C");
            }
            else if(grade >= 60)
            {
                System.out.println("Student grade is " + grade + " which is D");
            }
            else
            {
                System.out.println("Student grade is " + grade + " which is F");
            }
        }
    }
    
}
