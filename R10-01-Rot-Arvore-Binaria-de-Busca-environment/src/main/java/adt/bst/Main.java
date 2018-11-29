package adt.bst;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		BSTImpl<Integer> bst = new BSTImpl<>();
		
		bst.insert(10);
		bst.insert(15);
		bst.insert(30);
		
	    System.out.println(bst.detectBST(bst.root));
	    System.out.println(bst.countLeaf());
		System.out.println(Arrays.toString(bst.preOrder()));

	}

}
