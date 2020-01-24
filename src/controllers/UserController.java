package controllers;

import views.User;

public class UserController extends Controller {
	
	protected User view;

	public UserController() {
		
	}
	
	public void setView(User view) {
		this.view = view;
	}
	
	public void renderView() {
		view.render();
	}

}
