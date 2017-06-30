import java.util.*;
import java.io.*;


public class ArrayUtils
{
   public static Book [] createAndFillArray(final int total, final Scanner fin)throws Exception
   {
      if (fin == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      String t, i;
      int p;
        
      Book [] array = new Book[total];
      
      while(fin.hasNext())
      {
         t = fin.nextLine();
         i = fin.nextLine();
         p = fin.nextInt();
      }
      fin.close();
      
      return array;
   }//end method
   /*
   public static Author[] add(final Author [] theArray, final Scanner kb)
   {
      if (theArray == null || theArray.length < 1)
         throw new RuntimeException("Parameters Incorrect.");
         
      System.out.print("Enter first name, last name, publisher: ");
      Stirng firstName = kb.nextLine();
      String lastName = kb.nextLine();
      String publisher = kb.nextLine();
      
      Author [] tempArray = new Author[theArray.length + 1];
      
      for (int x = 0; x < theArray.length; x++)
      {
         tempArray[x] = theArray[x];
      }
      
      tempArray[tempArray.length - 1] = num;
      tempArray = SortUtil.selectionSort(tempArray);
      
   return tempArray;
   }//end method
   */
   public static void printArray(final Book [] array, final PrintStream out)
   {
      if (array == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      for (Book bk: array)
         out.print(bk);
         
      out.println();
         
   }//end method
    
 


}//end class