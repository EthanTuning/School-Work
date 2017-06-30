import java.util.InputMismatchException;
import java.util.Scanner;

public class infixToPostfixDriver
{
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		int option;
		String expression = "";
		infixToPostfixConverter convert;
		Double finalAnswer;
		String converted;
		
		do
		{
			System.out.print("\n1. Test program \n2. Quit: ");
			try
			{
				option = kb.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Input is wrong. Program terminated.");
				return;
			}
			
			kb.nextLine();
			
			if(option != 2)
			{
				System.out.print("Please enter the infix expression to process: ");
				expression = kb.nextLine();
				
				try
				{
					convert = new infixToPostfixConverter(expression);
				}
				catch(Exception e)
				{
					System.out.println("Input is wrong. Program terminated.");
					return;
				}
				
				converted = convert.convert();
				
				try
				{
					finalAnswer = postFixExpressionEvaluator.evaluate(converted);
				}
				catch(EmptyStackException e)
				{
					System.out.println("Invalid expression. Program terminated.");
					return;
				}

				System.out.println("The postfix expression for the input is: " + converted);
				System.out.println("The result after evaluating the postfix is: " + finalAnswer);
			}
		}while(option != 2);
	}//end the main method
}//end the program
