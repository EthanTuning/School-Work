public class redBalls extends decorations{

	public redBalls(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| red balls";
	}

	@Override
	public double cost(){
		return 1.00 + tree.cost();
	}
}