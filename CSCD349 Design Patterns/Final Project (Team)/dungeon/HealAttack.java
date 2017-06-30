package dungeon;

import java.util.Scanner;

public class HealAttack implements AttackBehavior {

	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		System.out.print("Attack from "+this.getClass().getName());
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		attacker.addHitPoints(hPoints);
		System.out.println(attacker.name + " added [" + hPoints + "] points.\n"
				+ "Total hit points remaining are: "
				+ attacker.getHitPoints());
		System.out.println();
	}

	@Override
	public int attackType() {
		int choice = 0;

		do {
			try {
				System.out.println("\n1. Attack");
				System.out.println("2. Heal");
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
