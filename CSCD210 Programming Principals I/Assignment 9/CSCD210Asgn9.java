import java.util.Scanner;
import java.lang.Math;

public class CSCD210Asgn9
{
public static void main(String [] args)
{
boolean cheat = true;
Scanner kb = new Scanner(System.in);
System.out.print("Welcome to Mastermind CSCD210 Edition.");
String goAgain;
int num;
String test = "";
boolean winner = true;

do
{
String k1 = "";
String k2 = "";
String k3 = "";
String k4 = "";
String key = "";
boolean check;
int ctr = 0;
num = ((int)(0+(Math.random()*9)));
k1 = k1 + num;
String guess = "";

   do
   {
   test = "";
   num =((int)(0+(Math.random()*9)));
   test = test + num;
   }while (test.equalsIgnoreCase(k1));
   
   k2 = k2 + num;
   
   do
   {
   test = "";
   num = ((int)(0+(Math.random()*9)));
   test += num;
   }while (test.equalsIgnoreCase(k1) || test.equalsIgnoreCase(k2));
   
   k3 = k3 + num;
      
   do
   {
   test = "";
   num = ((int)(0+(Math.random()*9)));
   test += num;
   }while (test.equalsIgnoreCase(k1) || test.equalsIgnoreCase(k2) || test.equalsIgnoreCase(k3));
   
   k4 = k4 + num;
   
   key = key+k1+k2+k3+k4;
   
   
   if (cheat)
      System.out.println(key);
      
do
{
int rn = 0;
int rp = 0;
winner = true;

   do
   {
   check = false;
   System.out.print("Enter your guess(must have 4 digits and no repeats): ");
   guess = kb.nextLine();
   
   if (guess.length() != 4)
      check = true;
   
   if (guess.length() == 4)
   {
      for (int x = 0; x < 4; x++)
      {
         for (int y = 0; y < 4; y++) 
         {
            if (x != y)
            {
               if (guess.charAt(x) == guess.charAt(y))
               check = true;
            }
         }    
      }
   }
   
   
   }while (check);
   
   ctr ++;
   
   for (int x = 0; x < 4; x++)
   {
      for (int y = 0; y < 4; y++)
      {
         if ((guess.charAt(x) == key.charAt(y)) && (x == y))
            rp++;
         else if (guess.charAt(x) == key.charAt(y))
            rn ++;
      }     
   }
   if (rp == 4)
   {
   System.out.println("YOU ARE A WINNER!!");
   winner = false;
   }
   else
   {
   System.out.println("You got " + rp + " numbers in the right place.");
   System.out.println("You got " + rn + " numbers right but they are in the wrong place.");
   }
   if (ctr >= 12)
   {
   System.out.println("You have no more attempts re-maining! :( The key was " + key);
   winner = false;
   }
   
}while (winner);

System.out.print("Would you like to play again? (yes/no)");
goAgain = kb.nextLine();

   while (!goAgain.equalsIgnoreCase("yes") && !goAgain.equalsIgnoreCase("no"))
   {
   System.out.print("Must enter yes or no!");
   goAgain = kb.nextLine(); 
   }
   
}while (goAgain.equalsIgnoreCase("yes"));

}//end
}