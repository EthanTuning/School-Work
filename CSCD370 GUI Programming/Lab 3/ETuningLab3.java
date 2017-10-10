package etuninglab3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Ethan
 */
public class ETuningLab3 extends Application {
    
    private Label mStatus;
    
    @Override
    public void start(Stage primaryStage) {
        
        SevenSegment sevSeg1 = new SevenSegment();
        SevenSegment sevSeg2 = new SevenSegment();
        SevenSegment sevSeg3 = new SevenSegment();
        SevenSegment sevSeg4 = new SevenSegment();
        SevenSegment sevSeg5 = new SevenSegment();
        
        Button btn = new Button();
        btn.setText("Increase");
        btn.setOnAction((ActionEvent event) -> {
            increase(sevSeg1, sevSeg2, sevSeg3, sevSeg4, sevSeg5);
        });
        
        GridPane gp = new GridPane();
        gp.add(sevSeg1, 0, 0);
        gp.add(sevSeg2, 1, 0);
        gp.add(sevSeg3, 2, 0);
        gp.add(sevSeg4, 3, 0);
        gp.add(sevSeg5, 4, 0);
        gp.add(btn, 2, 0);
        
        BorderPane root = new BorderPane();
        root.setCenter(gp);
        
        
        root.setTop(buildMenus());
        
        mStatus = new Label("Seven Segment");
        ToolBar toolBar = new ToolBar(mStatus);
        root.setBottom(toolBar);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Seven Segment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Lab 3, Fall 2017");
        alert.showAndWait();
    }
    
    MenuBar buildMenus(){
        MenuBar menuBar = new MenuBar();
        
        Menu fileMenu = new Menu("_File");
        MenuItem quitMenuItem = new MenuItem("_Quit");
        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.CONTROL_DOWN));
        quitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().add(quitMenuItem);
        
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem("_About");
        aboutMenuItem.setOnAction(actionEvent -> onAbout());
        helpMenu.getItems().add(aboutMenuItem);
        
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        
        return menuBar;
    }
    
    void setStatus(String status){
        mStatus = new Label(status);
    }

    private void increase(SevenSegment s1, SevenSegment s2, SevenSegment s3,
                          SevenSegment s4, SevenSegment s5) {
        for(int i = 0; i < 10; i++){
            s1.setCurrentValue(i);
            
            if(s1.getCurrentValue() > 9) {
               s2.setCurrentValue(i);
               return;
            }
            
            if(s2.getCurrentValue() > 9) {
                s3.setCurrentValue(i);
                return;
            }
            
            if(s3.getCurrentValue() > 9) {
                s4.setCurrentValue(i);
                return;
            }
            
            if(s4.getCurrentValue() > 9) {
                s5.setCurrentValue(i);
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}