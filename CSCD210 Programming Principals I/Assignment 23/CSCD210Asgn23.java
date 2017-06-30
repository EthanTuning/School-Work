public class CSCD210Asgn23
{
   public static final int SIZE = 52;
      
   public static void main(String [] args)
   {
      int hand1Score, hand2Score, count = 0;   
      
      Card [] hand1 = new Card[2];
      Card [] hand2 = new Card[2];
      Card [] deck = new Card[SIZE];
          
      
      CSCD210Asgn23Methods.fillDeck(deck);
      CSCD210Asgn23Methods.shuffle(deck);
      
      for(int x = 0; x < hand1.length; x++)
      {
         hand1[x] = CSCD210Asgn23Methods.dealCards(deck, count);   
         hand2[x] = CSCD210Asgn23Methods.dealCards(deck, count + 1);
         count += 2;   
         
      }// end for
      
      hand1Score = CSCD210Asgn23Methods.calcHandScore(hand1);
      hand2Score = CSCD210Asgn23Methods.calcHandScore(hand2);
      
      CSCD210Asgn23Methods.displayWinningHand(hand1Score, hand2Score);      
   
   }// end main
   
}// end class