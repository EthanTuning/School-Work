package pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cake extends Circle {

    private int mValue;

    public Cake(double x, double y) {
        
        mValue = 5;
        setCenterX(x);
        setCenterY(y);
        setRadius(12.5);
        setFill(Color.WHITE);
        
    }

    public int getValue() {
        
        return mValue;
        
    }

    public void hide() {
        
        this.setVisible(false);
        
    }

    public void show() {
        
        this.setVisible(true);
        
    }
}