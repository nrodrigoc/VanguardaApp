package vanguardamanager;

import java.util.Scanner;

import vanguardamanager.display.GerenciadorUI;

public class Launcher {
	
	public static void main(String[] args) {
		
		Caixa caixa = new Caixa();
		Thread c = new Thread(caixa);
		c.start();
		
	}
}
