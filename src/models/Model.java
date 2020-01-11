package models;

import java.util.HashMap;

public abstract class Model {
	
	public abstract HashMap<?, ?> get();
	public abstract boolean save();
	public abstract boolean update();
	public abstract boolean delete();
	

}
