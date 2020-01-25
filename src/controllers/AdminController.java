package controllers;

import views.Admin;

/**
 * The admin controller
 * @author gabrieleromanato
 *
 */

public class AdminController extends Controller {
	
	protected Admin view;

	public AdminController() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(Admin view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}

}
