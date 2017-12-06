package pacman;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score {

    private Text mScore;
    private Text mLives;

    Score(BorderPane root) {
        
        mScore = new Text(Wall.THICKNESS * 4, Wall.THICKNESS * 28, "Score: 0");
        mLives = new Text(Wall.THICKNESS * 20, Wall.THICKNESS * 28,"Lifes: 3");
        mScore.setFill(Color.WHITE);
        mScore.setFont(Font.font("Arial", 30));

        mLives.setFill(Color.WHITE);
        mLives.setFont(Font.font("Arial", 30));

        root.getChildren().add(mScore);
        root.getChildren().add(mLives);
    }
    
    public Text getScore() {
        
        return mScore;
        
    }
    
    public Text getLives() {
        
        return mLives;
        
    }
}
