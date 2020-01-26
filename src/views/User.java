package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import classes.PedaggioBase;
import classes.PedaggioFactory;
import controllers.Autostrada;
import controllers.Casello;
import controllers.Pagamenti;
import controllers.Pedaggio;
import controllers.Percorso;
import helpers.CSV;
import helpers.Formatter;
import interfaces.PedaggioInterface;
import models.CaselloModel;
import models.Pagamento;
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
		Autostrada autoCtrl = new Autostrada();
		ArrayList<CaselloModel> items = autoCtrl.getCaselli();
		String[] data = new String[items.size()];
		
		int i = -1;
		
		for(CaselloModel a : items) {
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
					
					String[] keys = { "modello", "marca", "anno", "targa", "assi", "peso", "altezza", "classe", "classe_ambientale" };
					HashMap<String, String> vehicleData = CSV.read(data, keys);
					Veicolo veicolo = new Veicolo(
							vehicleData.get("modello"), 
							vehicleData.get("marca"), 
							Integer.parseInt(vehicleData.get("anno")),
							vehicleData.get("targa"),
							Integer.parseInt(vehicleData.get("assi")),
							Integer.parseInt(vehicleData.get("peso")),
							Integer.parseInt(vehicleData.get("altezza")),
							vehicleData.get("classe"),
							vehicleData.get("classe_ambientale")
							
					);
					
					PedaggioInterface pedaggio = PedaggioFactory.getInstance("default", Autostrada.TARIFFA_UNITARIA, 0.50, veicolo.classe, veicolo.classeAmbientale);
					Casello casello = new Casello();
					casello.setStartKm(startSelected);
					casello.setEndKm(arrivalSelected);
					Percorso percorso = new Percorso(casello.getEndKm(), casello.getStartKm());
					percorso.calculateTravelKm();
					double amt = pedaggio.calculate(percorso.getTravelKm());
					String total = Formatter.formatCurrency(amt, new Locale("IT") ).replaceAll("[^0-9,]+", "");
					
					String msg = "L'importo da pagare è di Euro " + total + ". Procedere al pagamento?";
					int input = JOptionPane.showConfirmDialog(calculate, msg, "Pagamento", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(input == 0) {
						Pagamento pagamento = new Pagamento(veicolo.targa, amt, "contanti");
						Pagamenti pagamenti = new Pagamenti();
						
						if(pagamenti.savePayment(pagamento)) {
							JOptionPane.showMessageDialog(calculate, "Grazie e buon viaggio");
						} else {
							JOptionPane.showMessageDialog(calculate, "Errore nel pagamento");
						}
					}
					
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
