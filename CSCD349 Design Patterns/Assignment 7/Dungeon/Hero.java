package Dungeon;

public abstract class Hero extends DungeonCharacter{
	protected double chanceToBlock;
	
	public Hero(int hitPoints, int attackSpeed, double chanceToHit, int damageMin, 
							   int damageMax, double chanceToBlock){
		
		super(hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
	}
	
	public double getChanceToBlock(){
		return this.chanceToBlock;
	}
	
	public void block(){
		Block block = new Block();
		block.defend(this);
	}
}