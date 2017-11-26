package etuninghw3;

import java.io.Serializable;

public class MyText implements Serializable {
    
    public String TEXT;
    public double RED;
    public double GREEN;
    public double BLUE;
    
    public MyText(String text, double red, double green, double blue) {
        
        TEXT = text;
        RED = red;
        GREEN = green;
        BLUE = blue;
        
    }
    
    @Override
    public String toString() {
        
        return TEXT + "\nRed: " + RED + "\nGreen: " + GREEN + "\nBlue: " + BLUE;
        
    }
}