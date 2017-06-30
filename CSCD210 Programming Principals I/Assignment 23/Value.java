public enum Value
{
   ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

   private int value;

   private Value(final int value)
   {
      this.value = value;
   }//end method
   
   @Override
   public String toString()
   {
      switch(this)
      {
         case ACE: return "Ace";
         case TWO: return "Two";
         case THREE: return "Three";
         case FOUR: return "Four";
         case FIVE: return "Five";
         case SIX: return "Six";
         case SEVEN: return "Seven";
         case EIGHT: return "Eight";
         case NINE: return "Nine";
         case TEN: return "Ten";
         case JACK: return "Jack";
         case QUEEN: return "Queen";
         default: return "King";
      }
      
   }//end method
   
}//end type
               