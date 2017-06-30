import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class MinHeapUtils{
	public static void populateHeap(MinHeap heap, Scanner in){
		if(in == null)
			throw new RuntimeException("Input null on call to populate the heap.");
		int data;
		
		if(heap.getSize() == 0){
			data = in.nextInt();
			heap.add(data);
		}
		
		while(in.hasNext()){
			data = in.nextInt();
			
			if(heap.getSize() < heap.getMax())
				heap.add(data);
			else if(data > heap.getHeapIndex(1) && heap.getSize() >= heap.getMax()){
				heap.remove(1);
				heap.add(data);
			}
		}
	}
	
	public static void write(MinHeap heap){
		PrintStream result = null;
		int ctr = heap.getSize();
		
		heap.buildMaxHeap();
		heap.heapSort();
		
		try{
			result = new PrintStream("output.txt");
		}catch(FileNotFoundException e){
			System.out.println("File was not found.");
		}
		
		while(ctr >= 1){
			result.println(heap.getHeapIndex(ctr));
			ctr--;
		}
		result.flush();
		result.close();
	}
}