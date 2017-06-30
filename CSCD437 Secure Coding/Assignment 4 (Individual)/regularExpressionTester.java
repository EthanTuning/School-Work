import java.util.Scanner;

public class regularExpressionTester{
	/**
	 * Tester to test Regular Expressions
	 * from my regular expression class
	 */
	public static void main(String [] args){
		getRegex();
	}
	
	public static char menu(Scanner kb){
		char choice = '\0';
		
		System.out.printf( "Test a regex!\n"
				         + "---------------------------------\n"
				         + "a. Social Security Number\n"
				         + "b. US Phone number\n"
				         + "c. E-mail address\n"
				         + "d. Name on a class roster, assuming one or more middle initials - Last name, First name, MI\n"
				         + "e. Date in MM-DD-YYYY format\n"
				         + "f. House address - Street number, street name, abbreviation for road, street, boulevard or avenue\n"
				         + "g. City followed by state followed by zip as it should appear on a letter\n"
				         + "h. Military time, including seconds\n"
				         + "i. US Currency down to the penny (ex: $123,456,789.23)\n"
				         + "j. URL, including http:// (upper and lower case should be accepted)\n"
				         + "k. A password that contains at least 10 characters and includes at least one upper case character, lower case\n character, digit, punctuation mark, and does not have more than 3\n consecutive lower case characters\n"
				         + "l. All words containing an odd number of alphabetic characters, ending in 'ion'\n"
				         + "q. Quit tester.\n"
				         + "---------------------------------\n"
				         + "Enter your choice: ");
		choice = (char)kb.nextLine().charAt(0);
		return choice;
	}
	
	public static void getRegex(){
		String regex = null;
		char choice = ' ';
		Scanner kb = new Scanner(System.in);
		
		while((int)choice != (int)'q'){
			choice = menu(kb);
			
	        switch(choice){
	           case 'a':   regex = regularExpression.ssnRegex();
	                       break;
	           case 'b':   regex = regularExpression.phoneRegex();
	                       break;
	           case 'c':   regex = regularExpression.emailRegex();
	                       break;
	           case 'd':   regex = regularExpression.fullNameRegex();
	                       break;
	           case 'e':   regex = regularExpression.dateRegex();
	                       break;
	           case 'f':   regex = regularExpression.addressRegex();
	                       break;
	           case 'g':   regex = regularExpression.cityRegex();
	                       break;
	           case 'h':   regex = regularExpression.timeRegex();
	                       break;
	           case 'i':   regex = regularExpression.usCurrencyRegex();
	                       break;
	           case 'j':   regex = regularExpression.urlRegex();
	                       break;
	           case 'k':   regex = regularExpression.passwordRegex();
	                       break;
	           case 'l':   regex = regularExpression.endsInIonRegex();
	                       break;
	           default:    break;
	        }
	        
	        if((int)choice == (int)'q')
	        	System.exit(0);
			
			regularExpression.compile(regex, kb);
        }
	}
}