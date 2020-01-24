package controllers;

import views.NewAutostrada;

public class NewAutostradaController extends Controller {
	
	protected NewAutostrada view;

	public NewAutostradaController() {
		
	}
	
	public void setView(NewAutostrada view) {
		this.view = view;
	}
	
	public void renderView() {
		view.render();
	}

}
