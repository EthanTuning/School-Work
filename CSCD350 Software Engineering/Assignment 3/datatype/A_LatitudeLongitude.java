package datatype;


public abstract class A_LatitudeLongitude implements Comparable<A_LatitudeLongitude> {
	
	public static final double METERS_PER_NAUTICAL_MILE = 1852;
	public static final int MINUTES_PER_DEGREE = 60;
	public static final int SECONDS_PER_MINUTE = 60;
        
	private int mDegrees;
        private int mMinutes;
        private double mSeconds;
        
	public A_LatitudeLongitude(int degrees, int minutes, double seconds) {
            
            mDegrees = degrees;
            mMinutes = minutes;
            mSeconds = seconds;
	}
        
        public double calculateDistanceMeters(A_LatitudeLongitude target) {
            
            double result = calculateDistanceNauticalMiles(target);

            return result * METERS_PER_NAUTICAL_MILE;
        }
        
        public double calculateDistanceNauticalMiles(A_LatitudeLongitude target) {
            
        double result = Math.sqrt(((target.convertToNMEA() - convertToNMEA())*
                                   (target.convertToNMEA() - convertToNMEA()))+ 
                                   ((target.convertToNMEA() - convertToNMEA())* 
                                   (target.convertToNMEA() - convertToNMEA())));

        return result;
        }
        
        @Override
        public int compareTo(A_LatitudeLongitude target) {
            
            if(target.equals(this))
                return 0;
            
            else if(target.compareTo(this) > 0)
                return 1;
            
            else
                return -1;
        }
        
        public static int convertToDegrees(double nmea) {
            
            return (int)nmea / 100;
        }
        
        public static int convertToMinutes(double nmea) {
            
            return ((int)nmea) - ((int)nmea / 100) - ((int)nmea * 60);
        }
        
        public static double convertToNauticalMiles(int degrees, 
                                                    int minutes, 
                                                    double seconds) {
            
            
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        public double convertToNMEA() {
            
            return convertToNMEA(mDegrees, mMinutes, mSeconds);
        }
        
        public static double convertToNMEA(int degrees, 
                                           int minutes, 
                                           double seconds) {
            
            return ((degrees * 100) + minutes + (seconds / 60));
        }
        
        public static double convertToSeconds(double nmea) {
            
            return nmea * 60;
        }
        
        @Override
        public boolean equals(Object coordinates) {
            
            return coordinates.equals(this);
        }
        
        public int getDegrees() {
            
            return mDegrees;
        }
        
        public int getMinutes() {
            
            return mMinutes;
        }
        
        public String getPrettyForm() {
            
            return "Degrees: "+mDegrees+"\nMinutes: "+mMinutes+"\nSeconds"+mSeconds;
        }
        
        public int hashCode() {
            
            return ((mDegrees + mMinutes + (int) mSeconds) / 11);
        }
        
        public String toString() {
            
            return getPrettyForm();
        }
}