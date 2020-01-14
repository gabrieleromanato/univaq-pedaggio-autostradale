package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Database;
import models.Casello;
import models.Autostrada;

/**
 * The Autostrada entity controller
 * @author gabrieleromanato
 *
 */

public class AutostradaController {
	
	private Database db;
	private ArrayList<Casello> caselli;
	private ArrayList<Autostrada> autostrade;

	public AutostradaController() {
		db = new Database();
		caselli = setCaselli();
		autostrade = setAutostrade();
	}
	
	/**
	 * Sets the list of Casello models
	 * 
	 * @param None
	 * @return ArrayList A list of Casello models
	 */
	
	private ArrayList<Casello> setCaselli() {
		String query = "SELECT * FROM caselli";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		ArrayList<Casello> data = new ArrayList<>();
		for(HashMap<String, String> result : results) {
			Casello casello = new Casello(result.get("autostrada"), Double.parseDouble(result.get("progressiva_km")), result.get("nome"), result.get("codice"));
			data.add(casello);
		}
		return data;
	}
	
	/**
	 * 
	 * @return List of caselli
	 */
	
	public ArrayList<Casello> getCaselli() {
		return caselli;
	}
	
	/**
	 * Sets the list of Autostrada models
	 * 
	 * @param None
	 * @return ArrayList A list of Autostrada models
	 */
	
	private ArrayList<Autostrada> setAutostrade() {
		String query = "SELECT * FROM autostrade";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		ArrayList<Autostrada> data = new ArrayList<>();
		for(HashMap<String, String> result : results) {
			Autostrada auto = new Autostrada(result.get("nome"), result.get("codice"));
			data.add(auto);
		}
		
		return data;
	}
	
	/**
	 * 
	 * @return List of autostrade
	 */
	
	
	public ArrayList<Autostrada> getAutostrade() {
		return autostrade;
	}
	
	

}
