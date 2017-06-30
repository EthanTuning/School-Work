import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/*
 * Ethan Tuning
 * 4/16/2017
 * CSCD320 Algorithms
 * Bojian Xu
 * Program #1
 */

public class Test_OS_Finding{
	/*
	 * This is an implementation of a algorithm to find
	 * the i'th statistic in a given array
	 */
	public static void main(String [] args){

		String arg1;
		int arg2;
		
		try{
			arg1 = args[0];
			arg2 = Integer.parseInt(args[1]);
			
			File fin = new File(arg1);
			Scanner scanner = new Scanner(fin);
			int[] array = new int[scanner.nextInt()];
			
			for(int i = 0; i < array.length; i++){
				array[i] = scanner.nextInt();
			}
			int result = ithOrdered(array,0, array.length-1, arg2);
			System.out.println(result);
		
			scanner.close();
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}//end main method
	
	public static int ithOrdered(int array[], int left, int right, int i){
		if(left == right){
			return array[left];
		}
		
		int q = randomPartition(array, left, right);
		int k = q - left +1;
		
		if(i==k)
			return array[q];
		else if(i < k)
			return ithOrdered(array, left, q-1,i);
		else
			return ithOrdered(array, q+1, right, i-k);
	}//end ithOrdered method
	
	public static int randomPartition(int array[], int left, int right){
		int i = random(left, right);
		swap(array[i],array[right]);
		return partition(array, left, right);
	}//end randomPartition method

	public static int partition(int array[], int left, int right){
		int pivot = array[right], index = left;
		for(int i = left; i <= right-1; i++){
			if(array[i] <= pivot){
				swap(array[index], array[right]);
				index++;
			}
		}
		swap(array[index], array[right]);
		return index;
	}//end partition method
	
	public static int random(int min, int max){
		int randomNum = min+(int)(Math.random()*((max-min)+1));
		return randomNum;
	}
	
	public static void swap(int i, int j){
		int temp = i;
		i = j;
		j = temp;
	}//end swap method
}//end class