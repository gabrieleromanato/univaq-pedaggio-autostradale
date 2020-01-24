package controllers;

import views.Admin;

public class AdminController extends Controller {
	
	protected Admin view;

	public AdminController() {
		
	}
	
	public void setView(Admin view) {
		this.view = view;
	}
	
	public void renderView() {
		view.render();
	}

}
