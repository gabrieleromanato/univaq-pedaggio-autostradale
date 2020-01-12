package models;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Database;

/**
 * The data model for an casello record
 * 
 * @author gabrieleromanato
 *
 */

public class CaselloModel extends Model {
	
	private String autostrada;
	private double progressivaKm;
	private String nome;
	private String codice;
	private HashMap<?,?> data;
	private Database db;
	
	public CaselloModel() {
		this("A00", 1.00, "Casello", "000");
	}
	
	

	public CaselloModel(String autostrada, double progressivaKm, String nome, String codice) {
		this.autostrada = autostrada;
		this.progressivaKm = progressivaKm;
		this.nome = nome;
		this.codice = codice;
		this.db = new Database();
	}

	public String getAutostrada() {
		return autostrada;
	}

	public void setAutostrada(String autostrada) {
		this.autostrada = autostrada;
	}

	public double getProgressivaKm() {
		return progressivaKm;
	}

	public void setProgressivaKm(double progressivaKm) {
		this.progressivaKm = progressivaKm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public HashMap<?, ?> getData() {
		return data;
	}

	public void setData(HashMap<?, ?> data) {
		this.data = data;
	}
	
	/**
	 *   Gets a casello record from the database
	 *   
	 *   @param none
	 *   @return HashMap
	 * 
	 */

	@Override
	public HashMap<String, String> get() {
		
		String query = "SELECT * FROM caselli WHERE codice = '" + codice + "'";
		ArrayList<HashMap<String, String>> results = db.readData(query);
		if(results.size() > 0) {
			HashMap<String, String> result = new HashMap<String, String>();
			HashMap<String, String> datum = results.get(0);
			
			result.put("id", datum.get("id"));
			result.put("nome", datum.get("nome"));
			result.put("codice", datum.get("codice"));
			result.put("autostrada", datum.get("autostrada"));
			result.put("progressiva_km", datum.get("progressiva_km"));
			return result;
		} else {
			return null;
		}	
	}
	
	/**
	 *   Insert a casello record into the database
	 *   
	 *   @param none
	 *   @return Boolean
	 * 
	 */

	@Override
	public boolean save() {
		String query = "INSERT INTO caselli (autostrada, progressiva_km, nome, codice) VALUES ('" + autostrada + "'," + progressivaKm + ",'" + nome + "','" + codice + "')";
		return db.writeData(query);
	}
	
	/**
	 *   Updates a casello record
	 *   
	 *   @param none
	 *   @return Boolean
	 * 
	 */

	@Override
	public boolean update() {
		
		String query = "UPDATE caselli SET autostrada = '" + autostrada + "', progressiva_km = " + progressivaKm + ", nome = '" + nome + "', codice = '" + codice + "' WHERE codice = '" + codice + "'";
		return db.writeData(query);
	}
	
	/**
	 *   Deletes a casello record
	 *   
	 *   @param none
	 *   @return Boolean
	 * 
	 */

	@Override
	public boolean delete() {
		
		String query = "DELETE FROM caselli WHERE codice = '" + codice + "'";
		return db.writeData(query);
	}

}
