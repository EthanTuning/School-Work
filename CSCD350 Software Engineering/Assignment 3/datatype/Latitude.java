package datatype;


public class Latitude extends A_LatitudeLongitude implements Comparable<A_LatitudeLongitude> {
    
    public Latitude(double nmea) {
        
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
    }
    
    public Latitude(int degrees, int minutes, double seconds) {
        
        super(degrees, minutes, seconds);
    }
    
    public Latitude add(Latitude latitude) {
        
        Latitude resultLat;
        
        double result1 = convertToNMEA();
        double result2 = latitude.convertToNMEA();
        double finalResult = result1 + result2;
        
        resultLat = new Latitude(finalResult);
        
        return resultLat;
    }
    
    public Latitude subtract(Latitude latitude) {
        
        Latitude resultLat;
        
        double result1 = convertToNMEA();
        double result2 = latitude.convertToNMEA();
        double finalResult = result1 - result2;
        
        resultLat = new Latitude(finalResult);
        
        return resultLat;
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
}