package shapes;

class triangle extends shape{

	triangle(double height, double length){
		super("triangle", height, length);
	}
	
	@Override
	double computeArea(){
		return this.height * this.length/2;
	}
}