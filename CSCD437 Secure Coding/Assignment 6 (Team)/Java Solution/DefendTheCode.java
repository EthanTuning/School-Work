//Ethan Tuning, Gavin Rouse, Collin Nolen

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class DefendTheCode{
	private static Scanner kb = new Scanner(System.in);
	private static int int1, int2;
	private static long addResult, multResult;
	private static String firstName, lastName, inputFile, outputFile; 
	private static byte[]password, verifyPassword;
	private static byte[] salt;
	private static File real_input_file, unique_output_file;
	private static ArrayList<String> errors = new ArrayList<>();

	public static void main(String[] args){
		try{
			getFullName();
			getPassword();
			verifyPassword();
			getInteger();
			getInputFile();
			getOutputName();
			if(combineContents()){
				System.out.println("Successfully copied First + Last name, addition of the integers, mastication" +
						" of the integers, and the contents of the input file into the output file which can be " +
						"found in "+ System.getProperty("user.dir")+".");
			}

		}catch(Exception e){
			System.out.println("Something bad happened...");
			e.printStackTrace();
		}
	}
	
	static boolean getInput(String regex, String prompt, String inputType) throws NoSuchAlgorithmException, InvalidKeySpecException{
		boolean isValid = false;
		int intCount = 0;
		String attempt;
		
		while(!isValid){
			System.out.println(prompt);

			attempt = kb.nextLine();

			if(inputType.equals("password") && compareToRegex(regex, attempt)){
				salt = getSalt();
				password = getSecuredPassword(attempt, salt);
				isValid = true;
			}
			
			else if(inputType.equals("verifypassword") && compareToRegex(regex, attempt)){
				verifyPassword = getSecuredPassword(attempt, salt);
				isValid = validatePassword(verifyPassword, password);
			}

			else if(inputType.equals("outputfile") && compareToRegex(regex, attempt)){
				isValid = checkUniqueFileName(attempt);
				outputFile = attempt;
			}

			else if(inputType.equals("integer") && compareToRegex(regex, attempt)){
				try{
					if(Integer.parseInt(attempt) > Integer.MAX_VALUE || Integer.parseInt(attempt) < Integer.MIN_VALUE){
						System.out.println("Integer in-valid.");
					}
					else{
						intCount++;
						if(intCount == 1)
							int1 = Integer.parseInt(attempt);
						
						
						if(intCount == 2){
							int2 = Integer.parseInt(attempt);
							try {
								addResult = addInts(int1, int2);
								multResult = multInts(int1, int2);
							}
							catch (ArithmeticException e)
							{
								errors.add("Overflow occurred when adding or multiplying the two ints\r\n");
								System.out.println("Overflow occurred when adding or multiplying the two ints");
							}
							isValid = true;
						}
					}
				}catch(NumberFormatException e){
					System.out.println("Integer in-valid.");
				}
			}

			else if(inputType.equals("firstName") && compareToRegex(regex, attempt)){
				firstName = attempt;
				isValid = true;
			}

			else if(inputType.equals("lastName") && compareToRegex(regex, attempt)){
				lastName = attempt;
				isValid = true;
			}

			else if(inputType.equals("inputFile") && compareToRegex(regex, attempt)){
				inputFile = attempt;
				isValid = true;
			}
		}
		
		return isValid;
	}
	
	static long addInts(int num1, int num2){ return Math.addExact(num1, num2); }

	static long multInts(int num1, int num2){ return Math.multiplyExact(num1, num2); }

	static boolean getInteger() throws NoSuchAlgorithmException, InvalidKeySpecException{
		String intRegex = "\\d+";
		String prompt = "Enter an integer value: ";
		boolean isValid = getInput(intRegex, prompt, "integer");

		return isValid;
	}

	static boolean getPassword() throws NoSuchAlgorithmException, InvalidKeySpecException{
		String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		String prompt = "Enter a password at least 8 characters long (must contain a lower case, upper case, a digit, and a special character): ";
		boolean isValid = getInput(passwordRegex, prompt, "password");
		
		return isValid;
	}
	
	static boolean verifyPassword() throws NoSuchAlgorithmException, InvalidKeySpecException{
		String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		String prompt = "Re-enter your password: ";
		boolean isValid = getInput(passwordRegex, prompt, "verifypassword");
		
		if(isValid){
			System.out.println("Your password is valid.");
			return isValid;
		}
		else{
			System.out.println("Password is invalid.");
			return isValid;
		}
	}
	
	static boolean validatePassword(byte[] passwordAttempt, byte[] securePassword){;
		return Arrays.equals(passwordAttempt, securePassword);
	}
	
	static byte[] getSecuredPassword(String password, byte[] theSalt) throws NoSuchAlgorithmException, InvalidKeySpecException{
		/*Make our secure password*/
		int keyLen = 160;
		int iterations = 2000;
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), theSalt, iterations, keyLen);
		SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		return key.generateSecret(keySpec).getEncoded();
	}
	
	static byte[] getSalt() throws NoSuchAlgorithmException{
		/*Make our salt*/
		byte[] theSalt = new byte[8];
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.nextBytes(theSalt);
		
		return theSalt;
	}

	static boolean getFullName() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String nameRegex = "^[A-Za-z'-]{1,50}$";
		String prompt = "Enter your first name (50 or fewer characters)";
		getInput(nameRegex, prompt, "firstName");
		prompt = "Enter your last name (50 or fewer characters)";
		boolean isValid = getInput(nameRegex, prompt, "lastName");

		return isValid;
	}

	static boolean getInputFile() throws InvalidKeySpecException, NoSuchAlgorithmException {
		String inputFileRegex = "^[\\w_-]{1,50}(.txt)$";
		String prompt = "Enter an input file from current working directory (e.g. input.txt)";
		boolean isValid = getInput(inputFileRegex, prompt, "inputFile");

		return isValid;
	}

	static boolean compareToRegex(String regex, String input){
        	Pattern pattern = Pattern.compile(regex);
        	Matcher matcher = pattern.matcher(input);
        
        	return matcher.matches();
	}


	/**
	 * Retrieves the output file name from the user.
	 * @return boolean
	 */
	static boolean getOutputName() throws NoSuchAlgorithmException, InvalidKeySpecException{
		String outputfileRegex = "([a-zA-Z0-9!#$%&\\(\\)\\{\\}\\]\\[\\^_`~@; ]){1,255}";
		String prompt = "Enter a output file name. (must be within this directory (run from commandline), the file cannot exist" +
				", no file extensions, and it must be using the English Alphabet.)";
		
		return getInput(outputfileRegex, prompt, "outputfile");
	}


	/**
	 * Checks current directory's file/directory names against incoming param. Returns true if unique.
	 * @param attempt
	 * @return boolean
	 */
	static boolean checkUniqueFileName(String attempt){
		findFile(System.getProperty("user.dir"), attempt, 0);

		if(unique_output_file != null){
			System.out.println("File with that name already exists.");
			return false;
		}

		return true;
	}


	/**
	 * Recursively tries to match file with fileName, starting from path startparth,
	 * working its way in each of its subdirectories.
	 * @param startpath
	 * @param fileName
	 * @return
	 */
	static void findFile(String startpath, String fileName, int flag){
		File startPath = new File(startpath);
		File[] list;
		if((list = startPath.listFiles()) != null){
			for(File f: list) {
				if (f.isDirectory()) {
					findFile(f.getPath(), fileName, flag);
				}
				else if(f.getName().equals(fileName)){
					if(flag == 1)
						real_input_file = f;
					else if(flag == 0)
						unique_output_file = f;
				}
			}
		}
	}

	/**
	 * Combines First and Last name, addition of int1 and int2, multiplication of int1 and int2,
	 * and the contents of inputFile and writes them into the specified outputFile.
	 *
	 * Returns true if a successful combination, false otherwise.
	 * @return boolean
	 */
	static boolean combineContents(){

		try{
			String line;

			//Opens inputfile and creates output file
			findFile(System.getProperty("user.dir"), inputFile, 1);
			File input = real_input_file;
			File output = new File(outputFile +".txt");

			//Checks if input file exists.
			if(input == null) {
				System.out.println("Input file " + inputFile + " was not found.");
				return false;
			}

			//Opens inputfile reader
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);

			//Opens outputfile Writer
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("First and Last name: "+ firstName + " " + lastName);
			bw.newLine();
			bw.write("Adding the two ints: "+ addResult);
			bw.newLine();
			bw.write("Multiplying the two ints: " + multResult);
			bw.newLine();

			while((line = br.readLine())!=null){
				bw.write(line);
				bw.newLine();
			}

			for (String s : errors)
			{
				bw.write(s);
				bw.newLine();
			}

			br.close();
			bw.close();
			fr.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		return true;
	}
}