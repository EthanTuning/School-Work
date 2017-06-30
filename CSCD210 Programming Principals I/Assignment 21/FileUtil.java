import java.io.*;
import java.util.Scanner;


public class FileUtil
{
   public static File openInputFile(final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      return null;   
   }//end method
   
   public static int countRecords(final Scanner fin, final int num)
   {
      if (fin == null)
         throw new RuntimeException("Parameters Incorrect."); 
      
      return 1;
   }//end method
   
   public static PrintStream openOutputFile(final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      return null;
   }//end method

}//end class