package com.dam.main;

import java.awt.EventQueue;

import com.dam.control.CososControl;
import com.dam.view.VPrincipal;


public class InicioApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				VPrincipal vPrin = new VPrincipal();
				
				CososControl c = new CososControl(vPrin);
				
				vPrin.setControlador(c);
				
				vPrin.hacerVisible();
			}
		});

	}

}
