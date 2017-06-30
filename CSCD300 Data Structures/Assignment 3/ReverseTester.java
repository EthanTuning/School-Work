
public class ReverseTester 
{
	public static void main(String ... args)
	{
		MyLinkedList list = new MyLinkedList();
		list.add("Hello");
		list.add("my");
		list.add("name");
		list.add("is");
		list.add("Ethan");
		list.add("and");
		list.add("I");
		list.add("Program");
		
		System.out.println("This is the list before being reversed: ");
		System.out.println(list.toString());
		MyLinkedList revList = list.reverse();
		System.out.println("This is the list after being reversed: ");
		System.out.print(revList.toString());

	}//end the main method
}//end the tester
