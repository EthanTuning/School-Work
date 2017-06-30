public class infixToPostfixConverter 
{
	private Stack theStack;
	private String theInput;
	private String expression = "";
	
	public infixToPostfixConverter(String in)
	{
		this.theInput = in;
		int stackSize = theInput.length();
		this.theStack = new Stack();
	}//end the constructor
	
	public String convert()
	{
		for(int i = 0; i < this.theInput.length(); i++)
		{	
			char ch = this.theInput.charAt(i);
			
			switch(ch)
			{
				case '+':
				case '-':
					operandPrecedence(ch, 1);
					break;
				case '*':
				case '/':
					operandPrecedence(ch, 2);
					break;
				case '(':
					this.theStack.push(ch);
					break;
				case ')':
					getRightParen(ch);
					break;
				case '^':
					this.theStack.push(ch);
					break;
				default:
					this.expression = this.expression + ch;
			}
		}
		while(!this.theStack.isEmpty())
		{
			this.expression = this.expression + this.theStack.pop();
		}
		return this.expression;
	}//end the convert method
	
	private void operandPrecedence(char theOp, int precedence)
	{
		while(!this.theStack.isEmpty())
		{
			char top = (char) this.theStack.pop();
			if(top == '(')
			{
				this.theStack.push(top);
				break;
			}
			else
			{
				int nextPrecedence = 0;
				if(top == '+' || top == '-')
				{
					precedence = 1;
				}
				else
				{
					nextPrecedence = 2;
				
					if(nextPrecedence < precedence)
					{
						this.theStack.push(top);
						break;
					}
					else
					{
						this.expression = this.expression + top;
					}
				}
			}
		}
		this.theStack.push(theOp);
	}//the operand precedence method
	
	private void getRightParen(char ch)
	{
		while(!this.theStack.isEmpty())
		{
			char ch1 = (char) this.theStack.pop();
			
			if(ch1 == '(')
			{
				break;
			}
			else
			{
				this.expression = this.expression + ch1;
			}
		}
	}//end the get right paren method
}//end the infix to postfix converter