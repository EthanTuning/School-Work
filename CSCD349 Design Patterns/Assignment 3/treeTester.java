public class treeTester{

	public static void main(String[] args){
		christmasTree myTree = new douglasFir();
		myTree = new ruffles(myTree);
		myTree = new leds(myTree);
		myTree = star.newStar(myTree);
		myTree = new blueBalls(myTree);
		printtree(myTree);
		
		myTree = new balsamFir();
		printtree(myTree);
		
		myTree = new fraserFir();
		myTree = new silverBalls(myTree);
		myTree = star.newStar(myTree);
		myTree = star.newStar(myTree);
		printtree(myTree);
	}
	
	public static void printtree(christmasTree tree){
		System.out.println("Your " + tree.description() + " costs: $" + tree.cost() + "0.");
	}
}