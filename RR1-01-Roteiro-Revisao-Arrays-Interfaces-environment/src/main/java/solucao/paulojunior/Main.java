package solucao.paulojunior;

public class Main {

	public static void main(String[] args) {
		
		Quadrado q = new Quadrado(4);
		Retangulo r = new Retangulo(10, 5);
		Triangulo t = new Triangulo(10, 5);
		Circulo c = new Circulo(10);
		System.out.println(q.calculaArea());
		System.out.println(r.calculaArea());
		System.out.println(t.calculaArea());
		System.out.println(c.calculaArea());

	}

}
