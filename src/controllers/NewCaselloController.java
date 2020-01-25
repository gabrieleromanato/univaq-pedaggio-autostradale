package controllers;

import views.NewCasello;

/**
 * Handles a new Casello
 * @author gabrieleromanato
 *
 */

public class NewCaselloController extends Controller {
	
	protected NewCasello view;

	public NewCaselloController() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(NewCasello view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}

}
