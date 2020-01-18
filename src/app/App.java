package app;

/**
 * Main application class
 * @author gabrieleromanato
 *
 */

import views.Login;


public class App {

	public static void main(String[] args) {
		Login login = new Login();
		login.render();
	}

}
