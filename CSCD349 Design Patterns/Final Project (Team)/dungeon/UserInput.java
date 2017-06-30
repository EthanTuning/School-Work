package dungeon;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    public static boolean validateUserInput(String input, String type){
    	String intRegex = "\\d+";
    	String yesOrNoRegex = "^(y|n)$";
    	Pattern pattern = null;
    	
    	if(type.equals("integer"))
    		pattern = Pattern.compile(intRegex);
    	if(type.equals("yORn"))
    		pattern = Pattern.compile(yesOrNoRegex);
    	
    	Matcher matcher = pattern.matcher(input);
    	return matcher.matches();
    }
    
    public static String getUserInput(String type){
    	boolean isValid = false;
    	Scanner scanner = new Scanner(System.in);
    	String input = null;
    	
    	while(!isValid){
    		input = scanner.next();
    		isValid = validateUserInput(input, type);
    		scanner.nextLine();
    		if(!isValid)
    			System.out.println("Invalid input.");
    	}
    	return input;
    }
}