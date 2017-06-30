public class silverBalls extends decorations{

	public silverBalls(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| silver balls";
	}

	@Override
	public double cost(){
		return 3.00 + tree.cost();
	}
}