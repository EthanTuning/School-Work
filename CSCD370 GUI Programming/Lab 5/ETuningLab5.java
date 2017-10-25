package etuninglab5;

import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ETuningLab5 extends Application {   
    
    private Point2D.Double mFrom, mTo;
    private Canvas mPermCanvas, mTempCanvas;
    private Label mStatus;
    private BorderPane root;
    private ToolBar toolbar;
    private ToolBarPos mToolbarPos = ToolBarPos.LEFT;
    private Stage mStage;
    private Color mColor;
    private VBox mTopMenuVB;
    private VBox mBottomVB;
    private ToolBar mToolBar;
    private boolean mSave = false;
    private File mFile;
    private ArrayList<Line> mLines;
    private ToggleGroup mColorTG;
    private ToggleGroup mWidthTG;
    private StringProperty status = new SimpleStringProperty("");
    private int mLineWidth = 1;
    private enum ToolBarPos {
        LEFT, TOP, RIGHT, BOTTOM;
    }
    
    @Override
    public void start(Stage primaryStage) {       
        root = new BorderPane();
        
        StackPane canvasStack = new StackPane();
        
        mFile = null;
        mLines = new ArrayList<>();    
        mColor = Color.BLACK;
        
        mPermCanvas = new Canvas(400, 400);
        mTempCanvas = new Canvas(400, 400);   
        
        canvasStack.getChildren().add(mTempCanvas);
        canvasStack.getChildren().add(mPermCanvas);
        fillCanvas(mTempCanvas, false);
        fillCanvas(mPermCanvas, true);
        ScrollPane mSPane = new ScrollPane(canvasStack);
        root.setCenter(mSPane);

        mFrom = new Point2D.Double();
        mTo   = new Point2D.Double();
        
        mPermCanvas.setOnMousePressed(mouseEvent->onMousePressed(mouseEvent));
        mPermCanvas.setOnMouseDragged(mouseEvent->onMouseDrag(mouseEvent, Paint.valueOf("BLACK")));
        mPermCanvas.setOnMouseReleased(mouseEvent->onMouseRelease(mouseEvent));

        MenuBar menuBar = buildMenus();
        mTopMenuVB = new VBox(menuBar);
        root.setTop(mTopMenuVB);
        
        mToolBar = buildToolBar();
        root.setLeft(mToolBar);
        
        mStatus = new Label("");
        toolbar = new ToolBar(mStatus);
        mBottomVB = new VBox(toolbar);
        root.setBottom(mBottomVB);
        
        mStage = primaryStage;
        Scene scene = new Scene(root);
        
        primaryStage.setOnCloseRequest(actionEvent -> onExit());
        primaryStage.setTitle(" ");
        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    
    
    
    public ToolBar buildToolBar(){
        
        ToolBar toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.VERTICAL);
        
        Button newBtn = new Button(),
               openBtn = new Button(), 
               saveBtn = new Button(), 
               widthBtn = new Button(), 
               colorBtn = new Button(), 
               moveBtn = new Button();
                
        ImageView btnImage = new ImageView(new Image("ButtonImages/New.png"));                
        newBtn.setGraphic(btnImage);

        btnImage = new ImageView(new Image("ButtonImages/Open.png"));
        openBtn.setGraphic(btnImage);

        btnImage = new ImageView(new Image("ButtonImages/Save.png"));
        saveBtn.setGraphic(btnImage);

        btnImage = new ImageView(new Image("ButtonImages/Width.png"));
        widthBtn.setGraphic(btnImage);

        btnImage = new ImageView(new Image("ButtonImages/Color.png"));
        colorBtn.setGraphic(btnImage); 

        btnImage = new ImageView(new Image("ButtonImages/Move.png"));
        moveBtn.setGraphic(btnImage);            

        toolBar.getItems().addAll(newBtn, openBtn, saveBtn, new Separator(), 
                                  widthBtn, new Separator(), colorBtn, 
                                  new Separator(), moveBtn);   
        
        newBtn.setOnMouseClicked(ActionEvent -> onNew());
        openBtn.setOnMouseClicked(ActionEvent -> onOpen());
        saveBtn.setOnMouseClicked(ActionEvent -> onSave(false));
        widthBtn.setOnMouseClicked(ActionEvent -> onWidth(0));
        colorBtn.setOnMouseClicked(ActionEvent -> onColor(null));
        moveBtn.setOnMouseClicked(ActionEvent -> onToolbarMove());     
        
        newBtn.tooltipProperty().setValue(new Tooltip("Create new file"));
        openBtn.tooltipProperty().setValue(new Tooltip("Open file"));
        saveBtn.tooltipProperty().setValue(new Tooltip("Save file"));
        widthBtn.tooltipProperty().setValue(new Tooltip("Line width"));
        colorBtn.tooltipProperty().setValue(new Tooltip("Line color"));
        moveBtn.tooltipProperty().setValue(new Tooltip("Move image"));
        
        return toolBar;       
    }   
    
    public MenuBar buildMenus() {

        MenuBar menuBar = new MenuBar();
        
        Menu fileMenu = new Menu("_File");
        MenuItem newMenuItem = new MenuItem("_New");
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        newMenuItem.setOnAction(actionEvent -> onNew());
        
        MenuItem openMenuItem = new MenuItem("_Open");
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        openMenuItem.setOnAction(actionEvent -> onOpen());
        
        MenuItem saveMenuItem = new MenuItem("_Save");
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setOnAction(actionEvent -> onSave(false));        
        
        MenuItem saveAsMenuItem = new MenuItem("_Save_As");
        saveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        saveAsMenuItem.setOnAction(actionEvent -> onSave(true));
        
        SeparatorMenuItem sep = new SeparatorMenuItem();
        
        MenuItem quitMenuItem = new MenuItem("_Quit");
        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        quitMenuItem.setOnAction(actionEvent -> onExit());
        
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem, sep, quitMenuItem);
        
        
        Menu widthMenu = new Menu("_Width");       
        mWidthTG = new ToggleGroup();       
        RadioMenuItem onePix   = new RadioMenuItem("_1 Pixel");
        RadioMenuItem fourPix  = new RadioMenuItem("_4 Pixels");
        RadioMenuItem eightPix = new RadioMenuItem("_8 Pixels");
        onePix.setOnAction(actionEvent -> onWidth(1));
        fourPix.setOnAction(actionEvent -> onWidth(4));
        eightPix.setOnAction(actionEvent -> onWidth(8));
        onePix.setToggleGroup(mWidthTG);
        fourPix.setToggleGroup(mWidthTG);
        eightPix.setToggleGroup(mWidthTG);       
        onePix.setSelected(true);
        widthMenu.getItems().addAll(onePix, fourPix, eightPix);
        widthMenu.setOnShowing(event -> onWidthShowing());
        
        
        Menu colorMenu = new Menu("_Color");
        mColorTG = new ToggleGroup();
        RadioMenuItem color_black  = new RadioMenuItem("_Black");
        RadioMenuItem color_red    = new RadioMenuItem("_Red");
        RadioMenuItem color_green  = new RadioMenuItem("_Green");
        RadioMenuItem color_blue   = new RadioMenuItem("_Blue");
        color_black.setOnAction(actionEvent -> onColor(Color.BLACK));
        color_red.setOnAction(actionEvent -> onColor(Color.RED));
        color_green.setOnAction(actionEvent -> onColor(Color.GREEN));
        color_blue.setOnAction(actionEvent -> onColor(Color.BLUE));
        color_black.setToggleGroup(mColorTG);
        color_red.setToggleGroup(mColorTG);
        color_green.setToggleGroup(mColorTG);
        color_blue.setToggleGroup(mColorTG);      
        color_black.setSelected(true);
        colorMenu.getItems().addAll(color_black, color_red, color_green, color_blue);
        colorMenu.setOnShowing(event -> onColorShowing());

        Menu helpMenu = new Menu("_Help");
        MenuItem aboutMenuItem = new MenuItem("_About");
        aboutMenuItem.setOnAction(actionEvent -> onAbout());
        helpMenu.getItems().add(aboutMenuItem);
        
        menuBar.getMenus().addAll(fileMenu, widthMenu, colorMenu, helpMenu);
        
        return menuBar;
    }

    public void setStatus(String status) {
        mStatus.setText(status);
    }
    
    private void fillCanvas(Canvas mCanvas, boolean transparent) {
        GraphicsContext canvasGC = mCanvas.getGraphicsContext2D();
        if(transparent) {
            canvasGC.setFill(Color.TRANSPARENT);
        } else {
            canvasGC.setFill(Color.WHITE);            
        }
        canvasGC.fillRect(0, 0, mCanvas.getWidth(), mCanvas.getHeight());
        mCanvas.setWidth(400);
        mCanvas.setHeight(400);
    }  
  
    private void onMousePressed(MouseEvent mousePress) {
        
        setStatus("");
        mFrom = new Point2D.Double();
        mTo = new Point2D.Double();
        mFrom.x = mousePress.getX();
        mFrom.y = mousePress.getY();
        mTo.y   = mousePress.getY();
        mTo.x   = mousePress.getX();
    }
    
    private void onMouseDrag(MouseEvent mouseDrag, Paint linePaint) {
        
        mTo.x = mouseDrag.getX();
        mTo.y = mouseDrag.getY();
        GraphicsContext gc = mTempCanvas.getGraphicsContext2D();
        if(mPermCanvas.contains(mTo.x, mTo.y)) {
            gc.fillRect(0, 0, mPermCanvas.getWidth(), mPermCanvas.getHeight());
            gc.strokeLine(mFrom.x, mFrom.y, mTo.x , mTo.y);
        }
    }    
    
    private void onMouseRelease(MouseEvent mouseRelease) {
        
        GraphicsContext gc = mTempCanvas.getGraphicsContext2D();
        gc.fillRect(0, 0, 400, 400);
        
        mSave = true;
        Line newLine = new Line(mFrom, mTo, mLineWidth, new Color(mColor.getRed(),
                                mColor.getGreen(), mColor.getBlue(), 1));
        mLines.add(newLine);
        newLine.draw(mPermCanvas);
        if(mFile != null && !mStage.getTitle().contains("*")) 
            mStage.setTitle("*" + mStage.getTitle());
    }

    private void onWidthShowing() {
        
        int buttonNum = 0;
        switch (mLineWidth) {
            case 1:
                buttonNum = 0;
                break;
                
            case 4:
                buttonNum = 1;
                break;
                
            case 8:
                buttonNum = 2;
                break;
        }
        mWidthTG.selectToggle(mWidthTG.getToggles().get(buttonNum));
    }    
    
    private void onColorShowing() {
        
        int colorNum = 0;
        if (mColor == Color.RED) {
            colorNum = 1;
        } else if (mColor == Color.GREEN) {
            colorNum = 2;
        } else if (mColor == Color.BLUE) {
            colorNum = 3;
        }
        mColorTG.selectToggle(mColorTG.getToggles().get(colorNum));
    }

    private void onOpen() {

        if(mSave == true) {
            Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION,
                                        "Would you like to save drawing?",
                                        ButtonType.YES,
                                        ButtonType.NO);
            
            saveAlert.setTitle("Drawing not saved");
 
            Optional<ButtonType> choice = saveAlert.showAndWait();
            if(choice.isPresent() && choice.get() == ButtonType.YES) {
                onSave(false);      
            } else if(choice.get() == ButtonType.NO) {
                saveAlert.close();
            }
        }
        
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open a line File");
        chooser.setInitialDirectory(new File("."));
        chooser.getExtensionFilters().addAll(
            new ExtensionFilter("Line Files", "*.line"),
            new ExtensionFilter("All Files", "*.*"));
        
        File selectedFile = chooser.showOpenDialog(mStage);

        if(selectedFile == null) return;
        try {        
            FileInputStream fileStream = new FileInputStream(selectedFile);
            ObjectInputStream in = new ObjectInputStream(fileStream);
            clear();
            mLines = (ArrayList<Line>)in.readObject(); 
            
            for(Line line : mLines) {
                line.mColor = new Color(in.readDouble(), in.readDouble(), in.readDouble(), 1);
                line.draw(mPermCanvas);
            }
               
            in.close();
            mSave = false;
        } catch (IOException | ClassNotFoundException e) {
            setStatus("");
            return;
        }
        
        setStatus("Opened " + selectedFile.getName());
        mStage.setTitle(selectedFile.getName());
        mFile = selectedFile;
    }
    
    private void onNew() {
        if(mSave == true) {
            Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION);
            saveAlert.setTitle("Drawing not saved.");
            saveAlert.setHeaderText("Drawing not saved.");
            
            Optional<ButtonType> choice = saveAlert.showAndWait();
            if(choice.get() == ButtonType.OK) {
                mSave = false;
                mFile = null;
                setStatus(" ");    
        
                GraphicsContext gc = mPermCanvas.getGraphicsContext2D();
                gc.clearRect(0, 0, 400, 400);
                status.set("Created Canvas");        
            } else {
                saveAlert.close();
            }
        }
        mFile = null;
        setStatus("Document created");  
        mStage.setTitle(" ");

        mLines.clear();
        clear();
        status.set("Created Canvas");
        
    }
    
    private void onSave(boolean saveAs) {
        File selectedFile = mFile;
        
        if (mFile == null || saveAs) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Line File");
            fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Line Files", "*.line"),
                new ExtensionFilter("All Files", "*.*"));
            if (mFile!=null)
                fileChooser.setInitialFileName(mFile.getName());
            selectedFile = fileChooser.showSaveDialog(mStage);
        }
        
        if (selectedFile != null) {
            try {
                FileOutputStream fileStream = new FileOutputStream(selectedFile);
                ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
                objStream.writeObject(mLines);
                
                for(Line line : mLines) {
                    objStream.writeDouble(line.mColor.getRed());
                    objStream.writeDouble(line.mColor.getGreen());
                    objStream.writeDouble(line.mColor.getBlue());
                }                
                objStream.close();
                
            } catch (IOException ex) {
                System.out.println("Could not find file.");
                return;
            }
            
            mFile = selectedFile;
            setStatus("Saved " + mFile.getName());
            mStage.setTitle(mFile.getName());
            mSave = false;
        }
    }
    
    private void onWidth(int width) {
        
        GraphicsContext gc  = mTempCanvas.getGraphicsContext2D();
        GraphicsContext gc2 = mPermCanvas.getGraphicsContext2D();
        if(width == 0) {
            switch (mLineWidth) {
                case 1:
                    gc.setLineWidth(4);
                    gc2.setLineWidth(4);
                    mLineWidth = 4;
                    break;
                    
                case 4:
                    gc.setLineWidth(8);
                    gc2.setLineWidth(8);
                    mLineWidth = 8;
                    break;
                    
                case 8:
                    gc.setLineWidth(1);
                    gc2.setLineWidth(1);
                    mLineWidth = 1;
                    break;
                    
                default:
                    gc.setLineWidth(1);
                    gc2.setLineWidth(1);
                    mLineWidth = 1;
                    break;
            }
        } else {
            gc.setLineWidth(width);
            gc2.setLineWidth(width);
            mLineWidth = width;
        }
        
        status.set("Line width set to" + width);
    }
    
    private void onColor(Color newColor) {
        
        GraphicsContext gc  = mTempCanvas.getGraphicsContext2D();
        GraphicsContext gc2 = mPermCanvas.getGraphicsContext2D();        
        
        if(newColor == null) {
            mColor = Line.getNextColor(mColor);
        } else {
            mColor = newColor;
        }
        gc.setStroke(mColor);
        gc2.setStroke(mColor);        
        status.set("Line color set to " + mColor);
    }
    
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Ethan Tuning, CSCD 370 Lab5, Fall 2017");
        alert.showAndWait();
    }
    
    private void onToolbarMove() {
        
        switch(mToolbarPos) {
            case LEFT:
                root.setLeft(null);
                mToolBar.setOrientation(Orientation.HORIZONTAL);
                mTopMenuVB.getChildren().add(mToolBar);
                mToolbarPos = ToolBarPos.TOP;
                break;
                
            case TOP:
                mTopMenuVB.getChildren().remove(mToolBar);
                mToolBar.setOrientation(Orientation.VERTICAL);
                root.setRight(mToolBar);
                mToolbarPos = ToolBarPos.RIGHT;
                break;
                
            case RIGHT:
                root.setRight(null);
                mToolBar.setOrientation(Orientation.HORIZONTAL);
                mBottomVB.getChildren().add(0,mToolBar);
                mToolbarPos = ToolBarPos.BOTTOM;
                break;
                
            case BOTTOM:
                mBottomVB.getChildren().remove(0);
                mToolBar.setOrientation(Orientation.VERTICAL);
                root.setLeft(mToolBar);
                mToolbarPos = ToolBarPos.LEFT;
                break;
                
            default:
                mToolBar.setOrientation(Orientation.VERTICAL);
                root.setLeft(mToolBar);
                mToolbarPos = ToolBarPos.LEFT;
                break;
        }
        status.set("Move Event");
    }
    
    private void onExit() {
        
        if(mSave == true) {
            Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION);
            saveAlert.setTitle("Drawing not saved");
            saveAlert.setHeaderText("Drawing hasn't been saved.");
            
            Optional<ButtonType> choice = saveAlert.showAndWait();
            if(choice.get() == ButtonType.OK) {
                mSave = false;
                mFile = null;
                setStatus(" ");    
        
                GraphicsContext gc = mPermCanvas.getGraphicsContext2D();
                gc.clearRect(0, 0, 400, 400);
                status.set("Created New Canvas");        
            } else {
                saveAlert.close();
            }
        }
        Platform.exit();
    } 
    
    private void clear() {
        GraphicsContext gc = mPermCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 400, 400);
    }
    
    public ArrayList<Line> getLines() {
        return this.mLines;
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}