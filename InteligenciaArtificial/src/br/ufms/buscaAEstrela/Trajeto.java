package br.ufms.buscaAEstrela;

public class Trajeto {

	private int distanciaDaOrigem;
	private No no;

	public Trajeto(int distancia, No cidade) {
		this.distanciaDaOrigem = distancia;
		this.no = cidade;
	}

	public int getDistanciaDaOrigem() {
		return distanciaDaOrigem;
	}

	public No getNo() {
		return no;
	}

}