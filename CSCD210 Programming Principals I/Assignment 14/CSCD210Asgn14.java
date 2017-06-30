import java.util.Scanner;
import java.io.*;

public class CSCD210Asgn14
{
   public static void main(String [] args)throws Exception
   {
      File inf = null;
      Integer target = null;
      int num, choice, result;
      Integer [] myArray = null;
      double mean, median, midpoint, stdDev, mode;
      Scanner kb = new Scanner(System.in), fin = null;
            
      
      // Open the File and read it
      inf = FileUtil.openInputFile(args);
      fin = new Scanner(inf);

      num = FileUtil.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);      
      myArray = ArrayUtils.createAndFillArray(num, fin);
      fin.close();
                  
                  
      // Array is built do stuff            
      do
      {
         choice = MyUtils.menu(kb);
         
         switch(choice)
         {
            case 1:  myArray = ArrayUtils.add(myArray, kb);
                     break;
                     
            case 2:  myArray = ArrayUtils.delete(myArray, kb);
                     break;
                     
            case 3:  myArray = ArrayUtils.deleteByIndex(myArray, kb);
                     break;
                     
            case 4:  target =  Asgn14Methods.readValue(kb); 
                     result = SearchUtil.linearSearch(myArray, target);
                     Asgn14Methods.printResults(result);
                     break;
            
            case 5:  target =  Asgn14Methods.readValue(kb);  
                     result = SearchUtil.binarySearch(myArray, target);
                     Asgn14Methods.printResults(result);
                     break;    
                     
            case 6:  ArrayUtils.printArray(myArray);
                     break;
                     
            case 7:  mean = Asgn14Methods.computeMean(myArray);
                     Asgn14Methods.printResults("Mean", mean);
                     break;
                       
            case 8:  median = Asgn14Methods.computeMedian(myArray);
                     Asgn14Methods.printResults("median", median);
                     break;

            case 9:  midpoint = Asgn14Methods.computeMidpoint(myArray);
                     Asgn14Methods.printResults("Midpoint", midpoint);
                     break;

            case 10: stdDev = Asgn14Methods.computeStdDev(myArray);
                     Asgn14Methods.printResults("Standard Deviation", stdDev);
                     break;     
            
         }// end switch
      
      }while(choice != 11);
      
      System.out.println("Good Bye");   
   
   }// end main
  
}// end class