package dungeon;

import java.util.HashMap;
import java.util.Map;

public class AttackFactory {
	//AttackBehavior atackBehavior;
	private static final Map<String, AttackBehavior> attackPool = new HashMap<String, AttackBehavior>();
	
	public AttackBehavior getAttack(String attackName) {
		AttackBehavior attackBehavior = attackPool.get(attackName);
		
		if(attackBehavior == null) {
			if(attackName.equalsIgnoreCase("CrushingBlowAttack")) {
				attackBehavior = new CrushingBlowAttack();
			}
			else if(attackName.equalsIgnoreCase("HealAttack")) {
				attackBehavior = new HealAttack();
			}
			else if(attackName.equalsIgnoreCase("SurpriseAttack")) {
				attackBehavior = new SurpriseAttack();
			}
			else if(attackName.equalsIgnoreCase("BasicAttack")) {
				attackBehavior = new BasicAttack();
			}
			else if(attackName.equalsIgnoreCase("FireBallAttack")) {
				attackBehavior = new FireBallAttack();
			}
			else if(attackName.equalsIgnoreCase("SwordAttack")) {
				attackBehavior = new SwordAttack();
			}
			attackPool.put(attackName, attackBehavior);
		}
		return attackBehavior;
	}
}
