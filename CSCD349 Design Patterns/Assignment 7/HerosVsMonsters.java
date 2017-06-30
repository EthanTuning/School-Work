import java.util.Scanner;

import Dungeon.Battle;

public class HerosVsMonsters{
	public static void main(String [] args){
		Scanner kb = new Scanner(System.in);
		int choice;
		Battle theBattle;
		
		System.out.println("Welcome to Heros vs. Monsters\n"
						 + "1. New game\n"
						 + "2. quit\n"
						 + "Enter your choice: ");
		choice = kb.nextInt();
		do{
			if(choice == 1)
				theBattle = new Battle();
			
			if(choice == 2)
				System.exit(1);
		}while(choice != 2);
	}
}