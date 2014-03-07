package br.ufms.busca;

import java.util.ArrayList;
import java.util.List;

public class No {

	private String info;
	private List<No> filhos;
	private No prox;
	
	
	public No(String inf) {
		filhos = new ArrayList<>();
		info = inf;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<No> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<No> filhos) {
		this.filhos = filhos;
	}

	public void addFilhos(No filho) {
		filhos.add(filho);
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}


}
