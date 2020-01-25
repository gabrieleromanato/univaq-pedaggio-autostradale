package controllers;

import views.View;

/**
 * The base controller class
 * 
 * @author gabrieleromanato
 *
 */

public abstract class Controller {
	
	protected View view;

	public Controller() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(View view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView () {
		view.render();
	}

}
