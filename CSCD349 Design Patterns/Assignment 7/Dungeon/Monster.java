package Dungeon;

public abstract class Monster extends DungeonCharacter{
	protected double chanceToHeal;
	protected int minHeal;
	protected int maxHeal;
	
	public Monster(int hitPoints, int attackSpeed,double chanceToHit, double chanceToHeal,
		           int damageMin, int damageMax, int minHeal, int maxHeal){
	  
		super(hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	}
	
	public void heal(){
		Heal heal = new Heal();
		heal.defend(this);
	}
	
	public double getChanceToHeal(){
		return this.chanceToHeal;
	}
	
	public int getMinHeal(){
		return this.minHeal;
	}
	
	public int getMaxHeal(){
		return this.maxHeal;
	}
}