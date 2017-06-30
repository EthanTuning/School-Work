public class LinkedList 
{
	/*
	 * this is a doubly linked list
	 * implementation is also circle
	 */
	private class Node
	{
		private int data;
		private Node next;
		
		private Node(int data)
		{
			this.data = data;
		}//end constructor
		private Node()
		{
			//
		}
	}//end the nested node class
	
	private Node head;
	private int size;
	
	public LinkedList()
	{
		this.head = null;
		this.size = 0;
	}//end the constructor
	
	public void add(int data)
	{
		Node newNode = new Node(data);
		newNode.next = this.head;
		this.head = newNode;
		this.size++;
	}//end the add method
	
	public Node getHead()
	{
		return this.head;
	}//end the getHead method
	
	public void append(Node res)
	{
		this.head = res;
	}//end append method
	
	public Node mergeSort(Node head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node node1 = head;
		Node node2 = head.next;
		
		while(node2 != null && node2.next != null)
		{
			head = head.next;
			node2 = (node2.next).next;
		}
		
		node2 = head.next;
		head.next = null;
		
		return merge(mergeSort(node1), mergeSort(node2));
	}//end the mergeSort method
	
	private Node merge(Node node1, Node node2)
	{
		Node temp = new Node();
		Node head = temp;
		Node node3 = head;

		while((node1 !=  null) && (node2 != null))
		{
			if(node1.data <= node2.data)
			{
				node3.next = node1;
				node3 = node1;
				node1 = node1.next;
			}
			else
			{
				node3.next = node2;
				node3 = node2;
				node2 = node2.next;
			}
		}
		node3.next = (node1 == null) ? node2 : node1;
		
		return head.next;
	}//end the merge method
	
	public Node insertionSort(Node head)
	{
		if(head == null)
		{
			return null;
		}
		
		Node fakeHead = new Node(-1);
		fakeHead.next = head;
		Node node = head;
		
		while(node != null)
		{
			Node node1 = fakeHead;
			Node node2 = fakeHead.next;
			
			while(node2.data < node.data)
			{
				node2 = node2.next;
				node1 = node1.next;
			}
			Node next = node.next;
			node1.next = node;
			node.next = node2;
			
			while(node2.next != node)
			{
				node2 = node2.next;
			}
			
			node2.next = next;
			node = next;
		}
		return fakeHead.next;
	}//end the sort method
	
	public boolean isSorted()
	{
		
		if(this.size == 0)
		{
			return false;
		}
		
		Node curr = this.head;
		
		while(curr != null)
		{
			Node nextTo = curr;
			
			if(curr.data > nextTo.data)
			{
				return false;
			}
			curr = curr.next;
		}
		return true;
	}//end the is sorted method
	
	public boolean isEmpty()
	{
		return this.head == this.head.next;
	}//end the isEmpty method
	
	@Override
	public String toString()
	{
		String res = "|";
		
		for(Node curr = this.head; curr != null; curr = curr.next)
		{
			res += curr.data + ",";
		}
		return res + "|";
	}
}//end the linked list class
