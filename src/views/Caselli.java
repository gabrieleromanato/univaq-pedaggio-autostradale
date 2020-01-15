package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import controllers.AutostradaController;
import models.Casello;

public class Caselli extends View {
	
	private static final long serialVersionUID = 1L;

	public Caselli() {
		
	}

	public Caselli(int x, int y, int width, int height, String title) {
		super(x, y, width, height, title);
	}
	
@Override
	
	public void addMenu(String text, int x, int y, int width, int height, String[] items) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(x, y, width, height);
		this.content.add(menuBar);
		this.fields.add(menuBar);
		
		JMenu menu = new JMenu(text);
		menuBar.add(menu);
		this.fields.add(menu);
		
		for(int i = 0; i < items.length; i++) {
			JMenuItem item = new JMenuItem(items[i]);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JMenuItem menuItem = (JMenuItem)e.getSource();
					String text = menuItem.getText().toLowerCase();
					
					switch(text) {
						case "home":
							Admin admin = new Admin();
							admin.render();
							break;
						default:
							break;
					}
				}
			});
			
		menu.add(item);
		this.fields.add(item);
			
		}
	}

public void addList(ArrayList<Casello> items) {
	JPanel pane = new JPanel();
	pane.setBounds(364, 250, 400, 400);
	DefaultListModel<String> listModel = new DefaultListModel<>();
	for(Casello casello : items) {
		listModel.addElement(casello.nome);
	}
	JList<String> list = new JList<>(listModel);
	
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setVisibleRowCount(5);
    JScrollPane listScrollPane = new JScrollPane(list);
    listScrollPane.setPreferredSize(new Dimension(400, 110));
    listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
	pane.add(listScrollPane);
	pane.setVisible(true);
	this.content.add(pane);
	this.fields.add(list);
}

public void addTable(ArrayList<Casello> items) {
	JPanel pane = new JPanel();
	pane.setBounds(300, 250, 580, 400);
	String[] headers = {"Autostrada", "Km", "Nome", "Codice"};
	String[][] data = new String[items.size()][headers.length];
	
	
		for(int i = 0; i < items.size(); i++) {
			Casello casello = items.get(i);
			
			
			for(int j = 0; j < headers.length; j++) {
			
				data[i][0] = casello.autostrada;
				data[i][1] = Double.toString(casello.progressivaKm);
				data[i][2] = casello.nome;
				data[i][3] = casello.codice;
			}
		}
	JTable table = new JTable(data, headers);
	JScrollPane scrollPane = new JScrollPane(table);
	
	pane.add(scrollPane);
	pane.setVisible(true);
	this.content.add(pane);
	this.fields.add(table);
}

/**
 * Renders the view
 */

public void render() {
	AutostradaController autoCtrl = new AutostradaController();
	ArrayList<Casello> caselli = autoCtrl.getCaselli();
	String[] items = { "Home" };
	Caselli casello = new Caselli(0, 0, 1024, 768, "Caselli");
	casello.setBorders(5, 5, 5, 5);
	casello.addLabel("Caselli", 364, 60, 273, 93);
	casello.addMenu("Menu", 364, 180, 400, 40, items);
	casello.addTable(caselli);
	casello.initView();
}

}
