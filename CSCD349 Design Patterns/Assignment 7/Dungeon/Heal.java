package Dungeon;

public class Heal implements Defend{

	@Override
	public void defend(DungeonCharacter character){
		if(character instanceof Sorceress){
		    int hPoints;

			hPoints = (int)(Math.random() * (50 - 25 + 1)) + 25;
			character.addHitPoints(hPoints);
			System.out.println(character.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + character.getHitPoints());
			System.out.println();
		}
		if(character instanceof Monster){
			boolean canHeal;
			int healPoints;

			canHeal = (Math.random() <= ((Monster) character).getChanceToHeal()) && (character.getHitPoints() > 0);

			if (canHeal)
			{
				healPoints = (int)(Math.random() * ((Monster) character).getMaxHeal() - ((Monster) character).getMinHeal() + 1) + ((Monster) character).getMinHeal();
				character.addHitPoints(healPoints);
				System.out.println(character.getName() + " healed itself for " + healPoints + " points.\n"
											 + "Total hit points remaining are: " + character.getHitPoints());
				System.out.println();
			}//end can heal


		}
	}
}