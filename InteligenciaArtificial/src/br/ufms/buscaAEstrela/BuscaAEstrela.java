package br.ufms.buscaAEstrela;

import java.lang.management.GarbageCollectorMXBean;

public class BuscaAEstrela {

	static final String CIDADE = "bucareste";

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

		arad.getOpcoes().add(new Trajeto(75, zerid));
		arad.getOpcoes().add(new Trajeto(140, sibiu));
		arad.getOpcoes().add(new Trajeto(118, timisoara));

		bucareste.getOpcoes().add(new Trajeto(211, fagaras));
		bucareste.getOpcoes().add(new Trajeto(90, giurgiu));
		bucareste.getOpcoes().add(new Trajeto(101, pitesti));
		bucareste.getOpcoes().add(new Trajeto(85, urziceni));

		craiova.getOpcoes().add(new Trajeto(120, dobreta));
		craiova.getOpcoes().add(new Trajeto(138, pitesti));
		craiova.getOpcoes().add(new Trajeto(146, rVicea));

		dobreta.getOpcoes().add(new Trajeto(75, mehadia));
		dobreta.getOpcoes().add(new Trajeto(120, craiova));

		eforie.getOpcoes().add(new Trajeto(86, hirsova));

		fagaras.getOpcoes().add(new Trajeto(99, sibiu));
		fagaras.getOpcoes().add(new Trajeto(211, bucareste));
		//
		giurgiu.getOpcoes().add(new Trajeto(90, bucareste));

		hirsova.getOpcoes().add(new Trajeto(98, urziceni));
		hirsova.getOpcoes().add(new Trajeto(86, eforie));
		//
		iasi.getOpcoes().add(new Trajeto(87, neamt));
		iasi.getOpcoes().add(new Trajeto(92, vaslui));
		//
		lugoj.getOpcoes().add(new Trajeto(70, mehadia));
		lugoj.getOpcoes().add(new Trajeto(111, timisoara));
		//
		mehadia.getOpcoes().add(new Trajeto(75, dobreta));
		mehadia.getOpcoes().add(new Trajeto(70, lugoj));

		neamt.getOpcoes().add(new Trajeto(87, iasi));

		oradea.getOpcoes().add(new Trajeto(151, sibiu));
		oradea.getOpcoes().add(new Trajeto(71, zerid));

		pitesti.getOpcoes().add(new Trajeto(97, rVicea));
		pitesti.getOpcoes().add(new Trajeto(138, craiova));
		pitesti.getOpcoes().add(new Trajeto(101, bucareste));

		rVicea.getOpcoes().add(new Trajeto(80, sibiu));
		rVicea.getOpcoes().add(new Trajeto(146, craiova));
		rVicea.getOpcoes().add(new Trajeto(97, rVicea));

		sibiu.getOpcoes().add(new Trajeto(99, fagaras));
		sibiu.getOpcoes().add(new Trajeto(140, arad));
		sibiu.getOpcoes().add(new Trajeto(80, rVicea));
		sibiu.getOpcoes().add(new Trajeto(151, oradea));
		//
		timisoara.getOpcoes().add(new Trajeto(118, arad));
		timisoara.getOpcoes().add(new Trajeto(111, lugoj));

		urziceni.getOpcoes().add(new Trajeto(142, vaslui));
		urziceni.getOpcoes().add(new Trajeto(85, bucareste));
		urziceni.getOpcoes().add(new Trajeto(98, hirsova));

		vaslui.getOpcoes().add(new Trajeto(92, iasi));
		vaslui.getOpcoes().add(new Trajeto(142, urziceni));

		zerid.getOpcoes().add(new Trajeto(75, arad));
		zerid.getOpcoes().add(new Trajeto(71, oradea));

		CalcularF(arad);
	}

	public static void CalcularF(No no) {
		no.setVisitado(true);

		if (no.getOpcoes().size() > 0) {

			int f, g, h = no.getH(), fFinal;
			System.out.println("Cidade atual " + no.getInfo()
					+ " Distancia de " + CIDADE);
			if (no.getInfo().equalsIgnoreCase(CIDADE)) {
				System.out.println("Chegou em " + no.getInfo());
			} else {
				fFinal = no.getF();
				for (Trajeto t : no.getOpcoes()) {
					if (!t.getNo().isVisitado()) {
						g = t.getDistanciaDaOrigem() + no.getG();
						h = t.getNo().getH();
						f = g + h;
						System.out.println(t.getDistanciaDaOrigem()
								+ "   f = g + h \t Cidade "
								+ t.getNo().getInfo() + "\t" + f + " = " + g
								+ "+" + h + "");
						t.getNo().setF(f);
						t.getNo().setG(g);
						if (f < fFinal) {
							no.setF(f);
							fFinal = f;
						}
					}
				}

				// acha o menor
				int menor = Integer.MAX_VALUE;
				for (Trajeto t : no.getOpcoes()) {
					if (!t.getNo().isVisitado()) {
						if (t.getNo().getF() < menor) {
							menor = t.getNo().getF();
						}
					}

				}

				// vai para o menr
				for (Trajeto t : no.getOpcoes()) {
					if (!t.getNo().isVisitado()) {
						if (t.getNo().getF() == menor) {
							CalcularF(t.getNo());
						}
					}

				}

			}
		}
	}

	public static void buscar(No no) {

	}

	public static void imprimir(No no) {
		no.setVisitado(true);
		for (Trajeto n : no.getOpcoes()) {
			if (!no.isVisitado())
				System.out.println(n.getNo().getInfo() + "\t"
						+ n.getNo().getF() + "\t" + n.getNo().getH());

			imprimir(n.getNo());
		}

	}

}
