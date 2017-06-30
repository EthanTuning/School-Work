package Dungeon;

import java.util.Scanner;

public abstract class DungeonCharacter{
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin;
	protected int damageMax;
	
	public DungeonCharacter(int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax){
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
	}
	
	public void readName(String name){
		this.name = name;
	}
	
    public boolean isAlive(){
	  return (this.hitPoints > 0);
	}
    
	public void attack(DungeonCharacter opponent){
		DefaultAttack defaultAttack = new DefaultAttack();
		defaultAttack.attack(this, opponent);
	}
	
	public void addHitPoints(int hitPoints){
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else{
			this.hitPoints += hitPoints;
			System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}
	
	public void subtractHitPoints(int hitPoints){
		if (hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints > 0){
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(this.getName() + " hit for <" + hitPoints + "> points damage.");
			System.out.println(this.getName() + " now has " + getHitPoints() + " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(this.getName() + " has been killed :-(");
	}

	public double getChanceToHit(){
		return chanceToHit;
	}

	public int getDamageMin(){
		return damageMin;
	}

	public int getDamageMax(){
		return damageMax;
	}
	
	public int getHitPoints(){
		return this.hitPoints;
	}
	
	public int getAttackSpeed(){
		return this.attackSpeed;
	}
	
	public String getName(){
		return this.name;
	}
}