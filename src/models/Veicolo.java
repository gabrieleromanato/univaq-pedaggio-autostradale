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

	public Veicolo() {
		this("AX", "Fiat", Generator.createNumber(1990, 2010), Generator.createPlateNumber(), Generator.createNumber(2, 5), Generator.createNumber(100, 500),
				Generator.createNumber(120, 180));
	}

	public Veicolo(String modello, String marca, int anno, String targa, int assi, int peso, int altezza) {
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
		this.targa = targa;
		this.assi = assi;
		this.peso = peso;
		this.altezza = altezza;
	}
	
	

}
