/*
	Name: Ethan Tuning
	Date Due: 9/27/2017
	Desc: This program lists all the armstrong numbers from 0 - 999999,
		  also displays how many narmstrong numbers the program found.
*/

using System;

public class armstrong {
	public static void Main(){
		
		int totalArms = 0, currVal, remainder, tempCurrVal;
		long sumOfCurrN;
		
		for(currVal = 0; currVal <= 999999; currVal++){
			
			tempCurrVal = currVal;
			sumOfCurrN = 0;
			
			while(tempCurrVal != 0){
				
				remainder = tempCurrVal % 10;
				sumOfCurrN = sumOfCurrN + (long)Math.Pow(remainder,currVal.ToString().Length);
				tempCurrVal = tempCurrVal / 10;
			}
			
			if(currVal == sumOfCurrN){
				Console.WriteLine(currVal);
				totalArms++;
			}
		}
		
		Console.Write("There are: " + totalArms + " armstrong numbers.");
	}
}