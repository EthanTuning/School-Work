public class blueBalls extends decorations{

	public blueBalls(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| blue balls";
	}

	@Override
	public double cost(){
		return 2.00 + tree.cost();
	}
}