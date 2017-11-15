/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etuninghw2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 *
 * @author etuni
 */
public class MyAnimation extends Region{

    private Canvas mCanvas;

    private final double mAspectRatio = 30.0/40.0;
    private DoubleProperty mPosition;
    private DoubleProperty minHeight;
    private DoubleProperty maxHeight;
    private final int mWidth = 30;
    private final int mHeight = 40;
    private GraphicsContext mGc;
    
    public MyAnimation() {
        
        
        mCanvas = new Canvas();
        getChildren().add(mCanvas);
        mGc = mCanvas.getGraphicsContext2D();
        mPosition = new SimpleDoubleProperty(150);
        minHeight = new SimpleDoubleProperty(150);
        maxHeight = new SimpleDoubleProperty(150);
        setPrefSize(mWidth * 100, mHeight * 100);
    }
    
    @Override
    public void layoutChildren() {

        double lWidth = getWidth();
        double lHeight = getHeight();
        double width = lHeight * mAspectRatio;
        double height = width / mAspectRatio;
        if (height > height) {
            
            mCanvas.setHeight(height);
            mCanvas.setWidth(width);
            
        } else {
            
            mCanvas.setHeight(height);
            mCanvas.setWidth(width);
            
        }
        layoutInArea(mCanvas, 0, 0, width, height, 0, HPos.CENTER, VPos.CENTER);
        draw();

    }
    
    public void draw() {
        
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        double scaleX = mCanvas.getWidth() / mWidth;
        double scaleY = mCanvas.getHeight() / mHeight;
        gc.fillRect(100, 150, 100, 50);
        drawSpring(150);
         
    }
    
    public void drawSpring(double position) {
        
        double rad = position / 11;
        double pos = 0.0;
        
        for (int i = 0; i < 10; i++) {
            mGc.strokeOval(mCanvas.getWidth() / 2, pos, 25, rad * 2);
            pos += rad;
        }
        
    }
    
    public void update(double position) {
        
        mGc.clearRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        double scaleX = mCanvas.getWidth()/mWidth;
        double scaleY = mCanvas.getHeight()/mHeight;
        mGc.setStroke(Color.BLACK);
        double y = 7.75 * position;
        double bottom = y + 50;
        mGc.fillRect(100, 150 + y, 100, 50);
        drawSpring(150 + y);
        mPosition.set(bottom);
        
        if (bottom < minHeight.get()) {
            
            minHeight.set(bottom);
            
        }
        if (bottom > maxHeight.get()) {
            
            maxHeight.set(bottom);
            
        }
        
    }
    
    public DoubleProperty positionProperty() {
        
        return mPosition;
        
    }
    
    public DoubleProperty minYProperty() {
        
        return minHeight;
        
    }
    
    public DoubleProperty maxYProperty() {
        
        return maxHeight;
        
    }
}
