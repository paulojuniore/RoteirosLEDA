package adt.bst;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		BSTImpl<Integer> bst = new BSTImpl<>();
		
//		bst.insert(10);
//		bst.insert(15);
//		bst.insert(30);
//		bst.insert(50);
//		bst.insert(35);
		
		BSTImpl<Integer> bst2 = new BSTImpl<>();
		
//		bst2.insert(10);
//		bst2.insert(15);
//		bst2.insert(30);
//		bst2.insert(50);
		
		System.out.println(bst.isEqualsBST(bst2));
		
	    //System.out.println(bst.detectBST(bst.root));
	    System.out.println(bst.countLeaf());
		System.out.println(Arrays.toString(bst.preOrder()));

	}

}
