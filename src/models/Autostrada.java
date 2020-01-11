package models;

import java.util.HashMap;

public class Autostrada extends Model {
	
	private String nome;
	private String codice;
	private HashMap<?,?> data;
	
	public Autostrada() {
		this("A0", "A00");
	}
	
	
	
	public Autostrada(String nome, String codice) {
		this.nome = nome;
		this.codice = codice;
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
