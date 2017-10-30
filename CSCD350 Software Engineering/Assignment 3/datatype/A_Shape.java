package datatype;


public abstract class A_Shape {
    
    private CoordinatesWorld mReference;
    private CoordinatesDelta mDeltaStart;
    private CoordinatesDelta mDeltaEnd;
    private int mIndex;
            
    public A_Shape(CoordinatesWorld reference, 
                   CoordinatesDelta deltaStart,
                   CoordinatesDelta deltaEnd){
        
        mReference = reference;
        mDeltaStart = deltaStart;
        mDeltaEnd = deltaEnd;
    }
    
    public A_Shape(CoordinatesWorld reference, 
                   CoordinatesDelta deltaStart,
                   CoordinatesDelta deltaEnd, int index){
        
        mReference = reference;
        mDeltaStart = deltaStart;
        mDeltaEnd = deltaEnd;
        mIndex = index;        
    }
    
    public CoordinatesDelta getDeltaEnd() {
        
        return mDeltaEnd;
    }
    
    public CoordinatesDelta getDeltaStart() {
        
        return mDeltaStart;
    }
    
    public int getIndex() {
        
        return mIndex;
    }
    
    public abstract double getLength();
    
    public CoordinatesWorld getReference(){
        
        return mReference;
    }
    
    public CoordinatesWorld getWorldEnd() {
        
        CoordinatesWorld resultCoordinates = mReference.calculateTarget(mDeltaEnd);
        
        return resultCoordinates;
    }
    
    public CoordinatesWorld getWorldStart() {
        
        CoordinatesWorld resultCoordinates = mReference.calculateTarget(mDeltaStart);
        
        return resultCoordinates;
    }
    
    public boolean hasIndex() {
        
        return (mIndex != 0);
    }
    
    public abstract CoordinatesDelta interpolateDelta(double distance, boolean isFromAElseB);
    
    public CoordinatesWorld interpolateWorld(double distance, boolean isFromAElseB){
        
        CoordinatesDelta resultCoordinatesDel = interpolateDelta(distance, isFromAElseB);
        CoordinatesWorld resultCoordinatesWorld = mReference.calculateTarget(resultCoordinatesDel);
        
        return resultCoordinatesWorld;
    }
    
    public abstract boolean isOnPath(double distance);
    
    public void setIndex(int index) {
        
        mIndex = index;
    }
}