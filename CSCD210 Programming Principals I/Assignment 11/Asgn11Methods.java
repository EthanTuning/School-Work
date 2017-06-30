import java.util.Scanner;

public class Asgn11Methods
{
public static double readInfo(final Scanner kb, final String type)
{
double h;

System.out.print("Enter your " + type + ": ");
h = kb.nextDouble();

   while (h < 10)
   {
   System.out.print("Enter a value greater than 10.: ");
   h = kb.nextDouble();
   } //end while
    
return h;
}//end method


public static double readInfo(final String type, final Scanner kb)
{
return Asgn11Methods.readInfo(kb, type); 
}//end method


public static double calcBMI(final double height, final double weight)
{
double bmi;
double hsqr = (height * height);

bmi = ((weight) / (hsqr)) * 703;

return bmi;
}//end method


public static String retrieveBMIStatus(final double bmi)
{
String bMi = null;

   if(bmi < 18.5)
   {
   bMi = "underweight";
   }
   
   if (bmi > 18.5 && bmi < 25)
   {
   bMi = "normal";
   }
   
   if (bmi >= 25 && bmi <30)
   {
   bMi = "overweight";
   }
   
   if (bmi >= 30)
   {
   bMi = "obese";
   }
   
return bMi;
}//end method


public static void displayResults(final String name, final double height, final double weight, final double bmi)
{
String bMi = retrieveBMIStatus(bmi);

System.out.println("Name: " + name);
System.out.println("Your height: " + height);
System.out.println("Your weught: " + weight);
System.out.println("Your BMI: " + bmi);
System.out.println("You are: " + bMi);

}//end method

}//end class