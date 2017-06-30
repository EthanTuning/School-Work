package Dungeon;

public class Gremlin extends Monster{
	public Gremlin(){
		super(70, 5, .8, .4, 15, 30, 20, 40);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " jabs his kris at " + opponent + ":");
		super.attack(opponent);
	}
}