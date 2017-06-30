/*
 * Ethan Tuning
 * CSCD300
 * Assignment #3
 */
public class MyLinkedList 
{
	private class Node
	{
		/*
		 * this is a nested Node class
		 * will be used just for the
		 * implementation of the LinkedList class
		 */
		private Object data;
		private Node next;
		
		private Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		private Node(Object data)
		{
			this(data, null);
		}
	}//end the nested Node class
	
	private Node head;
	private int size;
	
	public MyLinkedList()
	{
		this.head = null;
		this.size = 0;
	}//end the linkedList constructor
	
	public boolean isEmpty()
	{
		return (this.head == null);
	}//end the isEmpty method
	
	public void add(Object data)
	{
		if(isEmpty())
		{
			this.head = new Node(data, this.head);
			this.size++;
		}
		else
		{
			Node curr = this.head;
			
			while(curr.next != null)
			{
				curr = curr.next;
			}
			curr.next = new Node(data, null);
			this.size++;
		}
	}//end the add method
	
	@Override
	public String toString()
	{
		String result = "";
		
		for(Node curr = this.head; curr!= null; curr = curr.next)
		{
			result += curr.data + " ";
		}
		return '|' + result + '|';
	}//end the toString method
	
	public MyLinkedList reverse()
	{
		return reverse(this.head);
	}//end the public reverse method
	
	private MyLinkedList reverse(Node node)
	{
		MyLinkedList list = new MyLinkedList();
		
		if(node != null)
		{
			list = reverse(node.next);
			list.add(node.data);
		}
		return list;
	}//end the private reverse method
	
}//end the linkedlist class
