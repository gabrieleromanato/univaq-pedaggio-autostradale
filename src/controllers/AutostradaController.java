package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Database;
import models.Casello;
import models.ClasseTariffaria;
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
	private ArrayList<ClasseTariffaria> classiTariffarie;
	private ArrayList<HashMap<String, Double>> mapTariffe;
	private double[] tariffe;

	public AutostradaController() {
		db = new Database();
		caselli = setCaselli();
		autostrade = setAutostrade();
		classiTariffarie = setClassiTariffarie();
	}
	
	public void setTariffe(double[] tariffe) {
		this.tariffe = tariffe;
	}
	
	public double[] getTariffe() {
		return tariffe;
	}
	
	/**
	 * Sets the map of tariffe and classi
	 * @param None
	 * @return ArrayList Map of tariffe and classi
	 */
	
	public void setMapTariffe() {
		ArrayList<HashMap<String, Double>> map = new ArrayList<HashMap<String, Double>>();
		
		int i = -1;
		
		for(ClasseTariffaria c: classiTariffarie) {
			i++;
			HashMap<String, Double> cl = new HashMap<String, Double>();
			cl.put(c.nome, tariffe[i]);
			map.add(cl);
		}
		
		
		mapTariffe = map;
		
	}
	
	public ArrayList<HashMap<String, Double>> getMapTariffe() {
		return mapTariffe;
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
	 * Sets the list of ClasseTariffaria models
	 * 
	 * @param None
	 * @return ArrayList A list of ClasseTariffaria models
	 */
	
	private ArrayList<ClasseTariffaria> setClassiTariffarie() {
		String query = "SELECT * FROM classi_tariffarie";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		ArrayList<ClasseTariffaria> data = new ArrayList<>();
		for(HashMap<String, String> result : results) {
			ClasseTariffaria classe = new ClasseTariffaria(result.get("nome"), result.get("esempi"));
			data.add(classe);
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
	
	/**
	 * 
	 * @return List of ClassiTariffarie
	 */
	
	public ArrayList<ClasseTariffaria> getClassiTariffarie() {
		return classiTariffarie;
	}
	
	/**
	 * Inserts an Autostrada into the database
	 * 
	 * @param auto Autostrada model
	 * @return Boolean
	 */
	
	public boolean saveAutostrada(Autostrada auto) {
		String query = "INSERT INTO autostrade (nome, codice) VALUES ('" + auto.nome + "','" + auto.codice + "')";
		return db.writeData(query);
	}
	
	

}
