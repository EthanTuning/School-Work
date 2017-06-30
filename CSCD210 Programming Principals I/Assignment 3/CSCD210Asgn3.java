import java.util.Scanner;

public class CSCD210Asgn3
{
public static void main(String [] args)
{
Scanner kb = new Scanner(System.in);
System.out.print("Enter your name:");  //get info form user
String name = kb.nextLine(); 

System.out.print("Enter the total restaurant bill:");
double bill = kb.nextDouble();

System.out.print("Enter the current tax rate:");
double tax = kb.nextDouble();

System.out.print("Enter the number of people in your party:");
int ppl = kb.nextInt();

System.out.print("Enter the tip percentage:");
double tp = kb.nextDouble();

System.out.print("Enter the total times you will eat out this year:");
int teo = kb.nextInt();

double a = (bill*tax);
double b = (tp/100);
double c = (b*bill);
double total = ((bill + a) + c);
double each = (total/ppl);
double yc = (total * teo);
double mc = (yc/12);
double wc = (yc/52.1775);
double yt = ((c)*teo);

System.out.println("Welcome " + name);
System.out.println("Your bill without tax or tip is: " + bill);
System.out.println("Your bill with tax and tip is: " + total);
System.out.println("Since you have " + ppl + " in yout party, each person will pay: " + each);
System.out.println("Your total amount spent on eating out this year will be about: " + yc);
System.out.println("Your total amount spent on eating out this month will be about: " + mc);
System.out.println("Your total amount spent on eating out this week will be about: " + wc);
System.out.println("Your total amount spent on tips this year will be about: " + yt); 




}
}