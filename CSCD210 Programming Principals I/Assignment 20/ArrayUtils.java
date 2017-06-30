import java.util.Scanner;
import java.io.*;


public class ArrayUtils
{
   public static Author[] fillArray(final Stirng firstName, final String lastName, final String publisher, final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      Author [] theArray = new Author[num];
      
      for (int x = 0; x < theArray.length; x++)
      {
         theArray[x] = (kb.nextLine());
      }
      kb.close();
      
      return theArray;
   }//end method
   
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
   
     public static void printArray(final Author [] theArray)
   {
      if (theArray == null || theArray.length < 1)
         throw new RuntimeException("Parameters Incorrect.");
         
      for (int x = 1; x < theArray.length; x++)
      {
         System.out.println(theArray[x]);
      }
   }//end method
    
 


}//end class