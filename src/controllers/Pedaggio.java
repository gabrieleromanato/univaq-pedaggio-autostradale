package controllers;

import interfaces.PedaggioInterface;

/**
 * Handles fees
 * 
 * @author gabrieleromanato
 *
 */

public class Pedaggio implements PedaggioInterface {
	
	private double tariffaUnitaria;
	private double arrotondamento;
	private String classeVeicolo;
	private String classeAmbientale;

	public Pedaggio() {
		this(0.5, 0.50, "A", "1");
	}

	public Pedaggio(double tariffaUnitaria, double arrotondamento, String classeVeicolo, String classeAmbientale) {
		this.tariffaUnitaria = tariffaUnitaria;
		this.arrotondamento = arrotondamento;
		this.classeVeicolo = classeVeicolo;
		this.classeAmbientale = classeAmbientale;
	}
	
	/**
	 * Calculates fees
	 * 
	 * @param km
	 * @return double The total feed
	 */
	
	public double calculate(double km) {
		double amount = 0;
		double amtByKm = tariffaUnitaria * km;
		
		amount += amtByKm;
		
		double vat = (amount * 22) / 100;
		
		amount += vat;
		
		double afterDecimal = amount - (int) amount;
		
		if(afterDecimal > arrotondamento) {
			amount = (int) amount + 1;
		} else {
			amount = (int) amount + 0;
		}
		
		switch(classeVeicolo) {
			case "A":
				amount += 1;
				break;
			case "B":
				amount += 2;
				break;
			case "3":
				amount += 3;
				break;
			case "4":
				amount += 4;
				break;
			case "5":
				amount += 5;
				break;
			default:
				break;
		}
		
		
			switch(classeAmbientale) {
				case "6":
					amount += 1;
					break;
				case "5":
					amount += 2;
					break;
				case "4":
					amount += 3;
					break;
				case "3":
					amount += 4;
					break;
				case "2":
					amount += 5;
					break;
				case "1":
					amount += 6;
					break;
					default:
						break;
			}
		
		return amount;
	}

}
