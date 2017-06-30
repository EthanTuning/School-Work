import java.util.Scanner;

public class MyUtils
{
   public static int readNum(final Scanner kb, final String type)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      System.out.print("Enter number of " + type + ":");
      return kb.nextInt();

   }//end method
   
   
   public static boolean goAgain(final Scanner kb)
   {
   String playAgain;
   playAgain = kb.nextLine();
      
      while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no"))
      {
      System.out.print("Do you want to play again(yes/no): ");
      playAgain = kb.nextLine();
      }
      if (playAgain.equalsIgnoreCase("yes"))
         return true;
      
      if (playAgain.equalsIgnoreCase("no"))
         System.out.print("Good Bye!");
         return false;
         
   }//end method
   
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      int choice;
      
      do
      {
      System.out.println("1. Print Array.");
      System.out.println("2. Print Rows.");
      System.out.println("3. Double number of rows.");
      System.out.println("4. Swap rows.");
      System.out.println("5. Exit.");
      System.out.print("What would you like to do?: ");
      
      choice = kb.nextInt();
      }while (choice < 1 || choice > 5);
         
   return choice;
   }

}//end class