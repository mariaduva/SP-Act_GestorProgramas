package com.dam.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dam.control.CososControl;

public class VPrincipal extends JFrame {
	
	private JButton btnWord;
	private JButton btnxl;
	private JButton btnppt;
	private JButton btnbuscar;
	private JTextField textField;
	private JTable tblUrl;
	private DefaultTableModel tModel;
	
	public static final String BTN_WORD = "WORD";
	public static final String BTN_EXCEL = "EXCEL";
	public static final String BTN_PPT = "POWERPOINT";
	public static final String BTN_BUSCAR = "BUSCAR";
	private static final String VALID_WEBSITE = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$";
	
	
	private static final int ANCHO = 600;
	private static final int ALTO = 500;
	
	
	public VPrincipal() {
		init();
	}


	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("*Hula*");
		getContentPane().setLayout(null);
		
		
		
		btnWord = new JButton(BTN_EXCEL);
		btnWord.setFont(new Font("Arial", Font.PLAIN, 12));
		btnWord.setBounds(378, 77, 150, 29);
		getContentPane().add(btnWord);
		
		btnxl = new JButton(BTN_WORD);
		btnxl.setFont(new Font("Arial", Font.PLAIN, 12));
		btnxl.setBounds(58, 77, 150, 29);
		getContentPane().add(btnxl);
		
		btnppt = new JButton(BTN_PPT);
		btnppt.setFont(new Font("Arial", Font.PLAIN, 12));
		btnppt.setBounds(218, 77, 150, 29);
		getContentPane().add(btnppt);
		
		btnbuscar = new JButton(BTN_BUSCAR);
		btnbuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnbuscar.setBounds(407, 160, 119, 29);
		getContentPane().add(btnbuscar);
		
		textField = new JTextField();
		textField.setBounds(58, 160, 339, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 233, 471, 184);
		getContentPane().add(scrollPane);
		
		tblUrl = new JTable();
		configurarTabla();
		
		scrollPane.setViewportView(tblUrl);
		
		JLabel lblTitulo = new JLabel("Gestor de Aplicaciones / Buscador web");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(26, 32, 222, 13);
		getContentPane().add(lblTitulo);
		
		JLabel lblTUrl = new JLabel("Ultimas URL buscadas:");
		lblTUrl.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTUrl.setBounds(58, 199, 150, 13);
		getContentPane().add(lblTUrl);
		
		centrarVentana();
		setSize(ANCHO,ALTO);
	}

	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO,ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador (CososControl c) {
		btnbuscar.addActionListener(c);
		btnWord.addActionListener(c);
		btnxl.addActionListener(c);
		btnppt.addActionListener(c);
	}
	
	private void configurarTabla() {
		tModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblUrl.setModel(tModel);
		
		tModel.addColumn("URL");
		
		tblUrl.getColumn("URL").setPreferredWidth(100);
	}
	
	public void cargarTabla(ArrayList<String> listaUrls) {
		
		tModel.getDataVector().clear();
		
		Object[]row = new Object [1];
		
		for (String str : listaUrls) {
			
			row [0] = str;
			
			
			tModel.addRow(row);
		}
				
	}


	public String verificarUrl() {
		String url = textField.getText();
		
		if (!url.matches(VALID_WEBSITE)) {
				mostrarError("URL inválida: La url no tiene sentido");
				url = "";	
		}
			return url;
		}
		

	private void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, 
				"Error de datos", JOptionPane.ERROR_MESSAGE);
		
	}
}
	

