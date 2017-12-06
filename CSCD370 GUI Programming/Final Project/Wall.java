package pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Rectangle {

    public final static double THICKNESS = 25;

    public Wall(double x, double y, String orientation, double length) {
        
        setX(x);
        setY(y);
        
        if (orientation.equals("horizontal")) {
            
            setHeight(Wall.THICKNESS);
            setWidth(length * Wall.THICKNESS);
            
        } else {
            
            setHeight(length * Wall.THICKNESS);
            setWidth(Wall.THICKNESS);
            
        }
        
        setFill(Color.BLUE);
        setStrokeWidth(2);
    }
}