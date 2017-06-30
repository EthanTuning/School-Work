import java.util.*;
import java.io.*;

public class CSCD210Asgn20
{
   public static void main(String [] args)throws FileNotFoundException
   {
      
      int choice;
      
      Author [] array = null;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtil.openInputFile(args);  // open the file passedin in args
      Scanner fin = new Scanner(inf);
      
      array = ArrayUtils.fillArray(fin);
      
      fin.close();
      
      SortUtil.selectionSort(array);
      
      do
      {
         choice = MyUtils.menu(kb);
         switch(choice)
         {
            case 1:	ArrayUtils.printArray(array, System.out);
   					   break;
                     
            case 2:  array = ArrayUtils.add(array, kb);
                     SortUtil.selectionSort(array);
                     break;

    			      			      
         }// end switch
      
      }while(choice != 3);
    
   }// end main
   
}// end class