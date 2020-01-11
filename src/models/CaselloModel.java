package models;

import java.util.HashMap;

public class CaselloModel extends Model {
	
	private String autostrada;
	private double progressivaKm;
	private String nome;
	private String codice;
	private HashMap<?,?> data;
	
	public CaselloModel() {
		this("A00", 1.00, "Casello", "000");
	}
	
	

	public CaselloModel(String autostrada, double progressivaKm, String nome, String codice) {
		this.autostrada = autostrada;
		this.progressivaKm = progressivaKm;
		this.nome = nome;
		this.codice = codice;
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
