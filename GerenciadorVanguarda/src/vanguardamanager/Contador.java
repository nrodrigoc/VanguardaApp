package vanguardamanager;

import java.util.ArrayList;

public class Contador{
	
	private static ArrayList<Integer> fila;
	private static int fichaAtual;
	
	public Contador() {
		fila = new ArrayList<>();
		fichaAtual = 0;
	}
	
	public void adicionarPessoa() {
		fichaAtual++;
		fila.add(fichaAtual);
	}
	
	public void proximaPessoa() {
		if(!fila.isEmpty())
			fila.remove(0);
	}
	
	public int getFichaAtual() {
		if(fila.isEmpty()) {
			return 0;
		}
		return fila.get(0);
	}
	
	public int getQueueSize() {
		return fila.size();
	}
	
	
}
