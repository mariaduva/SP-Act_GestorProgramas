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
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;

public class V_Principal extends JFrame {
	
	private JButton btnAcceder;
	private JTextField textField;
	private JTable tblPruebas2;
	private DefaultTableModel dtmPruebas2;
	
	public V_Principal() {
		init();
	}


	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("*Hula*");
		getContentPane().setLayout(null);
		
		
		
		btnAcceder = new JButton("Excel");
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAcceder.setBounds(543, 62, 119, 29);
		getContentPane().add(btnAcceder);
		
		btnAcceder = new JButton("Word");
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAcceder.setBounds(102, 62, 119, 29);
		getContentPane().add(btnAcceder);
		
		btnAcceder = new JButton("Power Point");
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAcceder.setBounds(317, 62, 119, 29);
		getContentPane().add(btnAcceder);
		
		btnAcceder = new JButton("Buscar");
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAcceder.setBounds(331, 524, 119, 29);
		getContentPane().add(btnAcceder);
		
		textField = new JTextField();
		textField.setBounds(286, 219, 191, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 307, 471, 184);
		getContentPane().add(scrollPane);
		
		tblPruebas2 = new JTable();
		configurarTabla();
		
		scrollPane.setViewportView(tblPruebas2);
		
		
		
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
	
	private void configurarTabla() {
		dtmPruebas2 = new DefaultTableModel() {
			//hacemos la tabla no editable salvo la columna EDAD
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 3) {
					return true;
				}
				return false;
			}
		};
		
		tblPruebas2.setModel(dtmPruebas2);
		
		dtmPruebas2.addColumn("URL");
		
		tblPruebas2.getColumn("URL").setPreferredWidth(100);
		
	}
}
	

