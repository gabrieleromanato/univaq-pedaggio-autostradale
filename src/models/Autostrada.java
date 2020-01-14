package models;

/**
 * The data model for an autostrada record
 * 
 * @author gabrieleromanato
 *
 */

public class Autostrada extends Model {
	
	public String nome;
	public String codice;
	
	
	public Autostrada() {
		this("A0", "A00");
	}
	
	
	
	public Autostrada(String nome, String codice) {
		this.nome = nome;
		this.codice = codice;
		
	}

}
