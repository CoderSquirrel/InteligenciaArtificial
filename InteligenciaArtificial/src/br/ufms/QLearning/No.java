package br.ufms.QLearning;

public class No {

	// 0-UP 1-DOWN 2-LEFT 3-RIGHT
	private double acoes[] = new double[4];

	public No() {
		for (int i = 0; i < acoes.length; i++) {
			acoes[i] = Math.random() / 1000;
		}
	}

	public double[] getAcoes() {
		return acoes;
	}

	public double getAcaoId(int i) {
		return acoes[i];
	}

	public void setAcaoId(int i, double recompensa) {
		this.acoes[i] = recompensa;
	}

	public void setAcoes(double acoes[]) {
		this.acoes = acoes;
	}

}
