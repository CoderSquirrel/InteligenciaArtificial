package br.ufms.buscaAEstrela;

public class AEstrela {
	static final String CIDADE = "bucareste";

	static int tam = 20;
	static int[] fs = new int[tam];
	static String[] cidades = new String[tam];
	static int[] gs = new int[tam];
	static int[] hs = new int[tam];
	static int[] pai = new int[tam];
	static int[] visitados = new int[tam];
	static int[][] m = new int[tam][tam];

	public AEstrela() {
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

		hs[0] = 366;
		hs[1] = 0;
		hs[2] = 160;
		hs[3] = 242;
		hs[4] = 61;
		hs[5] = 176;
		hs[6] = 77;
		hs[7] = 151;
		hs[8] = 226;
		hs[9] = 244;
		hs[10] = 241;
		hs[11] = 241;
		hs[12] = 380;
		hs[13] = 100;
		hs[14] = 193;
		hs[15] = 253;
		hs[16] = 329;
		hs[17] = 80;
		hs[18] = 199;
		hs[19] = 374;

		cidades[0] = "arad";
		cidades[1] = "bucareste";
		cidades[2] = "craiova ";
		cidades[3] = "dobreta ";
		cidades[4] = "eforie ";
		cidades[5] = "fagaras";
		cidades[6] = "giurgiu";
		cidades[7] = "hirsova ";
		cidades[8] = "iasi";
		cidades[9] = "lugoj ";
		cidades[10] = "mehadia ";
		cidades[11] = "neamt ";
		cidades[12] = "oradea ";
		cidades[13] = "pitesti";
		cidades[14] = "rVicea";
		cidades[15] = "sibiu ";
		cidades[16] = "timisoara";
		cidades[17] = "urziceni";
		cidades[18] = "vaslui ";
		cidades[19] = "zerid";

	}

	public static void main(String[] args) {
		new AEstrela();
		Aestrela(0, 0);
	}

	/**
	 * 
	 * @param atual
	 *            nó atual
	 * @param n
	 *            nó para qual eu vou
	 * @param anterior
	 *            nó antes do nó atual
	 * 
	 * <br />
	 *            <b>Passos</b> <br />
	 *            <b>1.</b> Ao entrar no metodo a cidade é marcada como já
	 *            visitada.<br />
	 *            <b>2.</b> É verificado se o nó atual é a cidade de destino.<br />
	 *            <b>3.</b> Verifica-se quais as cidades proximas da cidade
	 *            atual e é feito a o calculo de f.<br />
	 *            <b>4.</b> Verifica se é a cidade com menor f, armazena o id da
	 *            cidade e salva o f como menor f, para fim de comparação.<br />
	 *            <b>5.</b> Verifica se a cidade anterior a atua nao possui
	 *            nenhum destino possivel com menor f que cidade escolhida e que
	 *            não foi visitada, se houver armazena o id da cidade e salva o
	 *            f como menor f, para fim de comparação. <br/>
	 *            <b>6.</b> Chama o metodo enviando como parametros n que é o id
	 *            da cidade escolhida, e a cidade atual. <br/>
	 * 
	 */
	public static void Aestrela(int atual, int anterior) {
		System.out.println("Id atual " + atual + "\tId pai " + anterior + " Cidade "
				+ cidades[atual].toUpperCase());
		visitados[atual] = 1;
		if (!cidades[atual].equalsIgnoreCase(CIDADE)) {
			int menor = Integer.MAX_VALUE;
			int n = 0;

			/**
			 *  encontra o menos dos destinos possiveis apartir do no atual
	 		 */
	 		for (int i = 0; i < tam; i++) {
	 			if (m[atual][i] != 0) {
					gs[i] = gs[atual] + m[atual][i];
					fs[i] = gs[i] + hs[i];
					// System.out.println("Cidade " + cidades[i] + " f (" +
					// fs[i]
					// + ") = g (" + gs[i] + ") h (" + hs[i] + ")");
					if (fs[i] < menor) {
						menor = fs[i];
						n = i;
					}
				}
			}

			// System.out.println("\tCidade Escolhida antes de verificar o pai "
			// + cidades[n] + " id " + n + " f (" + fs[n] + ") = g ("
			// + gs[n] + ") h (" + hs[n] + ")");

			/**
			 * Verifica se algum dos destinos possiveis partindo da cidade
			 * anterior é menor que os possiveis apartir deste destino;
			 */

			for (int i = 0; i < tam; i++) {
				if (m[anterior][i] != 0 && visitados[i] == 0) {
					if (fs[i] < menor) {

						menor = fs[i];
						n = i;
					}
				}
			}
			// System.out.println("\tCidade Escolhida depois de vetificar o pai "
			// + cidades[n] + " f (" + fs[n] + ") = g (" + gs[n] + ") h ("
			// + hs[n] + ")");
			System.out.println("Indo para " + cidades[n].toUpperCase() + "\t F = " + fs[n]
					+ "  G = " + gs[n] + "  H = " + hs[n]);
			Aestrela(n, atual);
		}
	}

}
