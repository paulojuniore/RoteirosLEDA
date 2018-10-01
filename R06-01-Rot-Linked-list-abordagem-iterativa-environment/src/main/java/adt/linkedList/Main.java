package adt.linkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		SingleLinkedListImpl<Integer> lista = new SingleLinkedListImpl<>();
		
		lista.insert(10);
		lista.insert(50);
		lista.insert(100);
		System.out.println(lista.size());
		System.out.println(Arrays.toString(lista.toArray()));
		
	}

}
