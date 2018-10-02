package adt.linkedList;

import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		
		DoubleLinkedListImpl<Integer> lista = new DoubleLinkedListImpl<>();
		
		lista.insert(10);
		lista.insert(100);
		lista.insertFirst(80);
		lista.insertFirst(200);
		lista.removeFirst();
		lista.removeFirst();
		System.out.println(Arrays.toString(lista.toArray()));
		
	}

}
