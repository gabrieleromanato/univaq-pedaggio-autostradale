package views;

public class Admin extends View {
	
	private static final long serialVersionUID = 1L;

	public Admin() {
		
	}

	public Admin(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
		
	}
	
	/**
	 * Renders the view
	 */
	
	
	public static void render() {
		Admin admin = new Admin(0, 0, 1024, 768, "Admin Area");
		admin.setBorders(5, 5, 5, 5);
		admin.addLabel("Admin Area", 364, 60, 273, 93);
		admin.initView();
	}

}
