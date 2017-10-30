package datatype;


public class CoordinatesScreen {
    
    private int mX;
    private int mY;
    private boolean mIsVisible;
    
    public CoordinatesScreen(int x, int y) {
        
        mX = x;
        mY = y;
    }
    
    public CoordinatesScreen add(CoordinatesScreen coordinates) {
        
        CoordinatesScreen resultCoordinates = new CoordinatesScreen(mX + coordinates.getX(),
                                                                    mY + coordinates.getY());
        
        return resultCoordinates;
    }
    
    public CoordinatesScreen getHalf() {
        
        CoordinatesScreen resultCoordinates = new CoordinatesScreen((int)Math.floor(mX/2),
                                                                    (int)Math.floor(mY/2));
        
        return resultCoordinates;
    }
    
    public int getX() {
        
        return mX;
    }
    
    public int getY() {
        
        return mY;
    }
    
    public boolean isVisible() {
        
        return mIsVisible;
    }
    
    public void isVisible(boolean isVisible) {
        
        mIsVisible = isVisible;
    }
    
    public CoordinatesScreen subtract(CoordinatesScreen coordinates) {
        
        CoordinatesScreen resultCoordinates = new CoordinatesScreen(mX - coordinates.getX(),
                                                                    mY - coordinates.getY());
        
        return resultCoordinates;
    }
}