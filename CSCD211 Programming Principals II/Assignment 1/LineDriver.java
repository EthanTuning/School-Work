import java.util.*;

public class LineDriver
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      int choice, x1 = 0, x2 = 0, y1 = 0, y2 = 0, xb1 = 0, xb2 = 0, yb1 = 0, yb2 = 0, width = 0, width1 = 0;
      String color = null, color1 = null;
      Line line1 = new Line();
      Line line2 = new Line();
      
      do
      {
         System.out.println("Hello, Welcome to My Program!");
         System.out.println(" ");
         System.out.println("1.) Enter coordinates, width, and color for the first line: ");
         System.out.println("2.) Enter coordinates, width, and color for the second line: ");
         System.out.println("3.) Compare the two lines.");
         System.out.println("4.) Display coordinates, width, and color for the first line: ");
         System.out.println("5.) Display coordinates, width, and color for the second line: ");
         System.out.println("6.) Exit.");
         System.out.println(" ");
         System.out.print("What would you like to do?: ");
         choice = kb.nextInt();
        
         
      
         if (choice == 1)
         {
            do
            {
               System.out.println("Enter Coordinates for first point: ");
               System.out.print("X: ");
               x1 = kb.nextInt();
               System.out.print("Y: ");
               y1 = kb.nextInt();
               
               System.out.println("Enter Coordinates for second point: ");
               System.out.print("X: ");
               x2 = kb.nextInt();
               System.out.print("Y: ");
               y2 = kb.nextInt();
               
               System.out.print("Enter the width of the line: ");
               width = kb.nextInt();
               
               kb.nextLine();
               
               System.out.print("Enter the color of the line: ");
               color = kb.nextLine();
                  
               line1 = new Line(x1, y1, x2, y2, width, color);
               
               }while (Line.validatePoints(x1, y1) && Line.validatePoints(x2, y2));
            
         }//option 1
         
         if (choice == 2)
         {
            do
            {
               System.out.println("Enter Coordinates for first point: ");
               System.out.print("X: ");
               xb1 = kb.nextInt();
               System.out.print("Y: ");
               yb1 = kb.nextInt();
               
               System.out.println("Enter Coordinates for second point: ");
               System.out.print("X: ");
               xb2 = kb.nextInt();
               System.out.print("Y: ");
               yb2 = kb.nextInt();
               
               System.out.print("Enter the width of the line: ");
               width1 = kb.nextInt();
               
               kb.nextLine();
               
               System.out.print("Enter the color of the line: ");
               color1 = kb.nextLine();
                  
               line2 = new Line(xb1, yb1, xb2, yb2, width1, color1);
               
            }while (Line.validatePoints(xb1, yb1) && Line.validatePoints(xb2, yb2));
      
         }//option 2
         
         if (choice == 3)
         {
            Line.equals(x1, y1, x2, y2, color, width, xb1, yb1, xb2, yb2, color1, width1);
         
         }//option 3
         
         if (choice == 4)
         {
            System.out.println(line1);
            
         }//option 4
         
         if (choice == 5)
         {
            System.out.println(line2);
            
         }//option 5
         
      
      
      } while (choice != 6);
      //menu
      
         
   }


}