package models;


/**
 * The data model for an casello record
 * 
 * @author gabrieleromanato
 *
 */

public class CaselloModel extends Model {
	
	public String autostrada;
	public double progressivaKm;
	public String nome;
	public String codice;
	
	public CaselloModel() {
		this("A00", 1.00, "Casello", "000");
	}
	
	

	public CaselloModel(String autostrada, double progressivaKm, String nome, String codice) {
		this.autostrada = autostrada;
		this.progressivaKm = progressivaKm;
		this.nome = nome;
		this.codice = codice;
	}
}
