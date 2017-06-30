import java.io.*;
import java.util.Scanner;


public class FileUtil
{
   public static File openInputFile(final String [] args)
   {
      if (args.length < 1 || args [0] == null || args[0].isEmpty())
         throw new RuntimeException("Parameters Incorrect.");
   
     return null;

   }//end method
   
   public static int countRecords(final Scanner kb, final int num)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
   return 1;
   }//end method

}//end class