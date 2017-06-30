package dungeon;

public class BasicAttack implements AttackBehavior {

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		System.out.print("Attack from "+this.getClass().getName());
	}

	@Override
	public int attackType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
