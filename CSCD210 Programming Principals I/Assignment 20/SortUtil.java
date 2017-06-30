import java.util.Scanner;

public class SortUtil
{
   public static  Author [] selectionSort(final Author [] array)
   {
      if (array == null || array.length < 1)
         throw new RuntimeException("Parameters Incorrect.");
         
      int start, searcher, min;
      int temp;
      
      for (start = 0; start < array.length - 1; start++)
      {
         min = start;
         
         for (searcher = start + 1; searcher < array.length; searcher++)
         {
            if (array[searcher] < array[min])
               min = searcher;
         }
         
         temp = array[min];
         array[min] = array[start];
         array[start] = temp;
      }
      
      return array;
      
   }
}//end class