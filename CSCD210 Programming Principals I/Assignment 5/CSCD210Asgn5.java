import java.util.Scanner;

public class CSCD210Asgn5
{
public static void main(String [] args)
{
Scanner kb = new Scanner(System.in);

System.out.println("Enter three different integers below:");
int num1 = kb.nextInt();
int num2 = kb.nextInt();
int num3 = kb.nextInt();

kb.nextLine();

System.out.println("Enter three different doubles below:");
double db1 = kb.nextDouble();
double db2 = kb.nextDouble();
double db3 = kb.nextDouble();

kb.nextLine();

System.out.println("Enter three different Strings:");
String str1 = kb.nextLine();
String str2 = kb.nextLine();
String str3 = kb.nextLine();


System.out.println("Integers in asceding order are:");

if(num1 < num2 && num1 < num3)
{
   System.out.println(num1);
   if(num2 < num3)
      {
      System.out.println(num2);
      System.out.println(num3);
      }
   else
      {
      System.out.println(num3);
      System.out.println(num2);
      }
}
else if(num2 < num1 && num2 < num3)
{
   System.out.println(num2);
   if(num1 < num3)
      {
      System.out.println(num1);
      System.out.println(num3);
      }
   else
      {
      System.out.println(num3);
      System.out.println(num1);
      }
}
else
{
   System.out.println(num3);
   if(num1 < num2)
      {
      System.out.println(num1);
      System.out.println(num2);
      }
   else
      {
      System.out.println(num2);
      System.out.println(num1);
      }
}

System.out.println("The doubles in ascending order are:");
if(db1 < db2 && db1 < db3)
{
   System.out.println(db1);
   if(db2 < db3)
      {
      System.out.println(db2);
      System.out.println(db3);
      }
   else
      {
      System.out.println(db3);
      System.out.println(db2);
      }
}
else if(db2 < db1 && db2 < db3)
{
   System.out.println(db2);
   if(db1 < db3)
      {
      System.out.println(db1);
      System.out.println(db3);
      }
   else
      {
      System.out.println(db3);
      System.out.println(db1);
      }
}
else
{
   System.out.println(db3);
   if(db1 < db2)
      {
      System.out.println(db1);
      System.out.println(db2);
      }
   else
      {
      System.out.println(db2);
      System.out.println(db1);
      }
}

System.out.println("The strings in ascending order are:");

}//end program
}