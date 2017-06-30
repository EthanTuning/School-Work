package Dungeon;

class Warrior extends Hero{
	
	public Warrior(){
		super(125, 4, .8, 35, 60, .2);
	}
	
	public void crushingBlow(DungeonCharacter opponent){
		CrushingBlow crushingBlow = new CrushingBlow();
		crushingBlow.attack(this, opponent);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " swings a mighty sword at " + opponent.getName() + ":");
		super.attack(opponent);
	}
}