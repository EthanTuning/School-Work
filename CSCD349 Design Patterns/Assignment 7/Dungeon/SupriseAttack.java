package Dungeon;

public class SupriseAttack implements Attack{

	@Override
	public void attack(DungeonCharacter character, DungeonCharacter opponent){
		double surprise = Math.random();
		
		if (surprise <= .4){
			System.out.println("Surprise attack was successful!\n" + character.getName() + " gets an additional turn.");
			character.attack(opponent);
		}
		else if (surprise >= .9){
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" + " blocked your attack!");
		}
		else
		    character.attack(opponent);
	}
}