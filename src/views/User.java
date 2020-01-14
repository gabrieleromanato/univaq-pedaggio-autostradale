package views;

public class User extends View {
	
	private static final long serialVersionUID = 1L;

	public User() {
		
	}

	public User(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
		
	}
	
	/**
	 * Renders the view
	 */
	
	@Override
	
	
	public void render() {
		User user = new User(0, 0, 1024, 768, "Area Utente");
		user.setBorders(5, 5, 5, 5);
		user.addLabel("Area Utente", 364, 60, 273, 93);
		user.initView();
	}


}
