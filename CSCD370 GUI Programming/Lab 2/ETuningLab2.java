package EtuningLab2;

import java.awt.geom.Point2D;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ETuningLab2 extends Application {
    
    private final Canvas mTempCanvas = new Canvas(400, 400);
    private final Canvas mPermCanvas = new Canvas(400, 400);
    private Point2D.Double mTo;
    private Point2D.Double mFrom;
    private Label mStatus;
    
    @Override
    public void start(Stage primaryStage) {
        
        mPermCanvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                mouseEvent->onMousePressed(mouseEvent));
        mPermCanvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                mouseEvent->onMouseReleased(mouseEvent));
        mPermCanvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                mouseEvent->onMouseDragged(mouseEvent));
        
        setCanvasWhite();
        
        StackPane root = new StackPane();
        StackPane stackPane = new StackPane();
        
        stackPane.getChildren().add(mTempCanvas);
        stackPane.getChildren().add(mPermCanvas);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(stackPane);
        root.getChildren().add(scrollPane);
        
        mStatus = new Label("");
        ToolBar toolBar = new ToolBar(mStatus);
        StackPane.setAlignment(toolBar, Pos.BOTTOM_CENTER);
        root.getChildren().add(toolBar);
        
        MenuBar menu;
        menu = new MenuBar();
        menu = buildMenus();
        StackPane.setAlignment(menu, Pos.TOP_CENTER);
        root.getChildren().add(menu);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setCanvasWhite(){
        GraphicsContext gc = mTempCanvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, mTempCanvas.getWidth(), mTempCanvas.getHeight());
    }
    
    private void onMousePressed(MouseEvent mouseEvent){
        mTo = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
        mFrom = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
    }
    
    private void onMouseDragged(MouseEvent mouseEvent){
        
        if(mTempCanvas.contains(mouseEvent.getX(), mouseEvent.getY())){
            mTo = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
            setCanvasWhite();
            drawLine(mTempCanvas, Color.BLACK);
            setStatus("To: " + mTo + "From: " + mFrom);
        }
    }
    
    private void onMouseReleased(MouseEvent mouseEvent){
        if(mTempCanvas.contains(mouseEvent.getX(), mouseEvent.getY())){
            mTo = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
            setCanvasWhite();
            drawLine(mPermCanvas, Color.RED);
        }
        setCanvasWhite();
    }
    
    private void drawLine(Canvas canvas, Paint color){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(color);
        gc.strokeLine(mFrom.getX(), mFrom.getY(), mTo.getX(), mTo.getY());
    }
    
    private void setStatus(String status) {
        mStatus.setText(status);
    }
    
    private MenuBar buildMenus(){
        MenuBar menuBar;
        menuBar = new MenuBar();

        Menu fileMenu = new Menu("_File");
        MenuItem newMenuItem = new MenuItem("_New");
        MenuItem openMenuItem = new MenuItem("_Open");
        MenuItem saveMenuItem = new MenuItem("_Save");
        MenuItem saveAsMenuItem = new MenuItem("_Save As");
        MenuItem exitMenuItem = new MenuItem("_Exit");

        Menu widthMenu = new Menu("_Width:");
        RadioMenuItem onePx = new RadioMenuItem("_1 Pixel");
        RadioMenuItem fourPx = new RadioMenuItem("_4 Pixels");
        RadioMenuItem eightPx = new RadioMenuItem("_8 Pixels");
        
        Menu colorMenu = new Menu("_Color:");
        RadioMenuItem black = new RadioMenuItem("_Black");
        RadioMenuItem red = new RadioMenuItem("_Red");
        RadioMenuItem green = new RadioMenuItem("_Green");
        RadioMenuItem blue = new RadioMenuItem("_Blue");
        
        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem("_About");
        
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem,
                saveAsMenuItem, exitMenuItem);
        widthMenu.getItems().addAll(onePx, fourPx, eightPx);
        colorMenu.getItems().addAll(black, red, green, blue);
        helpMenu.getItems().add(aboutMenuItem);
        
        newMenuItem.setAccelerator(new
                KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        openMenuItem.setAccelerator(new
                KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setAccelerator(new
                KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveAsMenuItem.setAccelerator(new
                KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        exitMenuItem.setAccelerator(new
                KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        
        newMenuItem.setOnAction(actionEvent -> onNew());
        openMenuItem.setOnAction(actionEvent -> onOpen());
        saveMenuItem.setOnAction(actionEvent -> onSave());
        saveAsMenuItem.setOnAction(actionEvent -> onSaveAs());
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        onePx.setOnAction(actionEvent -> onOnePx());
        fourPx.setOnAction(actionEvent -> onFourPx());
        eightPx.setOnAction(actionEvent -> onEightPx());
        
        black.setOnAction(actionEvent -> onBlack());
        red.setOnAction(actionEvent -> onRed());
        green.setOnAction(actionEvent -> onGreen());
        blue.setOnAction(actionEvent -> onBlue());
        
        aboutMenuItem.setOnAction(actionEvent -> onAbout());
        
        menuBar.getMenus().addAll(fileMenu, colorMenu, widthMenu, helpMenu);

        return menuBar;
    }
    
    private void onAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Lab 2, Fall 2017");
        alert.showAndWait();
    }

    private void onNew() {
        setStatus("New Selected");
    }

    private void onOpen() {
        setStatus("Open Selected");
    }

    private void onSave() {
        setStatus("Save Selected");
    }

    private void onSaveAs() {
        setStatus("Save As Selected");
    }

    private void onOnePx() {
        setStatus("1 Pixel Selected");
    }

    private void onFourPx() {
        setStatus("Four Pixels Selected");
    }

    private void onEightPx() {
        setStatus("Eight Pixels Selected");
    }

    private void onBlack() {
        setStatus("Black Selected");
    }

    private void onRed() {
        setStatus("Red Selected");
    }

    private void onGreen() {
        setStatus("Green Selected");
    }

    private void onBlue() {
        setStatus("Blue Selected");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}