package controllers;

import views.Login;

public class LoginController extends Controller {
	protected Login view;
	
	public LoginController() {
		
	}
	
	public void setView(Login view) {
		this.view = view;
	}
	
	public void renderView() {
		view.render();
	}

}
