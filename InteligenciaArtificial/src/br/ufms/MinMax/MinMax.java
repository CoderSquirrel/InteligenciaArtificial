package br.ufms.MinMax;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * @author jasane
 * 
 */
public class MinMax {

	static Jogador tabuleiro[][] = new Jogador[3][3];
	// static Jogador tabuleiro[][] = { { Jogador.PESSOA, null, Jogador.PESSOA
	// },
	// { null, Jogador.PESSOA, null },
	// { Jogador.COMPUTADOR, null, Jogador.COMPUTADOR } };

	static int custos[][] = new int[3][3];

	public MinMax() {

	}

	public static boolean vencedou(Jogador jogador) {
		boolean ganhou = false;
		if (jogador == Jogador.PESSOA) {
			if (verificarTransversais(Jogador.PESSOA)) {
				ganhou = true;
			} else if (verificarHorzontais(Jogador.PESSOA)) {
				ganhou = true;
			} else if (verificarVerticais(Jogador.PESSOA)) {
				ganhou = true;
			}

		}

		else if (jogador == Jogador.COMPUTADOR) {
			if (verificarTransversais(Jogador.COMPUTADOR)) {
				ganhou = true;
			} else if (verificarHorzontais(Jogador.COMPUTADOR)) {
				ganhou = true;
			} else if (verificarVerticais(Jogador.COMPUTADOR)) {
				ganhou = true;
			}
		}

		return ganhou;

	}

