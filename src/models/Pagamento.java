package models;

import java.util.ArrayList;
import java.util.Date;
import classes.Database;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class Pagamento extends Model {
	
	private String idVeicolo;
	private double importo;
	private Date orario;
	private String tipologia;
	private HashMap<?, ?> data;
	private Database db;
	
	public Pagamento() {
		this("AZ1234", 9.99, "contanti");
	}
	
	public Pagamento(String idVeicolo, double importo, String tipologia) {
		this.idVeicolo = idVeicolo;
		this.importo = importo;
		this.orario = new Date();
		this.tipologia = tipologia;
		this.db = new Database();
	}

	public HashMap<?, ?> getData() {
		return data;
	}

	public void setData(HashMap<?, ?> data) {
		this.data = data;
	}

	public String getIdVeicolo() {
		return idVeicolo;
	}

	public void setIdVeicolo(String idVeicolo) {
		this.idVeicolo = idVeicolo;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Date getOrario() {
		return orario;
	}

	public void setOrario(Date orario) {
		this.orario = orario;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public HashMap<String, String> get() {
		
		String query = "SELECT * FROM pagamenti WHERE id_veicolo = '" + idVeicolo + "'";
		ArrayList<HashMap<String, String>> results = db.readData(query);
		if(results.size() > 0) {
			HashMap<String, String> result = new HashMap<String, String>();
			HashMap<String, String> datum = results.get(0);
			
			result.put("id", datum.get("id"));
			result.put("id_veicolo", datum.get("id_veicolo"));
			result.put("importo", datum.get("importo"));
			result.put("orario", datum.get("orario"));
			result.put("tipologia", datum.get("tipologia"));
			return result;
		} else {
			return null;
		}	
	}

	@Override
	public boolean save() {
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateTime = simpleDateFormat.format(orario);
		
		String query = "INSERT INTO pagamenti (id_veicolo, importo, orario, tipologia) VALUES ('" + idVeicolo + "'," + importo + ",'" + dateTime + "','" + tipologia + "')";
		
		return db.writeData(query);
	}

	@Override
	public boolean update() {
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateTime = simpleDateFormat.format(orario);
		
		String query = "UPDATE pagamenti SET id_veicolo = '" + idVeicolo + "', importo = " + importo + ", orario = '" + dateTime + "', tipologia = '" + tipologia + "' WHERE id_veicolo = '" + idVeicolo + "'";
		return db.writeData(query);
	}

	@Override
	public boolean delete() {
		String query = "DELETE FROM pagamenti WHERE id_veicolo = '" + idVeicolo + "'";
		return db.writeData(query);
	}

}
