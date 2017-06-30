package Dungeon;

public class Skeleton extends Monster{
	public Skeleton(){
		super(100, 3, .8, .3, 30, 50, 30, 50);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " slices his rusty blade at " + opponent.getName() + ":");
		super.attack(opponent);
	}
}