public class ruffles extends decorations{

	public ruffles(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| ruffles";
	}

	@Override
	public double cost(){
		return 2.00 + tree.cost();
	}
}