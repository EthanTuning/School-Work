package shapes;

class rectangle extends shape{

	rectangle(double height, double length){
		super("rectangle", height, length);
	}
	
	@Override
	double computeArea(){
		return this.height * this.length;
	}
}