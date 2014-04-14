package br.ufms.MinMax;

public enum Jogador {
	PESSOA, COMPUTADOR;

	public Jogador contrario(Jogador o) {
		if (o == PESSOA) {
			return COMPUTADOR;
		} else {
			return PESSOA;
		}
	}
}
