package helpers;

import java.util.regex.Pattern;

public class Validator {

	public Validator() {
	}
	
	public static boolean isNumeric(String value) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if(value == null) {
			return false;
		}
		return pattern.matcher(value).matches();
	}

}
