package br.ufms.qLearning;

public class Q_learning {

	static final int tam = 3;
	static final int metaL = 2;
	static final int metaC = 2;
	static double soma_anterior;
	static No[][] matriz;

	public Q_learning() {

		matriz = new No[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				matriz[i][j] = new No();
			}
		}
	}

	public static void qLearning() {
		double soma = 0;
		if (Math.abs(soma - soma_anterior) < 0.01) {

		}
	}

	public double somar() {
		double somaAtual = 0.0;
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				somaAtual = somaAtual + matriz[i][j].getDown()
						+ matriz[i][j].getLeft() + matriz[i][j].getRight()
						+ matriz[i][j].getUp();
			}
		}
		return somaAtual;
	}

	public static void main(String[] args) {
		new Q_learning();
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				System.out.println(matriz[i][j] + " U " + matriz[i][j].getUp()
						+ " D " + matriz[i][j].getDown() + " L "
						+ matriz[i][j].getLeft() + " R "
						+ matriz[i][j].getRight());
				if (i == metaL && j == metaC) {
					System.out.println("META");
				}
			}
		}

	}
}
