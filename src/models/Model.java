package models;

import java.util.HashMap;

/**
 * The base class for models
 * 
 * @author gabrieleromanato
 *
 */

public abstract class Model {
	
	/**
	 * Gets a resource
	 * 
	 * @return HashMap
	 */
	
	public abstract HashMap<?, ?> get();
	/**
	 * Saves a resource
	 * 
	 * @return Boolean
	 */
	public abstract boolean save();
	/**
	 * Updates a resource
	 * 
	 * @return Boolean
	 */
	public abstract boolean update();
	/**
	 * Deletes a resource
	 * 
	 * @return Boolean
	 */
	public abstract boolean delete();
	

}
