package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import classes.Database;

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
	
	/**
	 * Gets a random classe tariffaria
	 * 
	 * @param None
	 * @return String Name of the classe tariffaria
	 */
	
	public static String getRandomClasseTariffaria() {
		String classe = "";
		Database db = new Database();
		ArrayList<HashMap<String, String>> result = db.readData("SELECT * FROM classi_tariffarie ORDER BY RAND() LIMIT 1");
		classe = result.get(0).get("nome");
		return classe;
	}

}
