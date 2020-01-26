package helpers;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility class for formatting strings
 * @author gabrieleromanato
 *
 */

public class Formatter {
	
	/**
	 * Formats an amount to a specific locale string
	 * @param amount
	 * @param locale
	 * @return String
	 */

	public static String formatCurrency(double amount, Locale locale) {
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	    return currencyFormatter.format(amount);
	}

}
