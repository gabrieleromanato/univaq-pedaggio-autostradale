package models;

/**
 * The data model for an autostrada record
 * 
 * @author gabrieleromanato
 *
 */

public class AutostradaModel extends Model {
	
	public String nome;
	public String codice;
	
	
	public AutostradaModel() {
		this("A0", "A00");
	}
	
	
	
	public AutostradaModel(String nome, String codice) {
		this.nome = nome;
		this.codice = codice;
		
	}

}
