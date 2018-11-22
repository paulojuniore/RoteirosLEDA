package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed by
	 * the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must be
	 * BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Verifies the black-height property from the root.
	 */
	private boolean verifyBlackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T value) {
		
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		if (node.equals(root)) {
			node.setColour(Colour.BLACK);
		} else {
			fixUpCase2(node);
		}
	}

	protected void fixUpCase2(RBNode<T> node) {
		if (((RBNode<T>) node.getParent()).getColour() == Colour.BLACK) {

		} else {
			fixUpCase3(node);
		}
	}

	protected void fixUpCase3(RBNode<T> node) {
		RBNode<T> aux = (RBNode<T>) node.getParent().getParent();
		if (((RBNode<T>) aux.getRight()).getColour() == Colour.RED) {
			((RBNode<T>) aux.getLeft()).setColour(Colour.BLACK);
			((RBNode<T>) aux.getRight()).setColour(Colour.BLACK);
			aux.setColour(Colour.RED);
			fixUpCase1(node);
		} else {
			fixUpCase4(node);
		}
	}

	protected void fixUpCase4(RBNode<T> node) {
		RBNode<T> next = node;
		RBNode<T> parent = (RBNode<T>) node.getParent();
		RBNode<T> grandparent = (RBNode<T>) parent.getParent();
		if(parent.getRight().equals(node) && grandparent.getLeft().equals(parent)) {
			Util.leftRotation(parent);
			next = (RBNode<T>) node.getLeft();
		} else if(parent.getLeft().equals(node) && grandparent.getRight().equals(parent)) {
			Util.rightRotation(parent);
			next = (RBNode<T>) node.getRight();
		}
		fixUpCase5(next);
	}

	protected void fixUpCase5(RBNode<T> node) {
		RBNode<T> parent = (RBNode<T>) node.getParent();
		parent.setColour(Colour.BLACK);
		((RBNode<T>) parent.getParent()).setColour(Colour.RED);
		if(parent.getLeft().equals(node)) {
			Util.rightRotation((RBNode<T>) parent.getParent());
		} else {
			Util.leftRotation((RBNode<T>) parent.getParent());
		}
	}
}
