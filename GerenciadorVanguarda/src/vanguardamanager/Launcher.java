package vanguardamanager;

public class Launcher {
	
	public static void main(String[] args) {
		
		Caixa caixa = new Caixa();
		Thread c = new Thread(caixa);
		c.start();
		
	}
}
