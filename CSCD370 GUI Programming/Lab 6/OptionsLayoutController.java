/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etuninglab6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Ethan
 */
public class OptionsLayoutController extends Dialog<ButtonType> 
                                     implements Initializable {

    @FXML
    private CheckBox italicsCheck;
    @FXML
    private CheckBox boldCheck;
    @FXML
    private RadioButton showDandTbtn;
    @FXML
    private ToggleGroup toggleGroupRadioBtn;
    @FXML
    private RadioButton showStringBtn;
    @FXML
    private TextField stringToDisplay;
    @FXML
    private TextField textHeight;
    
    private ButtonType mOkBtn;
    
    public OptionsLayoutController()throws IOException {
        
        super();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OptionsLayout.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        
        getDialogPane().setContent(root);
        
        mOkBtn = new ButtonType("OK", ButtonData.OK_DONE);
        ButtonType cancelBtn = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().add(mOkBtn);
        getDialogPane().getButtonTypes().add(cancelBtn);
        
        getDialogPane().lookupButton(mOkBtn).addEventFilter(ActionEvent.ACTION, evt -> {
            onOk(evt);
        }); 
        

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        OptionsData options = new OptionsData();
        
        italicsCheck.setSelected(options.displayItalics);
        boldCheck.setSelected(options.displayBold);
        showDandTbtn.setSelected(options.displayDateAndTime);
        showStringBtn.setSelected(!options.displayDateAndTime);
        stringToDisplay.setText(options.displayString);
        textHeight.setText(""+options.fontSize);
        
        if(options.displayDateAndTime)
            onShowDandT();
    }

    private void onShowDandT() {
        
        textHeight.setDisable(true);
        stringToDisplay.setDisable(true);
    }
    
    @FXML
    private void onShowDandTbtn(ActionEvent event) {
        
        onShowDandT();
    }

    @FXML
    private void onShowStringBtn(ActionEvent event) {
        
        textHeight.setDisable(false);
        stringToDisplay.setDisable(false);        
    }
    
    private void onOk(ActionEvent evt) {
                
        String text = textHeight.getText();
        textHeight.selectAll(); 
        
        try {

            int height = Integer.parseInt(text);

            if(height < 8 || height > 40) {
                
                evt.consume();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Enter a valid text height 8 - 40!");
                alert.showAndWait();
            }
            else {
                
                OptionsData newOptions = new OptionsData();

                newOptions.displayItalics = italicsCheck.isSelected();
                newOptions.displayBold = boldCheck.isSelected();
                newOptions.displayDateAndTime = showDandTbtn.isSelected();
                newOptions.displayString = stringToDisplay.getText();
                newOptions.fontSize = height;
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @FXML
    private void onItalicsCheck(ActionEvent event) {
    }

    @FXML
    private void onBoldCheck(ActionEvent event) {
    }
    
}
