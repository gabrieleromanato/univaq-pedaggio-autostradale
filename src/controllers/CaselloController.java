package controllers;

import classes.Database;
import models.Casello;

public class CaselloController {
	
	private Database db;

	public CaselloController() {
		db = new Database();
	}
	
	public boolean saveCasello(Casello casello) {
		String query = "INSERT INTO caselli (autostrada, progressiva_km, nome, codice) VALUES (";
		query += "'" + casello.autostrada + "'," + Double.toString(casello.progressivaKm) + ",";
		query += "'" + casello.nome + "','" + casello.codice + "')";
		
		return db.writeData(query);
	}

}
