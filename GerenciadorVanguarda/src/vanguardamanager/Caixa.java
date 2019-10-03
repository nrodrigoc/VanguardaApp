package vanguardamanager;

import vanguardamanager.display.GerenciadorUI;

public class Caixa implements Runnable{

	private GerenciadorUI uiManager;
	private ObjectManager objectManager;
	private Contador fila;
	
	private boolean rodando;
	
	public Caixa() {
		uiManager = new GerenciadorUI();
		rodando = true;
		objectManager = new ObjectManager(this);
		fila = objectManager.getFila();
	}
	
	public void run() {
		
		while(rodando) {
			System.out.println("Tamanho atual da fila: " + fila.getQueueSize());
			System.out.println("Ficha atual: " + fila.getFichaAtual());
			
			/*Scanner input = new Scanner(System.in);*/
			String s = uiManager.getCommand();
			
			switch(s.toLowerCase()) {
				case "add": fila.adicionarPessoa(); break;
				case "prox": fila.proximaPessoa(); break;
				case "fechar": rodando = false; break;
				default: break;
			
			}	
			
		}
		System.out.println("Fim do programa!");
		
	}
	
	public void fecharCaixa() {
		rodando = false;
	}
	

}
