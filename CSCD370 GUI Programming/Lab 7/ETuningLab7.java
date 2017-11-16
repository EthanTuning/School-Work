package etuninglab7;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ETuningLab7 extends Application {

    private static Label mStatus;
    private static Text mainText;
    private static BorderPane root = new BorderPane();
    private static Preferences mPreferences;

    @Override
    public void start(Stage primaryStage) throws Exception {

        OptionsData.readPreferences(getClass());
        mPreferences = Preferences.userNodeForPackage(getClass());
        mPreferences.addPreferenceChangeListener(this::onPrefChanged);
        
        root.setTop(buildMenus());
        
        mStatus = new Label("Everything is Copacetic");
        ToolBar toolBar = new ToolBar(mStatus);
        root.setBottom(toolBar);
        
        setText();
        
        Scene scene = new Scene(root, 400, 450);

        primaryStage.setTitle("My Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void onPrefChanged(PreferenceChangeEvent event) {

        Platform.runLater(ETuningLab7::setText);

    }
    
    private void onFirstRun() {
        
        if (mPreferences.getBoolean("FirstRun", true)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText("Welcome!");
            alert.setContentText("Welcome to my application.");
            alert.showAndWait();
            mPreferences.putBoolean("First", false);
        }
        
    }

    private static MenuBar buildMenus() {

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("_File");
        
        MenuItem quitMenuItem = new MenuItem("_Quit");
        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        quitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        MenuItem options = new MenuItem("_Options");
        options.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        options.setOnAction(actionEvent -> onOptions(options));
        fileMenu.getItems().addAll(options, quitMenuItem);
        
        Menu helpMenu = new Menu("_Help");
        MenuItem about = new MenuItem("_About");
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        about.setOnAction(actionEvent -> onAbout());
        helpMenu.getItems().add(about);
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        
        return menuBar;

    }

    private static void onOptions(MenuItem options) {

        try {

            mStatus.setText("Options selected");
            
            OptionsLayoutController optionsController = new OptionsLayoutController();
            optionsController.initModality(Modality.NONE);
            optionsController.show();
            options.setDisable(true);
            optionsController.setOnCloseRequest(actionEvent -> options.setDisable(false));

        } catch (IOException e) {
            
            System.out.print(e.getMessage());
            
        }
    }

    private static void setText() {
        
        if (!OptionsData.displayDateAndTime) {
            
            mainText = new Text(OptionsData.displayString);
            
        } 
        else {

            SimpleDateFormat date = new SimpleDateFormat();
            mainText = new Text(date.format(new Date()));

        }
        if (OptionsData.displayBold && OptionsData.displayItalics) {
            
            mainText.setFont(Font.font(null, 
                                       FontWeight.BOLD, 
                                       FontPosture.ITALIC, 
                                       OptionsData.fontSize));
            
        } 
        else if (OptionsData.displayBold && !OptionsData.displayItalics) {
            
            mainText.setFont(Font.font(null, 
                                       FontWeight.BOLD, 
                                       OptionsData.fontSize));
            
        } 
        else if (!OptionsData.displayBold && OptionsData.displayItalics) {
            
            mainText.setFont(Font.font(null, 
                                       FontPosture.ITALIC, 
                                       OptionsData.fontSize));
            
        } 
        else {
            
            mainText.setFont(new Font(OptionsData.fontSize));
            
        }
        mStatus.setText("Text updated");
        root.setCenter(mainText);
    }

    private static void onAbout() {

        mStatus.setText("About selected");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan Tuning CSCD370 Lab 7, Fall 2017");
        alert.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }
}