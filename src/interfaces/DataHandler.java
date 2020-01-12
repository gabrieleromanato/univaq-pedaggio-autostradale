package interfaces;

import java.util.ArrayList;

/**
 * The generic data handler
 * 
 * @author gabrieleromanato
 *
 */

public interface DataHandler {
	
	/**
	 * Reads data from a source
	 * 
	 * 
	 * 
	 * @return ArrayList
	 */
	
	ArrayList<?> readData();
	
	/**
	 * Writes data to a destination
	 * 
	 * @return Boolean
	 */
	
	boolean writeData();

}
