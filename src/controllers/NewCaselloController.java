package controllers;

import views.NewCasello;

public class NewCaselloController extends Controller {
	
	protected NewCasello view;

	public NewCaselloController() {
		
	}
	
	public void setView(NewCasello view) {
		this.view = view;
	}
	
	public void renderView() {
		view.render();
	}

}
