public class ribbons extends decorations{

	public ribbons(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| ribbons";
	}

	@Override
	public double cost(){
		return 2.00 + tree.cost();
	}
}