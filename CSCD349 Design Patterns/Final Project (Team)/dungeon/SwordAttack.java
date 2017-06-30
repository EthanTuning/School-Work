package dungeon;


import java.util.Scanner;

public class SwordAttack  implements AttackBehavior {
    public void attack(DungeonCharacter attacker, DungeonCharacter victim) {

        int damage = 75;
        double attack = Math.random();
        if(attack <= .6){
            System.out.println(attacker.name+ " performs attack on "+ victim.name);
            System.out.println("Ninja damage applied to "+ victim.name+ " is "+ damage);
            victim.subtractHitPoints(damage);
        }
        else {
            System.out.println(attacker.name+ " failed the attack");
        }


    }
    public int attackType() {
        int choice = 0;

        do {
            try {
                System.out.println("\n1. Attack");
                System.out.println("2. Ninja Attack");
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
