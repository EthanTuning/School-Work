/*
 * Ethan Tuning
 * Assignment #1
 * CSCD 300 Data Structures
 * Tony Tian
 * Fall 2016
 */

package Assignment1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LinkedListTester 
{
	/*
	 * This is the Tester class for
	 * my LinkedList implementation
	 * This contains the main method
	 * at which to test my LinkedList's 
	 * functionality
	 */
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String ... args)
	{
		LinkedList<Integer> testList = new LinkedList<>();
		
		menu(testList);
	}//end the main method
	
//--------------------------------------------------------------------------------------------------------------------------
	
	public static void menu(LinkedList<Integer> testList)
	{
		int choice;
		
		do
		{
			displayMenu();
			
			choice = getChoice();
			
			switch(choice)
			{
				case 1:
					testAdd(testList);
					break;
					
				case 2:
					testAdd2(testList);
					break;
					
				case 3:
					testAddFirst(testList);
					break;
					
				case 4:
					testAddLast(testList);
					break;
					
				case 5:
					testAddAll(testList);
					break;
					
				case 6:
					testAddAll2(testList);
					break;
					
				case 7:
					testClear(testList);
					break;
					
				case 8:
					testContains(testList);
					break;
					
				case 9:
					testContainsAll(testList);
					break;
					
				case 10:
					testGet(testList);
					break;
					
				case 11:
					testIndexOF(testList);
					break;
					
				case 12:
					testIterator(testList);
					break;
					
				case 13:
					testIsEmpty(testList);
					break;
					
				case 14:
					testLastIndexOf(testList);
					break;
					
				case 15:
					testListIterator(testList);
					break;
					
				case 16:
					testListIterator2(testList);
					break;
					
				case 17:
					testRemove(testList);
					break;
					
				case 18:
					testRemove2(testList);
					break;
					
				case 19:
					testRemoveAll(testList);
					break;
					
				case 20:
					testRetainAll(testList);
					break;
					
				case 21:
					testSet(testList);
					break;
					
				case 22:
					testSize(testList);
					break;
					
				case 23:
					testSubList(testList);
					break;
					
				case 24:
					testToArray(testList);
					break;
					
				case 25:
					testToArray2(testList);
					break;
					
				case 26:
					testToString(testList);
					break;
			}
			
		}while (choice != 27);
	}//end the menu method

	private static int getChoice()
	{
		try
		{
			System.out.print("Enter a method to test: ");
			int choice = kb.nextInt();
			return choice;
		}
		catch(Exception e)
		{
			System.out.print("Enter an Integer.");
			return -1;
		}
	}//end the getChoice method
	
	private static void displayMenu()
	{
		System.out.println
		(
				"\n1. Test add(data)\n" +
				"2. Test add(index, data)\n" +
				"3. Test addFirst\n" +
				"4. Test addLast\n" +
				"5. Test addAll(index, collection)\n" +
				"6. Test addAll(collection)\n" +
				"7. Test clear\n" +
				"8. Test contains\n" +
				"9. Test containsAll\n" +
				"10. Test get\n" +
				"11. Test indexOf\n" +
				"12. Test iterator\n" +
				"13. Test isEmpty\n" +
				"14. Test lastIndexOf\n" +
				"15. Test listIterator()\n" +
				"16. Test listIterator(int)\n" +
				"17. Test remove(index)\n" +
				"18. Test remove(data)\n" +
				"19. Test removeAll\n" +
				"20. Test retainAll\n" +
				"21. Test size\n" +
				"22. Test set\n" +
				"23. Test subList\n" +
				"24. Test toArray()\n" +
				"25. Test toArray()\n" +
				"26. Test toString\n" +
				"27. Exit the program.\n\n"
		);
	}//end the displayMenu method

