package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;

/**
 * The base class for views
 * 
 * @author gabrieleromanato
 *
 */

public class View extends JFrame implements ActionListener {
	protected JPanel content;
	private int x;
	private int y;
	private int width;
	private int height;
	private String title;
	private static final long serialVersionUID = 1L;
	protected ArrayList<? super JComponent> fields;
	
	public View() {
		this(0, 0, 1024, 758, "Default");
	}
	
	public View(int x, int y, int width, int height, String title) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.title = title;
		this.content = new JPanel();
		this.fields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(this.x, this.y, this.width, this.height);
		
		
	}
	
	/**
	 * Performs an action after a button has been clicked
	 * 
	 * @param ActionEvent evt
	 * 
	 */
	
	public void actionPerformed(ActionEvent evt) {
		
	}
	
	/**
	 * Sets the border of the panel
	 * 
	 * @param top Top border
	 * @param right Right border
	 * @param bottom Bottom border
	 * @param left Left border
	 * 
	 */
	
	public void setBorders(int top, int right, int bottom, int left) {
		this.content.setBorder(new EmptyBorder(top, right, bottom, left));
	}
	
	/**
	 * Initializes the panel
	 * 
	 * 
	 */
	
	public void initView() {
		try {
			URL src = new URL("https://gabrieleromanato-com.s3-eu-west-1.amazonaws.com/universita/logo-univaq.png");
			BufferedImage logo = ImageIO.read(src);
			JLabel logoLabel = new JLabel(new ImageIcon(logo));
			
			logoLabel.setBounds(10, 10, 70, 87);
			
			this.content.add(logoLabel);
			
		} catch(Exception e) {
			
		}
		setContentPane(this.content);
		this.content.setLayout(null);
		this.setTitle(this.title);
		this.setVisible(true);
	}
	
	/**
	 * Adds a text label
	 * 
	 * @param text The text of the label
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * @param width Width of the label
	 * @param height Height of the label
	 * 
	 */
	
	public void addLabel(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		this.content.add(label);
		this.fields.add(label);
	}
	
	/**
	 * Adds an input field
	 * 
	 * @param type The field's type
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * @param width Width of the field
	 * @param height Height of the field
	 * @param columns Number of field's columns
	 * 
	 */
	
	public void addInputField(String type, int x, int y, int width, int height, int columns) {
		
		switch(type) {
			case "text":
				JTextField textField = new JTextField();
				textField.setBounds(x, y, width, height);
				this.content.add(textField);
				textField.setColumns(columns);
				this.fields.add(textField);
				break;
			case "password":
				JPasswordField passwordField = new JPasswordField();
				passwordField.setBounds(x, y, width, height);
				this.content.add(passwordField);
				this.fields.add(passwordField);
				break;
			default:
				break;
		}
		
	}
	
	/**
	 * Adds a button
	 * 
	 * @param text The text of the button
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * @param width Width of the button
	 * @param height Height of the button
	 * 
	 */
	
	public void addButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.addActionListener(this);
		button.setBounds(x, y, width, height);
		this.content.add(button);
		this.fields.add(button);
	}
	
	
	/**
	 * Adds a menu
	 * 
	 * @param text The menu's name
	 * @param x Horizontal coordinate
	 * @param y Vertical coordinate
	 * @param width Menu's width
	 * @param height Menu's height
	 * @param items Menu items
	 */
	
	
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
			
			
			menu.add(item);
			this.fields.add(item);
			
		}
	}
	
	/**
	 * Adds a list
	 * @param items Array of items
	 */
	
	public void addList(String[] items) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(int i = 0; i < items.length; i++) {
			listModel.addElement(items[i]);
		}
		JList<String> list = new JList<>(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
		
		this.content.add(listScrollPane, BorderLayout.PAGE_END);
		this.fields.add(list);
	}
	
	/**
	 * Renders the view
	 */
	
	public void render() {
		
	}
}
