package Dungeon;

import java.util.Scanner;

public class Battle{
	private static DungeonCharacter player, enemy;
	private static Scanner kb = new Scanner(System.in);
	private static int numTurns;
	
	public Battle(){
		player = getPlayer();
		enemy = generateMonster();
		
		System.out.println("Enter your character's name: ");
		String playerName = kb.nextLine();
		player.readName(playerName);

		kb.nextLine();
		
		System.out.println("Enter the your enemy's name: ");
		String enemyName = kb.nextLine();
		enemy.readName(enemyName);

		fight();
		
	}
	
	public DungeonCharacter getPlayer(){
		int choice;
		
		System.out.println("1.Warrior\n"
						 + "2.Sorceress\n"
						 + "3.Thief\n"
						 + "Select your character: ");
		choice = kb.nextInt();
		
		switch(choice){
			case 1: return CharacterFactory.createCharacter("Warrior");

			case 2: return CharacterFactory.createCharacter("Sorceress");

			case 3: return CharacterFactory.createCharacter("Thief");

			default: System.out.println("invalid choice, returning Thief");
				     return CharacterFactory.createCharacter("Thief");
		}
	}
	
	public DungeonCharacter generateMonster(){
		int choice;
		choice = (int)(Math.random() * 3) + 1;

		switch(choice){
			case 1: return CharacterFactory.createCharacter("Ogre");

			case 2: return CharacterFactory.createCharacter("Gremlin");

			case 3: return CharacterFactory.createCharacter("Skeleton");

			default: System.out.println("invalid choice, returning Skeleton");
				     return CharacterFactory.createCharacter("Skeleton");
		}
	}
	
	public static void fight(){
		char pause = 'p';
		System.out.println(player.getName() + " battles " + enemy.getName());
		System.out.println("---------------------------------------------");

		while (player.isAlive() && enemy.isAlive() && pause != 'q'){
			battleChoices();

			if(enemy.isAlive())
				enemy.attack(player);
			
			System.out.print("\n'q' to quit, anything else to continue: ");
			pause = kb.next().charAt(0);
		}

		if (!enemy.isAlive())
		    System.out.println(player.getName() + " was victorious!");
		else if (!player.isAlive())
			System.out.println(player.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");
	}
	
	public static void battleChoices(){
		getTurns();
		int choice;

		do{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Special Move");
		    System.out.println("Choose an option: ");
		    choice = kb.nextInt();

		    switch(choice){
			    case 1: player.attack(enemy);
			        break;
			    case 2: getSpecialAttack();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);
	}
	
	public static void getTurns(){
	    numTurns = player.getAttackSpeed()/enemy.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);
	}
	
	public static void getSpecialAttack(){
		if(player instanceof Warrior)
			((Warrior)player).crushingBlow(enemy);
		
		else if(player instanceof Sorceress)
			((Sorceress)player).heal();
		
		else if(player instanceof Thief)
			((Thief)player).supriseAttack(enemy);
	}
}