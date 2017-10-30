package datatype;


public class ShapeArc extends A_Shape {

    public ShapeArc(CoordinatesWorld reference, 
                    CoordinatesDelta deltaStart, 
                    CoordinatesDelta deltaEnd, 
                    CoordinatesDelta deltaOrigin) {
        
        super(reference, deltaStart, deltaEnd);
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Angle getAngleEnd() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Angle getAngleStart() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public CoordinatesDelta getDeltaOrigin() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public double getLength() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getRadius() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB) {
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }	

    @Override
    public boolean isOnPath(double distance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}