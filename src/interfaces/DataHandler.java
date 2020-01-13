package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The generic data handler
 * 
 * @author gabrieleromanato
 *
 */

public interface DataHandler {
	
	/**
	 * Reads data from a source
	 * @param String query
	 * 
	 * 
	 * 
	 * @return ArrayList
	 */
	
	ArrayList<HashMap<String, String>> readData( String query );
	
	/**
	 * Writes data to a destination
	 * @param String query
	 * 
	 * @return Boolean
	 */
	
	boolean writeData( String query );

}
