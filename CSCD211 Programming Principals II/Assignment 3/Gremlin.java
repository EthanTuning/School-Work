import java.util.*;

public class Gremlin extends Monsters
{
   @Override
   public void attack(DungeonCharacter opponent)
   {
      Random rand = new Random();
   		
		if(rand.nextDouble() < this.accuracy)
		{
			int damage = minDamage + (int)(rand.nextDouble() * (maxDamage-minDamage));
			opponent.hP = opponent.hP - damage;
         System.out.println(this.name+" hit you for "+ damage +" HP.");
         System.out.println("Your health is now:"+opponent.hP);
		}
		else
			System.out.println(this.name + " missed.");
   }
    
   public Gremlin()
   {
      super(70, 5, 15, 30, .8, .4, 60, 30);
      this.name = ("Grimey Gremlin");
   }
}