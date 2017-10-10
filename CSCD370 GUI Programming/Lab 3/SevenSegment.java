package etuninglab3;


import java.util.Arrays;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class SevenSegment extends Region {
    private Canvas mCanvas = new Canvas();
    private int currentValue;
    private double[] segmentState = new double[7];
    
    private static final int margin = 2;
    private static final double dimX = 20;
    private static final double dimY = 34;
    private static final double aspectRatio = .588;
    
    private static final Color on = new Color(1.0, 0, 0, 1.0);
    private static final Color off = new Color(1.0, 0, 0, 0.4);
    
    private static final double [] xPoints = {2, 1, 2, 5, 6, 5};
    private static final double [] yPoints = {1, 2, 3, 3, 2, 1};
    
    private static final double [][] states = {{1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
                                               {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                                               {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                                               {1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
                                               {1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                                               {1, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                                               {0, 0, 1, 1, 1, 1, 1, 0, 1, 1}
                                              };
    
    
    public SevenSegment() {
        getChildren().add(mCanvas);
        setPrefSize(20000,34000);
        setCurrentValue(0);
    }
    
    public SevenSegment(int value) {
        getChildren().add(mCanvas);
        setPrefSize(20000,34000);
        setCurrentValue(value);
    }
    
    public int getCurrentValue() {
        return currentValue;
    }
    
    public void setCurrentValue(int value) {
        if(value == 0)
            segmentState = states[0];
        if(value == 1)
            segmentState = states[1];
        if(value == 2)
            segmentState = states[2];
        if(value == 3)
            segmentState = states[3];
        if(value == 4)
            segmentState = states[4];
        if(value == 5)
            segmentState = states[5];
        if(value == 6)
            segmentState = states[6];
        if(value == 7)
            segmentState = states[7];
        if(value == 8)
            segmentState = states[8];
        if(value == 9)
            segmentState = states[9];
        else
            System.out.print("Invalid");
        
        currentValue = value;
    }
    
    public void draw() {
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        double calcX;
        double calcY;
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        
        gc.save();
        calcX = (mCanvas.getWidth() / dimX);
        calcY = (mCanvas.getHeight() / dimY);
        gc.scale(calcX, calcY);
        
        gc.save();
        gc.setFill(segmentState[0] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(8.5, 1.5);
        gc.rotate(90);
        gc.setFill(segmentState[1] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(-1.5, 8.5);
        gc.rotate(270);
        gc.setFill(segmentState[5] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(-1.5, 14);
        gc.rotate(270);
        gc.setFill(segmentState[4] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(8.5, 7);
        gc.rotate(90);
        gc.setFill(segmentState[5] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(0, 5.75);
        gc.setFill(segmentState[6] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.save();
        gc.translate(0, 11.5);
        gc.setFill(segmentState[3] == 0 ? off:on);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.restore();
        
        gc.restore();
    }
    
    @Override
    public void layoutChildren() {
        double avW = getWidth();
        double avH = getHeight();
        double calcH = avW / aspectRatio;
        double calcW = avH * aspectRatio;
        double finalH;
        double finalW;
        
        if(calcH > avH) {
            finalH = avH;
            finalW = calcW;
        }
        else {
            finalH = calcH;
            finalW = avW;
        }
        
        mCanvas.setHeight(finalH);
        mCanvas.setWidth(finalW);
        layoutInArea(mCanvas, 0, 0, finalW, finalH, 0, HPos.CENTER, VPos.CENTER);
        draw();
    }
}