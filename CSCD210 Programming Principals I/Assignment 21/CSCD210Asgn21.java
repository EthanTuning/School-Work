import java.io.*;
import java.util.*;

public class CSCD210Asgn21
{
   public static void main(String [] args)throws Exception
   {
      File inf = null;
      int choice, total;
      Book [] myBooks = null;
      PrintStream fout = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      
      inf = FileUtil.openInputFile(kb); /* prompts for the file name -- ensures it opens */
      fin = new Scanner(inf);
      total = FileUtil.countRecords(fin, 3);
      fin.close();
      
      fin = new Scanner(inf);
      myBooks = ArrayUtils.createAndFillArray(total, fin);
      fin.close();
      
      do
      {
         choice = MyUtils.menu(kb);
         
         if(choice == 1)
            ArrayUtils.printArray(myBooks, System.out);
            
         else if(choice == 2)
         {
            fout = FileUtil.openOutputFile(kb);
            ArrayUtils.printArray(myBooks, fout);
            fout.close();
         }// end choice 2
         
         else if(choice == 3)
         {
            SortUtil.selectionSort(myBooks);
            ArrayUtils.printArray(myBooks, System.out);
         }// end choice 3
         
         else if(choice == 4)
         {
            Arrays.sort(myBooks, new ISBNSort());
            ArrayUtils.printArray(myBooks, System.out);
         }// end choice 4
         
         else if(choice == 5)
         {
            Arrays.sort(myBooks, new TitleSort());
            ArrayUtils.printArray(myBooks, System.out);
            fout = FileUtil.openOutputFile(kb);
            ArrayUtils.printArray(myBooks, fout);
            fout.close();

         }// end choice 5
         
         else if(choice == 6)
         {
            Book toFind = CSCD210AsgnMethods.readBookToFind(kb);
            int location = SearchUtil.linearSearch(myBooks, toFind);  // calls the equals method
            if(location != -1)
               System.out.println("The book: " + myBooks[location] + " was found");
            
            else
               System.out.println("Book not found");
         }// end choice 6
         
      }while(choice != 7);
      
      System.out.println("I hope you enjoyed reading my books");
   }// end main
}// end class