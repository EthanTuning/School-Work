package pacman;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class Main extends Application {

    GameController mController;
    
    @Override
    public void start(Stage stage) {
        
        BorderPane root = new BorderPane();
        BorderPane gameRoot = new BorderPane();
        
        Canvas canvas = new Canvas(1215, 750);
        gameRoot.setCenter(canvas);
        
        root.setTop(buildMenus());
        root.setCenter(gameRoot);
        
        mController = new GameController(gameRoot);
        mController.drawBoard();

        root.setStyle("-fx-background-color: black");
        
        Scene scene = new Scene(root);
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> mController.movePacman(event));
        scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> mController.stopPacman(event));
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> mController.restartGame(event));
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> mController.cheatCode(event));
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> mController.drawCakes(event));
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> mController.pause(event));
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Pac-Man");
        stage.show();
    }

    private MenuBar buildMenus() {
        
        MenuBar menu =  new MenuBar();
        
        Menu file = new Menu("_File");
        
        MenuItem quit = new MenuItem("_Quit");
        quit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCodeCombination.CONTROL_DOWN));
        quit.setOnAction(actionEvent -> Platform.exit());
        
        MenuItem save = new MenuItem("_Save");
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCodeCombination.CONTROL_DOWN));
        save.setOnAction(actionEvent -> save());
        
        MenuItem open = new MenuItem("_Open");
        open.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_DOWN));
        open.setOnAction(actionEvent -> open());
        
        file.getItems().addAll(save, open, quit);
        
        Menu game = new Menu("_Game");
        
        MenuItem pause = new MenuItem("_Pause");
        pause.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCodeCombination.CONTROL_DOWN));
        pause.setOnAction(actionEvent -> mController.pause());
        
        MenuItem addGhost = new MenuItem("_Add Ghost");
        addGhost.setAccelerator(new KeyCodeCombination(KeyCode.G, KeyCodeCombination.CONTROL_DOWN));
        addGhost.setOnAction(actionEvent -> mController.addGhost());
        
        game.getItems().addAll(pause, addGhost);
        
        
        Menu help = new Menu("_Help");
        MenuItem about = new MenuItem("_About");
        about.setOnAction(actionEvent -> onAbout());
        help.getItems().add(about);
        
        menu.getMenus().addAll(file,game, help);
        
        return menu;
        
    }
    
    private void save() {
        
        
        
    } 
    
    private void open() {
        
        
        
    }
    
    private void onAbout() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Written by Ethan Tuning");
        alert.showAndWait();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}