package shapes;

public abstract class shape implements Comparable<shape>{
	private String name;
	double height, length;
	
	shape(String name, double height, double length){
		this.name = name;
		this.height = height;
		this.length = length;
	}

	@Override
	public int compareTo(shape that){
		if(that == null)
			throw new NullPointerException();
		
		int firstCompare = this.name.compareTo(that.name);
		
		if(firstCompare == 0){
			double secondCompare = this.computeArea() - that.computeArea();
			
			if(secondCompare < 0)
				return -1;
			
			if(secondCompare > 0)
				return 1;
			
			return 0;
		}
		return firstCompare;
	}
	
	@Override
	public String toString(){
		return "\nThe area of your: " + this.name + " is: " + computeArea();
	}
	
	abstract double computeArea();
}