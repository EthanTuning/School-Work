package etuninglab7;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class OptionsLayoutController extends Dialog<Void> {

    @FXML
    private CheckBox italicsCheck;
    @FXML
    private CheckBox boldCheck;
    @FXML
    private RadioButton showDandTbtn;
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
        
        getDialogPane().setContent(loader.load());
        mOkBtn = new ButtonType("Apply", ButtonBar.ButtonData.APPLY);
        ButtonType cancel = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(mOkBtn, cancel);
        getDialogPane().lookupButton(mOkBtn).addEventFilter(ActionEvent.ACTION, this::onOk);
        
        initialize();
    }

    public void initialize() {
        
        OptionsData.readPreferences(ETuningLab7.class); 
        
        italicsCheck.setSelected(OptionsData.displayItalics);
        boldCheck.setSelected(OptionsData.displayBold);
        showDandTbtn.setSelected(OptionsData.displayDateAndTime);
        showStringBtn.setSelected(!OptionsData.displayDateAndTime);
        stringToDisplay.setText(OptionsData.displayString);
        textHeight.setText(""+OptionsData.fontSize);
        
        if(OptionsData.displayDateAndTime)
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

                OptionsData.displayItalics = italicsCheck.isSelected();
                OptionsData.displayBold = boldCheck.isSelected();
                OptionsData.displayDateAndTime = showDandTbtn.isSelected();
                OptionsData.displayString = stringToDisplay.getText();
                OptionsData.fontSize = height;

            }
            OptionsData.storePreferences(ETuningLab7.class);
            evt.consume();
        
        } catch (Exception e) {
            
            System.out.print(e.getMessage());
            
        }
    }
}