package controllers;

import views.View;

public abstract class Controller {
	
	protected View view;

	public Controller() {
		
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void renderView () {
		view.render();
	}

}
