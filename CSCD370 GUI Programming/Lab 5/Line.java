package etuninglab5;
    
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.Serializable;

public class Line implements Serializable
{
    public Point2D.Double mTo, mFrom;
    public int mWidth;
    public transient Color mColor;
    
    public Line(Point2D.Double to, Point2D.Double from, int width, Color color) {
        
        this.mTo = to;
        this.mFrom = from;
        this.mWidth = width;
        this.mColor = color;
    }
    
    public void draw(Canvas canvas) {
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(mWidth);
        gc.setStroke(mColor);
        if(canvas.contains(mTo.x, mTo.y)) {
            gc.strokeLine(mFrom.x, mFrom.y, mTo.x, mTo.y);
        }       
    }
    
    public void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
        } catch (IOException ex) {
            Logger.getLogger(Line.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readObject(ObjectInputStream in) {
        try {
            in.defaultReadObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Line.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
    
    public static Color getNextColor(Color color) {

        if(color == Color.BLACK) {
            return Color.RED;
        } else if (color == Color.RED) {
            return Color.BLUE;
        } else if (color == Color.GREEN) {
            return Color.BLACK;
        } else if (color == Color.BLUE) {
            return Color.GREEN;
        }
        return Color.BLACK;
    }
}