//--------------------------------------------------------------------------------------------------------------------------
	
	private static void testAdd(LinkedList<Integer> list)
	{
		for(int i = 0; i < 11; i++)
		{
			System.out.print("\nEnter a number to add: ");
			Integer data =  kb.nextInt();
			list.add(data);
			String str = list.toString();
			System.out.print(str);
		}
	}//end the testAdd method
	
	private static void testAdd2(LinkedList<Integer> list)
	{
		for(int i = 0; i < 2; i++)
		{
			System.out.print("\nEnter a number to add: ");
			Integer data = kb.nextInt();
			System.out.print("");
			System.out.print("\nEnter an index: ");
			int index = kb.nextInt();
			list.add(index, data);
			String str = list.toString();
			System.out.print(str);
		}
	}//end the testAdd2

	private static void testAddFirst(LinkedList<Integer> list) 
	{
		for(int i = 0; i < 11; i++)
		{
			System.out.print("\nEnter a number to add: ");
			Integer data = kb.nextInt();
			list.addFirst(data);
			String str = list.toString();
			System.out.print(str);
		}
	}//end the testAddFirt method

	private static void testAddLast(LinkedList<Integer> list)
	{
		for(int i = 0; i < 11; i++)
		{
			System.out.print("\nEnter a number to add: ");
			Integer data = kb.nextInt();
			list.add(data);
			String str = list.toString();
			System.out.print(str);
		}
	}//end the testAddLast method

	private static void testAddAll(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list:");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nHere is the collection: ");
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(5);
		collection.add(6);
		collection.add(23);
		collection.add(3);
		System.out.print(collection);
		list.addAll(collection);
		System.out.print("\nHere is the list:");
		str = list.toString();
		System.out.print(str);
	}//end the testAddAll method

	private static void testAddAll2(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list:");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nHere is the collection: ");
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(5);
		collection.add(6);
		collection.add(23);
		collection.add(3);
		System.out.print(collection);
		System.out.print("\nEnter an index: ");
		int index = kb.nextInt();
		list.addAll(index, collection);
		System.out.print("\nHere is the list:");
		str = list.toString();
		System.out.print(str);
	}//end the testAddAll2 method

	private static void testClear(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		list.clear();
		str = list.toString();
		System.out.print(str);
	}//end the testClear method

	private static void testContains(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nWhat would you like to check?: ");
		int toCheck = kb.nextInt();
		boolean result = list.contains(toCheck);
		if(result)
		{
			System.out.print("\nThis is in the list.");
		}
		else
		{
			System.out.print("\nThis is not in the list.");
		}
	}//end the testContains method

	private static void testContainsAll(LinkedList<Integer> list) 
	{
		list.add(1);
		list.add(5);
		list.add(6);
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nHere is first the collection: ");
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(5);
		collection.add(6);
		System.out.print(collection);
		
		if(list.containsAll(collection))
		{
			System.out.print("\nThe list contains the collection.");
		}
		
		System.out.print("\nHere is second the collection: ");
		ArrayList<Integer> collection2 = new ArrayList<>();
		collection.add(123123);
		collection.add(32323);
		collection.add(901);
		System.out.print(collection2);
		
		if(!list.containsAll(collection2))
		{
			System.out.print("\nThe list does not contain the collection.");
		}
	}//end the testContainsAll method

	private static void testGet(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter an index to get: ");
		int index = kb.nextInt();
		int get = list.get(index);
		System.out.print("\nThis is the value you chose: " + get);
	}//end the testGet method

	private static void testIndexOF(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter the data: ");
		int data = kb.nextInt();
		int theIndex = list.indexOf(data);
		System.out.print("\nHere is the index of the data you chose: " + theIndex);
	}//end the testIndexOf method

	private static void testIterator(LinkedList<Integer> list) 
	{
		Iterator<Integer> it = list.iterator();
		System.out.print("\nAfter the iterator method, it returns: ");
		
		while(it.hasNext())
		{
			System.out.print(it.next());
		}
	}//end the testIterator method

	private static void testIsEmpty(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		
		if(!list.isEmpty())
		{
			System.out.print("\nThe list is not empty.");
		}
		
		list.clear();
		
		System.out.print("\nHere is the list now that is empty: ");
		str = list.toString();
		System.out.print(str);
		
		if(list.isEmpty())
		{
			System.out.print("\nThe list is empty.");
		}
	}//end theIsEmpty method

	private static void testLastIndexOf(LinkedList<Integer> list) 
	{
		list.add(12);
		list.add(4);
		list.add(99);
		list.add(2);
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter the data: ");
		int data = kb.nextInt();
		int theIndex = list.lastIndexOf(data);
		System.out.print("\nHere is the index of the data you chose: " + theIndex);
	}//end the testLastIndexOf method

	private static void testListIterator(LinkedList<Integer> list) 
	{
		System.out.print("\nThis method is not implemented.");
	}//end the testListIterator method

	private static void testListIterator2(LinkedList<Integer> list) 
	{
		System.out.print("\nThis method is not implemented");
	}//end the testListIterator2 method

	private static void testRemove(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter an index to remove: ");
		int index = kb.nextInt();
		list.remove(index);
		System.out.print("\nHere is the list now: ");
		str = list.toString();
		System.out.print(str);
	}//end the testRemove method

	private static void testRemove2(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter the data to remove: ");
		int data = kb.nextInt();
		list.remove(data);
		str = list.toString();
		System.out.print("\nThis is the list now: ");
	}//end the testRemove2 method

	private static void testRemoveAll(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the collection: ");
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(5);
		collection.add(6);
		collection.add(23);
		collection.add(3);
		System.out.print(collection);
		list.addAll(collection);
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		list.removeAll(collection);
		System.out.print("\nHere is the list now: ");
		str = list.toString();
		System.out.print(str);
	}//end the testRemoveAll method

	private static void testRetainAll(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the collection: ");
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(5);
		collection.add(6);
		collection.add(23);
		collection.add(3);
		System.out.print(collection);
		list.addAll(collection);
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		list.retainAll(collection);
		System.out.print("\nHere is the list now: ");
		str = list.toString();
		System.out.print(str);
	}//end the testRetainAll method

	private static void testSet(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter an index: ");
		int index = kb.nextInt();
		System.out.print("\nEnter the data: ");
		int data = kb.nextInt();
		list.set(index, data);
		System.out.print("\nHere is the list now: ");
		str = list.toString();
		System.out.print(str);
	}//end the testSet method

	private static void testSize(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nHere is the size of the list: ");
		System.out.print(list.size());
	}//end the testSize method

	private static void testSubList(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
		System.out.print("\nEnter the staart index: ");
		int start = kb.nextInt();
		System.out.print("\nEnter the end index: ");
		int end = kb.nextInt();
		System.out.print("\nHere is the sublist: ");
		List<Integer> subList = list.subList(start, end);
		System.out.print(subList);
	}//end the testSubList method

	private static void testToArray(LinkedList<Integer> list) 
	{
		System.out.print("\nThis method is not implemented.");
	}//end the testToArray method
	
	private static void testToArray2(LinkedList<Integer> list) 
	{
		System.out.print("\nThis method is not implemented.");
	}//end the testToArray2 method

	private static void testToString(LinkedList<Integer> list) 
	{
		System.out.print("\nHere is the list: ");
		String str = list.toString();
		System.out.print(str);
	}//end the toInteger method
}//end the Tester class