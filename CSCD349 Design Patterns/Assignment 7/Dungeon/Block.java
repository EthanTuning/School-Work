package Dungeon;

public class Block implements Defend{
	boolean isBlocked;
	
	@Override
	public void defend(DungeonCharacter character){
		if(character instanceof Hero){
			this.isBlocked = Math.random() <= ((Hero)character).getChanceToBlock();
		}
	}
}