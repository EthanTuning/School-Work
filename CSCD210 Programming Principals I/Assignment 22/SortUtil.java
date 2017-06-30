import java.util.Scanner;
import java.io.*;

public class SortUtil
{
   public static  void selectionSort(Comparable [] myBooks)
   {
      if (myBooks == null)
         throw new RuntimeException("Parameters Incorrect.");
       
      int start, searcher, min;
      Comparable temp;
      
      for (start = 0; start < myBooks.length - 1; start++)
      {
         min = start;
         
         for (searcher = start + 1; searcher < myBooks.length; searcher++)
         {
            if (myBooks[searcher].compareTo(myBooks[min]) < 0)
               min = searcher;
         }
         
         temp = myBooks[min];
         myBooks[min] = myBooks[start];
         myBooks[start] = temp;
      }
     
   }//end method
}//end class