import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class regularExpression{
	/**
	 * Methods to return the appropriate static String to be
	 * compiled as a regular expression in the test class.
	 */
	public static String ssnRegex(){
		/**
		 * Matches 123-23-1234, 123 12 1234, 123231234 
		 */
		return "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$|"
			 + "^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$|"
			 + "^(?!000|666)[0-8][0-9]{2} (?!00)[0-9]{2} (?!0000)[0-9]{4}$";
	}
	
	public static String phoneRegex(){
		/**
		 * Matches (123)1231234, (123) 123 1234, (123)-123-1234, 1231231234, 123-123-1234, 123 123 1234
		 */
		return "^[0-9]{3}-[0-9]{3}-[0-9]{4}$|"
			 + "^[0-9]{3}[0-9]{3}[0-9]{4}$|"
			 + "^[0-9]{3} [0-9]{3} [0-9]{4}$|"
			 + "^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$|"
			 + "^\\([0-9]{3}\\)[0-9]{3}[0-9]{4}$|"
			 + "^\\([0-9]{3}\\) [0-9]{3} [0-9]{4}$";
	}
	
	public static String emailRegex(){
		/**
		 * I DID NOT come up with this.
		 * Found at following link:
		 * https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
		 */
		return "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	}
	
	public static String fullNameRegex(){
		/**
		 * Matches Name mi name
		 */
		return "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
	}
	
	public static String dateRegex(){
		/**
		 * Matches 12 12 1234, 12-12-1234, 12/12/1234
		 */
		return "^[0-9]{2}-[0-9]{2}-[0-9]{4}$|"
			 + "^[0-9]{2}/[0-9]{2}/[0-9]{4}$|"
			 + "^[0-9]{2} [0-9]{2} [0-9]{4}$";
	}
	
	public static String addressRegex(){
		/**
		 * Matches 123 E roadname rd, or with any valid ending
		 */
		return "[0-9]{1,6} ((w|W|west|West|WEST|e|E|east|East|EAST|n|N|north|North|NORTH|s|S|south|South|SOUTH|"
			 + "nw|NW|northwest|Northwest|NorthWest|NORTHWEST|ne|NE|northeast|Northeast|NorthEast|NORTHEAST|sw|"
			 + "SW|southwest|Southwest|SouthWest|SOUTHWEST|se|SE|southeast|Southeast|SouthEast|SOUTHEAST) )"
			 + "?[A-Za-z0-9]{1,30} (road|Road|ROAD|rd|Rd|RD|street|Street|STREET|st|St|ST|boulevard|Boulevard|"
			 + "BOULEVARD|blvd|Blvd|BLVD|avenue|Avenue|AVENUE|ave|Ave|AVE)";
	}
	
	public static String cityRegex(){
	    /**
		 * Matches city ST zip, state needs to be campitilized
		 */
		return "^[A-Za-z]{1,20},? (AL|AK|AZ|AR|CA|CO|CT|DE|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|"
			 + "MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY)"
			 + "\\s? [0-9]{5}";
	}
	
	public static String timeRegex(){
		/**
		 * Matches 23:23:12, straight forward military time
		 */
		return "^([01]\\d|2[0-3]):?([0-5]\\d):?([0-5]\\d)$";
	}
	
	public static String usCurrencyRegex(){
		/**
		 * Matches $4.03, needs cents and dollar sign
		 */
		return "^-?\\$\\d{1,3}(?:,\\d{3}){0,4}\\.\\d{2}$";
	}
	
	public static String urlRegex(){
		/**
		 * Matches https://google.com, needs http:// in front of it, also match .anything
		 */
		return "^(http|https|HTTP|HTTPS):\\/\\/(?!-)(?!.*\\.\\.)[A-Za-z0-9_.-~]{1,30}\\.[A-Za-z0-9]{2,6}$";
	}
	
	public static String passwordRegex(){
		/**
		 * Matches any password as specified. I used a few different resources to get this one.
		 * http://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
		 * https://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
		 * few others I forgot to write down url.
		 */
		return "(?!.*[a-z]{3})(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!#$%&'*+-/=?^_`{|}~.])[A-Za-z0-9!#$%&'*+-/=?^_`{|}~.]{10}";
	}
	
	public static String endsInIonRegex(){
		/**
		 * Matches anything that ends with ion up to 29 chars
		 */
		return "([A-Za-z][A-Za-z]){1,29}(ion)$";
	}
	
	public static void compile(String regex, Scanner kb){
		String in = null;
		System.out.print("Enter test case: ");
		in = kb.nextLine();
		System.out.println(in+"\n");
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(in);
		
		if(match.matches())
			System.out.println("This is a match.\n");
		else
			System.out.println("This is not match.\n");
	}
}