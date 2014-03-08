package br.ufms.buscaProfundidade;

import java.util.List;

public class BuscaProfundidade {
	static No inicio, fim, pont;

	public static void pre(No pt) {
	for (No n : pt.getFilhos()) {
			pre(n);
		}
		if (pt.getFilhos().isEmpty() || visitados(pt.getFilhos())) {
			pt.setEstado(Estado.Visitado);
			System.out.println("Nó " + pt.getInfo() + "\tEstado " + pt.getEstado());
		}

	}

	public static boolean visitados(List<No> nos) {
		boolean todos = true;
		for (No no : nos) {
			if (no.getEstado().equals(Estado.Nao_Visitado)) {
				todos = false;
			}
		}

		return todos;
	}

	public static void main(String[] args) {
		No raiz = new No("a");
		No b = new No("b");
		No c = new No("c");

		raiz.addFilhos(b);
		raiz.addFilhos(c);
		No d = new No("d");
		No e = new No("e");
		b.addFilhos(d);
		b.addFilhos(e);
		 No f = new No("f");
		 No g = new No("g");
		 c.addFilhos(f);
		 c.addFilhos(g);
		
		 
		 pre(raiz);


	}

	public static void imprimir(No n) {
		for (No no : n.getFilhos()) {
			imprimir(no);
		}
		System.out.println("Nó " + n.getInfo() + "\tEstado " + n.getEstado());

	}

}

// ver se chegou ao fim
// ver se todos os filhos foram visitados
