/**
* Average.java - Compute average of three numbers
*and display result
*@author Ai Doanstudi
*/
import java.util.Scanner;

public class CSCD210Asgn4B
{
   public static void main(String [] args);
   {
      double a = 11.11;
      double b = 111.111;
      double c = 1111.1111;
      
      Scanner kb = new Scanner(System.in);
      System.out.println("Please Enter Your name");       
      String name = kb.nextLine();
      
      double result = (a + b + c) / 3;
      System.out.println("The average of " + a + "," + b + "and" + c + "is:"  + result);
      
      /* Section 2 */
      /* start here */
      String name1 = "I love Java";
      String name2 = "I love Java too";
      
      System.out.println(name);
      System.out.println(name1 + " " + name2);
      System.out.println(name2.substring(2, 52));
      System.out.println(name.toUpperCase());
      // end here
      
   }
      
}