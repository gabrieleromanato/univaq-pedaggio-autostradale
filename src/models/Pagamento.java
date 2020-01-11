package models;

import java.util.Date;
import java.util.HashMap;

public class Pagamento extends Model {
	
	private String idVeicolo;
	private double importo;
	private Date orario;
	private String tipologia;
	private HashMap<?, ?> data;
	
	public Pagamento() {
		this("AZ1234", 9.99, "contanti");
	}
	
	public Pagamento(String idVeicolo, double importo, String tipologia) {
		this.idVeicolo = idVeicolo;
		this.importo = importo;
		this.orario = new Date();
		this.tipologia = tipologia;
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
	public HashMap<?, ?> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
