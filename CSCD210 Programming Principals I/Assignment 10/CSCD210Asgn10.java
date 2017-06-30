import java.util.Scanner;

public class CSCD210Asgn10
{
   public static void main(String [] args)
   {
      int theNum, choice;
      Scanner kb = new Scanner(System.in);
      
      theNum = Asgn10Methods.readPosNum(kb);
      
      do
      {
         choice = Asgn10Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  theNum = Asgn10Methods.readPosNum(kb);
                     break;
                    
            case 2:  Asgn10Methods.oddEvenZero(theNum);
                     break;  
            
            case 3:  Asgn10Methods.lightOrHeavy(theNum, kb);
                     break;
                     
            case 4:  Asgn10Methods.printPrimes(theNum);
                     break;
                     
            default: System.out.println("Good Bye");         
         
         }// end switch
            
      }while(choice != 5);
  
   }// end main


}// end class