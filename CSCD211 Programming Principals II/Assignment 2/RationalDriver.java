import java.util.*;

public class RationalDriver
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      int choice;
      
      ArrayList<Rational> ratArray = new ArrayList();
      ratArray.add(new Rational(2, 3));
      ratArray.add(new Rational(2, 18));
      ratArray.add(new Rational(3, 12));
      ratArray.add(new Rational(9, 3));
      ratArray.add(new Rational(2, 5));
      ratArray.add(new Rational(22, 7));
      
      do
      {
         System.out.println("1. Display the value of a Rational object.");
         System.out.println("2. Change the value of a Rational.");
         System.out.println("3. Add two Rational objects together and display the sum as a new Rational object.");
         System.out.println("4. Subtract two Rational objects together and display the difference as a new Rational object.");
         System.out.println("5. Sort the array of Rational number objects.");
         System.out.println("6. Determine if a particular Rational object is in the ArrayList.");
         System.out.println("7. Print the array of Rational number objects to the screen.");
         System.out.println("8. Quit the program.");
         System.out.println(" ");
         
         System.out.print("What would you like to do?: ");
         choice = kb.nextInt();
         
         System.out.print(" ");
         
         if (choice == 1)
         {
            System.out.print("Enter the index of the ArrayList you would like to see: ");
            int index = kb.nextInt();
            
            Rational theRat = ratArray.get(index);
            
            System.out.println(theRat);
         }
         
         if (choice == 2)
         {
            System.out.print("Enter the index you would like to replace: ");
            int theIndex = kb.nextInt();
            System.out.println("Enter the new numerator and denominator for the rational object.");
            System.out.print("Numerator: ");
            int num = kb.nextInt();
            System.out.print("Denominator: ");
            int den = kb.nextInt();
            
            Rational newRat = new Rational(num, den);
            
            ratArray.set(theIndex, newRat);
         }
         
         if (choice == 3)
         {
            System.out.println("Enter the two index's of the rationals you would like to add.");
            System.out.print("First index: ");
            int in1 = kb.nextInt();
            System.out.print("Second index: ");
            int in2 = kb.nextInt();
            
            Rational rat1 = ratArray.get(in1);
            Rational rat2 = ratArray.get(in2);
            
            Rational sum = Rational.add(rat1, rat2);
            
            System.out.println(sum);
         }
         
         if (choice == 4)
         {
         
            System.out.println("Enter the two index's of the rationals you would like to subtract.");
            System.out.print("First index: ");
            int in1 = kb.nextInt();
            System.out.print("Second index: ");
            int in2 = kb.nextInt();
            
            Rational rat1 = ratArray.get(in1);
            Rational rat2 = ratArray.get(in2);
            
            Rational dif = Rational.subtract(rat1, rat2);
            
            System.out.println(dif);
         }
         
         if (choice == 5)
         {
            Collections.sort(ratArray);
            System.out.println(ratArray);
            
         }
         
         if (choice == 6)
         {
           System.out.println("Enter a rational to see if it is in the array.");
           System.out.print("Enter the numerator: ");
           int num = kb.nextInt();
           System.out.print("Enter the denominator: ");
           int den = kb.nextInt();
           
           Rational rat = new Rational(num, den);
           
           if (ratArray.contains(rat))
           {
              System.out.println("The rational is in the arrayList.");
           }
           else
           {
              System.out.println("The rational is not in the arrayList.");
           }
            
         }
         
         if (choice == 7)
         {
            System.out.println(ratArray);
         }
               
      }while(choice != 8);   
   }   
}//end program