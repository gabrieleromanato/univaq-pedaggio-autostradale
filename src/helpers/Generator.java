package helpers;

import java.util.Random;

/**
 *  Helper methods and utilities
 * 
 * @author gabrieleromanato
 *
 */

public class Generator {
	
	/**
	 * Creates a random plate number in the format letterletter-digits
	 * 
	 * @param None
	 * @return String
	 */
	
	public static String createPlateNumber() {
		char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		Random rand = new Random();
		
		String firstLetter = "" + letters[rand.nextInt(letters.length)];
		String secondLetter = "" + letters[rand.nextInt(letters.length)];
		int number = rand.nextInt(9999);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(firstLetter + secondLetter);
		sb.append("-");
		sb.append(number);
		
		return sb.toString();
	}

}
