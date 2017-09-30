/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etuninglab1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ethan
 */
public class ETuningLab1 extends Application 
implements ChangeListener<String>{
    
    private Label mStatus;
    private ImageView mImageView = new ImageView(new Image("images/logo.png"));
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            setStatus("Hello World!");
        });
        
        ListView<String> listView = new ListView();
        listView.setItems(FXCollections.observableArrayList("First Album", "Cindy", "Fred", "Kate", "Keith", "Matt", "Rickey"));
        listView.getSelectionModel().selectedItemProperty().addListener(this);
        
        BorderPane root = new BorderPane();
        
        root.setLeft(listView);
        listView.setPrefWidth(computeStringWidth("First Album") + 20);
        root.setCenter(mImageView);
        btn.prefWidthProperty().bind(primaryStage.widthProperty().divide(2));
        
        root.setTop(buildMenus());
        
        mStatus = new Label("Everything is Copacetic");
        ToolBar toolBar = new ToolBar(mStatus);
        root.setBottom(toolBar);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Lab 1, Fall 2017");
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
        mStatus.setText(status);
    }
    
    private double computeStringWidth(String s) {
        final Text text = new Text(s);
        return text.getLayoutBounds().getWidth();
    }
    
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if(newValue.equals("Cindy")) {
            mImageView.setImage( new Image(("images/cindy.png")));
            setStatus("Cindy Wilson (Percussion since 1976)");
        }
        
        if(newValue.equals("Fred")) {
            mImageView.setImage( new Image(("images/fred.png")));
            setStatus("Fred Schneider (Vocals, Cowbell, since 1976)");
        }
        
        if(newValue.equals("Kate")) {
            mImageView.setImage( new Image(("images/kate.png")));
            setStatus("Kate Pierson (Organ since 1976)");
        }
        
        if(newValue.equals("Keith")) {
            mImageView.setImage(new Image(("images/keith.png")));
            setStatus("Keith Strickland (Drums, Guitar, since 1976)");
        }
        
        if(newValue.equals("Matt")) {
            mImageView.setImage(new Image(("images/matt.png")));
            setStatus("Matt Flynn (Touring, Drums, prior to 2004)");
        }
        
        if(newValue.equals("Rickey")) {
            mImageView.setImage(new Image(("images/rickey.png")));
            setStatus("Ricky Wilson, deceased (Bass, 1976-1985)");
        }

        if(newValue.equals("First Album")) {
            mImageView.setImage(new Image(("images/logo.png")));
            setStatus("Everything is Copacetic");
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
