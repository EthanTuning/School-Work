package Dungeon;

class Thief extends Hero{
	
	public Thief(){
		super(75, 6, .8, 20, 40, .5);
	}
	
	public void supriseAttack(DungeonCharacter opponent){
		SupriseAttack supriseAttack = new SupriseAttack();
		supriseAttack.attack(this, opponent);
	}
	
	public void attack(DungeonCharacter opponent){
		System.out.println(this.getName() + " sneaks behind up on" + opponent.getName() + ":");
		super.attack(opponent);
	}
}