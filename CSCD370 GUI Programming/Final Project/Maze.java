package pacman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.BorderPane;

public class Maze {

    private Set<Wall> mWalls;

    Maze() {
        
        mWalls = new HashSet<>();
        
    }

    public Boolean isTouching(double x, double y, double padding) {
        
        for (Wall wall:mWalls) {
            
            if ( x >= wall.getX() - padding &&
                 x <= wall.getX() + padding + wall.getWidth() &&
                 y >= wall.getY() - padding &&
                 y <= wall.getY() + padding + wall.getHeight()) {
                
                return true;
            }
        }
        return false;
    }

    public Boolean hasWall(double fromX,  double toX, double fromY, double toY) {
        
        boolean isTouching = false;
        
        for (double i = fromX; i < toX; i++) {
            
            for (double j = fromY; j < toY; j++) {
                
                if (isTouching(i, j, 0)) isTouching = true;
                
            }
        }
        return isTouching;
    }

    public void CreateMazeLevelOne(BorderPane root) {
        
        mWalls.removeAll(mWalls);
        
        mWalls.add(new Wall(0, 0, "horizontal", 48));
        mWalls.add(new Wall(0, 600, "horizontal", 48));
        mWalls.add(new Wall(0, 0, "vertical", 25));
        mWalls.add(new Wall(1225 - Wall.THICKNESS, 0, "vertical", 25));
        mWalls.add(new Wall(12 * Wall.THICKNESS, Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(36 * Wall.THICKNESS, Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(12 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 4 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(8 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(8 * Wall.THICKNESS, 12 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(8 * Wall.THICKNESS, 16 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 12 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 16 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 4 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 5 * Wall.THICKNESS, "vertical", 6));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 600 - 10 * Wall.THICKNESS, "vertical", 6));
        mWalls.add(new Wall(40 * Wall.THICKNESS, 4 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(44 * Wall.THICKNESS, 5 * Wall.THICKNESS, "vertical", 6));
        mWalls.add(new Wall(40 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(44 * Wall.THICKNESS, 600 - 10 * Wall.THICKNESS, "vertical", 6));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 8 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(32 * Wall.THICKNESS, 600 - 16 * Wall.THICKNESS, "vertical", 8));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 16 * Wall.THICKNESS, "vertical", 8));
        mWalls.add(new Wall(17 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(27 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));

        root.getChildren().addAll(mWalls);
    }
    
    public void CreateMazeLevelTwo(BorderPane root) {
        
        mWalls.removeAll(mWalls);
        
        mWalls.add(new Wall(0, 0, "horizontal", 48));
        mWalls.add(new Wall(0, 600, "horizontal", 48));
        mWalls.add(new Wall(0, 0, "vertical", 25));
        mWalls.add(new Wall(1225 - Wall.THICKNESS, 0, "vertical", 25));
        mWalls.add(new Wall(12 * Wall.THICKNESS, Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(36 * Wall.THICKNESS, Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(12 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "vertical", 4));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 4 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 4 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 12 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(4 * Wall.THICKNESS, 16 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 12 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(36 * Wall.THICKNESS, 16 * Wall.THICKNESS, "horizontal", 9));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 8 * Wall.THICKNESS, "horizontal", 17));
        mWalls.add(new Wall(32 * Wall.THICKNESS, 600 - 16 * Wall.THICKNESS, "vertical", 8));
        mWalls.add(new Wall(16 * Wall.THICKNESS, 600 - 16 * Wall.THICKNESS, "vertical", 8));
        mWalls.add(new Wall(17 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));
        mWalls.add(new Wall(27 * Wall.THICKNESS, 8 * Wall.THICKNESS, "horizontal", 5));

        root.getChildren().addAll(mWalls);
    }
}