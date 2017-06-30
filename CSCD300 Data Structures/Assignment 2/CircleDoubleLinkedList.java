/*
 * Ethan Tuning
 * CSCD300
 * Assignment #2
 */

public class CircleDoubleLinkedList 
{
	/*
	 * this is a doubly linked list
	 * implementation is also circle
	 */
	private class Node
	{
		private Object data;
		private Node next, prev;
		
		private Node(Object data, Node prev, Node next)
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}//end constructor
	}//end the nested node class
	
	private Node head;
	private int size;
	
	public CircleDoubleLinkedList()
	{
		this.head = new Node(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}//end the constructor
	
	public void add(Object data, int index)
	{
		if(index < 0 || index > this.size || data == null)
		{
			throw new IllegalArgumentException("Something went horribly wrong.");
		}
		 Node curr;
		 int i;
		 
		 for(i = 0, curr = this.head; i < index; i++)
		 {
			 curr = curr.next;
		 }
		 Node newNode = new Node(data, curr, curr.next);
		 curr.next.prev = newNode;
		 curr.next = newNode;
		 this.size++;
	}//end the add method
	
	public void sort()
	{
		Node lastSorted, sortedWalker;
		
		Comparable firstUnsortedData;
		
		for(lastSorted = this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next)
		{
			firstUnsortedData = (Comparable) lastSorted.next.data;
			
			for(sortedWalker = lastSorted; sortedWalker != head && ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0; sortedWalker = sortedWalker.prev)
			{
				sortedWalker.next.data = sortedWalker.data;
			}
			sortedWalker.next.data = firstUnsortedData;
		}
	}//end the sort method
	
	public boolean isEmpty()
	{
		return this.head == this.head.next;
	}//end the isEmpty method
	
	@Override
	public String toString()
	{
		String res = "|";
		
		for(Node curr = this.head.next; curr != this.head; curr = curr.next)
		{
			res += curr.data + ",";
		}
		return res + "|";
	}
}//end the linkedlist class