	public static void Mostrar() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == null) {
					System.out.print(" - |");
				} else {
					switch (tabuleiro[i][j]) {
					case PESSOA:
						System.out.print(" x |");
						break;
					case COMPUTADOR:
						System.out.print(" o |");
						break;
					default:

						break;
					}
				}
			}
			System.out.println("\n");
		}
	}


	public static boolean Cheio() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == null) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while (Cheio()) {
			if (i % 2 == 0) {
				System.out.println("Jogue: ");
				int l = scanner.nextInt();
				int c = scanner.nextInt();

				jogadaPessoa(l, c);
				if (vencedou(Jogador.PESSOA)) {
					System.out.println(Jogador.PESSOA.name() + " Venceu!!");
					break;
				}
			} else {
				System.out.println("computador");
				jogadaComputador();
				if (vencedou(Jogador.COMPUTADOR)) {
					System.out.println(Jogador.COMPUTADOR.name() + " Venceu!!");
					break;
				}
			}
			Mostrar();
			i++;
		}
		Mostrar();
	}

	public static boolean verificarTransversais(Jogador jogador) {
		// direita
		if (tabuleiro[0][0] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[2][2]
				&& tabuleiro[2][2] == jogador) {
			return true;
		}
		if (tabuleiro[0][2] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[2][0]
				&& tabuleiro[2][0] == jogador) {
			return true;
		}

		// esquerda
		return false;
	}

	public static boolean verificarVerticais(Jogador jogador) {
		// 0
		if (tabuleiro[0][0] == tabuleiro[1][0]
				&& tabuleiro[1][0] == tabuleiro[2][0]
				&& tabuleiro[2][0] == jogador) {
			return true;
		}

		// 1
		if (tabuleiro[0][1] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[2][1]
				&& tabuleiro[2][1] == jogador) {
			return true;
		}
		// 2
		if (tabuleiro[0][2] == tabuleiro[1][2]
				&& tabuleiro[1][2] == tabuleiro[2][2]
				&& tabuleiro[2][2] == jogador) {
			return true;
		}
		return false;
	}

	public static boolean verificarHorzontais(Jogador jogador) {
		// 0
		if (tabuleiro[0][0] == tabuleiro[0][1]
				&& tabuleiro[0][1] == tabuleiro[0][2]
				&& tabuleiro[0][2] == jogador) {
			return true;
		}

		// 1
		if (tabuleiro[1][0] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[1][2]
				&& tabuleiro[1][2] == jogador) {
			return true;
		}
		// 2
		if (tabuleiro[2][0] == tabuleiro[2][1]
				&& tabuleiro[2][1] == tabuleiro[2][2]
				&& tabuleiro[2][2] == jogador) {
			return true;
		}
		return false;
	}

	public static Jogador Proximo(Jogador atual) {
		if (atual == Jogador.PESSOA) {
			return Jogador.COMPUTADOR;
		} else {
			return Jogador.PESSOA;
		}
	}

	public static int Min(Jogador atual) {
		int r = 0;
		int custo = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == null) {
					tabuleiro[i][j] = atual;
					if (Cheio()) {
						if (vencedou(Jogador.COMPUTADOR)) {
							r = -1;
						} else if (vencedou(Jogador.PESSOA)) {
							r = 10;
						} else {
							r = 0;
						}

					} else {
						Max(Proximo(atual));
					}
				}
			}
		}
		System.out.println(r);
		return r;
	}

	public static int Max(Jogador atual) {
		int r = 0;
		int custo = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == null) {
					tabuleiro[i][j] = atual;
					if (Cheio()) {
						if (vencedou(Jogador.COMPUTADOR)) {
							r = 10;
						} else if (vencedou(Jogador.PESSOA)) {
							r = -1;
						} else {
							r = 0;
						}
					} else {
						Min(Proximo(atual));
					}
					tabuleiro[i][j] = null;
				}
			}
		}
		return r;
	}

	public static void jogadaPessoa(int l, int c) {
		if (tabuleiro[l][c] == null) {
			custos[l][c] = -99;
			tabuleiro[l][c] = Jogador.PESSOA;
		} else {
			System.out.println("Jogada não permitida " + l + "\t" + c + "\t"
					+ Jogador.PESSOA.name());
		}
	}

	public static void jogadaComputador() {

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				if (tabuleiro[linha][coluna] == null) {
					System.out.println(Maxi(Jogador.COMPUTADOR));
				}
			}
			System.out.println("\n");

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(custos[i][j] + "|");
				}
				System.out.println("\n");
			}
			System.out.println("\n");

		}
			int i = 0, j = 0;
			int custo = custos[0][0];
			for (int linha = 0; linha < 3; linha++) {
				for (int coluna = 0; coluna < 3; coluna++) {
					if (custos[linha][coluna] > custo) {
						custo = custos[linha][coluna];
						i = linha;
						j = coluna;
					}
				}
			}

			if (tabuleiro[i][j] == null) {
				tabuleiro[i][j] = Jogador.COMPUTADOR;
				custos[i][j] = -99;
			} else {
				System.out.println("Jogada não permitida " + i + "\t" + j
						+ "\t" + Jogador.COMPUTADOR.name());
			}
		}
	

	public static int Maxi(Jogador atual) {
		// System.out.print("\nMAXI ");
		int r = 0;
		if (vencedou(Jogador.COMPUTADOR)) {
			// System.out.print("GANHOU");
			r = 10;
		} else if (vencedou(Jogador.PESSOA)) {
			// System.out.print("PERDEU");
			r = -1;
		} else if (!Cheio()) {
			// System.out.print("EMPATOU");
			r = 0;
		} else {
			for (int l = 0; l < 3; l++) {
				for (int c = 0; c < 3; c++) {
					// System.out.println(tabuleiro[l][c]);
					if (tabuleiro[l][c] == null) {
						tabuleiro[l][c] = atual;
						// System.out.println("Min " + Mini(Proximo(atual)));
						custos[l][c] = Mini(Proximo(atual));
						tabuleiro[l][c] = null;
					}
				}
			}
		}
		return r;
	}

	public static int Mini(Jogador atual) {
		// System.out.print("\nMINI " );
		int r = 0;
		if (vencedou(Jogador.COMPUTADOR)) {
			// System.out.print("GANHARIA");
			r = 10;
		} else if (vencedou(Jogador.PESSOA)) {
			// System.out.print("PERDERIA");
			r = -1;
		} else if (!Cheio()) {
			// System.out.print("SERIA EMPATE");
			r = 0;
		} else {
			for (int l = 0; l < 3; l++) {
				for (int c = 0; c < 3; c++) {
					if (tabuleiro[l][c] == null) {
						tabuleiro[l][c] = atual;
						Maxi(Proximo(atual));
						tabuleiro[l][c] = null;
					}
				}
			}
		}
		return r;
	}

}
