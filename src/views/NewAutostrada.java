package views;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.AutostradaController;
import models.Autostrada;

/**
 * The view for the Autostrada insert form
 * @author gabrieleromanato
 *
 */

public class NewAutostrada extends View {
	
	private static final long serialVersionUID = 1L;

	public NewAutostrada() {
		
	}
	
	public NewAutostrada(int x, int y, int width, int height, String title) {
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
		JTextField nome = (JTextField) fields.get(1);
		JTextField codice = (JTextField) fields.get(2);
		String name = nome.getText();
		String code = codice.getText();
		JButton button = (JButton) fields.get(5);
		
		boolean valid = true;
		
	
		
		if(name.length() == 0 || code.length() == 0 || code.length() > 3) {
			
			valid = false;
			
			
		}
		if(!valid) {
			JOptionPane.showMessageDialog(button, "I dati inseriti non sono validi");
		} else {
			Autostrada auto = new Autostrada(name, code);
			AutostradaController autoCtrl = new AutostradaController();
			
			if(autoCtrl.saveAutostrada(auto)) {
				JOptionPane.showMessageDialog(button, "Salvataggio riuscito");
			} else {
				JOptionPane.showMessageDialog(button, "Errore durante il salvataggio");
			}
		}
	}
	
	
	/**
	 * Renders the view
	 */
	
	@Override
	
	public void render() {
		NewAutostrada auto = new NewAutostrada(0, 0, 1024, 768, "Nuova autostrada");
		auto.setBorders(5, 5, 5, 5);
		auto.addLabel("Nuova autostrada", 364, 60, 273, 93);
		auto.addInputField("text", 364, 170, 281, 34, 3);
		auto.addInputField("text", 364, 220, 281, 34, 3);
		auto.addLabel("Nome", 250, 168, 250, 34);
		auto.addLabel("Codice", 250, 220, 250, 34);
		auto.addButton("Salva", 364, 270, 100, 34);
		auto.initView();
	}

}
