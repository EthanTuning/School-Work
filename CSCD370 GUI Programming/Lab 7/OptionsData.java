package etuninglab7;

import java.util.prefs.Preferences;

public class OptionsData {
    
    public static boolean displayDateAndTime = false;
    public static boolean displayItalics = false;
    public static boolean displayBold = false;
    public static String displayString = "Do File -> Options to change this.";
    public static int fontSize = 12;
    
    public static void storePreferences(Class theClass) {

        Preferences prefs = Preferences.userNodeForPackage(theClass);
        prefs.putBoolean("displayDateAndTime", displayDateAndTime);
        prefs.putBoolean("displayItalics", displayItalics);
        prefs.putBoolean("displayBold", displayBold);
        prefs.put("displayString", displayString);
        prefs.putInt("fontSize", fontSize);

    }

    public static void readPreferences(Class theClass) {

        Preferences prefs = Preferences.userNodeForPackage(theClass);
        displayDateAndTime = prefs.getBoolean("displayDateAndTime", false);
        displayItalics = prefs.getBoolean("displayItalics", false);
        displayBold = prefs.getBoolean("displayBold", false);
        displayString = prefs.get("displayString", "Do File -> Options to change this.");
        fontSize = prefs.getInt("fontSize", 12);
        
    }
}