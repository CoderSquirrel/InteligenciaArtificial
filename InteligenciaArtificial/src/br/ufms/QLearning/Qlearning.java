package br.ufms.QLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Qlearning {

	static final int tam = 30;
	static final int metaL = 15;
	static final int metaC = 15;
	static double soma_anterior = 0;
	static int r;
	static final double alpha = 0.2;
	static final double gama = 0.99;
	static int it = 0;
	static List<Integer> acoes;
	static int mov[][] = { { -1, 0 }, { +1, 0 }, { 0, -1 }, { 0, +1 } };
	static No[][] matriz;

	public Qlearning() {
		acoes = new ArrayList<Integer>();
		matriz = new No[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				matriz[i][j] = new No();
			}
		}

	}

	public static double guloso(int i, int j) {
		double maior = matriz[i][j].getAcaoId(0);
		for (int k = 1; k < 4; k++) {
			if (maior < matriz[i][j].getAcaoId(k)) {
				maior = matriz[i][j].getAcaoId(k);
			}
		}
		return maior;
	}

	public static double soma() {

		double resultado = 0;

		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				for (int k = 0; k < 4; k++)
					resultado += matriz[i][j].getAcaoId(k);
			}
		}
		return resultado;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bf = new BufferedWriter(new FileWriter("arquivo.txt"));
		new Qlearning();
		double erro = 0;
		do {

			qlearning1((int) (Math.random() * tam), (int) (Math.random() * tam));
			double soma = soma();
			erro = soma - soma_anterior;
			soma_anterior = (1 - alpha) * soma_anterior + alpha * soma;
			System.out.printf("%7d %f\n", it++, erro);
			bf.write(it + " \t " + erro + "\n");
			// bf.flush();
		} while (Math.abs(erro)>0.00000001);
		bf.close();
		im();

	}

	/**
	 * Verficar bsrdas
	 * 
	 * @param i
	 * @param j
	 * <br />
	 *            i = linha; <br />
	 *            i <- -> j = coluna; ^ \/ 0-UP 1-DOWN 2-LEFT 3-RIGHT
	 */

	public static void qlearning1(int i, int j) {
		int proxI = i, proxJ = j, acao = 0;
		while (true) {
			// verifica se chegou na meta
			if (i == metaL && j == metaC) {
				// System.out.println("Chegou na meta");
				break;
			} else {
				// 0-UP 1-DOWN 2-LEFT 3-RIGHT
				// i <- -> ; j = coluna; ^ \/

				double maior = matriz[i][j].getAcaoId(0);
				for (int k = 1; k < 4; k++) {

					if (maior <= matriz[i][j].getAcaoId(k)) {
						maior = matriz[i][j].getAcaoId(k);
						acao = k;
					}
				}
				if (Math.random() > 0.90)
					acao = (int) (Math.random() * 4);

				proxI = proxI + mov[acao][0];
				proxJ = proxJ + mov[acao][1];

				// 0-UP 1-DOWN 2-LEFT 3-RIGHT
				// i <- -> ; j = coluna; ^ \/

				if (proxI == metaL && proxJ == metaC) {
					r = 10;

				} else if (proxI >= tam || proxI < 0 || proxJ >= tam
						|| proxJ < 0) {
					r = -10;
					proxI = i;
					proxJ = j;
				} else {
					r = -1;
				}

				double recompensa = ((1 - alpha) * matriz[i][j].getAcaoId(acao))
						+ alpha * (r + gama * (guloso(proxI, proxJ)));
				matriz[i][j].setAcaoId(acao, recompensa);
				// System.out.printf("%d,%d -> %d,%d = %d \t %d\n", i, j, proxI,
				// proxJ, r, acao);
				i = proxI;
				j = proxJ;
			}
		}
	}

	public static void im() {
		char[] sym = "^v<>".toCharArray();
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if (i == metaL && j == metaC) {

					System.out.print("m");
					continue;
				}
				int m = 0;
				for (int k = 1; k < 4; k++)
					// se m > k ? ; sim:nao
					m = matriz[i][j].getAcaoId(m) > matriz[i][j].getAcaoId(k) ? m
							: k;
				System.out.print(sym[m]);
			}
			System.out.println();
		}
	}

}
