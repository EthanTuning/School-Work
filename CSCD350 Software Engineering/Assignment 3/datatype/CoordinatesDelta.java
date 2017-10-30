package datatype;


public class CoordinatesDelta {
	
    private double mX;
    private double mY;
    
    public CoordinatesDelta(double x, double y) {
        
        mX = x;
        mY = y;
    }
    
    public CoordinatesDelta add(CoordinatesDelta coordinates) {
        
        CoordinatesDelta result = new CoordinatesDelta(mX + coordinates.getX(),
                                                       mY + coordinates.getY());
        
        return result;
    }
    
    public Angle calculateBearing(CoordinatesDelta target) {
        
        Angle resultAngle;
        
        double xDis = target.getX() - mX;
        double yDis = target.getY() - mY;
        
        double result = Math.toDegrees(Math.atan(yDis/xDis));
        resultAngle = new Angle(result);
        
        return resultAngle;
    }
    
    public double calculateDistance(CoordinatesDelta target) {
        
        double result = Math.sqrt((target.getX() - mX)*(target.getX() - mX) +
                                  (target.getY() - mY )*(target.getY() - mY));
        
        return result;
    }
    
    public CoordinatesDelta calculateTarget(Angle bearing, double distance) {
        
        CoordinatesDelta resultCoordinates;
        
        double result1 = Math.cos(bearing.getValue()) * distance;
        double result2 = Math.sin(bearing.getValue()) * distance;
        double newX = mX + result1;
        double newY = mY + result2;
        
        resultCoordinates = new CoordinatesDelta(newX, newY);
        
        return resultCoordinates;
    }
    
    public double getX() {
        
        return mX;
    }
    
    public double getY() {
        
        return mY;
    }
    
    public CoordinatesDelta subtract(CoordinatesDelta coordinates) {
        
        CoordinatesDelta result = new CoordinatesDelta(mX - coordinates.getX(),
                                                       mY - coordinates.getY());
        
        return result;
    }
    
    @Override
    public String toString() {
        
        return "X: "+ mX + "\nY: " + mY;
    }
}