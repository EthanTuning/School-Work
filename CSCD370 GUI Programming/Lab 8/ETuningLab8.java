package etuninglab8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ETuningLab8 extends Application {
    
    private Image mO = new Image("images/x.png");
    private Image mX = new Image("images/o.png");
    private Label mStatus;
    
    @Override
    public void start(Stage primaryStage) {
        
        ImageView oView = new ImageView(mO);
        ImageView xView = new ImageView(mX);
        
        oView.setUserData("O");
        xView.setUserData("X");
        
        
        oView.setOnDragDetected(this::onDragDet);
        xView.setOnDragDetected(this::onDragDet);
        
        HBox xoTopView = new HBox(xView, oView);
        xoTopView.setAlignment(Pos.CENTER);
        
        VBox board = makeBoard(xoTopView);
        
        BorderPane root = new BorderPane();
        root.setCenter(board);
        root.setTop(buildMenus());
        
        mStatus = new Label("Everything is Copacetic");
        ToolBar tb = new ToolBar(mStatus);
        root.setBottom(tb);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    private VBox makeBoard(HBox xoTopView) {
        
        ImageView[] squares = new ImageView[9];
        
        for(int ctr = 0; ctr < 9; ctr++) {
            
            squares[ctr] = new ImageView("images/blank.png");
            squares[ctr].setUserData("Empty");
            squares[ctr].setOnDragOver(this::onDragOver);
            squares[ctr].setOnDragDropped(this::onDragDrop);
            
        }
        
        ImageView[] lines = new ImageView[12];
        
        for(int ctr = 0; ctr < 12; ctr++) {
            
            if(ctr == 0 || ctr == 1 || ctr == 5 || ctr == 6 || ctr == 10 || ctr == 11)
                lines[ctr] = new ImageView("images/vert.png");
            else
                lines[ctr] = new ImageView("images/horiz.png");
            
        }
        
        GridPane board = new GridPane();
        board.addRow(0, squares[0], lines[0], squares[1], lines[1], squares[2]);
        board.add(lines[2], 0, 1);
        board.add(lines[3], 2, 1);
        board.add(lines[4], 4, 1);
        board.addRow(2, squares[3], lines[5], squares[4], lines[6], squares[5]);
        board.add(lines[7], 0, 3);
        board.add(lines[8], 2, 3);
        board.add(lines[9], 4, 3);
        board.addRow(4, squares[6], lines[10], squares[7], lines[11], squares[8]);
        
        VBox result = new VBox(xoTopView, board);
        
        return  result;
        
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
        
        menu.getMenus().addAll(file, help);
        
        return menu;
        
    }
    
    private void onDragDet(MouseEvent actionEvent) {
        

        ImageView image = (ImageView) actionEvent.getSource();
        Dragboard drag = image.startDragAndDrop(TransferMode.COPY);
        
        Image tempImage = image.getImage();
        drag.setDragView(tempImage, tempImage.getWidth()/2, tempImage.getHeight()/2);
        
        ClipboardContent content = new ClipboardContent();
        content.putString((String) image.getUserData());
        drag.setContent(content);
        
    }
    
    private void onDragOver(DragEvent actionEvent) {
        
        ImageView image = (ImageView) actionEvent.getSource();
        
        if (!image.getUserData().equals("Empty")) {
            
            return;
            
        } else {

            Dragboard dragboard = actionEvent.getDragboard();
            
            if(dragboard.hasString()) {

                if(dragboard.getString().equals("O") || dragboard.getString().equals("X")) {
                    
                    actionEvent.acceptTransferModes(TransferMode.COPY);
                    
                }
            }
        }
    }    
    
    private void onDragDrop(DragEvent actionEvent) {
        
        
        ImageView image = (ImageView) actionEvent.getSource();
        Dragboard drag = actionEvent.getDragboard();
        
        if (drag.getString().equals("X")) {
            
            image.setImage(mX);
            image.setUserData("X");
            
        } else {
            
            image.setImage(mO);
            image.setUserData("O");

        }
        actionEvent.setDropCompleted(true);
        
    }
    
    private static void onAbout() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan Tuning CSCD370 Lab 8, Fall 2017");
        alert.showAndWait();
        
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
    }   
}