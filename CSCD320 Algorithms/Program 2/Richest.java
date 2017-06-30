import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Richest{
	public static void main(String [] args){
		MinHeap heap = new MinHeap(10000);
		Scanner reader = null;
		
		try{
			File fin = new File(args[0]);
			reader = new Scanner(fin);
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
		}catch(ArrayIndexOutOfBoundsException f){
			System.out.println("Invalid arguments.");
		}
		
		MinHeapUtils.populateHeap(heap, reader);
		MinHeapUtils.write(heap);
	}
}