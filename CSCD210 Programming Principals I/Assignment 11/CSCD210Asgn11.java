import java.util.Scanner;

public class CSCD210Asgn11
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      String name = null;
      double height, weight;
      
      do
      {
         name = MyUtils.readName(kb);
         height = Asgn11Methods.readInfo(kb, "height");
         weight = Asgn11Methods.readInfo("weight", kb);
         Asgn11Methods.displayResults(name, height, weight, Asgn11Methods.calcBMI(height, weight));
         
      }while(MyUtils.goAgain(kb)); 
   
   }// end main

}// end class