import java.util.Scanner;

public class CSCDAsgn6
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("Hello! Welcome to the Tuition Calculator Program.");
      System.out.print("How many total credits are you taking?:");
      int credits = kb.nextInt();
      kb.nextLine();
      System.out.print("Are you a WA resident? (Y/N):");
      String res = kb.nextLine();
      System.out.print("Are you a graduate student? (Yes/No):");
      String grad = kb.nextLine();
      System.out.print("What percentage increase?:");
      double per = kb.nextDouble();
   
      String n1 = "Y";
      String n2 = "N";
      String n3 = "Yes";
      String n4 = "No";
      double tution;
      double raise;
      double new_tution;
   
      if (res.equals(n1))
      {
         if (grad.equals(n4))
         {
         
            if (credits < 10)
            {
               tution = (credits*245.73);
            }
            if (credits >= 10 && credits <= 18)
            {
               tution = 2457.34;
            }
            else
            {
               tution = ((credits*245.73) + (224.83));
            }
            raise = ((per/100)*(tution));
            new_tution = (tution + raise);
            System.out.println("An undergraduate resident taking " + credits + " credits curently pays $" + tution);
            System.out.println("With an increase of " + per + "% per credit tuition goes up " + raise + ", and an undergraduate resident taking " + credits + " credits will pay $" + new_tution);  
         }
         if (grad.equals(n3))
         {
            if (credits < 10)
            {
               tution = (credits*363.98);
            }
            if (credits >= 10 && credits <= 18)
            {
               tution = 3639.82;
            }
            else
            {
               tution = ((credits*363.98) + (344.18));
            }   
            raise = ((per/100)*(tution));
            new_tution = (tution + raise);
            System.out.println("An graduate resident taking " + credits + " credits curently pays $" + tution);
            System.out.println("With an increase of " + per + "% per credit tuition goes up " + raise + ", and an graduate resident taking " + credits + " credits will pay $" + new_tution);
         }
      
      }
      if (res.equals(n2))
      {
         if (grad.equals(n4))
         {
         
            if (credits < 10)
            {
               tution = (credits*682.19);
            }
            if (credits >= 10 && credits <= 18)
            {
               tution = 6821.87;
            }
            else
            {
               tution = ((credits*682.19) + (661.69));
            }
            raise = ((per/100)*(tution));
            new_tution = (tution + raise);
            System.out.println("An undergraduate non-resident taking " + credits + " credits curently pays $" + tution);
            System.out.println("With an increase of " + per + "% per credit tuition goes up " + raise + ", and an undergraduate non-resident taking " + credits + " credits will pay $" + new_tution);  
         }
         if (grad.equals(n3))
         {
            if (credits < 10)
            {
               tution = (credits*846.15);
            }
            if (credits >= 10 && credits <= 18)
            {
               tution = 8461.53;
            }
            else
            {
               tution = ((credits*846.15) + (826.55));
            }   
            raise = ((per/100)*(tution));
            new_tution = (tution + raise);
            System.out.println("An graduate non-resident taking " + credits + " credits curently pays $" + tution);
            System.out.println("With an increase of " + per + "% per credit tuition goes up " + raise + ", and an graduate non-resident taking " + credits + " credits will pay $" + new_tution);
         }
      
      }
   
   
   
   }//end
}