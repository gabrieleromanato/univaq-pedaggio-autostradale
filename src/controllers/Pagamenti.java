package controllers;
import java.text.SimpleDateFormat;

import classes.Database;
import models.Pagamento;

/**
 * Handles payments
 * @author gabrieleromanato
 *
 */

public class Pagamenti {
	private Database db;
	public Pagamenti() {
		db = new Database();
	}
	
	/**
	 * Saves a payment into the database
	 * @param payment Pagamento model
	 * @return Boolean
	 */
	
	public boolean savePayment(Pagamento payment) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String query = "INSERT INTO pagamenti (id_veicolo, importo, orario, tipologia) VALUES (";
		query += "'" + payment.idVeicolo + "'," + Double.toString(payment.importo) + ",";
		query += "'" + simpleDateFormat.format(payment.orario) + "','" + payment.tipologia + "')";
		
		return db.writeData(query);
	}

}
