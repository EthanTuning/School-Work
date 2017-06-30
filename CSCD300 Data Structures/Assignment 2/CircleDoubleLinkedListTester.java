
public class CircleDoubleLinkedListTester 
{
	public static void main(String ... args)
	{
		CircleDoubleLinkedList testList = new CircleDoubleLinkedList();
		testList.add("hello", 0);
		testList.add("apple", 1);
		testList.add("orange", 2);
		testList.add("cherry", 3);
		testList.add("blueberry", 4);
		testList.add("java", 5);
		testList.add("zzzzz", 6);
		testList.add("elephant", 7);
		testList.add("fox", 8);
		System.out.print("This is the list before being sorted: ");
		System.out.print("\n" + testList.toString());
		testList.sort();
		System.out.println("");
		System.out.print("\nThis is the list after being sorted: ");
		System.out.print("\n" + testList.toString());
	}//end the main method
}//end the tester
