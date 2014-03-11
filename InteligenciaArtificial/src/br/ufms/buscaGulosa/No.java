package br.ufms.buscaGulosa;

import java.util.ArrayList;
import java.util.List;

public class No {

	private	String info;
	private	int distancia;
	private List<No> filhos;

	public No(String inf, int d) {
		filhos = new ArrayList<>();
		info = inf;
		distancia = d;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public List<No> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<No> filhos) {
		this.filhos = filhos;
	}

}
