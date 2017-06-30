package Dungeon;

class Sorceress extends Hero{
	
	public Sorceress(){
		super(75, 5, .7, 25, 50, .3);
	}
	
	public void heal(){
		Heal heal = new Heal();
		heal.defend(this);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}
}