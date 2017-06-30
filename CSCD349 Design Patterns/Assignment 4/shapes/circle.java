package shapes;

class circle extends shape{

	circle(double height){
		super("circle", height, height);
	}
	
	@Override
	double computeArea(){
		return this.height * this.length * Math.PI;
	}
}