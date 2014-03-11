package br.ufms.buscaGulosa;

import br.ufms.buscaGulosa.No;

public class BuscaGulosa {

	static final String CIDADE = "bucareste";

	public static void procurar(No no) {
		System.out.println("Cidade atual " + no.getInfo() + " Distancia de "
				+ CIDADE + " " + no.getDistancia());
		if (no.getInfo().equalsIgnoreCase(CIDADE)) {
			System.out.println("Chegou em " + no.getInfo());
		} else {
			int d = no.getDistancia();
			No filho = null;
			for (No n : no.getFilhos()) {
				if (d > n.getDistancia()) {
					d = n.getDistancia();
					filho = n;
				}
			}

			procurar(filho);

		}
	}

	public static void main(String[] args) {

		No arad = new No("arad", 366);
		No bucareste = new No("bucareste", 0);
		No craiova = new No("cariova", 160);
		No dobreta = new No("dobreta", 242);
		No eforie = new No("eforie", 161);
		No fagaras = new No("faragas", 176);
		No giurgiu = new No("giurgiu", 77);
		No hirsova = new No("hirsova", 151);
		No iasi = new No("iasi", 226);
		No lugoj = new No("lugoj", 244);
		No mehadia = new No("mehadia", 241);
		No neamt = new No("neamt", 241);
		No oradea = new No("oradea", 380);
		No pitesti = new No("pitiest", 100);
		No rVicea = new No("rVicea", 193);
		No sibiu = new No("sibiu", 253);
		No timisoara = new No("timisoara", 329);
		No urziceni = new No("urziceni", 80);
		No vaslui = new No("vaslui", 199);
		No zerid = new No("zerid", 374);

		arad.getFilhos().add(sibiu);
		arad.getFilhos().add(timisoara);
		arad.getFilhos().add(zerid);

		sibiu.getFilhos().add(arad);
		sibiu.getFilhos().add(fagaras);
		sibiu.getFilhos().add(oradea);
		sibiu.getFilhos().add(rVicea);

		fagaras.getFilhos().add(sibiu);
		fagaras.getFilhos().add(bucareste);
		
		procurar(arad);

	}

}
