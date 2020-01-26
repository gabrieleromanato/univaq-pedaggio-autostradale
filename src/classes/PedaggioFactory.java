package classes;

import controllers.Pedaggio;
import interfaces.PedaggioInterface;

/**
 * Implements the factory pattern for Pedaggio
 * @author gabrieleromanato
 *
 */

public class PedaggioFactory {
	
	/**
	 * Returns an instance of a specific Pedaggio class
	 * 
	 * @param type
	 * @param tariffaUnitaria
	 * @param arrotondamento
	 * @param classeVeicolo
	 * @param classeAmbientale
	 * @return A Pedaggio specific instance
	 */

	public static PedaggioInterface getInstance(String type, double tariffaUnitaria, double arrotondamento, String classeVeicolo,  String classeAmbientale) {
		switch(type) {
		case "default":
			return new PedaggioBase(tariffaUnitaria, arrotondamento,classeVeicolo);
		case "tax":
			return new Pedaggio(tariffaUnitaria, arrotondamento, classeVeicolo, classeAmbientale);
		default:
			return null;
			
		}
	}

}
