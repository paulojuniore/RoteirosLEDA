package adt.avltree;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLCountAndFillImpl<Integer> a = new AVLCountAndFillImpl<>();
		a.insert(50);
		a.insert(60);
		a.insert(70);
		
		System.out.println(Arrays.toString(a.preOrder()));
	}

}
