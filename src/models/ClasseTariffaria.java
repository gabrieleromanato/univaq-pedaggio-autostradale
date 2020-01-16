package models;

public class ClasseTariffaria extends Model {
	
	public String nome;
	public String esempi;

	public ClasseTariffaria() {
		this( "Classe", "Esempio" );
	}
	
	public ClasseTariffaria(String nome, String esempi) {
		this.nome = nome;
		this.esempi = esempi;
	}

}
