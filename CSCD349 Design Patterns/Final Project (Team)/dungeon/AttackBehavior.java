package dungeon;

import java.io.Serializable;

public interface AttackBehavior extends Serializable{
	// might need to return an int for the amount of damage points
	public void attack(DungeonCharacter attacker, DungeonCharacter victim);
	public int attackType();
}
