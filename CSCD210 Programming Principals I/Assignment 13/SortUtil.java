import java.util.Scanner;

public class SortUtil
{
   public static  int [] selectionSort(final int [] theArray)
   {
      if (theArray == null || theArray.length < 1)
         throw new RuntimeException("Parameters Incorrect.");
         
      int start, searcher, min;
      int temp;
      
      for (start = 0; start < theArray.length - 1; start++)
      {
         min = start;
         
         for (searcher = start + 1; searcher < theArray.length; searcher++)
         {
            if (theArray[searcher] < theArray[min])
               min = searcher;
         }
         
         temp = theArray[min];
         theArray[min] = theArray[start];
         theArray[start] = temp;
      }
      
      return theArray;
      
   }
}//end class