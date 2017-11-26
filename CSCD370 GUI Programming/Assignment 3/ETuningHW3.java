package etuninghw3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ETuningHW3 extends Application {
    
    private Label mStatus;
    private ToggleGroup mViewGroup = new ToggleGroup();
    private BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) {
        
        MyPanel topPanel = new MyPanel("Hello", .6, .3, .8);
        MyPanel bottomPanel = new MyPanel("World", .3, .5, .9);
        
        VBox container = new VBox();
        container.getChildren().addAll(topPanel, bottomPanel);
        
        root.setCenter(container);
        root.setTop(buildMenus());
        
        mStatus = new Label("Everything is Copacetic");
        ToolBar bottomBar = new ToolBar(mStatus);
        root.setBottom(bottomBar);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Clipboard and CSS");
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    private void onView(int selection) {
        
        if(selection == 1)
            root.getStylesheets().add(getClass()
                                 .getResource("dark.css")
                                 .toExternalForm());
        
        if(selection == 2)
            root.getStylesheets().remove(root.getStylesheets().size()-1);
        
    }

    private MenuBar buildMenus() {
        
        MenuBar menu =  new MenuBar();
        
        Menu file = new Menu("_File");
        MenuItem quit = new MenuItem("_Quit");
        quit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCodeCombination.CONTROL_DOWN));
        quit.setOnAction(actionEvent -> Platform.exit());
        file.getItems().add(quit);
        
        Menu help = new Menu("_Help");
        MenuItem about = new MenuItem("_About");
        about.setOnAction(actionEvent -> onAbout());
        help.getItems().add(about);
        
        Menu view = new Menu("_View");
        RadioMenuItem light = new RadioMenuItem("_Light");
        light.setOnAction(actionEvent -> onView(2));
        light.setToggleGroup(mViewGroup);
        light.setSelected(true);
        
        RadioMenuItem dark = new RadioMenuItem("_Dark");
        dark.setOnAction(actionEvent -> onView(1));
        dark.setToggleGroup(mViewGroup);
        view.getItems().addAll(light, dark);
        
        menu.getMenus().addAll(file, view, help);
        
        return menu;
        
    }
    
    private static void onAbout() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan Tuning CSCD370 Homework 3, Fall 2017");
        alert.showAndWait();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}