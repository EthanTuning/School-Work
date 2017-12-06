package pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Pacman extends Arc {

    public Pacman(double x, double y) {
        
        setCenterX(x);
        setCenterY(y);
        setRadiusX(25);
        setRadiusY(25);
        mouthClosed();
        setType(ArcType.ROUND);
        setFill(Color.YELLOW);
        
    }
    
    public void mouthOpenRight() {     
        
        setStartAngle(45);
        setLength(270);
        
    }
    
    public void mouthOpenLeft() {          
        
        setStartAngle(225);
        setLength(270);
    }
    
    public void mouthOpenUp() {        
        
        setStartAngle(135);
        setLength(270);

    }
    
    public void mouthOpenDown() {          
        
        setStartAngle(315);
        setLength(270);

    }
    
    public void mouthClosed() {
        
        setStartAngle(0);
        setLength(360);
        
    }
}
