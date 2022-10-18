package Trabajo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CososControl implements ActionListener {
	
	private V_Principal vPrin;
	
	public CososControl(V_Principal vPrin) {
	this.vPrin = vPrin;
	
	
}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(vPrin.BTN_WORD)) {
				ProcessBuilder proceso = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");

			}else if (ev.getActionCommand().equals(vPrin.BTN_EXCEL)) {
				ProcessBuilder proceso = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
				
			}else if (ev.getActionCommand().equals(vPrin.BTN_PPT)) {
				ProcessBuilder proceso = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
				
			}else if (ev.getActionCommand().equals(vPrin.BTN_BUSCAR)) {
				
			}
		}
	
	}
	}
