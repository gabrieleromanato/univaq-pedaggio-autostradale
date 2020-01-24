package app;

/**
 * Main application class
 * @author gabrieleromanato
 *
 */

import views.*;
import controllers.*;



public class App {

	public static void main(String[] args) {
		Login login = new Login();
		LoginController loginCtrl = new LoginController();
		
		loginCtrl.setView(login);
		loginCtrl.renderView();
	}

}
