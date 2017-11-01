/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etuninglab6;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author etuni
 */
public class MainApplicationController implements Initializable {

    @FXML
    private MenuItem optionsBtn;
    @FXML
    private MenuItem aboutBtn;
    @FXML
    private Label mStatus;
    @FXML
    private BorderPane mainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mainPane.setCenter(new Text("Do File -> Options to change this."));
        
    }    

    @FXML
    private void onOptionsClick(ActionEvent event) {
        
        try {
            OptionsLayoutController options = new OptionsLayoutController();
            Optional<ButtonType> okBtn = options.showAndWait();
            
            if(okBtn.isPresent()){
                int result = okBtn.get().getButtonData().compareTo(ButtonData.OK_DONE);
                
                if(result == 0){
                    mStatus.setText("Options updated.");
                    
                    OptionsData optionsData = new OptionsData();
                    
                    if(!optionsData.displayDateAndTime) {
                        FontWeight fontWeight;
                        FontPosture fontPosture;

                        if(optionsData.displayBold)
                            fontWeight = FontWeight.BOLD;
                        else
                            fontWeight = FontWeight.NORMAL;

                        if(optionsData.displayItalics)
                            fontPosture = FontPosture.ITALIC;
                        else
                            fontPosture = FontPosture.REGULAR;

                        Text text = new Text(optionsData.displayString);

                        text.setFont(Font.font("Segoe UI", 
                                                fontWeight, 
                                                fontPosture, 
                                                optionsData.fontSize));
                        
                        mainPane.setCenter(text);
                    }
                    else {
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat();
                        Date dateTime = new Date();
                        Text text = new Text(dateFormat.format(dateTime));
                        
                        mainPane.setCenter(text);
                    }
                    
                }
                else {
                    mStatus.setText("Canceled options.");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onAboutClick(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Lab 6, Fall 2017");
        alert.showAndWait();
    }
    
    @FXML
    private void onQuit(ActionEvent event) {
        
        Platform.exit();
    }
}
