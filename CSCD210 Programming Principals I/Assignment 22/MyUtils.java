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
      System.out.println("1) Print all books to the screen."); 
      System.out.println("2) Print all books to a file that the user provides the name."); 
      System.out.println("3) Sort the array using the compareTo method in Book and print to the screen."); 
      System.out.println("4) Sort the array using the Comparator for ISBNSort and print to the screen .");
      System.out.println("5) Sort the array using TitleSort and print to the file that user provides the name.");
      System.out.print("What would you like to do?: ");
      
      choice = kb.nextInt();
      }while (choice < 1 || choice > 6);
         
   return choice;
   }

}//end class