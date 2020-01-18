package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Database;
import models.CaselloModel;
import models.ClasseTariffaria;
import models.AutostradaModel;

/**
 * The Autostrada entity controller
 * @author gabrieleromanato
 *
 */

public class Autostrada {
	
	private Database db;
	private ArrayList<CaselloModel> caselli;
	private ArrayList<AutostradaModel> autostrade;
	public static final double TARIFFA_UNITARIA = 0.5;
	
	public Autostrada () {
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
	
	private ArrayList<CaselloModel> setCaselli() {
		String query = "SELECT * FROM caselli";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		ArrayList<CaselloModel> data = new ArrayList<>();
		for(HashMap<String, String> result : results) {
			CaselloModel casello = new CaselloModel(result.get("autostrada"), Double.parseDouble(result.get("progressiva_km")), result.get("nome"), result.get("codice"));
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
	
	@SuppressWarnings("unused")
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
	
	public ArrayList<CaselloModel> getCaselli() {
		return caselli;
	}
	
	/**
	 * Sets the list of Autostrada models
	 * 
	 * @param None
	 * @return ArrayList A list of Autostrada models
	 */
	
	private ArrayList<AutostradaModel> setAutostrade() {
		String query = "SELECT * FROM autostrade";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		ArrayList<AutostradaModel> data = new ArrayList<>();
		for(HashMap<String, String> result : results) {
			AutostradaModel auto = new AutostradaModel(result.get("nome"), result.get("codice"));
			data.add(auto);
		}
		
		return data;
	}
	
	/**
	 * 
	 * @return List of autostrade
	 */
	
	
	public ArrayList<AutostradaModel> getAutostrade() {
		return autostrade;
	}
	
	/**
	 * Inserts an Autostrada into the database
	 * 
	 * @param auto Autostrada model
	 * @return Boolean
	 */
	
	public boolean saveAutostrada(AutostradaModel auto) {
		String query = "INSERT INTO autostrade (nome, codice) VALUES ('" + auto.nome + "','" + auto.codice + "')";
		return db.writeData(query);
	}
	
	

}
