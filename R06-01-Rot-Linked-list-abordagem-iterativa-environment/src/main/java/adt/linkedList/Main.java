package adt.linkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		SingleLinkedListImpl<Integer> lista = new SingleLinkedListImpl<>();
		
		System.out.println(lista.size());
		lista.insert(10);
		lista.insert(20);
		System.out.println(Arrays.toString(lista.toArray()));
		lista.remove(20);
		System.out.println(Arrays.toString(lista.toArray()));
		System.out.println(lista.search(10));
		System.out.println(lista.isEmpty());
		
	}

}
