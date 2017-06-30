public class star extends decorations{

	private star(christmasTree tree){
		this.tree = tree;
	}
	
	public static christmasTree newStar(christmasTree tree){
		if(!tree.description().contains("star"))
			return new star(tree);
		System.out.println("Your tree already has a star!!");
		return tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| star";
	}

	@Override
	public double cost(){
		return 4.00 + tree.cost();
	}
}