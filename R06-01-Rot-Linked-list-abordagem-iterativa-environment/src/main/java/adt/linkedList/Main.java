package adt.linkedList;

public class Main {

	public static void main(String[] args) {
		
		SingleLinkedListImpl<Integer> lista = new SingleLinkedListImpl<>();
		
		lista.insert(10);
		lista.insert(50);
		System.out.println(lista.size());
		System.out.println(lista.toArray());
		

	}

}
