package Dungeon;

public class CrushingBlow implements Attack{

	@Override
	public void attack(DungeonCharacter character, DungeonCharacter opponent){
		if (Math.random() <= .4){
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(character.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		}
		else{
			System.out.println(character.getName() + " failed to land a crushing blow");
			System.out.println();
		}
	}
}