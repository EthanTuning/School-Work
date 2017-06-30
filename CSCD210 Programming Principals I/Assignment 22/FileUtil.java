import java.io.*;
import java.util.*;


public class FileUtil
{
   public static File openInputFile(final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      String fn = null;
      File inf = null;
      
      do
      {
         System.out.print("Enter a file you would like to open: ");
         fn = kb.nextLine();
         inf = new File(fn);
      }while(!inf.exists());
         
      return inf;   
   }//end method
   
   public static int countRecords(final Scanner fin, final int num)
   {
      if (fin == null)
         throw new RuntimeException("Parameters Incorrect."); 
     
      int lines = 0;
      Integer Int;
      
      do
      {
         lines++;
      }while(lines < 5d);
      return lines;
      
   }//end method
   
   public static PrintStream openOutputFile(final Scanner kb)throws Exception
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      String fn = null;
      PrintStream fout = null;
      
      System.out.print("Enter the file: ");
      fn = kb.nextLine();
      
         while (fn == null || fn.isEmpty())
         {
            System.out.print("Enter the file: ");
            fn = kb.nextLine();
         }
      fout = new PrintStream(fn);
    
      return fout;
   }//end method

}//end class