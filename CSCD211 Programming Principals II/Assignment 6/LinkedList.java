public class LinkedList implements Comparable<LinkedList>
{
	private Node head;
	private int size;
	
	public LinkedList()
	{
		head = new Node(null);
		size = 0;
	}//the constructor
	
	public void add(Integer value)
	{
      Node newNode = new Node(value);
      Node curr = head;
      
      while(curr.getNext() != null)
      {
         curr = curr.getNext();
      }
      
		curr.setNext(newNode);
		size++;
	}//addds to the back of the list
   
   public void addAtIndex(Integer value, int index)
   {
      Node newNode = new Node(value);
      Node curr = head;
      
      for(int i = 1; i < index && curr.getNext() != null; i++)
      {
         curr = curr.getNext();
      }
      
      newNode.setNext(curr.getNext());
      curr.setNext(newNode);
      size++;
   }//adds to given index
	
	public Integer get(int index)
	{
		if(index <= 0)
			return null;
		
		Node curr = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(curr.getNext() == null)
				return null;
			
			curr = curr.getNext();
		}
		return curr.getVal();
	}//gets value from given index
   
   public void destroyList()
   {
      head = null;
   }//destroys the entire list
	
	public boolean removeAtIndex(int index)
	{
		if(index < 1 || index > size())
			return false;
		
		Node curr = head;
		for(int i = 1; i < index; i++)
		{
			if(curr.getNext() == null)
				return false;
			
			curr = curr.getNext();
		}
		curr.setNext(curr.getNext().getNext());
		size--;
		return true;
	}//removes at given index
	
	public int size()
	{
		return size;
	}//returns the size
	
	public String toString()
	{
		Node curr = head.getNext();
		String output = "";
		while(curr != null)
		{
			output += "[" + curr.getVal().toString() + "]";
			curr = curr.getNext();
		}
		return output;
	}//the toString method  
   
   
   public int compareTo(LinkedList myList)
   {
      Node curr = head;
      int res = 0;
      
      while(curr != null)
      {
         res = (curr.getVal().compareTo(curr.getNext().getVal()));
      }
      return res;
   }
   
   public void sort()
   {
      Node curr = head;
      
      while(curr.getNext() != null)
      {
         curr.getVal().compareTo(curr.getNext().getVal());
      }

   }
}