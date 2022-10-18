package Trabajo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class V_Principal extends JFrame {
	
	private JButton btnWord;
	private JButton btnxl;
	private JButton btnppt;
	private JButton btnbuscar;
	private JTextField textField;
	
	public static final String BTN_WORD = "WORD";
	public static final String BTN_EXCEL = "Excel";
	public static final String BTN_PPT = "PowerPoint";
	public static final String BTN_BUSCAR = "Buscar";

	
	public V_Principal() {
		init();
	}


	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("*Hula*");
		getContentPane().setLayout(null);
		
		
		
		btnWord = new JButton("Excel");
		btnWord.setFont(new Font("Arial", Font.PLAIN, 12));
		btnWord.setBounds(543, 62, 119, 29);
		getContentPane().add(btnWord);
		
		btnxl = new JButton("Word");
		btnxl.setFont(new Font("Arial", Font.PLAIN, 12));
		btnxl.setBounds(102, 62, 119, 29);
		getContentPane().add(btnxl);
		
		btnppt = new JButton("Power Point");
		btnppt.setFont(new Font("Arial", Font.PLAIN, 12));
		btnppt.setBounds(317, 62, 119, 29);
		getContentPane().add(btnppt);
		
		btnbuscar = new JButton("Buscar");
		btnbuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnbuscar.setBounds(331, 524, 119, 29);
		getContentPane().add(btnbuscar);
		
		textField = new JTextField();
		textField.setBounds(286, 219, 191, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 307, 471, 184);
		getContentPane().add(scrollPane);
		
		
		
		
		centrarVentana();
		setSize(800, 600);
	}

	private void centrarVentana() {
		setPreferredSize(new Dimension(800,600));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador (CososControl c) {
		
	}
}
	

