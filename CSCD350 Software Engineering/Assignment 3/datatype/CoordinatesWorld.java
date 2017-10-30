package datatype;


public class CoordinatesWorld {
	
    //public static final CoordinatesWorld KGEG = ....;
    //public static final CoordinatesWorld KSFF = ....;
    //public static final CoordinatesWorld KSKA = ....;
    public static final double METERS_PER_NAUTICAL_MILE = 1852;
    
    private Latitude mLatitude;
    private Longitude mLongitude;
    
    public CoordinatesWorld(Latitude latitude, Longitude longitude) {
        
        mLatitude = latitude;
        mLongitude = longitude;
    }
    
    public CoordinatesWorld add(CoordinatesWorld coordinates) {
        
        Latitude resultLat = mLatitude.add(coordinates.getLatitude());
        Longitude resultLong = mLongitude.add(coordinates.getLongitude());
        
        CoordinatesWorld resultCoordinates = new CoordinatesWorld(resultLat, resultLong);
        
        return resultCoordinates;
    }
    
    public static CoordinatesWorld build(int latitudeDegrees, 
                                         int latitudeMinutes, 
                                         double latitudeSeconds, 
                                         int longitudeDegrees, 
                                         int longitudeMinutes, 
                                         double longitudeSeconds) {
        
        Latitude resultLat = new Latitude(latitudeDegrees, 
                                          latitudeMinutes, 
                                          latitudeSeconds);
        
        Longitude resultLong = new Longitude(longitudeDegrees,
                                             longitudeMinutes,
                                             longitudeSeconds);
        
        CoordinatesWorld resultCoordinates = new CoordinatesWorld(resultLat, resultLong);
        
        return resultCoordinates;
    }
    
    public Angle calculateBearing(CoordinatesWorld target) {
        
        double latDis = target.getLatitude().subtract(mLatitude).convertToNMEA();
        double longDis = target.getLongitude().subtract(mLongitude).convertToNMEA();
        
        double result = Math.toDegrees(Math.atan(latDis/longDis));
        
        Angle resultAngle = new Angle(result);
        
        return resultAngle;
    }
    
    public double calculateDistanceMeters(CoordinatesWorld target) {
        
        double result = calculateDistanceNauticalMiles(target);
        
        return result * METERS_PER_NAUTICAL_MILE;
    }
    
    public double calculateDistanceNauticalMiles(CoordinatesWorld target) {
        
        double result = Math.sqrt(((target.getLatitude().subtract(mLatitude).convertToNMEA())*
                                   (target.getLatitude().subtract(mLatitude).convertToNMEA()))+ 
                                   ((target.getLongitude().subtract(mLongitude).convertToNMEA())* 
                                   (target.getLongitude().subtract(mLongitude).convertToNMEA())));

        return result;
    }
    
    public CoordinatesWorld calculateTarget(Angle bearing, double distance) {
        
        CoordinatesWorld resultCoordinates;
        
        Latitude result1 = new Latitude(Math.cos(bearing.getValue()) * distance);
        Longitude result2 = new Longitude(Math.sin(bearing.getValue()) * distance);
        Latitude newLat = mLatitude.add(result1);
        Longitude newLong = mLongitude.add(result2);
        
        resultCoordinates = new CoordinatesWorld(newLat, newLong);
        
        return resultCoordinates;
    }
    
    public CoordinatesWorld calculateTarget(CoordinatesDelta target) {
        
        CoordinatesWorld resultCoordinates;
        
        Latitude resultLat = new Latitude(target.getX() + mLatitude.convertToNMEA());
        Longitude resultLong = new Longitude(target.getY() + mLongitude.convertToNMEA());
        
        resultCoordinates = new CoordinatesWorld(resultLat, resultLong);
        
        return resultCoordinates;
    }
    
    public static double convertMetersToNauticalMiles(double meters) {
        
        return meters / METERS_PER_NAUTICAL_MILE;
    }
    
    public Latitude getLatitude() {
        
        return mLatitude;
    }
    
    public Longitude getLongitude() {
        
        return mLongitude;
    }
    
    public String getPrettyForm() {
        
        return "Latitude: " + mLatitude + "\nLongitude: " + mLongitude;
    }
    
    public CoordinatesWorld subtract(CoordinatesWorld coordinates) {
        
        Latitude resultLat = mLatitude.subtract(coordinates.getLatitude());
        Longitude resultLong = mLongitude.subtract(coordinates.getLongitude());
        
        CoordinatesWorld resultCoordinates = new CoordinatesWorld(resultLat, resultLong);
        
        return resultCoordinates;
    }
    
    @Override
    public String toString() {
        
        return getPrettyForm();
    }
    
    public String toStringNMEA() {
        
        return "NMEA Latitude: " + mLatitude.convertToNMEA() +
               "\nNMEA Longitude: " + mLongitude.convertToNMEA();
    }
}
