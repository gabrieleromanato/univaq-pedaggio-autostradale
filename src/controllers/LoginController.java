package controllers;

import views.Login;

/**
 * Handles the login process
 * @author gabrieleromanato
 *
 */

public class LoginController extends Controller {
	protected Login view;
	
	public LoginController() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(Login view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}

}
