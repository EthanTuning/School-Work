import java.lang.Math;

public class Die
{
private int sides;
   
   public Die()
   {
      this.sides = 6;
   }// end method
   
   public Die(final int sides)
   {
      this.sides = sides;
   }// end method
   
   /*public Die(final int sides)
   {
      this.sides = sides;
   
      if (sides < 2)
         System.out.print("Sides must be greater than 2.");
   }//end method*/
   
   public int getSides()
   {
      return this.sides;
   }//end method
   
   public String toString()
   {
      String str = " ";
      str += "Sides " + this.sides;
      return str;
   }//end method
   
   public int roll()
   {
      int sides = this.sides;
      int roll = 1 + (int)(Math.random()*sides);
      
      return roll;
   }//end method
}//end class