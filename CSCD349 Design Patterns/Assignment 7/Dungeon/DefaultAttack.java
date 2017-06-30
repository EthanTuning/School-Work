package Dungeon;

public class DefaultAttack implements Attack
{
	@Override
	public void attack(DungeonCharacter character, DungeonCharacter opponent){
		boolean canAttack;
		int damage;
		canAttack = Math.random() <= character.getChanceToHit();

		if (canAttack){
			damage = (int)(Math.random() * (character.getDamageMax() - character.getDamageMin() + 1)) + character.getDamageMin();
			opponent.subtractHitPoints(damage);
			System.out.println();
		}
		else{
			System.out.println(character.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
	}
}