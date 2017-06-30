public enum Suit
{
   CLUBS, HEARTS, DIAMONDS, SPADES;

   @Override   
   public String toString()
   {
      switch(this)
      {
         case CLUBS: return "Clubs";
         case HEARTS: return "Hearts";
         case DIAMONDS: return "Diamonds";
         default: return "Spades";
      }
   }//end method

}//end type    