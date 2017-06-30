import java.util.Scanner ;
public class Asgn16Methods
{
   public static int[][] create2D(final int rows, final int cols)
   {
      int [][] theArray = new int [rows][cols];
      return theArray;
   }//end method
   
   public static void init2D(int[][] theArray, final Scanner kb)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      for (int row = 0; row < theArray.length; row++)
      {
         for (int col = 0; col < theArray[row].length; col++)
         {
            System.out.print("Enter an integer: ");
            int num = kb.nextInt();
            theArray[row][col] = num;
         }
      }
   }//end method
   
   public static void print2D(int [][] theArray)
   {
      for (int row = 0; row < theArray.length; row++)
      {
         for (int col = 0; col < theArray[row].length; col++)
         {
            if (col == theArray[row].length - 1)
               System.out.println(theArray[row][col] + " ");
            
            else
               System.out.print(theArray[row][col] + " ");
         }
      }
   }//end method
   
   public static int[][] doubleRows(int[][] theArray)
   {
      int[][] tempArray = new int[2 * (theArray.length)][theArray[0].length];
      
         for (int row = 0; row < theArray.length; row++)
         {
            tempArray[row] = theArray[row];
         }
         return tempArray;
   }//end method
   
   public static void initDoubledRows(final Scanner kb, int[][] theArray)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      for (int row = 0; row < theArray.length; row++)
      {
         for (int col = 0; col < theArray[row].length; col++)
         {
            int num = theArray[row][col];
            
               if (num == 0)
               {
                  System.out.print("Enter an Integer: ");
                  theArray[row][col] = kb.nextInt();
               }
         }
      }
   }//end method
   
   public static void swapRows(int[][] theArray, final int firstRow, final int secondRow)
   {
      int [] tempArray = theArray[firstRow];
      theArray[firstRow] = theArray[secondRow];
      theArray[secondRow] = tempArray;
   }//end method
   
   public static int readRow(final Scanner kb, int[][] theArray)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      int row;
      
      do
      {
         System.out.print("Enter row: ");
         row = kb.nextInt();
      }while(row < 0 || row > theArray.length);
      
      return row;
      
   }//end method 
   
   public static int readRow(final Scanner kb, int firstRow, int [][] theArray)
   {
      if (kb == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      int row;
      do
      {
         System.out.print("Enter row to switch with " + firstRow + ":");
         row = kb.nextInt();
      }while (row < 0 || row > theArray.length - 1);
      return row;
   }//end method
   
   public static void printRow(int[][] theArray, final int row)
   {
      for (int col = 0; col < theArray[row].length; col++)
      {
         System.out.println(theArray[row][col]);
      }
   }//end method
}//end class