import java.util.Scanner;

public class postFixExpressionEvaluator 
{
	public static Double evaluate(String str)
	{
		if(str == null || str.isEmpty())
		{
			System.out.println("The string entered was empty.");
			return null;
		}
		else
		{
			String input = str.replace(""," ").trim();
			Scanner sc = new Scanner(input);
			return evaluate(sc);
		}
	}
	
	private static double evaluate(Scanner sc)
	{
		/**
		 * this method takes a valid postFix
		 * expression and evaluates it
		 */
		
	    Stack<Double> stack = new Stack<Double>();

	    while (sc.hasNext()) 
	    {
	        if (sc.hasNextInt()) 
	        {
	            stack.push(sc.nextDouble());
	        }
	        else
	        {
		        double right = stack.pop();
		        double left = stack.pop();
		        char operator = sc.next().charAt(0);
		        
		        if(operator == '+') 
		        {
		        	stack.push(left + right);
		        }
		        
		        else if(operator == '-') 
		        {
		        	stack.push(left - right);
		        }
		        
		        else if(operator == '*') 
		        {
		        	stack.push(left * right);
		        }
		        
		        else if(operator == '/') 
		        {
		        	stack.push(left / right);
		        }
		        else if(operator == '%') 
		        {
		        	stack.push(left % right);
		        }
		        else if(operator == '^')
		        {
		        	stack.push(Math.pow(left, right));
		        }
	        }
	    }

	    sc.close();
	    return stack.pop();
	}//end the evaluate method
}//end the class
