package shapes;

import java.util.NoSuchElementException;

public class shapeFactory{
	
	public static shape createShape(String name, double height, double length) throws NoSuchElementException{
		if(name.equalsIgnoreCase("triangle"))
			return new triangle(height, length);
		
		else if(name.equalsIgnoreCase("rectangle"))
			return new rectangle(height, length);
		else
			throw new NoSuchElementException();
	}
	
	public static shape createShape(String name, double height) throws NoSuchElementException{
		if(name.equalsIgnoreCase("square"))
			return new square(height);
		
		else if(name.equalsIgnoreCase("circle"))
			return new circle(height);
		else
			throw new NoSuchElementException();
	}
}