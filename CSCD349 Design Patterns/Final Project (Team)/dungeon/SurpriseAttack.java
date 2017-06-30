package dungeon;

import java.util.Scanner;

public class SurpriseAttack implements AttackBehavior {

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		System.out.println("Attack from " + this.getClass().getName());
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + victim.name + " is hit again :)");
			attacker.attack(attacker, victim);
		} // end surprise
		else if (surprise >= .9) {
			System.out.println("Uh oh! " + victim.name + " saw you and" + " blocked your attack!");
		}
		else {
			attacker.attack(attacker, victim);
		}

	}

	@Override
	public int attackType() {
		int choice = 0;

		do {
			try {
				System.out.println("\n1. Attack");
				System.out.println("2. Surprise Attack");
				choice = Integer.parseInt(UserInput.getUserInput("integer"));
			}
			catch (Exception e) {
				System.out.println("Enter an integer choice: ");
			}
		} while (choice != 1 && choice != 2);
		// input.close();
		return choice;
	}

}