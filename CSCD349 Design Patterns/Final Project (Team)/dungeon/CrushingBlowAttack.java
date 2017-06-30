package dungeon;

import java.util.Scanner;

public class CrushingBlowAttack implements AttackBehavior {

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		//System.out.println("Attack from " + this.getClass().getName());
		if (Math.random() <= .4) {
			int blowPoints = (int) (Math.random() * 76) + 100;
			System.out.println(attacker.name + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			victim.subtractHitPoints(blowPoints);
		} // end blow succeeded
		else {
			System.out.println(attacker.name+ " failed to land a crushing blow on "+ victim.name);
			System.out.println();
		} // blow failed

	}

	
	@Override
	public int attackType() {
		int choice = 0;

		do {
			try {
				System.out.println("\n1. Attack");
				System.out.println("2. Crushing Blow");
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
