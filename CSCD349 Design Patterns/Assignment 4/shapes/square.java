package shapes;

class square extends shape{

	square(double height){
		super("square", height, height);
	}
	
	@Override
	double computeArea(){
		return this.height * this.length;
	}
}