package dungeon;

public class HeroFactory {

	private Hero hero = null;
	private AttackFactory attackFactory;

	public HeroFactory() {

		attackFactory = new AttackFactory();
	}

	/* getHero() creates a hero object and assigns an attack behavior from the attack factory*/
	public Hero getHero(String name) {

		if (name.equalsIgnoreCase("Warrior")) {
			hero = new Hero("Warrior", 125, 4, .8, 35, 60, .2);
			//attackBehavior = attackFactory.getAttack("CrushingBlowAttack");
			hero.setAttackBehavior(attackFactory.getAttack("CrushingBlowAttack"));
		}
		else if (name.equalsIgnoreCase("Thief")) {
			hero = new Hero("Thief", 125, 4, .8, 35, 60, .2);
			hero.setAttackBehavior(attackFactory.getAttack("SurpriseAttack"));
			
		}
		else if (name.equalsIgnoreCase("Sorceres")) {
			hero = new Hero("Sorceress", 125, 4, .8, 35, 60, .2);
			hero.setAttackBehavior(attackFactory.getAttack("HealAttack"));
		}
		else if(name.equalsIgnoreCase("Eagle")) {
			hero = new Hero("Eagle", 150, 7, .8, 35, 60, .2);
			hero.setAttackBehavior(attackFactory.getAttack("FireBallAttack"));
		}
		else if(name.equalsIgnoreCase("Ninja")) {
			hero = new Hero("Ninja", 190, 8, .8, 50, 70, .5);
			hero.setAttackBehavior(attackFactory.getAttack("SwordAttack"));
		}

		return hero;
	}
}
