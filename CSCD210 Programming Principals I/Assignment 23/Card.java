public class Card
{
   private Value value;
   private Suit suit;
   
   private Card()
   {
      this(Suit.SPADES, Value.ACE);
   }//end method
   
   public Card(final Suit suit, final Value value)
   {
      this.suit = suit;
      this.value = value;
   }//end method
   
   public String toString()
   {
      return this.value + " of " +this.suit;
   }//end method
   
}//end class