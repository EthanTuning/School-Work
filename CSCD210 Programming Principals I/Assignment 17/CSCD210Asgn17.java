public class CSCD210Asgn17
{
   public static void main(String [] args)
   {
      Die one = new Die();  // six sides  
      Die two = new Die(20); // 20 sides
      
      System.out.println("This die has " + one.getSides()+ " sides"); 
      System.out.println(two); // Die has 20 sides
      
      System.out.println("You rolled a " + two.roll());  // number between 1 and sides inclusive   
   }// end main
}// end class