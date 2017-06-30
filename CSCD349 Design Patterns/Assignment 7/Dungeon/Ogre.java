package Dungeon;

public class Ogre extends Monster{
	public Ogre(){
		super(200, 2, .6, .1, 30, 50, 30, 50);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " slowly swings a club toward's " + opponent.getName() + ":");
		super.attack(opponent);
	}
}