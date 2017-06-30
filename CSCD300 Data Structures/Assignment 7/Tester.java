public class Tester 
{

	public static void main(String[] args) 
	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		for(int i = 0; i <= 2000000; i++)
		{
			int rand = (int)(Math.random() * 3000000 + 1);
			list1.add(rand);
			list2.add(rand);
		}
		
		double then = System.currentTimeMillis();
		list1.append(list1.mergeSort(list1.getHead()));
		double now = System.currentTimeMillis();
		
		System.out.println("Time cost in milliseconds for merge sort on two million elements are: " + (now - then));
		System.out.println("Sort worked: " + list1.isSorted());
		
		then = System.currentTimeMillis();
		list2.append(list2.insertionSort(list2.getHead()));
		now = System.currentTimeMillis();
		System.out.println("Time cost in milliseconds for insertion sort on two million elements are: " + (now - then));
		System.out.println("Sort worked: " + list2.isSorted());
	}//end the main method
}//end the tester class
