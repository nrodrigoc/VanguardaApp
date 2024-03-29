package vanguardamanager;

import vanguardamanager.display.Display;
import vanguardamanager.gfx.Alertas;
import vanguardamanager.gfx.Assets;

public class Caixa implements Runnable{
	
	private Display display;
	
	private Alertas uiManager;
	private ObjectManager objectManager;
	private Contador fila;
	
	private boolean rodando;
	
	public Caixa() {
		uiManager = new Alertas();
		rodando = true;
		objectManager = new ObjectManager(this);
		fila = objectManager.getFila();
	}
	
	public void run() {
		init();
		/*while(rodando) {
			System.out.println("Tamanho atual da fila: " + fila.getQueueSize());
			System.out.println("Ficha atual: " + fila.getFichaAtual());
			
			/*Scanner input = new Scanner(System.in);
			String s = uiManager.getCommand();
			
			if(s != null)
				switch(s.toLowerCase()) {
					case "add": fila.adicionarPessoa(); break;
					case "prox": fila.proximaPessoa(); break;
					case "fechar": rodando = false; break;
					default: break;
				
				}	
			
		}
		System.out.println("Fim do programa!");
		*/
	}
	
	private void init() {
		Assets.init();
		Display.abrir();
	}
	
	public void fecharCaixa() {
		rodando = false;
	}
	

}
