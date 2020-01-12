package models;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Database;

public class Autostrada extends Model {
	
	private String nome;
	private String codice;
	private HashMap<?,?> data;
	private Database db;
	
	public Autostrada() {
		this("A0", "A00");
	}
	
	
	
	public Autostrada(String nome, String codice) {
		this.nome = nome;
		this.codice = codice;
		this.db = new Database();
	}

	@Override
	public HashMap<String,String> get() {
		String query = "SELECT * FROM autostrade WHERE codice = '" + codice + "'";
		ArrayList<HashMap<String, String>> results = db.readData(query);
		if(results.size() > 0) {
			HashMap<String, String> result = new HashMap<String, String>();
			HashMap<String, String> datum = results.get(0);
			
			result.put("id", datum.get("id"));
			result.put("nome", datum.get("nome"));
			result.put("codice", datum.get("codice"));
			return result;
		} else {
			return null;
		}	
	}

	@Override
	public boolean save() {
		String query = "INSERT INTO autostrade (nome, codice) VALUES ('" + nome + "','" + codice + "')";
		return db.writeData(query);
	}

	@Override
	public boolean update() {
		String query = "UPDATE autostrade SET nome = '" + nome + "', codice = '" + codice + "' WHERE codice = '" + codice + "'";
		return db.writeData(query);
	}

	@Override
	public boolean delete() {
		String query = "DELETE FROM autostrade WHERE codice = '" + codice + "'";
		return db.writeData(query);
	}
	
	public void setData(HashMap<?,?> data) {
		this.data = data;
	}
	
	public HashMap<?,?> getData() {
		return null;
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

}
