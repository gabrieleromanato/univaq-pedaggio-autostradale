package views;

import java.awt.event.ActionEvent;
import javax.swing.*;

import controllers.AdminController;
import controllers.UserController;

public class Login extends View {
	
	private static final long serialVersionUID = 1L;

	public Login() {
	}

	public Login(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
		
	}
	
	/**
	 * Performs an action after a button has been clicked
	 * 
	 * @param ActionEvent evt
	 * 
	 */
	
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		JTextField user = (JTextField) fields.get(1);
		JPasswordField password = (JPasswordField) fields.get(2);
		String username = user.getText();
		char[] pwd = password.getPassword();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < pwd.length; i++) {
			sb.append(pwd[i]);
		}
		
		String userPass = sb.toString();
		
		// Mock login processing
		
		if(username.equals("admin") && userPass.equals("admin")) {
			
			Admin admin = new Admin();
			AdminController adminCtrl = new AdminController();
			
			adminCtrl.setView(admin);
			adminCtrl.renderView();
			
			
			
		} else if (username.equals("user") && userPass.equals("user")) {
			
				User userClass = new User();
				UserController userCtrl = new UserController();
				
				userCtrl.setView(userClass);
				userCtrl.renderView();
			
		} else {
			JButton button = (JButton) fields.get(5);
			JOptionPane.showMessageDialog(button, "Credenziali errate");
		}
	}
	
	/**
	 * Renders the view
	 */
	
	@Override
	
	public void render() {
		Login login = new Login(0, 0, 1024, 768, "Login");
		login.setBorders(5, 5, 5, 5);
		login.addLabel("Login", 364, 60, 273, 93);
		login.addInputField("text", 364, 170, 281, 34, 3);
		login.addInputField("password", 364, 220, 281, 34, 3);
		login.addLabel("Nome utente", 250, 168, 250, 34);
		login.addLabel("Password", 250, 220, 250, 34);
		login.addButton("Entra", 364, 270, 100, 34);
		login.initView();
	}

}
