/*
 * Ethan Tuning
 * Assignment #1
 * CSCD 300 Data Structures
 * Tony Tian
 * Fall 2016
 */

package Assignment1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Serializable, Cloneable, Iterable<E>
{
	/*
	 * This is my implementation of Java's
	 * LinkedList class
	 * There is a nested Node class
	 * Also uses Generic Types(for extra credit)
	 * Doubly Linked with a dummy/buffer head node
	 */
	
//-------------------------------------------------------------------------------------------
	
	private class Node<T>
	{
		/*
		 * This is the nested Node class
		 * Is only to be used within the
		 * LinkedList class
		 */
		
		private T data;
		private Node<T> next, prev;
		
		private Node(T data, Node<T> prev, Node<T> next)
		{
			this.setData(data);
			this.prev = prev;
			this.next = next;
		}//end constructor

		public T getData() 
		{
			return data;
		}

		public void setData(T data) 
		{
			this.data = data;
		}
	}//end the nested Node class
	
//-------------------------------------------------------------------------------------------	
	
	public class myIterator implements Iterator<E>
	{
		/*
		 * this is a nested Iterator class
		 * public, may be used outside of
		 * linkedList class 
		 */
		
		private Node<E> curr, last;
		private boolean change;
		
		private myIterator(Node<E> start)
		{
			this.curr = start;
			this.last = null;
			this.change = false;
		}//end the constructor
		
		@Override
		public boolean hasNext() 
		{
			return this.curr != head;
		}//end the hasNext method
	
		@Override
		public E next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException("No element found.");
			}
			
			last = curr;
			E data = curr.data;
			curr = curr.next;
			change = true;
			
			return data;
		}//end the next method
		
	}//end myIterator class
	
