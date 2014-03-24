package br.ufms.buscaAEstrela;

public class Teste {
	static final int tam = 20;

	public Teste() {

	}

	public static int[][] preecherMatriz() {
		int m[][] = new int[tam][tam];
		m[0][15] = m[15][0] = 140;
		m[0][16] = m[16][0] = 118;
		m[0][19] = m[19][0] = 75;

		m[1][5] = m[5][1] = 211;
		m[1][6] = m[6][1] = 90;
		m[1][13] = m[13][1] = 101;
		m[1][17] = m[17][1] = 85;

		m[2][3] = m[3][2] = 120;
		m[2][13] = m[13][2] = 138;
		m[2][14] = m[14][2] = 146;

		m[3][10] = m[10][3] = 75;

		m[4][7] = m[7][4] = 86;

		m[5][15] = m[15][5] = 99;

		m[7][17] = m[17][7] = 98;

		m[8][11] = m[11][8] = 87;
		m[8][18] = m[18][8] = 92;

		m[9][10] = m[10][9] = 70;
		m[9][16] = m[16][9] = 111;

		m[12][15] = m[15][12] = 151;
		m[12][19] = m[19][12] = 71;

		m[13][14] = m[14][13] = 97;

		m[14][15] = m[15][14] = 80;

		m[17][18] = m[18][17] = 142;

		return m;
	}

	
	
	public static void main(String[] args) {
		int a[][] = preecherMatriz();
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if (a[i][j] != 0)
					System.out.println("[" + i + "][" + j + "] = " + a[i][j]);
			}
		}
	}
}
