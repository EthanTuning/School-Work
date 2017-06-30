import java.io.*;
import java.util.Scanner;


public class FileUtil
{
   public static File openInputFile(final String [] args)
   {
      
      Scanner kb = new Scanner(System.in);
     
      String fn = null;
      File inf = null;
      
      do
      {
      
      System.out.print("Enter a file you would like to open: ");
      fn = kb.nextLine();
      
      inf = new File(fn);
      
      }while (!inf.exists());
   
     return inf;

   }//end method
   
   public static int countRecords(final Scanner fin, final int num)
   {
      if (fin == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      int lines = 0;
      
      while (fin.readLine() != null) lines++;
      fin.close();   
         
   return fin;
   }//end method

}//end class