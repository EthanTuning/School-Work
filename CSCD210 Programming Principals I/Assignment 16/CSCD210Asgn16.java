import java.util.Scanner;

public class CSCD210Asgn16
{
   public static void main(String [] args)
   {
      int [][] twoD = null;
      Scanner kb = new Scanner(System.in);
      int rows, cols, choice, firstRow, secondRow;
      
      rows = MyUtils.readNum(kb, "rows");
      cols = MyUtils.readNum(kb, "columns"); 
      
      twoD = Asgn16Methods.create2D(rows, cols);
      Asgn16Methods.init2D(twoD, kb);
      
      do
      {
         choice = MyUtils.menu(kb);
         
         switch(choice)
         {
            case 1:  Asgn16Methods.print2D(twoD);
                     break;
                     
            case 2:  firstRow = Asgn16Methods.readRow(kb, twoD);
                     Asgn16Methods.printRow(twoD, firstRow);
                     break;
                     
            case 3:  twoD = Asgn16Methods.doubleRows(twoD);
                     Asgn16Methods.initDoubledRows(kb, twoD);
                     Asgn16Methods.print2D(twoD);
                     break;
            
            case 4:  firstRow = Asgn16Methods.readRow(kb, twoD);
                     secondRow = Asgn16Methods.readRow(kb, firstRow, twoD);
                     Asgn16Methods.swapRows(twoD, firstRow, secondRow);
                     Asgn16Methods.print2D(twoD);         
         
         }// end switch
     
      }while(choice != 5);
      
   }// end main

}// end class