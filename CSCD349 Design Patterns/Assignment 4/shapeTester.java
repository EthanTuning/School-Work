import shapes.shapeFactory;
import shapes.shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class shapeTester{
	public static void main(String[] args){
		
		try{
			ArrayList<shape> shapeArray = new ArrayList<>();
			shapeArray.add(shapeFactory.createShape("circle", 2));
			shapeArray.add(shapeFactory.createShape("rectangle", 2, 6));
			shapeArray.add(shapeFactory.createShape("triangle", 1, 1));
			shapeArray.add(shapeFactory.createShape("square", 6));
			shapeArray.add(shapeFactory.createShape("circle", 8));
			shapeArray.add(shapeFactory.createShape("square", 4));
			shapeArray.add(shapeFactory.createShape("triangle", 4, 6));
			
			System.out.println("Our shapes before sort: " + shapeArray);
			
			Collections.sort(shapeArray);
			
			System.out.println("\nOur shapes after sort: " + shapeArray);
			
		}catch(NoSuchElementException e){
			System.out.println("Something went wrong.");
		}
	}
}