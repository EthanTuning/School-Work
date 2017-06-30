package dungeon;

import java.io.Serializable;

public abstract class DungeonCharacter implements Serializable {
	
	protected AttackBehavior attackBehavior;
	
	
	
	protected String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	protected int damageMin;



	protected int damageMax;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin,
			int damageMax) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}// end constructor
	
	public void setAttackBehavior(AttackBehavior newBehavior) {
		//System.out.println("Setting new attack behavior");
		this.attackBehavior = newBehavior;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isAlive() {
		return (hitPoints > 0);
	}// end isAlive method
	
	public int getHitPoints() {
		return hitPoints;
	}// end getHitPoints
	
	public void setHitPoints(int points){
		this.hitPoints = points;
	}
	// -----------------------------------------------------------------

//	public int getDamageMax() {
//		return this.damageMax;
//	}
//	public int getDamageMin() {
//		return this.damageMin;
//	}
//	
	public double getChanceToHit() {
		return this.chanceToHit;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}// end getAttackSpeed
	
	public void attack(DungeonCharacter attacker, DungeonCharacter victim) {
		//this.attackBehavior.attack(opponent);
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack) {
			damage = (int) (Math.random() * (damageMax - damageMin + 1)) + damageMin;
			victim.subtractHitPoints(damage);

			System.out.println();
		} // end if can attack
		else {

			System.out.println(getName() + "'s attack on " + victim.getName() + " failed!");
			System.out.println();
		} // end else

	}// end attack method
	
	public void subtractHitPoints(int hitPoints) {
		if (hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints > 0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " + " for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
			System.out.println();
		} // end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");

	}// end method
	
	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
			// System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}// end addHitPoints method

	public AttackBehavior getAttackBehavior() {
		return attackBehavior;
	}
}
