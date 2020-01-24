package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Autostrada;
import controllers.Casello;
import controllers.NewAutostradaController;
import controllers.NewCaselloController;



public class Admin extends View {
	
	private static final long serialVersionUID = 1L;

	public Admin() {
		
	}

	public Admin(int x, int y, int width, int height, String title) {
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
						case "autostrade":
							Autostrade auto = new Autostrade();
							Autostrada autoCtrl = new Autostrada();
							autoCtrl.setView(auto);
							autoCtrl.renderView();
							break;
						case "caselli":
							Caselli caselli = new Caselli();
							Casello caselloCtrl = new Casello();
							caselloCtrl.setView(caselli);
							caselloCtrl.renderView();
							break;
						case "nuova autostrada":
							NewAutostrada newAuto = new NewAutostrada();
							NewAutostradaController autoCtrl2 = new NewAutostradaController();
							autoCtrl2.setView(newAuto);
							autoCtrl2.renderView();
							break;
						case "nuovo casello":
							NewCasello newCasello = new NewCasello();
							NewCaselloController caselloCtrl2 = new NewCaselloController();
							caselloCtrl2.setView(newCasello);
							caselloCtrl2.renderView();
							
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
	
	
	/**
	 * Renders the view
	 */
	
	
	@Override
	
	
	public void render() {
		String[] items = { "Autostrade", "Caselli", "Nuova autostrada", "Nuovo casello" };
		Admin admin = new Admin(0, 0, 1024, 768, "Area Amministrativa");
		admin.setBorders(5, 5, 5, 5);
		admin.addLabel("Area Amministrativa", 364, 60, 273, 93);
		
		admin.addMenu("Menu", 364, 180, 400, 40, items);
		
		
		
		admin.initView();
		
	}

}
