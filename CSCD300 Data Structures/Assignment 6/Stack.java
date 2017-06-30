public class Stack <E>
{
	/*
	 * this is an array implementation
	 * of a stack data structure
	 */
	
	protected int capacity; //capacity of the container
	public static final int CAP = 1000; //how many items the stack can hold
	protected int top = -1; //always pointing to the last element
	protected E stack[]; // the stack
	
	public Stack()
	{
		this(CAP);
	}//end the default constructor
	
	public Stack(int cap)
	{
		this.capacity = cap;
		this.stack = (E []) new Object[capacity];
	}//end the explicit constructor
	
	public int size()
	{
		return(this.top + 1);
	}//end the size method
	
	public boolean isEmpty()
	{
		return size() <= 0;
	}//end the isEmpty method
	
	public void push(E element) throws FullStackException
	{
		if(size() == capacity)
		{
			throw new FullStackException("Stack is Full.");
		}
		
		stack[++top] = element;
	}//end the push method
	
	public E peek() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException("Stack is empty.");
		}
		
		return stack[top];
	}//end the peek method
	
	public E pop() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException("Stack is empty.");
		}
		
		E element;
		element = stack[top];
		stack[top--] = null;
		
		return element;
	}//end the pop method
}//end the Stack class