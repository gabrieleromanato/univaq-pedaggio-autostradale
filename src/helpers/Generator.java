package helpers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
	
	/**
	 * Creates a random number between min and max
	 * 
	 * @param min Minimum value
	 * @param max Maximum value
	 * @return int Random number
	 */
	
	public static int createNumber(int min, int max) {
		int randomInt = ThreadLocalRandom.current().nextInt(min, max);
		return randomInt;
	}

}
