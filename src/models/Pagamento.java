package models;

import java.util.Date;

/**
 * The data model for a pagamento record
 * 
 * @author gabrieleromanato
 *
 */

public class Pagamento extends Model {
	
	public String idVeicolo;
	public double importo;
	public Date orario;
	public String tipologia;
	
	public Pagamento() {
		this("AZ1234", 9.99, "contanti");
	}
	
	public Pagamento(String idVeicolo, double importo, String tipologia) {
		this.idVeicolo = idVeicolo;
		this.importo = importo;
		this.orario = new Date();
		this.tipologia = tipologia;
	}

}
