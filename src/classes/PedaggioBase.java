package classes;

public abstract class PedaggioBase {
	
	private double tariffaUnitaria;
	private double arrotondamento;
	private String classeVeicolo;

	public PedaggioBase() {
		this(0.5, 0.50, "A");
	}

	public PedaggioBase(double tariffaUnitaria, double arrotondamento, String classeVeicolo) {
		this.tariffaUnitaria = tariffaUnitaria;
		this.arrotondamento = arrotondamento;
		this.classeVeicolo = classeVeicolo;
	}
	
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
		
		return amount;
	}

}
