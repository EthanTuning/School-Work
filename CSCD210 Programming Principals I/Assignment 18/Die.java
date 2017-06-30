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
   
   public boolean equals(Object obj)
   {
      if (obj == this) return true;
      if (obj == null) return false;
      if (!(obj instanceof Die)) return false;
      
      else
      {
         Die pi = (Die) obj;
         return this.sides == pi.sides;
      }
   }// end method
   
   public void setSides (final int num)
   {
      this.sides = num;
   }//end method
   
       
}//end class