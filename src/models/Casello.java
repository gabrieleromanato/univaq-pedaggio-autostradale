package models;


/**
 * The data model for an casello record
 * 
 * @author gabrieleromanato
 *
 */

public class Casello extends Model {
	
	public String autostrada;
	public double progressivaKm;
	public String nome;
	public String codice;
	
	public Casello() {
		this("A00", 1.00, "Casello", "000");
	}
	
	

	public Casello(String autostrada, double progressivaKm, String nome, String codice) {
		this.autostrada = autostrada;
		this.progressivaKm = progressivaKm;
		this.nome = nome;
		this.codice = codice;
	}
}
