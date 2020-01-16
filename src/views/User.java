package views;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controllers.AutostradaController;
import models.Casello;
import models.ClasseTariffaria;

public class User extends View {
	
	private static final long serialVersionUID = 1L;

	public User() {
		
	}

	public User(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
		
	}
	
	private String[] getCaselloList() {
		AutostradaController autoCtrl = new AutostradaController();
		ArrayList<Casello> items = autoCtrl.getCaselli();
		String[] data = new String[items.size()];
		
		int i = -1;
		
		for(Casello a : items) {
			i++;
			data[i] = a.nome;
		}
		
		return data;
	}
	
	private String[] getClassiTariffarieList() {
		AutostradaController autoCtrl = new AutostradaController();
		ArrayList<ClasseTariffaria> items = autoCtrl.getClassiTariffarie();
		String[] data = new String[items.size()];
		
		int i = -1;
		
		for(ClasseTariffaria a : items) {
			i++;
			data[i] = a.nome;
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
	 * Renders the view
	 */
	
	@Override
	
	
	public void render() {
		User user = new User(0, 0, 1024, 768, "Area Utente");
		user.setBorders(5, 5, 5, 5);
		user.addLabel("Area Utente", 364, 60, 273, 93);
		user.addSelectBox(getCaselloList(), 364, 170, 281, 34);
		user.addSelectBox(getCaselloList(), 364, 220, 281, 34);
		user.addSelectBox(getClassiTariffarieList(), 364, 280, 281, 34);
		user.addLabel("Partenza", 250, 168, 250, 34);
		user.addLabel("Arrivo", 250, 220, 250, 34);
		user.addLabel("Classe veicolo", 250, 280, 292, 34);
		user.addButton("Calcola pedaggio", 364, 354, 200, 34);
		user.initView();
	}


}
