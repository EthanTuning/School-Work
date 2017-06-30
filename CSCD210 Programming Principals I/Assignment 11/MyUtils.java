import java.util.Scanner;

public class MyUtils
{
public static String readName(final Scanner kb)
{
String name = null;

System.out.print("Enter your name: ");
name = kb.nextLine();

return name;
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

}//end class