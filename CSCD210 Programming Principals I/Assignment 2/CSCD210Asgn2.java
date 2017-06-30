import java.util.Scanner;

public class CSCD210Asgn2
{
public static void main(String [] args)
{

Scanner kb = new Scanner(System.in);
System.out.print("Please Enter a Value:");
double num = kb.nextDouble();
double angle = 30;
System.out.println("Your base is:"  + num);
System.out.println("Your side is:"  + 2*num);
System.out.println("Your height is:"  + num*Math.sqrt(3));
System.out.println("Your area is:" + ((num*(.5))*num*Math.sqrt(3)));
System.out.println("The sin of 30 degrees is:"  + Math.sin(Math.toRadians(angle)));
System.out.println("The cosine of 30 degrees is:"  + Math.cos(Math.toRadians(angle)));
System.out.println("The tangent of 30 degrees is:"  + Math.tan(Math.toRadians(angle)));   
}//end main
}//end class