package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import controllers.AutostradaController;
import helpers.CSV;
import models.Casello;
import models.ClasseTariffaria;
import models.Veicolo;

public class User extends View {
	
	private static final long serialVersionUID = 1L;
	private File datiVeicolo;

	public User() {
		
	}
	
	public void setDatiVeicolo(File data) {
		datiVeicolo = data;
	}
	
	public File getDatiVeicolo() {
		return datiVeicolo;
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
	
	@SuppressWarnings("unused")
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
	
	private void actions(User instance) {
		JButton fileChoose = (JButton) instance.fields.get(3);
		JButton calculate = (JButton) instance.fields.get(7);
		
		fileChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Scegli un file in formato CSV");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
				jfc.addChoosableFileFilter(filter);
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					instance.setDatiVeicolo(selectedFile);
				}
			}
		});
		
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File data = instance.getDatiVeicolo();
				@SuppressWarnings("rawtypes")
				JComboBox start = (JComboBox) instance.fields.get(1);
				@SuppressWarnings("rawtypes")
				JComboBox arrival = (JComboBox) instance.fields.get(2);
				
				String startSelected = start.getSelectedItem().toString();
				String arrivalSelected = arrival.getSelectedItem().toString();
				
				boolean valid = true;
				
				if(data == null || startSelected.length() == 0 || arrivalSelected.length() == 0) {
					valid = false;
				}
				if(!valid) {
					JOptionPane.showMessageDialog(calculate, "I dati inseriti non sono validi");
				} else {
					
					String[] keys = { "modello", "marca", "anno", "targa", "assi", "peso", "altezza", "classe" };
					HashMap<String, String> vehicleData = CSV.read(data, keys);
					Veicolo veicolo = new Veicolo(
							vehicleData.get("modello"), 
							vehicleData.get("marca"), 
							Integer.parseInt(vehicleData.get("anno")),
							vehicleData.get("targa"),
							Integer.parseInt(vehicleData.get("assi")),
							Integer.parseInt(vehicleData.get("peso")),
							Integer.parseInt(vehicleData.get("altezza")),
							vehicleData.get("classe")
							
					);
					AutostradaController autostrada = new AutostradaController();
					double[] tariffe = { 10, 20, 30, 40, 50 };
					autostrada.setTariffe(tariffe);
					autostrada.setMapTariffe();
					System.out.println(vehicleData);
					System.out.println(veicolo.modello + ", " + veicolo.marca + ", " + veicolo.anno + ", " + veicolo.targa + ", " + veicolo.assi + ", " +
					veicolo.peso + ", " + veicolo.altezza + ", " + veicolo.classe);
					System.out.println(autostrada.getMapTariffe());
				}
			}
		});
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
		user.addButton("Scegli file", 364, 270, 200, 34);
		user.addLabel("Partenza", 250, 168, 250, 34);
		user.addLabel("Arrivo", 250, 220, 250, 34);
		user.addLabel("Dati veicolo", 250, 270, 250, 34);
		user.addButton("Calcola pedaggio", 364, 354, 200, 34);
		actions(user);
		user.initView();
	}


}
