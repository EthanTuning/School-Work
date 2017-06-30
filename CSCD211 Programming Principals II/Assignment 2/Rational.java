public class Rational implements Comparable<Rational>
{
   private int num;
   private int den;
   
   public Rational()
   {
      this.num = 1;
      this.den = 1;
   }//DVC
   
   public Rational (int num, int den)
   {
      this.num = num;
      this.den = den;
      
      simplify();
   }//EVC
   
   public int getNum()
   {
      return this.num;
   }//gets
   
   public int getDen()
   {
      return this.den;
   }//gets
   
   public void setNum()
   {
      this.num = num;
   }//sets
   
   public void setDen()
   {
      this.den = den;
   }//sets
   
   @Override
   public String toString()
   {
      String str = " ";
      str += this.num + "/" + this.den;
      return str;
   }//toString
   
   @Override
   public boolean equals(Object obj)
   {
      if(obj.getClass().getSimpleName().equals("Rational"))
      {
         Rational that = (Rational)obj;
         
         if(this.num == that.num && this.den == that.den)
         {
            return true;
         }
      }
      return false;   
   }//equals method
   
   public int compareTo(Rational that)
   {
      double num1 = ((double)this.num / this.den);
      double num2 = ((double)that.num / that.den);
      
      if(num1 - num2 < 0)
         return -1;
      
      if(num1 - num2 > 0)
         return 1;
      
      else
         return 0;

   
   } 
   
   private static int euclidGCD(int num1, int num2)
   {
   	int remainder;
   	
   	while(num2 > 0)
   	{ 
   		remainder = num1 % num2;
   		num1 = num2;
   		num2 = remainder;
   	}
   	return num1;
   }

   
   public static Rational add(Rational rat1, Rational rat2)
   {
      Rational rat3 = new Rational();
      int num1 = rat1.getNum();
      int den1 = rat1.getDen();
      int num2 = rat2.getNum();
      int den2 = rat2.getDen();
      
      int newNum = (num1 * den2) + (num2 * den1);
      int newDen = den1 * den2;
      
      rat3 = new Rational(newNum, newDen);
      
      return rat3;
   }
   
   public static Rational subtract(Rational rat1, Rational rat2)
   {
      Rational rat3 = new Rational();
      int num1 = rat1.getNum();
      int den1 = rat1.getDen();
      int num2 = rat2.getNum();
      int den2 = rat2.getDen();
      
      int newNum = (num1 * den2) - (num2 * den1);
      int newDen = den1 * den2;
      
      rat3 = new Rational(newNum, newDen);
      
      return rat3;
   }
   
   public void simplify()
   {
      
      int gcd = euclidGCD(this.num, this.den);
      this.num = this.num/gcd;
      this.den = this.den/gcd;
   }
   
}//end program