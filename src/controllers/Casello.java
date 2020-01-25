package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Database;
import models.CaselloModel;
import views.Caselli;

/**
 * Handles Casello's distances
 * @author gabrieleromanato
 *
 */

public class Casello extends Controller {
	
	private Database db;
	private double startKm;
	private double endKm;
	protected Caselli view;

	public Casello() {
		db = new Database();
	}
	
	public Casello(double startKm, double endKm) {
		this.startKm = startKm;
		this.endKm = endKm;
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(Caselli view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}
	
	public void setStartKm(String casello) {
		startKm = getKm(casello);
	}
	
	public void setEndKm(String casello) {
		endKm = getKm(casello);
	}

	public double getStartKm() {
		return startKm;
	}

	public void setStartKm(double startKm) {
		this.startKm = startKm;
	}

	public double getEndKm() {
		return endKm;
	}

	public void setEndKm(double endKm) {
		this.endKm = endKm;
	}
	
	/**
	 * Save a new casello into the database
	 * @param casello Casello model instance
	 * @return boolean
	 */

	public boolean saveCasello(CaselloModel casello) {
		String query = "INSERT INTO caselli (autostrada, progressiva_km, nome, codice) VALUES (";
		query += "'" + casello.autostrada + "'," + Double.toString(casello.progressivaKm) + ",";
		query += "'" + casello.nome + "','" + casello.codice + "')";
		
		return db.writeData(query);
	}
	
	/**
	 * Gets the total distance of each casello from the database
	 * 
	 * @param caselloName
	 * @return double
	 */
	
	private double getKm(String caselloName) {
		String query = "SELECT progressiva_km FROM caselli WHERE nome = '" + caselloName + "'";
		ArrayList <HashMap<String, String>> results = db.readData(query);
		return Double.parseDouble(results.get(0).get("progressiva_km"));
	}

}
