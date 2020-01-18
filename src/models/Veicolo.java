package models;

import helpers.Generator;

public class Veicolo extends Model {
	
	public String modello;
	public String marca;
	public int anno;
	public String targa;
	public int assi;
	public int peso;
	public int altezza;
	public String classe;
	public String classeAmbientale;

	public Veicolo() {
		this("Panda", "Fiat", Generator.createNumber(1990, 2010), Generator.createPlateNumber(), Generator.createNumber(2, 5), Generator.createNumber(100, 500),
				Generator.createNumber(120, 180), Generator.getRandomClasseTariffaria(), "1");
	}

	public Veicolo(String modello, String marca, int anno, String targa, int assi, int peso, int altezza, String classe, String classeAmbientale) {
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
		this.targa = targa;
		this.assi = assi;
		this.peso = peso;
		this.altezza = altezza;
		this.classe = classe;
		this.classeAmbientale = classeAmbientale;
	}
	
	

}
