import java.util.*;

public abstract class DungeonCharacter 
{
	protected String name;
	protected int hP;
	protected int attSpeed;
	protected int minDamage;
	protected int maxDamage;
	protected double accuracy;
	
	public DungeonCharacter(int hP, int attSpeed, int minDamage, int maxDamage, double accuracy)
	{
		this.hP = hP;
		this.accuracy = accuracy;
		this.attSpeed = attSpeed;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}
	
   public void attack(DungeonCharacter opponent)
	{
		Random rand = new Random();
		
		if(rand.nextDouble() < this.accuracy)
		{
			int damage = minDamage + (int)(rand.nextDouble() * (maxDamage-minDamage));
			opponent.hP = opponent.hP - damage;
			System.out.println(opponent.name + " got hit for " + damage + "HP.");
			System.out.println(opponent.name + " now has " + opponent.hP + "HP.");
		}
		else
			System.out.print(this.name + " missed.");
	}
	
   
   public boolean alive()
   {
      if (this.hP > 0)
         return true;
      else
         return false;
   }
	
	@Override
	public String toString(){ return name; }
   
   public int getAttSpeed()
   {
      return this.attSpeed;
   }
}
