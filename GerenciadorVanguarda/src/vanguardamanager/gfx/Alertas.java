package vanguardamanager.gfx;

import javax.swing.JOptionPane;

public class Alertas {
	
	//private String message;
	
	public Alertas() {
		//this.message = "Bom dia meu querido";
	}
	
	public String getCommand() {
		
		String texto = JOptionPane.showInputDialog("O que deseja fazer?");
		return texto;
	}
	
	public void mostrarFila() {
		
		
	}
	
	
	
}
