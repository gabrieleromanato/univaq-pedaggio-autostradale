package controllers;

import views.NewAutostrada;

/**
 * Handles a new Autostrada
 * @author gabrieleromanato
 *
 */

public class NewAutostradaController extends Controller {
	
	protected NewAutostrada view;

	public NewAutostradaController() {
		
	}
	
	/**
	 * Sets the view instance
	 * @param view A view instance
	 */
	
	public void setView(NewAutostrada view) {
		this.view = view;
	}
	
	/**
	 * Renders the view
	 */
	
	public void renderView() {
		view.render();
	}

}
