package dungeon;

import java.util.Scanner;

public class FireBallAttack implements AttackBehavior {

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		System.out.print("Attack from "+this.getClass().getName());

		
	}

	@Override
	public int attackType() {
		int choice = 0;

		do {
			try {
				System.out.println("\n1. Attack");
				System.out.println("2. Fireball Attack");
				choice = Integer.parseInt(UserInput.getUserInput("integer"));
			}
			catch (Exception e) {
				System.out.println("Enter an integer choice: ");
			}
		} while (choice != 1 && choice != 2);
		//input.close();
		return choice;
	}

}
