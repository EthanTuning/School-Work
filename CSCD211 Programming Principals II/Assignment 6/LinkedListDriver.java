import java.util.*;

public class LinkedListDriver
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      LinkedList myList = new LinkedList();
      int choice = 0;
      
      do
      {
         System.out.println("");
         System.out.println("Welcome to my Linked List Program");
         System.out.println("-------------------------------------------");
         System.out.println("1. Add to the beginning of the list");
         System.out.println("2. Add to the list by index");
         System.out.println("3. Remove an item in the list by index");
         System.out.println("4. Destroy the list");
         System.out.println("5. Print the list");
         System.out.println("6. Print the list in sorted order");
         System.out.println("7. Print all the even numbers in the list");
         System.out.println("8. Quit the program");
         System.out.println("-------------------------------------------");
         System.out.print("What would you like to do?: ");
         try
         {
            choice = kb.nextInt();
         }
         catch (InputMismatchException e)
         {
            System.out.println("Input is invalid.");
            kb.nextLine();
         }
         
         if(choice == 1)
         {
            System.out.print("Enter an Integer to add to the list: ");
            try
            {
               int value = kb.nextInt();
               myList.add(value);
            }
            catch (InputMismatchException e)
            {
               System.out.println("Enter an integer.");
               kb.nextLine();
            }
            
            
         }//choice 1
         
         if(choice == 2)
         {
            System.out.print("Enter an Integer you would like to add, also enter the index: ");
            try
            {
               int value = kb.nextInt();
               int index = kb.nextInt();
               
               myList.addAtIndex(value, index);
            }
            catch (InputMismatchException e)
            {
               System.out.println("Enter an integer.");
               kb.nextLine();
            }
         }//choice 2
         
         if(choice == 3)
         {
            System.out.print("Enter the index that you wish to delete: ");
            try
            {
               int index = kb.nextInt();
               myList.removeAtIndex(index);
            }
            catch (InputMismatchException e)
            {
               System.out.print("Enter a valid index.");
               kb.nextLine();
            }
            catch (NullPointerException e)
            {
               System.out.print("The list is empty");
            }
            
         }//choice 3
         
         if(choice == 4)
         {
            myList.destroyList();
         }//choice 4
         
         if(choice == 5)
         {
            try
            {
               System.out.print(myList);
            }
            catch(NullPointerException e)
            {
               System.out.print("The list is empty.");
            }
         }//choice 5
         
         if(choice == 6)
         {
            try
            {
               myList.sort();
               System.out.println(myList);
            }
            catch(NullPointerException e)
            {
               System.out.print("The list is empty.");
            }
  
         }//choice 6
         
         if(choice == 7)
         {
            
            
         }//choice 7
               
            
            
                
         

   
      }while(choice != 8);
   }
}