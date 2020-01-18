package views;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.Autostrada;
import controllers.Casello;
import helpers.Validator;
import models.AutostradaModel;
import models.CaselloModel;

/**
 * The view of the Casello insert form
 * @author gabrieleromanato
 *
 */

public class NewCasello extends View {
	
	private static final long serialVersionUID = 1L;

	public NewCasello() {
		
	}

	public NewCasello(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
		
	}
	
	private String[] getAutostradeList() {
		Autostrada autoCtrl = new Autostrada();
		ArrayList<AutostradaModel> items = autoCtrl.getAutostrade();
		String[] data = new String[items.size()];
		
		int i = -1;
		
		for(AutostradaModel a : items) {
			i++;
			data[i] = a.codice;
		}
		
		return data;
	}
	
	
	public void addSelectBox(String[] values, int x, int y, int width, int height) {
		JComboBox<String> list = new JComboBox<>(values);
		list.setBounds(x, y, width, height);
		this.content.add(list);
		this.fields.add(list);
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
		JTextField km = (JTextField) fields.get(3);
		@SuppressWarnings("rawtypes")
		JComboBox autostrada = (JComboBox) fields.get(4);
		
		String name = nome.getText();
		String code = codice.getText();
		String kmValue = km.getText();
		String autoSelected = autostrada.getSelectedItem().toString();
		JButton button = (JButton) fields.get(9);
		
		boolean valid = true;
		
	
		
		if(name.length() == 0 || code.length() == 0 || kmValue.length() == 0 || autoSelected.length() == 0) {
			
			valid = false;
			
			
		}
		if(!Validator.isNumeric(kmValue)) {
			valid = false;
		}
		if(!valid) {
			JOptionPane.showMessageDialog(button, "I dati inseriti non sono validi");
		} else {
			CaselloModel casello = new CaselloModel(autoSelected, Double.parseDouble(kmValue), name, code);
			Casello caselloCtrl = new Casello();
			
			if(caselloCtrl.saveCasello(casello)) {
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
		NewCasello casello = new NewCasello(0, 0, 1024, 768, "Nuovo casello");
		casello.setBorders(5, 5, 5, 5);
		casello.addLabel("Nuovo casello", 364, 60, 273, 93);
		casello.addInputField("text", 364, 170, 281, 34, 3);
		casello.addInputField("text", 364, 220, 281, 34, 3);
		casello.addInputField("text", 364, 254, 281, 34, 3);
		casello.addSelectBox(getAutostradeList(), 364, 288, 281, 34);
		casello.addLabel("Nome", 250, 168, 250, 34);
		casello.addLabel("Codice", 250, 220, 250, 34);
		casello.addLabel("Km", 250, 254, 250, 34);
		casello.addLabel("Autostrada", 250, 288, 250, 34);
		casello.addButton("Salva", 364, 354, 100, 34);
		casello.initView();
	}

}
