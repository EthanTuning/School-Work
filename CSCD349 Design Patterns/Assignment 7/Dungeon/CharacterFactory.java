package Dungeon;

import java.util.NoSuchElementException;

public class CharacterFactory{
	public static DungeonCharacter createCharacter(String type){
		if(type.equals("Warrior")){
			return new Warrior();
		}
		else if(type.equals("Sorceress")){
			return new Sorceress();
		}
		else if(type.equals("Thief")){
			return new Thief();
		}
		else if(type.equals("Gremlin")){
			return new Gremlin();
		}
		else if(type.equals("Ogre")){
			return new Ogre();
		}
		else if(type.equals("Skeleton")){
			return new Skeleton();
		}
		else{
			throw new NoSuchElementException();
		}
	}
}