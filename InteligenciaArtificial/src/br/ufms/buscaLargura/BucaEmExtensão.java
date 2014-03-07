package br.ufms.buscaLargura;

public class BucaEmExtensão {

	static No inicio, fim, pont;

	public static No inserir(No no) {
		pont = no;

		if (fim != null) {
			fim.setProx(pont);
		} else {
			inicio = pont;
		}

		fim = pont;
		return fim;
	}

	public static void impressao() {
		No pt = inicio;
		while (pt != null) {
			System.out.print(pt.getInfo() + " ");
			pt = pt.getProx();
		}
		System.out.println("");
	}

	public static void percorerEListar(No no) {

		for (No n : no.getFilhos()) {
			inserir(n);
		}

		for (No n : no.getFilhos()) {
			percorerEListar(n);
		}

	}

	public static void buscaNo(String info) {

		while (inicio != null) {
			System.out.println("No atual " + inicio.getInfo());
			if (inicio.getInfo().equalsIgnoreCase(info)) {
				System.out.println("Encontrado " + info);
				break;
			}
			inicio = inicio.getProx();
		}

	}

	public static void remover() {
		inicio = inicio.getProx();
	}

	public static void main(String[] args) {
		No raiz = new No("a");
		No b = new No("b");
		No c = new No("c");
		No d = new No("d");
		No e = new No("e");
		No f = new No("f");
		No g = new No("g");

		raiz.addFilhos(b);
		raiz.addFilhos(c);

		b.addFilhos(d);
		b.addFilhos(e);

		c.addFilhos(f);
		c.addFilhos(g);
		inserir(raiz);
		percorerEListar(raiz);
		impressao();

		buscaNo("i");

	}

}