/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etuninghw2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author etuni
 */
public class ETuningHW2 extends Application {
    
    private static AnimationTimer mTimer = new AnimationTimer(){
        @Override
        public void handle(long time) {
            onTimer(time);
        }
    };
    
    private static MyAnimation mAn = new MyAnimation();
    private static long mTime = 0;
    private static int mCurr = 0;
    private static double mVelocity = 0.0;
    private static double mDisplacement = 0.0;
    private static final double mGrav = 9.80665;
    private static final double mSpringConst = 1.1;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane root = new BorderPane();
        ProgressBar progress = new ProgressBar(0.0);
        root.setCenter(mAn);
        ToolBar toolBar = new ToolBar(progress);
        root.setBottom(progress);
        MenuBar menuBar = new MenuBar();
        Menu help = new Menu("_Help");
        MenuItem about = new MenuItem("_About");
        help.getItems().add(about);
        menuBar.getMenus().add(help);
        root.setTop(menuBar);
        Scene scene = new Scene(root, 300, 400);
        scene.setOnKeyPressed(this::onKey);
        about.setOnAction(actionEvent -> onAbout());
        progress.progressProperty().bind((mAn.positionProperty().subtract(mAn.minYProperty())).divide(mAn.maxYProperty().subtract(mAn.minYProperty()))); 
        
        primaryStage.setTitle("Animation Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private static boolean calc() {

        mCurr++;
        double acceleration = mGrav - (mSpringConst*mDisplacement);
        mVelocity += acceleration * 25 / 1000f;
        mDisplacement += mVelocity * 25 / 1000f;
        mAn.update(mDisplacement);
        return (mCurr < Integer.MAX_VALUE);

    }
    
    private static void onTimer(long time) {

        time = System.currentTimeMillis();
        long elapsed = (time - mTime);
        if (elapsed > 25) {
            
            if (!calc()) {
                
                mTimer.stop();
                mCurr = 0;
                
            }
            mTime = time;
        }

    }
    
    private void onKey(KeyEvent keyEvent) {

        if(keyEvent.getCode() == KeyCode.DOWN)
            mTimer.stop();
        if(keyEvent.getCode() == KeyCode.UP)
            mTimer.start();
    }
    
    private void onAbout() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Homework 2, Fall 2017");
        alert.showAndWait();       
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}