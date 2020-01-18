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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import controllers.Autostrada;
import models.AutostradaModel;

public class Autostrade extends View {
	
	private static final long serialVersionUID = 1L;

	public Autostrade() {
		
	}

	public Autostrade(int x, int y, int width, int height, String title) {
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


public void addList(ArrayList<AutostradaModel> items) {
	JPanel pane = new JPanel();
	pane.setBounds(364, 250, 400, 4004);
	DefaultListModel<String> listModel = new DefaultListModel<>();
	for(AutostradaModel auto : items) {
		listModel.addElement(auto.nome);
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
	
	/**
	 * Renders the view
	 */
	
	public void render() {
		Autostrada autoCtrl = new Autostrada();
		ArrayList<AutostradaModel> autostrade = autoCtrl.getAutostrade();
		String[] items = { "Home" };
		Autostrade auto = new Autostrade(0, 0, 1024, 768, "Autostrade");
		auto.setBorders(5, 5, 5, 5);
		auto.addLabel("Autostrade", 364, 60, 273, 93);
		auto.addMenu("Menu", 364, 180, 400, 40, items);
		auto.addList(autostrade);
		auto.initView();
	}

}
