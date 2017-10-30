package datatype;


public class ShapeLine extends A_Shape {
    
    private double mLength;

    public ShapeLine(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd) {
            
        super(reference, deltaStart, deltaEnd);
        mLength = deltaStart.calculateDistance(deltaEnd);
    }

    @Override
    public double getLength() {
        
        return mLength;
    }

    @Override
    public CoordinatesDelta interpolateDelta(double distance, boolean isFromAElseB) {
        
        CoordinatesDelta resultCoordinates;
        
        Angle result = getDeltaStart().calculateBearing(getDeltaEnd());
        resultCoordinates = getDeltaStart().calculateTarget(result, distance);
        
        return resultCoordinates;
    }
    
    @Override
    public boolean isOnPath(double distance) {
        
        return distance < getDeltaStart().calculateDistance(getDeltaEnd());
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
	
}