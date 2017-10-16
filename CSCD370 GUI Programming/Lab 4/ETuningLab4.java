package ETuningLab4;

import java.awt.geom.Point2D;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ETuningLab4 extends Application {
    
    private final Canvas mTempCanvas = new Canvas(400, 400);
    private final Canvas mPermCanvas = new Canvas(400, 400);
    private Point2D.Double mTo;
    private Point2D.Double mFrom;
    private Label mStatus;
    private Paint mColor;
    private double mWidth;
    private static int mWidthCycle = 0;
    private static int mColorCycle = 0;
    private ToggleGroup mColorToggle = new ToggleGroup();
    private ToggleGroup mWidthToggle = new ToggleGroup();
    private enum mToolBarPos{TOP, LEFT, RIGHT, BOTTOM};
    
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
        ToolBar status = new ToolBar(mStatus);
        StackPane.setAlignment(status, Pos.BOTTOM_CENTER);
        root.getChildren().add(status);
        
        ToolBar tools = buildToolBar();
        StackPane.setAlignment(tools, Pos.TOP_LEFT);
        stackPane.getChildren().add(tools);
        
        MenuBar menu;
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
            drawLine(mPermCanvas, mColor);
        }
        setCanvasWhite();
    }
    
    private void drawLine(Canvas canvas, Paint color){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(color);
        gc.strokeLine(mFrom.getX(), mFrom.getY(), mTo.getX(), mTo.getY());
        gc.setLineWidth(mWidth);
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
        
        onePx.setToggleGroup(mWidthToggle);
        fourPx.setToggleGroup(mWidthToggle);
        eightPx.setToggleGroup(mWidthToggle);
        onePx.setSelected(true);
        
        Menu colorMenu = new Menu("_Color:");
        RadioMenuItem black = new RadioMenuItem("_Black");
        RadioMenuItem red = new RadioMenuItem("_Red");
        RadioMenuItem green = new RadioMenuItem("_Green");
        RadioMenuItem blue = new RadioMenuItem("_Blue");
        
        black.setToggleGroup(mColorToggle);
        red.setToggleGroup(mColorToggle);
        green.setToggleGroup(mColorToggle);
        blue.setToggleGroup(mColorToggle);
        black.setSelected(true);
        
        widthMenu.showingProperty().addListener((boolObj, oldVal, newVal) -> 
                onWidthShowing(newVal));
        colorMenu.showingProperty().addListener((boolObj, oldVal, newVal) -> 
                onColorShowing(newVal));
        
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
    
    private void onWidthShowing(boolean newVal){
        ObservableList<Toggle> widthToggles = mWidthToggle.getToggles();
        Toggle toGet = widthToggles.get(mWidthCycle);
        mWidthToggle.selectToggle(toGet);
    }
    
    private void onColorShowing(boolean newVal){
        ObservableList<Toggle> colorToggles = mColorToggle.getToggles();
        Toggle toGet = colorToggles.get(mColorCycle);
        mColorToggle.selectToggle(toGet);
    }
    
    private void onAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan J.E. Tuning, CSCD 370 Lab 4, Fall 2017");
        alert.showAndWait();
    }

    private void onNew() {
        GraphicsContext gc = mPermCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, mTempCanvas.getWidth(), mTempCanvas.getHeight());
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
        mWidth = 1.0;
    }

    private void onFourPx() {
        mWidth = 4.0;
    }

    private void onEightPx() {
        mWidth = 8.0;
    }

    private void onBlack() {
        mColor = Color.BLACK;
    }

    private void onRed() {
        mColor = Color.RED;
    }

    private void onGreen() {
        mColor = Color.GREEN;
    }

    private void onBlue() {
        mColor = Color.BLUE;
    }
    
    private void onMoveToolBar() {
        
    }
    
    private void onMove() {
        setStatus("On Move");
    }
    
    private void onColor() {
        
        if(mColorCycle == 0) {
            mColorCycle++;
            onRed();
        }
    
        else if(mColorCycle == 1) {
            mColorCycle++;
            onGreen();
        } 
        
        else if(mColorCycle == 2) {
            mColorCycle++;
            onBlue();
        }
        else if(mColorCycle == 3) {
            mColorCycle = 0;
            onBlack();
        }
    }
    
    private void onWidth() {
        
        if(mWidthCycle == 0) {
            mWidthCycle++;
            onFourPx();
        }
    
        else if(mWidthCycle == 1) {
            mWidthCycle++;
            onEightPx();
        } 
        
        else if(mWidthCycle == 2) {
            mWidthCycle = 0;
            onOnePx();
        }
    }
    
    private ToolBar buildToolBar() {
        
        ToolBar tb = new ToolBar();
        tb.setOrientation(Orientation.VERTICAL);
        Button toolBarMoveBtn = new Button();
        Button colorBtn = new Button();
        Button moveBtn = new Button();
        Button newBtn = new Button();
        Button openBtn = new Button();
        Button saveBtn = new Button();
        Button widthBtn = new Button();
        
        toolBarMoveBtn.setGraphic(new ImageView(new Image("icons/arrow_move.png")));
        toolBarMoveBtn.setTooltip(new Tooltip("Move Tool Bar"));
        
        colorBtn.setGraphic(new ImageView(new Image("icons/Color.png")));
        colorBtn.setTooltip(new Tooltip("Cycle Color"));
        
        moveBtn.setGraphic(new ImageView(new Image("icons/Move.png")));
        moveBtn.setTooltip(new Tooltip("Move"));
        
        newBtn.setGraphic(new ImageView(new Image("icons/New.png")));
        newBtn.setTooltip(new Tooltip("New"));
        
        openBtn.setGraphic(new ImageView(new Image("icons/Open.png")));
        openBtn.setTooltip(new Tooltip("Open"));
        
        saveBtn.setGraphic(new ImageView(new Image("icons/Save.png")));
        saveBtn.setTooltip(new Tooltip("Save"));
        
        widthBtn.setGraphic(new ImageView(new Image("icons/Width.png")));
        widthBtn.setTooltip(new Tooltip("Cycle Width"));
        
        toolBarMoveBtn.setOnAction(actionEvent -> onMoveToolBar());
        colorBtn.setOnAction(actionEvent -> onColor());
        moveBtn.setOnAction(actionEvent -> onMove());
        newBtn.setOnAction(actionEvent -> onNew());
        openBtn.setOnAction(actionEvent -> onOpen());
        saveBtn.setOnAction(actionEvent -> onSave());
        widthBtn.setOnAction(actionEvent -> onWidth());
        
        tb.getItems().addAll(toolBarMoveBtn, new Separator(), colorBtn, 
                new Separator(), moveBtn,new Separator(), newBtn, 
                new Separator(), openBtn, new Separator(), saveBtn, 
                new Separator(), widthBtn);
        
        return tb;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}