package br.ufms.buscaAEstrela;

import java.util.ArrayList;
import java.util.List;

public class No {

	private String info;
	private int h;
	private List<Trajeto> opcoes;
	private boolean visitado;
	private int f;
	private int g;
	public No(String inf, int d) {
		opcoes = new ArrayList<>();
		info = inf;
		h = d;
		setVisitado(false);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getH() {
		return h;
	}

	public void setH(int distanciaAteDestino) {
		this.h = distanciaAteDestino;
	}

	public List<Trajeto> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Trajeto> opcoes) {
		this.opcoes = opcoes;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

}
