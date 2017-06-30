public class lights extends decorations{

	public lights(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| lights";
	}

	@Override
	public double cost(){
		return 5.00 + tree.cost();
	}
}