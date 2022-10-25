package com.dam.control;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;

import com.dam.view.VPrincipal;

public class CososControl implements ActionListener {
	
	private VPrincipal vPrin;
	public ArrayList <String> listaUrl;

	public CososControl(VPrincipal vPrin) {
		this.vPrin = vPrin;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		listaUrl = new ArrayList<>();
		
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(VPrincipal.BTN_WORD)) {
				nuevoProceso("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");

			}else if (ev.getActionCommand().equals(VPrincipal.BTN_PPT)) {
				nuevoProceso("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
				
			}else if (ev.getActionCommand().equals(VPrincipal.BTN_EXCEL )) {
				nuevoProceso("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");			
				
			}else if (ev.getActionCommand().equals(VPrincipal.BTN_BUSCAR)) {
				 String url = vPrin.verificarUrl();
				 
				 
				 if(!url.isEmpty()) {
					 System.out.println("Holaa");
					 listaUrl.add("Hola");
					 listaUrl.add("A");
					 vPrin.cargarTabla(listaUrl);
					 /*ProcessBuilder b = new ProcessBuilder();
				        
				        // Create an ArrayList with two values.
				        // ... This starts a specific browser, which is not ideal.
				        ArrayList<String> values = new ArrayList<>();
				        values.add("C:\\Program Files\\Internet Explorer\\iexplore.exe");
				        values.add("http://en.wikipedia.org/");
				        
				        // Pass List to command method.
				        b.command(values);
				        try {
							b.start();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				        try {
				        URL link = new URL("www.google.com");
				        System.out.println("hola");
				        
				        try {
				            Desktop.getDesktop().browse(link.toURI());
				        } catch (IOException e) {
				            e.printStackTrace();
				        } catch (URISyntaxException e) {
				            e.printStackTrace();
				        }
				        }catch (MalformedURLException e1) {
				            e1.printStackTrace();
				        }*/
					
				 }
				
				 
			}
		}
	
	}


	private void nuevoProceso(String ruta) {
		try {
			Process miProceso = new ProcessBuilder(ruta).start();
			Thread.sleep(15000);
			miProceso.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
