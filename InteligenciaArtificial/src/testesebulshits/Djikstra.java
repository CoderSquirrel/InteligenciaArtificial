package testesebulshits;

public class Djikstra {

	public static void main(String[] args) {
		int n = 2, menor, tam = n + 2, ml;
		int matriz[][] = new int[tam][tam], caminho[][] = new int[tam][tam], visto[] = new int[tam];
		menor = 1000;
		matriz[0][1] = matriz[1][0] = 1;
		matriz[0][2] = matriz[2][0] = 3;
		matriz[0][3] = matriz[3][0] = 9;
		matriz[1][3] = matriz[3][1] = 2;
		matriz[2][3] = matriz[3][2] = 2;

		for (int i = 0; i < tam; i++) {

			for (int j = 0; j < tam; j++) {
				if (i == 0) {
					caminho[j][0] = matriz[j][0];
					visto[j] = 1;
					visto[0] = 0;
				} else if (visto[j] == 1) {
					if (matriz[i][j] > 0) {
						ml = 1000;
						for (int k = 0; k < tam; k++) {
							if (caminho[i][k] != 0) {
								if (caminho[i][k] < ml)
									ml = caminho[i][k];

							}
						}
						for (int k = 0; k < tam; k++) {
							if (caminho[j][k] == 0) {
								caminho[j][k] = ml + matriz[i][j];

							}
						}

					}

				}
System.out.println("Caminho\n");				
imprimit(caminho);
System.out.println("\n\nMatriz");
imprimit(matriz);
			}
			visto[i] = 1;

		}

		menor = 1000;
		for (int j = 0; j < tam; j++) {
			if (caminho[n + 1][j] < menor) {
				menor = caminho[n + 1][j];
			}

		}

//		System.out.println(menor);
	}

	public static void imprimit(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
