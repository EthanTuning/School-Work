package dungeon;

public class Hero extends DungeonCharacter {
	protected double chanceToBlock;
	protected int numTurns;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		// will need to get theh hero name here later
		this.chanceToBlock = chanceToBlock;
	}

	public void battleChoices(DungeonCharacter opponent) {
		numTurns = opponent.getAttackSpeed() / opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}// end battleChoices

	public boolean defend() {
		return Math.random() <= chanceToBlock;

	}// end defend method

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(super.getName()+ " BLOCKED the attack!");
		}
		else {
			super.subtractHitPoints(hitPoints);
		}

	}// end method
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		//this.attackBehavior.attack(opponent);
		int attackType = super.attackBehavior.attackType();
		if(attackType == 1) {
			// regular attack
			super.attack(attacker, victim);
		}
		else if(attackType == 2 ) {
			// especial attack
			super.attackBehavior.attack(attacker, victim);
		}

	}// end attack method

	
	
}
