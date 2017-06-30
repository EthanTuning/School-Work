public class leds extends decorations{

	public leds(christmasTree tree){
		this.tree = tree;
	}
	
	@Override
	public String description(){
		return tree.description() + "| LED's";
	}

	@Override
	public double cost(){
		return 10.00 + tree.cost();
	}
}