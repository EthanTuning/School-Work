import java.util.Scanner;

public class CSCD210Asgn7
{
public static void main(String [] args)
{
String ans = " ";

do
{
Scanner kb = new Scanner(System.in);
System.out.print("Welcome to my PI appoximation program!");
System.out.print("Enter the term number to which you like to approxiate Pi?:");
int term = kb.nextInt();

while(term <= 9)//make sure larger than 9
{
System.out.println("Must enter a number greater than 9.");
System.out.print("Enter the term number to which you like to approxiate Pi?:");
term = kb.nextInt();
}

int x = 3;
double y = 4.0;
double sum = 4;
int sign = 1;
int ctr = 0;

   while(term >= 0)//do math
   {
   sum -= (sign *(y/x));
   x += 2;
   sign *= -1;
   term -= 1;
      
      if (term <= 10)//format output
      {
      System.out.println("Term " + ctr + ":" + (sum));
      }
      ctr++;
   }
kb.nextLine();


System.out.print("Want to play again?:");
ans = kb.nextLine();

   while(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"))
   {
   System.out.print("Want to play again?:");
   ans = kb.nextLine();
   }
}
while(!ans.equalsIgnoreCase("no"));




}//end program
}