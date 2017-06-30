public class SearchUtil
{
   public static int linearSearch(final Book [] myBooks, final Book toFind)
   {
      if (myBooks == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      for(int x = 0; x < myBooks.length; x++)
      {
         if (myBooks [x] == toFind)
         return x;
      }
      
      return -1;
   }//end method
}//end class