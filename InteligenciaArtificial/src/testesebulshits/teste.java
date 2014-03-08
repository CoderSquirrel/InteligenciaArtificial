package testesebulshits;

import br.ufms.buscaProfundidade.No;

public class teste {

	static No a = new No("A");
	
	public static void alalala(No n) {
		System.out.println(n);
		System.out.println(a);
		No p = a;
		p.setInfo("b");
		System.out.println(p);

	}

	public static void mudarValor1(No w) {
		w.setInfo("b");
	}

	public static void mudarValor2() {
		No az = a;
		az.setInfo("8");
	}

	public static void main(String[] args) {
	//		alalala(a);
		
		System.out.println(a.getInfo());
		mudarValor1(a);
		System.out.println(a.getInfo());
		mudarValor2();
		System.out.println(a.getInfo());
	}

}
