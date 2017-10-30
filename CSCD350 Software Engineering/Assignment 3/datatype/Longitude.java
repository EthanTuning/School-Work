package datatype;


public class Longitude extends A_LatitudeLongitude implements Comparable<A_LatitudeLongitude> {
    
    public Longitude(double nmea) {
        
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
    }
    
    public Longitude(int degrees, int minutes, double seconds) {
        
        super(degrees, minutes, seconds);
    }
    
    public Longitude add(Longitude longitude) {
        
        Longitude resultLong;
        
        double result1 = convertToNMEA();
        double result2 = longitude.convertToNMEA();
        double finalResult = result1 + result2;
        
        resultLong = new Longitude(finalResult);
        
        return resultLong;
    }
    
    public Longitude subtract(Longitude longitude) {
        
        Longitude resultLong;
        
        double result1 = convertToNMEA();
        double result2 = longitude.convertToNMEA();
        double finalResult = result1 - result2;
        
        resultLong = new Longitude(finalResult);
        
        return resultLong;
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
}