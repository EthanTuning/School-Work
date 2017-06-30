import java.util.Scanner;
import java.io.*;


public class ArrayUtils
{
   public static Book [] createAndFillArray(final int total, final Scanner fin)
   {
      if (fin == null)
         throw new RuntimeException("Parameters Incorrect.");
      /*   
      Author [] theArray = new Author[num];
      
      for (int x = 0; x < theArray.length; x++)
      {
         theArray[x] = (kb.nextLine());
      }
      kb.close();
      */
      return null;
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
         
   }//end method
    
 


}//end class