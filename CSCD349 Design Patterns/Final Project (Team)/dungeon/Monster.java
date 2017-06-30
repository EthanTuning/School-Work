package dungeon;

public class Monster extends DungeonCharacter {

	private double chanceToHeal;
	private int minHeal, maxHeal;
	

	public Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, 
			double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal) {
		
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	}

	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		heal();

	}// end method
	
	public void heal() {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (super.getHitPoints() > 0);

		if (canHeal) {
			healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(super.getName()+ " healed itself for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + super.getHitPoints());
			System.out.println();
		} // end can heal

	}// end heal method
	
	
}
