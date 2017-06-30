package dungeon;

import java.util.ArrayList;
import java.util.Random;

public class MonsterFactory {
	private Monster monster;
	private AttackFactory attackFactory;
	private ArrayList<String> monsterNames;
	
	public MonsterFactory() {
		this.attackFactory = new AttackFactory();
		monsterNames = new ArrayList<String>();
		
		monsterNames.add("Ogre");
		monsterNames.add("Skeleton");
		monsterNames.add("Gremlin");
		monsterNames.add("Megatron");
		monsterNames.add("Swiper");
	}
	
	public Monster getMonster() {
		//radnom generate a monster and return it
		
		Random rand = new Random();
		int nameIndex = rand.nextInt(5);
		String monsterName = monsterNames.get(nameIndex);
		
		if(monsterName.equals("Ogre")) {
			monster = new Monster("Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
			monster.setAttackBehavior(attackFactory.getAttack("BasicAttack"));
		}
		else if(monsterName.equalsIgnoreCase("Skeleton")) {
			monster = new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
			monster.setAttackBehavior(attackFactory.getAttack("BasicAttack"));
		}
		else if(monsterName.equalsIgnoreCase("Gremlin")) {
			monster = new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
			monster.setAttackBehavior(attackFactory.getAttack("BasicAttack"));
		}
		else if(monsterName.equalsIgnoreCase("Megatron")) {
			monster = new Monster("Mega-Megatron", 200, 8, .9, .8, 20, 50, 30, 60);
			monster.setAttackBehavior(attackFactory.getAttack("BasicAttack"));
		}
		else if(monsterName.equalsIgnoreCase("Swiper")) {
			monster = new Monster("Swiper", 200, 8, .9, .8, 20, 50, 30, 60);
			monster.setAttackBehavior(attackFactory.getAttack("BasicAttack"));
		}
		return monster;
	}
}