//-------------------------------------------------------------------------------------------
	
	private Node<E> head;
	private int size;
	
	public LinkedList()
	{
		this.head = new Node<E>(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}//end the constructor
	
	private Node<E> find(int index)
	{
		Node<E> curr = this.head.next;
		
		for(int i = 0; i < index; i++)
		{
			curr = curr.next;
		}
		
		return curr;
	}
	
	@Override
	public boolean add(E data) 
	{
		if(data == null)
		{
			throw new NullPointerException("Data is null.");
		}
		Node<E> node = new Node<E>(data, this.head.prev, this.head);
		this.head.prev.next = node;
		this.head.prev = node;
		this.size++;
		return true;
		
	}//end the add method

	@Override
	public void add(int index, E data) 
	{
		if(index > size || index < 0)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds!");
		}
		
		Node<E> curr = find(index);
		Node<E> node =  new Node<E>(data, curr.prev, curr);
		this.head.prev.next = node;
		this.head.prev = node;
		this.size++;
	}//end the add method

	public void addFirst(E data)
	{
		Node<E> curr = this.head;
		
		if(this.head.prev == null)
		{
			this.head.prev = curr;
		}
		this.size++;
	}//end the addFirst method
	
	public void addLast(E data)
	{
		add(data);
	}//end the addLast method
	
	@Override
	public boolean addAll(int index, Collection<? extends E> collection) 
	{
		
		if(collection == null)
		{
			throw new NullPointerException("Collection is null.");
		}
		
		if(index < 0 || index > this.size)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		boolean change = false;
		
		for(E data: collection)
		{
			add(index, data);
			change = true;
		}
		
		return change;
	}//end the addAll method

	@Override
	public boolean addAll(Collection<? extends E> collection) 
	{
		if(collection == null)
		{
			throw new NullPointerException("Collection is null.");
		}
		
		boolean change = false;
		
		for(E data: collection)
		{
			if(add(data))
			{
				change = true;
			}
		}
		return change;
	}//end the addAll method

	@Override
	public void clear() 
	{
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}//end the clear method

	@Override
	public boolean contains(Object obj) 
	{
		for(E data: this)
		{
			if(data == obj || data.equals(obj))
			{
				return true;
			}
		}
		return false;
	}//end the contains method

	@Override
	public boolean containsAll(Collection<?> collection) 
	{
		if(collection == null)
		{
			throw new NullPointerException("Collection is null.");
		}
		
		for(Object obj: collection)
		{
			if(!contains(obj))
			{
				return false;
			}
		}
		return true;
	}//end the containsAll method

	@Override
	public E get(int index) 
	{
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		
		return find(index).data;
	}//end the get method

	@Override
	public int indexOf(Object data) 
	{
		int index = 0;
		Node<E> curr = this.head;
		
		while(curr != null && !curr.data.equals(data))
		{
			curr = curr.next;
			index++;
		}
		
		if(curr == null)
		{
			return -1;
		}
		else
		{
			return index;
		}
	}//end the indexOf method

	@Override
	public Iterator iterator() 
	{
		return new myIterator(head.next);
	}//end the iterator

	@Override
	public boolean isEmpty() 
	{
		return this.size == 0 || this.head.next == null;
	}//end the isEmpty method

	@Override
	public int lastIndexOf(Object data) 
	{
		int index = this.size -1;
		Node<E> curr = this.head.prev;
		
		while(curr != null && !curr.data.equals(data))
		{
			curr = curr.prev;
			index--;
		}
		if(curr == null)
		{
			return -1;
		}
		else
		{
			return index;
		}
	}//end the lastIndexOf method

	@Override
	public ListIterator<E> listIterator() 
	{
		throw new UnsupportedOperationException();
	}//end the listIterator method

	@Override
	public ListIterator<E> listIterator(int index) 
	{
		throw new UnsupportedOperationException();
	}//end the ListIterator method

	@Override
	public E remove(int index) 
	{
		if(index < 0 || index > this.size)
		{
			throw new IndexOutOfBoundsException("The index is out of bounds.");
		}
		
		Node<E> curr;
		
		curr = find(index);
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		
		return curr.data;
	}//end the remove method

	@Override
	public boolean remove(Object obj) 
	{
		myIterator iterator = (LinkedList<E>.myIterator) iterator();
		
		while(iterator.hasNext())
		{
			E data = iterator.next();
			if(data == obj || data.equals(obj))
			{
				iterator.remove();
				return true;
			}
		}
		return false;
	}//end the remove method

	@Override
	public boolean removeAll(Collection<?> collection) 
	{
		if(collection == null)
		{
			throw new NullPointerException("Collection is null");
		}
		
		boolean changed = false;
		
		for(Object obj : collection)
		{
			if(remove(obj))
			{
				changed = true;
			}
		}
		return changed;
	}//end the removeAll method

	@Override
	public boolean retainAll(Collection<?> collection) 
	{
		if(collection == null)
		{
			throw new NullPointerException("Collection is null.");
		}
		
		boolean changed = false;
		
		Iterator iterator = iterator();
		
		while(iterator.hasNext())
		{
			if(!collection.contains(iterator.next()))
			{
				iterator.remove();
				changed = true;
			}
		}
		return changed;
	}//end the retainAll method

	@Override
	public E set(int index, E data) 
	{
		if(index < 0 || index > this.size)
		{
			throw new IndexOutOfBoundsException("The index is out of bounds.");
		}
		if(data == null)
		{
			throw new NullPointerException("Data is null.");
		}
		
		Node<E> curr;
		
		curr = find(index);
		curr.data = data;
		
		return curr.data;
	}//end the set method

	@Override
	public int size() 
	{
		return this.size;
	}//end the size method

	@Override
	public List<E> subList(int fromIndex, int toIndex) 
	{
		if(fromIndex < 0 || toIndex > this.size || fromIndex > toIndex)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		Node<E> fromIndexNode = find(fromIndex);
		Node<E> toIndexNode = find(toIndex);
		
		LinkedList<E> theList = new LinkedList<E>();
		
		while(fromIndexNode.next != toIndexNode)
		{
			theList.add(fromIndexNode.next.data);
		}
		
		return theList;
	}//end the subList method

	@Override
	public Object[] toArray() 
	{
		throw new UnsupportedOperationException();
	}//end the toArray method

	@Override
	public <T> T[] toArray(T[] array) 
	{
		throw new UnsupportedOperationException();
	}//end the toArray method
	
	public String toString()
	{
		String result = "";
		Iterator iterator = iterator();
		
		while(iterator.hasNext())
		{
			result += iterator.next().toString();
			result += " | ";
		}
		return result;
	}//end the toString method

}//end the LinkedList class
