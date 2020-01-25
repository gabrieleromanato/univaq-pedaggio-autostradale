package controllers;

import views.User;

/**
 * Handles the User's area
 * @author gabrieleromanato
 *
 */

public class UserController extends Controller {
	
	protected User view;

	public UserController() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(User view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}

}
