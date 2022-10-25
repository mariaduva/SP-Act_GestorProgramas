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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dam.control.CososControl;

public class VPrincipal extends JFrame {
	
	private JButton btnWord;
	private JButton btnxl;
	private JButton btnppt;
	private JButton btnbuscar;
	private JTextField textField;
	private JLabel lblError;
	private JTable tblUrl;
	private DefaultTableModel tModel;
	
	public static final String BTN_WORD = "WORD";
	public static final String BTN_EXCEL = "EXCEL";
	public static final String BTN_PPT = "POWERPOINT";
	public static final String BTN_BUSCAR = "BUSCAR";
	private static final String VALID_WEBSITE = "^https?://(www2?\\.)?[-a-zA-Z\\d@:%._+~#=]{1,256}\\.[a-zA-Z\\d()]{1,6}\\b([-a-zA-Z\\d()@:%_+.~#?&/=]*)$";
	
	
	private static final int ANCHO = 600;
	private static final int ALTO = 550;
	
	
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
		btnbuscar.setBounds(407, 187, 119, 29);
		getContentPane().add(btnbuscar);
		
		textField = new JTextField();
		textField.setBounds(58, 187, 339, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 260, 471, 184);
		getContentPane().add(scrollPane);
		
		tblUrl = new JTable();
		configurarTabla();
		
		scrollPane.setViewportView(tblUrl);
		
		JLabel lblTitulo = new JLabel("Gestor de Aplicaciones / Buscador web");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(26, 32, 222, 13);
		getContentPane().add(lblTitulo);
		
		lblError = new JLabel("URL no v\u00E1lida ");
		lblError.setVisible(false);
		lblError.setInheritsPopupMenu(false);
		lblError.setFont(new Font("Arial", Font.PLAIN, 12));
		lblError.setBounds(58, 166, 310, 13);
		getContentPane().add(lblError);
		
		JLabel lblTUrl = new JLabel("Ultimas URL buscadas:");
		lblTUrl.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTUrl.setBounds(58, 237, 150, 13);
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
	
	private void cargarTabla(ArrayList<String> listaUrls) {
		
		/*for (String url : listaUrls) {
			tModel.addRow(url);
        }*/
	}


	public String verificarUrl() {
		String url = textField.getText();
		boolean esCorrecta = false;
		System.out.println(url);
		
		while(!esCorrecta) {
			System.out.println(url);
			if (url == null || url.trim().isEmpty()) {
				mostrarError("URL inválida");			
			} else if (!url.matches(VALID_WEBSITE)) {
				mostrarError("URL inválida: La url no tiene sentido");	
			} else {
				esCorrecta = true;
			}
		}
		
		return url;
	}


	private void mostrarError(String error) {
		lblError.setVisible(true);
		lblError.setText(error);
		//lblError.setForeground(red);
		
	}
}
	

