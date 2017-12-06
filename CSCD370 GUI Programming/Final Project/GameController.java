package pacman;

import java.io.File;
import java.net.URL;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class GameController {

    private Pacman mPacman;
    private BorderPane mRoot;
    private Set<Cake> mCakes;
    private Set<Ghost> mGhosts;
    private AnimationTimer mLeftAnimation;
    private AnimationTimer mRightAnimation;
    private AnimationTimer mUpAnimation;
    private AnimationTimer mDownAnimation;
    private Maze mMaze;
    private int mLives;
    private int mScore;
    private Score mScoreBoard;
    private boolean mIsGameEnded;
    private int mCakesEaten;
    private boolean mIsOnToLevelTwo;
    private boolean mIsCheatEnabled;
    private boolean mIsStarted;

    GameController(BorderPane root) {
        
        mRoot = root;
        mMaze = new Maze();
        mPacman = new Pacman(2.5 * Wall.THICKNESS, 2.5 * Wall.THICKNESS);
        mCakes = new HashSet<>();
        mGhosts = new HashSet<>();
        mLeftAnimation = createAnimation("left");
        mRightAnimation = createAnimation("right");
        mUpAnimation = createAnimation("up");
        mDownAnimation = createAnimation("down");
        mLives = 3;
        mScore = 0;
        mCakesEaten = 0;
        mIsOnToLevelTwo = false;
        mIsCheatEnabled = false;
        mIsStarted = true;
        
    }

    public void pause(KeyEvent event) {
        
        if(event.getCode() == KeyCode.SPACE){
            
            pause();

        }
        
    }
    
    public void pause() {

        for(Ghost ghost: mGhosts){

            ghost.stopAnimation();

        }
        mLeftAnimation.stop();
        mRightAnimation.stop();
        mUpAnimation.stop();
        mDownAnimation.stop();
        
    }
    
    private void lifeLost() {
        
        URL resource = getClass().getResource("/sounds/death.wav");
        AudioClip clip = new AudioClip(resource.toString());
        clip.play(1);
     
        mLeftAnimation.stop();
        mRightAnimation.stop();
        mUpAnimation.stop();
        mDownAnimation.stop();
        
        for (Ghost ghost : mGhosts) {
            
            ghost.getAnimation().stop();
            
        }
        
        mPacman.setCenterX(2.5 * Wall.THICKNESS);
        mPacman.setCenterY(2.5 * Wall.THICKNESS);
        mLives--;
        mScore -= 10;
        mScoreBoard.getLives().setText("Lifes: " + mLives);
        mScoreBoard.getScore().setText("Score: " + mScore);
        
        if (mLives == 0) {
            
            loserEndGame();
            
        }
    }
    
    private void clearBoard() {
        
        mRoot.getChildren().remove(mPacman);
        
        for (Ghost ghost : mGhosts) {
            
            mRoot.getChildren().remove(ghost);
            
        }
        for(Cake cake: mCakes) {

            mRoot.getChildren().removeAll(mCakes);
            mCakes.remove(cake);

        }
 
        mRoot.getChildren().remove(mScoreBoard.getScore());
        mRoot.getChildren().remove(mScoreBoard.getLives());        
    }

    private void setText(Text text) {
        
        text.setX(Wall.THICKNESS * 3);
        text.setY(Wall.THICKNESS * 28);
        text.setFont(Font.font("Arial", 40));
        text.setFill(Color.WHITE);
        
        mRoot.getChildren().add(text);
        
    }
    
    private void loserEndGame() {
        
        mIsGameEnded = true;

        Text text = new Text("You lose. Press ESC to restart");
        
        clearBoard();
        
        setText(text);
    }
    

    
    private void nextLevel() {

        if (mIsOnToLevelTwo){
                
            mIsOnToLevelTwo = false;
            mIsGameEnded = true;

            Text text = new Text("You won! Press ESC to restart");

            clearBoard();

            setText(text);
                
        }
        
        else if (!mIsOnToLevelTwo) {
            
            mIsOnToLevelTwo = true;
            mIsGameEnded = false;

            Text text = new Text("You beat the level! Press ESC to start next level.");

            clearBoard();

            setText(text);
        }
    }

    public void restartGame(KeyEvent event) {
        
        if (event.getCode() == KeyCode.ESCAPE && mIsGameEnded) {
            
            mIsStarted = true;
            mIsGameEnded = false;
            mRoot.getChildren().clear();
            mCakes.clear();
            mGhosts.clear();
            drawBoard();
            mPacman.setCenterX(2.5 * Wall.THICKNESS);
            mPacman.setCenterY(2.5 * Wall.THICKNESS);
            mLives = 3;
            mScore = 0;
            mCakesEaten = 0;
            
        }
        
        if (event.getCode() == KeyCode.ESCAPE  && !mIsGameEnded) {
            
            mIsStarted = true;
            mIsGameEnded = false;
            mRoot.getChildren().clear();
            mCakes.clear();
            mGhosts.clear();
            drawBoard();
            mPacman.setCenterX(2.5 * Wall.THICKNESS);
            mPacman.setCenterY(2.5 * Wall.THICKNESS);
            mLives = 3;
            mScore = 0;
            mCakesEaten = 0;
            
        }
    }
    
    public void cheatCode(KeyEvent event) {
        
        if(event.getCode() == KeyCode.HOME) {
            
            mIsStarted = false;
            mCakes.clear();
            
            for(Cake cake: mCakes) {
                
                mCakes.remove(cake);
                mRoot.getChildren().remove(cake);
                
            }
            drawCakesCheat();
        }
    }

    public void drawBoard() {
        
        if(!mIsOnToLevelTwo  && !mIsCheatEnabled){
            
            mMaze.CreateMazeLevelOne(mRoot);
            mScoreBoard = new Score(mRoot);
            mRoot.getChildren().add(mPacman);
            generateGhosts();
            mRoot.getChildren().addAll(mGhosts);
            
        }
        
        if(mIsOnToLevelTwo && !mIsCheatEnabled){
            
            mMaze.CreateMazeLevelTwo(mRoot);
            mScoreBoard = new Score(mRoot);
            mRoot.getChildren().add(mPacman);
            generateGhosts();
            mRoot.getChildren().addAll(mGhosts);
            
        }
        

        
        
    }
    
    public void drawCakes(KeyEvent event) {
        
        if(event.getCode() != KeyCode.HOME && event.getCode() != KeyCode.ESCAPE && !mIsOnToLevelTwo && mIsStarted && !mIsGameEnded) {
            
            mIsStarted = false;
            drawCakesLevelOne();
            
        }
        
        if(event.getCode() != KeyCode.HOME && event.getCode() != KeyCode.ESCAPE && mIsOnToLevelTwo && mIsStarted &&  !mIsGameEnded) {
            
            mIsStarted = false;
            drawCakesLevelTwo();
            
        }
        
    }
    
    private void drawCakesCheat() {
        
        Integer row2[] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        putCakesDown(row2, 2.5);
        
    }
    
    private void drawCakesLevelOne() {
        
            Integer row1[] = new Integer[]{5, 17};
            Integer row2[] = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
            Integer row3[] = new Integer[]{1, 21};
            Integer row4[] = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
            Integer row5[] = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
            Integer row6[] = new Integer[]{3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19};
            Integer row7[] = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
            Integer row8[] = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
            Integer row9[] = new Integer[]{1, 21};
            Integer row10[] = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
            Integer row11[] = new Integer[]{5, 17};
            
            putCakesDown(row1, 2.5);
            putCakesDown(row2, 4.5);
            putCakesDown(row3, 6.5);
            putCakesDown(row4, 8.5);
            putCakesDown(row5, 10.5);
            putCakesDown(row6, 12.5);
            putCakesDown(row7, 14.5);
            putCakesDown(row8, 16.5);
            putCakesDown(row9, 18.5);
            putCakesDown(row10, 20.5);
            putCakesDown(row11, 22.5);
        
    }

    private void drawCakesLevelTwo() {
        
            Integer row1[] = new Integer[]{5, 17};
            Integer row2[] = new Integer[]{1, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17};
            Integer row3[] = new Integer[]{};
            Integer row4[] = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21};
            Integer row5[] = new Integer[]{7, 8, 9, 10, 11, 12, 13, 14, 15};
            Integer row6[] = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21};
            Integer row7[] = new Integer[]{7, 8, 9, 10, 11, 12, 13, 14, 15};
            Integer row8[] = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21};
            Integer row9[] = new Integer[]{};
            Integer row10[] = new Integer[]{1, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17};
            Integer row11[] = new Integer[]{5, 17};
            
            putCakesDown(row1, 2.5);
            putCakesDown(row2, 4.5);
            putCakesDown(row3, 6.5);
            putCakesDown(row4, 8.5);
            putCakesDown(row5, 10.5);
            putCakesDown(row6, 12.5);
            putCakesDown(row7, 14.5);
            putCakesDown(row8, 16.5);
            putCakesDown(row9, 18.5);
            putCakesDown(row10, 20.5);
            putCakesDown(row11, 22.5);
        
    }    
    
    private void putCakesDown(Integer[] skip, double row) {
        
        for (int i = 0; i < 23; i++) {
            
            if (!Arrays.asList(skip).contains(i)) {
                
                Cake cake = new Cake(((2 * i) + 2.5) * Wall.THICKNESS, row * Wall.THICKNESS);
                mCakes.add(cake);
                mRoot.getChildren().add(cake);
                
            }
        }    
    }
    
    public void generateGhosts() {
        
        mGhosts.add(new Ghost(18.5 * Wall.THICKNESS, 12.5 * Wall.THICKNESS, Color.LIGHTBLUE, mMaze, this));
        mGhosts.add(new Ghost(22.5 * Wall.THICKNESS, 12.5 * Wall.THICKNESS, Color.PINK, mMaze, this));
        
        if(mIsOnToLevelTwo) {
            
            addGhost();
            addGhost();
            
        }
        
    }
    
    public void addGhost() {
        
        mRoot.getChildren().removeAll(mGhosts);
        mGhosts.add(new Ghost(28.5 * Wall.THICKNESS, 12.5 * Wall.THICKNESS, Color.color(Math.random(), Math.random(), Math.random()), mMaze, this));
        mRoot.getChildren().addAll(mGhosts);
        
        if(mIsOnToLevelTwo) {
            
            for(Ghost ghost: mGhosts){
                
                ghost.speedUp(7);
                
            }
            
        }
        
    }

    public void movePacman(KeyEvent event) {
        
        URL resource = getClass().getResource("/sounds/eat.wav");
        AudioClip clip = new AudioClip(resource.toString());
        clip.play(1);   
        
        for (Ghost ghost : mGhosts) {
            
            ghost.run();
            
        }
        
        switch(event.getCode()) {
            
            case RIGHT:
                mRightAnimation.start();
                mPacman.mouthOpenRight();
                break;
                
            case LEFT:
                mLeftAnimation.start();
                mPacman.mouthOpenLeft();
                break;
                
            case UP:
                mUpAnimation.start();
                mPacman.mouthOpenUp();
                break;
                
            case DOWN:
                mPacman.mouthOpenDown();
                mDownAnimation.start();
                break;
        }
    }

    public void stopPacman(KeyEvent event) {
        
        switch(event.getCode()) {
            case RIGHT:
                mRightAnimation.stop();
                mPacman.mouthClosed();
                break;
                
            case LEFT:
                mLeftAnimation.stop();
                mPacman.mouthClosed();
                break;
                
            case UP:
                mUpAnimation.stop();
                mPacman.mouthClosed();
                break;
                
            case DOWN:
                mDownAnimation.stop();
                mPacman.mouthClosed();
                break;
        }
    }

    private AnimationTimer createAnimation(String direction) {
        
        double step = 5;
        
        return new AnimationTimer() {
            
            public void handle(long currentNanoTime) {
                
                switch (direction) {

                    case "left":
                        if (!mMaze.isTouching(mPacman.getCenterX() - mPacman.getRadiusX(), mPacman.getCenterY(), 15)) {

                            mPacman.setCenterX(mPacman.getCenterX() - step);
                            checkCakes(mPacman, "x");
                            checkGhost();

                        }
                        break;

                    case "right":
                        if (!mMaze.isTouching(mPacman.getCenterX() + mPacman.getRadiusX(), mPacman.getCenterY(), 15)) {

                            mPacman.setCenterX(mPacman.getCenterX() + step);
                            checkCakes(mPacman, "x");
                            checkGhost();

                        }
                        break;

                    case "up":
                        if (!mMaze.isTouching(mPacman.getCenterX(), mPacman.getCenterY() - mPacman.getRadiusY(), 15)) {

                            mPacman.setCenterY(mPacman.getCenterY() - step);
                            checkCakes(mPacman, "y");
                            checkGhost();

                        }
                        break;

                    case "down":
                       if (!mMaze.isTouching(mPacman.getCenterX(), mPacman.getCenterY() + mPacman.getRadiusY(), 15)) {

                           mPacman.setCenterY(mPacman.getCenterY() + step);
                           checkCakes(mPacman, "y");
                           checkGhost();

                       }
                       break;
                }
            }
        };
    }
    
    private void checkCakes(Pacman mPacman, String axis) {
        
        double pacmanY = mPacman.getCenterY();
        double pacmanX = mPacman.getCenterX();
        double pacmanLeft = pacmanX - mPacman.getRadiusX();
        double pacmanRight = pacmanX + mPacman.getRadiusX();
        double pacmanTop = pacmanY - mPacman.getRadiusY();
        double pacmanBottom = pacmanY + mPacman.getRadiusY();
        
        for (Cake cake:mCakes) {
            
            double cakeCenterX = cake.getCenterX();
            double cakeCenterY = cake.getCenterY();
            double cakeLeftEdge = cakeCenterX - cake.getRadius();
            double cakeRightEdge = cakeCenterX + cake.getRadius();
            double cakeTopEdge = cakeCenterY - cake.getRadius();
            double cakeBottomEdge = cakeCenterY + cake.getRadius();
            
            if (axis.equals("x")) {
                
                if ((cakeCenterY >= pacmanTop && cakeCenterY <= pacmanBottom) && (pacmanRight >= cakeLeftEdge && pacmanRight <= cakeRightEdge)) {
                    
                    if (cake.isVisible()) {
                        
                        mScore += cake.getValue();
                        mCakesEaten++;
                        
                    }
                    cake.hide();
                }

                if ((cakeCenterY >= pacmanTop && cakeCenterY <= pacmanBottom) && (pacmanLeft >= cakeLeftEdge && pacmanLeft <= cakeRightEdge)) {
                    
                    if (cake.isVisible()) {
                        
                        mScore += cake.getValue();
                        mCakesEaten++;
                        
                    }
                    cake.hide();
                }
                
            } else {
                
                if ((cakeCenterX >= pacmanLeft && cakeCenterX <= pacmanRight) && (pacmanBottom >= cakeTopEdge && pacmanBottom <= cakeBottomEdge)) {
                    
                    if (cake.isVisible()) {
                        
                        mScore += cake.getValue();
                        mCakesEaten++;
                        
                    }
                    cake.hide();
                }

                if ((cakeCenterX >= pacmanLeft && cakeCenterX <= pacmanRight) && (pacmanTop <= cakeBottomEdge && pacmanTop >= cakeTopEdge)) {
                    
                    if (cake.isVisible()) {
                        
                        mScore += cake.getValue();
                        mCakesEaten++;
                        
                    }
                    cake.hide();
                }
            }
            
            mScoreBoard.getScore().setText("Score: " + mScore);
            
            if (mCakesEaten == mCakes.size()) {
                
                nextLevel();
                
            }
        }
    }

    public void checkGhost() {
        
        double pacmanY = mPacman.getCenterY();
        double pacmanX = mPacman.getCenterX();
        double pacmanLeft = pacmanX - mPacman.getRadiusX();
        double pacmanRight = pacmanX + mPacman.getRadiusX();
        double pacmanTop = pacmanY - mPacman.getRadiusY();
        double pacmanBottom = pacmanY + mPacman.getRadiusY();
        
        for (Ghost ghost : mGhosts) {
            
            double ghostLeftEdge = ghost.getX();
            double ghostRightEdge = ghost.getX() + ghost.getWidth();
            double ghostTopEdge = ghost.getY();
            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
            
            if ((pacmanLeft <= ghostRightEdge && pacmanLeft >= ghostLeftEdge) || (pacmanRight >= ghostLeftEdge && pacmanRight <= ghostRightEdge)) {
                
                if ((pacmanTop <= ghostBottomEdge && pacmanTop >= ghostTopEdge) || (pacmanBottom >= ghostTopEdge && pacmanBottom <= ghostBottomEdge)) {
                    
                    lifeLost();
                    
                }
            }
        }
    }
}