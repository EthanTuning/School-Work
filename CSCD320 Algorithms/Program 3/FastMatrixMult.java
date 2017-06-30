import java.util.*;
import java.io.*;

public class FastMatrixMult{
	static int[][]array1;
	static int[][]array2;
	
	public static void main(String [] args){
		
		File file = null;
		Scanner input = null;
		
		if(args.length == 0){
			System.out.println("No arguments were given.");
		}
		else{
			for(String str: args){
				file = new File(str);
			}
		}
		
		try{
			input = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.println("File was not found.");
		}
		/*
		 * ****************YOU MUST CHANGE THE VALUE OF THE ARRAY SIZE TO*******************
		 * ****************MATCH THE SIZE OF THE VALUE WITHIN THE TEXT FILE*****************
		 */
		int[] array = new int[4];
		int i = 0;
		
		while(input.hasNextInt()){
			array[i++] = input.nextInt();
		}
		
		chainOrder(array);
		int cost = printOptimalParens(array2, 0, array2.length-1);
		System.out.print("\n" + cost);
	}
	
	public static void chainOrder(int[] dimensions){
		int length = dimensions.length - 1;
		array1 = new int[length][length];
		array2 = new int[length][length];
		
		for(int ctr = 1; ctr < length; ctr++){
			for(int i = 0; i < length - ctr; i++){
				int j = i + ctr;
				array1[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; k++){
					int q = array1[i][k] + array1[k+1][j] + dimensions[i]*dimensions[k+1]*dimensions[j+1];
					
					if(q < array1[i][j]){
						array1[i][j] = q;
						array2[i][j] = k;
					}
				}
			}
		}
	}
	
	public static int printOptimalParens(int[][]array, int i, int j){
		if(i == j){
			System.out.print("A"+i);
		}
		else{
			System.out.print("(");
			printOptimalParens(array, i, array[i][j]);
			printOptimalParens(array, array[i][j] + 1, j);
			System.out.print(")");
			return array1[i][j];
		}
		return 0;
	}
}