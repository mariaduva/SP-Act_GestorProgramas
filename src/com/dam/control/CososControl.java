package com.dam.control;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import com.dam.view.VPrincipal;

public class CososControl implements ActionListener {
	
	private VPrincipal vPrin;
	public ArrayList <String> listaUrl = new ArrayList<>();

	public CososControl(VPrincipal vPrin) {
		this.vPrin = vPrin;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
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
					 listaUrl.add(url);
					 vPrin.cargarTabla(listaUrl);
					 try {
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				 }
				
				 
			}
		}
	
	}


	private void nuevoProceso(String ruta) {
		try {
			Process miProceso = new ProcessBuilder(ruta).start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
