import java.util.Scanner;

public class CSCDAsgn8
{
public static void main(String [] args)
{
Scanner kb = new Scanner(System.in);
System.out.println("Welcome to Intger Fun!");
int choice;
int num = 0;
int i = 0;

   do
   {
   System.out.println("1. Enter a new number:");
   System.out.println("2. Print the number of odd, even and zeros in the integer.");
   System.out.println("3. Print the prime numbers between 2 and the integer.");
   System.out.println("4. Quit the program.");
   System.out.print("Select a menu option:");
   choice = kb.nextInt();
   
      while (choice < 1 || choice > 4)
      {
      System.out.print("Invalid menu choice, please try again");
      choice = kb.nextInt();
      }
      
   if (choice == 1)
   {
   System.out.print("Enter a positive integer:");
   num = kb.nextInt();
   i = num;
   
      while (num <= 0)
      {
      System.out.print("Invalid entry, enter a positive integer!");
      num = kb.nextInt();
      }
   }
   else
   {
   }
   
   if (choice == 2)
   {
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
     }
   
   if (choice == 3)
   {
   System.out.println("The prime numbers between 2 and " + num + "are: ");
      for (int x = 3; x < num; x++)
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
      
       
   }
   }
   while (choice != 4);
   System.out.println("BYE!!");
}//end program
}