package br.ufms.buscaProfundidade;

import java.util.ArrayList;
import java.util.List;

public class No {

	private String info;
	private List<No> filhos;
	private No prox;
	private Estado estado;

	public No(String inf) {
		filhos = new ArrayList<>();
		info = inf;
		estado = Estado.Nao_Visitado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
