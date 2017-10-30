package datatype;


public class Angle implements Comparable<Angle> {

    public static Angle ANGLE_000 = new Angle(0);
    public static Angle ANGLE_045 = new Angle(45);
    public static Angle ANGLE_090 = new Angle(90);
    public static Angle ANGLE_135 = new Angle(135);
    public static Angle ANGLE_180 = new Angle(180);
    public static Angle ANGLE_225 = new Angle(225);
    public static Angle ANGLE_270 = new Angle(270);
    public static Angle ANGLE_315 = new Angle(315);
    
    private double mAngle;
    
    public Angle(double angle) {
        
        mAngle = angle;
    }
    
    public Angle add(Angle angle) {
        
        double result = normalize(angle.getValue() + mAngle);
        Angle resultAngle = new Angle(result);
        
        return resultAngle;
    }
    
    @Override
    public int compareTo(Angle angle) {
        
        if(mAngle > angle.getValue())
            return 1;
        
        else if(mAngle < angle.getValue())
            return -1;
        
        else
            return 0;
    }
    
    public double getValue() {
        
        return mAngle;
    }
    
    public static double normalize(double angle) {
        
        double result;
        result = angle % 360;
        
        if(result < 0)
            result += 360;
        
        return result;
    }
    
    public Angle reciprocate() {
        
        Angle result = new Angle(mAngle + 180);
        
        return result;
    }
    
    public Angle subtract(Angle angle) {
        
        double result = normalize(angle.getValue() - mAngle);
        Angle resultAngle = new Angle(result);
        
        return resultAngle;
    }
    
    @Override
    public String toString() {
        
        return ""+mAngle;
    }
}