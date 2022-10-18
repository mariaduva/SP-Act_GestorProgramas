package Trabajo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class V_Principal extends JFrame {
	
	private JButton btnAcceder;
	
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
	

