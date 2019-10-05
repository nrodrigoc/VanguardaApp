package vanguardamanager;

public class ObjectManager {
	
	private Contador fila;
	private Caixa caixa;
	
	public ObjectManager(Caixa caixa) {
		this.caixa = caixa;
		fila = new Contador();
	}
	
	public Contador getFila() {
		return fila;
	}
	
	public Caixa getCaixa() {
		return caixa;
	}
	
}
