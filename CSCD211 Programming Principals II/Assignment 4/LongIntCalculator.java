import java.util.*;

public class LongIntCalculator
{

   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      String choice = null;
      int timesThrough = 0;
      int base1 = 0;
      int base2 = 0;
      String num1 = null;
      String num2 = null;
      
      do
      {
         System.out.println("Bin - Binary           +");
         System.out.println("Oct - Octal            -");
         System.out.println("Dcm - Decimal          *");
         System.out.println("Hex - Hexadecimal      /"); 
         System.out.println("Q   - Quit             =");

         
         if(timesThrough == 0);
         {
            
            System.out.print("Enter number base for number 1: ");
            String mode = (kb.nextLine()).toUpperCase();
             
            if (mode.equals("BIN"))
            {
               System.out.println("Enter a binary integer: ");
               String longInt = kb.nextLine();
               
               LongInteger bin = new BinaryInteger(longInt);
               num1 = bin.toString();
               base1 = 2;
            }
            
            if (mode.equals("OCT"))
            {
               System.out.println("Enter an octal integer: ");
               String longInt = kb.nextLine();
               
               LongInteger oct = new OctalInteger(longInt);
               num1 = oct.toString();
               base1 = 8;
            }
            
            if (mode.equals("DCM"))
            {
               System.out.println("Enter an integer: ");
               int int1 = kb.nextInt();
               num1 = Integer.toString(int1);
               base1 = 10;
            }
            
            if (mode.equals("HEX"))
            {
               System.out.println("Enter an octal integer: ");
               String longInt = kb.nextLine();
               
               LongInteger hex = new HexInteger(longInt);
               num1 = hex.toString();
               base1 = 16;
            }
            
            timesThrough = 1;   
         }
         
         if(timesThrough == 1);
         {
            
            System.out.print("Enter number base for number 2: ");
            String mode = (kb.nextLine()).toUpperCase();
             
            if (mode.equals("BIN"))
            {
               System.out.println("Enter a binary integer: ");
               String longInt = kb.nextLine();
               
               LongInteger bin2 = new BinaryInteger(longInt);
               num2 = bin2.toString();
               base2 = 2;
            }
            
            if (mode.equals("OCT"))
            {
               System.out.println("Enter an octal integer: ");
               String longInt = kb.nextLine();
               
               LongInteger oct2 = new OctalInteger(longInt);
               num2 = oct2.toString();
               base2 = 8;
            }
            
            if (mode.equals("DCM"))
            {
               System.out.println("Enter an integer: ");
               int int2 = kb.nextInt();
               num2 = Integer.toString(int2);
               base2 = 10;
            }
            
            if (mode.equals("HEX"))
            {
               System.out.println("Enter an octal integer: ");
               String longInt = kb.nextLine();
               
               LongInteger hex2 = new HexInteger(longInt);
               num2 = hex2.toString();
               base2 = 16;
            }
            
            timesThrough = 2;   
         }

         
         if(timesThrough == 2)
         {
            System.out.println("Would you like to add, subtract, multiply, or divide?: ");
            String op = (kb.nextLine()).toUpperCase();
            
            if(op.equals("ADD"))
            {
               LongInteger.add(num1, num2, base1, base2);
            }
            
            if(op.equals("SUBTRACT"))
            {
               LongInteger.subtract(num1, num2, base1, base2);
            }
            
            if(op.equals("MULTIPLY"))
            {
               LongInteger.multiply(num1, num2, base1, base2);
            }
            
            if(op.equals("DIVIDE"))
            {
               LongInteger.divide(num1, num2, base1, base2);
            }
            timesThrough = 0; 
         }
              
      }while(!choice.equals("Q"));
   }
   
      
}