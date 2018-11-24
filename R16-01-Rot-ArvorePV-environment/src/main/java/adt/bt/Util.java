package adt.bt;

import adt.bst.BSTNode;

public class Util {
	
	public static <T extends Comparable<T>> boolean isLeftChild(BSTNode<T> node) {
		return node.getParent() != null && !node.getParent().isEmpty()
                && !node.getParent().getLeft().isEmpty() &&
                node.getParent().getLeft().getData().equals(node.getData());
	}

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> filhoDireita = (BSTNode<T>) node.getRight();

		filhoDireita.setParent(node.getParent());
		if (filhoDireita.getParent() != null) {
			if (node.getParent().getRight().equals(node)) {
				node.getParent().setRight(filhoDireita);
			} else {
				node.getParent().setLeft(filhoDireita);
			}
		}
		node.setRight(filhoDireita.getLeft());
		filhoDireita.getLeft().setParent(node);
		filhoDireita.setLeft(node);
		node.setParent(filhoDireita);
		return filhoDireita;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> filhoEsquerda = (BSTNode<T>) node.getLeft();

		filhoEsquerda.setParent(node.getParent());
		if (filhoEsquerda.getParent() != null) {
			if (node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(filhoEsquerda);
			} else {
				node.getParent().setRight(filhoEsquerda);
			}
		}
		node.setLeft(filhoEsquerda.getRight());
		filhoEsquerda.getRight().setParent(node);
		filhoEsquerda.setRight(node);
		node.setParent(filhoEsquerda);
		return filhoEsquerda;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
