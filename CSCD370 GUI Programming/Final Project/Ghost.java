package pacman;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Ghost extends Rectangle implements Runnable {

    private String mDirection;
    private GameController mController;
    private Maze mMaze;
    private AnimationTimer mTimer;
    private int mSteps;
    private int mSpeed;

    public Ghost(double x, double y, Color color, Maze maze, GameController controller) {
        
        setX(x);
        setY(y);
        setArcWidth(30);
        setArcHeight(100);
        mMaze = maze;
        mController = controller;
        setHeight(50);
        setWidth(50);
        setFill(color);
        mSteps = 0;
        mDirection = "down";
        createAnimation();
        mSpeed = 5;
        
    }

    private String getDirection(String exclude1, String exclude2) {
        
        String[] mDirections = {"left", "right", "up", "down"};
        int random = new Random().nextInt(mDirections.length);
        
        while (mDirections[random].equals(exclude1) || mDirections[random].equals(exclude2)) {
            
            random = new Random().nextInt(mDirections.length);
            
        }
        
        return mDirections[random];
    }
    
    public AnimationTimer getAnimation() {
        
        return mTimer;
        
    }

    private void checkPath(String direction) {
        
        double right, left, top, bottom;
        
        switch (direction) {
            
            case "down":
                left = getX() - 10;
                bottom = getY() + getHeight() + 15;
                right = getX() + getWidth() + 10;
                
                if (!mMaze.hasWall(left, right, bottom - 1, bottom)) {
                    
                    mDirection = direction;
                    
                }
                break;
                
            case "up":
                left = getX() - 10;
                right = getX() + getWidth() + 10;
                top = getY() - 15;
                
                if (!mMaze.hasWall(left, right, top - 1, top)) {
                    
                    mDirection = direction;
                    
                }
                break;
                
            case "left":
                left = getX() - 15;
                bottom = getY() + getHeight() + 10;
                top = getY() - 10;
                
                if (!mMaze.hasWall(left - 1, left, top, bottom)) {
                    
                    mDirection = direction;
                    
                }
                break;
                
            case "right":
                bottom = getY() + getHeight() + 10;
                right = getX() + getWidth() + 15;
                top = getY() - 10;
                
                if (!mMaze.hasWall(right - 1, right, top, bottom)) {
                    
                    mDirection = direction;
                    
                }
                break;
        }
    }

    private void move(String toGo, String whereTo, double left, double top, double right, double bottom, double padding) {
        
        switch (toGo) {
            
            case "left":
                if (!mMaze.isTouching(left, top, padding)) {
                    
                    setX(left - mSpeed);
                    
                } else {
                    
                    while (mMaze.isTouching(getX(), getY(), padding)) {
                        
                        setX(getX() + 1);
                        
                    }
                    mDirection = whereTo;
                }
                break;
                
            case "right":
                if (!mMaze.isTouching(right, top, padding)) {
                    
                    setX(left + mSpeed);
                
                } else {
                    
                    while (mMaze.isTouching(getX() + getWidth(), getY(), padding)) {
                        
                        setX(getX() - 1);
                        
                    }
                    mDirection = whereTo;
                }
                break;
                
            case "up":
                if (!mMaze.isTouching(left, top, padding)) {
                    
                    setY(top - mSpeed);
                    
                } else {
                    
                    while (mMaze.isTouching(getX(), getY(), padding)) {
                        
                        setY(getY() + 1);
                        
                    }
                    mDirection = "left";
                }
                break;
                
            case "down":
                if (!mMaze.isTouching(left, bottom, padding)) {
                    
                    setY(top + mSpeed);
                    
                } else {
                    
                    while (mMaze.isTouching(getX(), getY() + getHeight(), padding)) {
                        
                        setY(getY() - 1);
                        
                    }
                    mDirection = "right";
                }
                break;
        }
    }
    
    public void stopAnimation() {
        
        mTimer.stop();
        
    }

    public void createAnimation() {

        mTimer = new AnimationTimer() {
            
            public void handle(long currentNanoTime) {
                
                mController.checkGhost();
                double left = getX();
                double top = getY();
                double right = getX() + getWidth();
                double bottom = getY() + getHeight();
                double padding = 12;
                mSteps++;
                int walk = 4;
                
                switch (mDirection) {
                    
                    case "left":
                        move("left", "down", left, top, right, bottom, padding);
                        
                        if (mSteps > walk) {
                            
                            checkPath(getDirection("left", "right"));
                            mSteps = 0;
                            
                        }
                        break;
                        
                    case "right":
                        move("right", "up", left, top, right, bottom, padding);
                        
                        if (mSteps > walk) {
                            
                            checkPath(getDirection("left", "right"));
                             mSteps = 0;
                             
                        }
                        break;
                        
                    case "up":
                        move("up", "left", left, top, right, bottom, padding);
                        
                        if (mSteps > walk) {
                            
                            checkPath(getDirection("up", "down"));
                            mSteps = 0;
                            
                        }
                        break;
                        
                    case "down":
                        move("down", "right", left, top, right, bottom, padding);
                        
                        if (mSteps > walk) {
                            
                            checkPath(getDirection("up", "down"));
                            mSteps = 0;
                            
                        }
                        break;
                }
            }
        };
    }
    
    public void speedUp(int speed) {
        
        mSpeed = speed;
        
    }

    @Override
    public void run() {
        
        mTimer.start();
        
    }
}