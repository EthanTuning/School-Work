import java.util.Scanner;

public class Asgn10Methods
{
Scanner kb = new Scanner(System.in);

int choice;

   public static int menu(final Scanner kb)
   {
   int choice;
   
   System.out.println("1. Enter a new number:");
   System.out.println("2. Print the number of odd, even and zeros in the integer.");
   System.out.println("3. Print if number is light or heavy.");
   System.out.println("4. Print all prime numbers from 2 to your number.");
   System.out.println("5. Exit.");
   System.out.print("Select a menu option:");
   choice = kb.nextInt();
   
      while (choice < 1 || choice > 5)
      {
      System.out.print("Invalid menu choice, please try again: ");
      choice = kb.nextInt();
      }
   return choice;
   }//end method
   
   
   
   public static int readPosNum(final Scanner kb)
   {
   int theNum;
   
   System.out.print("Enter a positive integer:");
   theNum = kb.nextInt();
   
      while (theNum <= 0)
      {
      System.out.print("Invalid entry, enter a positive integer!");
      theNum = kb.nextInt();
      }
   
   return theNum;
   }//end method
   
   
   
   public static void oddEvenZero(final int theNum)
   {
   int i = theNum;
   
   
   int o = 0;
   int e = 0;
   int z = 0;
   
      while (i > 0)
      {
         if (i % 10 == 0)
         z++;
         else if (i % 2 == 0)
         e++;
         else
         o++;
         
         i = ((int)(i / 10));
         
      }
      
      System.out.println("odds: " + o);
      System.out.println("evens: " + e);
      System.out.println("zeros: " + z);
     

   }//end method
   
   
   public static void lightOrHeavy(final int theNum, final Scanner kb)
   {
   int a = theNum;
   int num2;
   double db = 0.0;
   
   System.out.print("Enter another integer: ");
   num2 = kb.nextInt();
   
   while (a > 0)
   {
   db += a % 10;
   a = a / 10;
   }
   
   if (a > num2)
   {
   System.out.println("Heavy.");
   }
   else
   {
   System.out.println("Light");
   }
   }//end method
   
   
   
   public static void printPrimes(final int theNum)
   {
   
   
   System.out.println("The prime numbers between 2 and " + theNum + "are: ");
      for (int x = 3; x < theNum; x++)
      {
      int a = 0;
      int b = 0;
      
         for(int y = 2; y < x; y++)
         {
            if(x % y == 0 && a != x)
            {
            b = 1;
            a = x;
            }
         }
         if (b == 0)
         System.out.println(x);
      }   
   

   }//end method

}//end class
