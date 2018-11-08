package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		BSTNode nodeRight = (BSTNode) node.getRight();
		BSTNode nodeLeft = (BSTNode) node.getLeft();

		int rightHeight = height(nodeRight);
		int leftHeight = height(nodeLeft);

		return Math.abs(leftHeight - rightHeight);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.root.setData(element);
				this.root.setLeft(new BSTNode());
				this.root.setRight(new BSTNode());
				this.root.getLeft().setParent(root);
				this.root.getRight().setParent(root);
			} else {
				insert(element, root);
			}
		}
	}

	private void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode());
			node.setRight(new BSTNode());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			rebalanceUp(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode) node.getLeft());
			} else {
				insert(element, (BSTNode) node.getRight());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty())
				remove(node);
		}
	}

	private void remove(BSTNode<T> node) {
		if (node.isEmpty())
			return;

		switch (getDegreeNode(node)) {
		case 0:
			removeLeaf(node);
			break;
		case 1:
			removeGrauUm(node);
			break;
		case 2:
			removeGrauDois(node);
			break;
		default:
			break;
		}
	}

	private void removeGrauDois(BSTNode<T> node) {
		BSTNode<T> sucessor = sucessor(node.getData());

		if (sucessor != null) {
			int grau = getDegreeNode(sucessor);

			node.setData(sucessor.getData());

			if (grau == 0) {
				removeLeaf(sucessor);
			} else if (grau == 1) {
				removeGrauUm(sucessor);
			} else {
				removeGrauDois(sucessor);
			}

		}
	}

	private void removeGrauUm(BSTNode<T> node) {

		if (node.getParent() == null) {
			if (!(node.getLeft().isEmpty())) {
				node.getLeft().setParent(null);
				this.root = (BSTNode<T>) node.getLeft();
				rebalanceUp(root);
				return;
			} else {
				node.getRight().setParent(null);
				this.root = (BSTNode<T>) node.getRight();
				rebalanceUp(root);
				return;
			}

		}
		BSTNode<T> aux = null;

		if (!node.getRight().isEmpty()) {
			aux = (BSTNode<T>) node.getRight();
		} else {
			aux = (BSTNode<T>) node.getLeft();
		}

		aux.setParent(node.getParent());

		if (node.getParent().getLeft().equals(node)) {
			node.getParent().setLeft(aux);
		} else {
			node.getParent().setRight(aux);
		}

		rebalanceUp(aux);

	}

	private void removeLeaf(BSTNode<T> node) {
		node.setData(null);
		rebalanceUp(node);
	}

	private int getDegreeNode(BSTNode<T> node) {
		if ((node.getLeft().isEmpty()) && (node.getRight().isEmpty())) {
			return 0;
		} else if ((!node.getLeft().isEmpty()) && (node.getRight().isEmpty())) {
			return 1;
		} else if ((node.getLeft().isEmpty()) && (!node.getRight().isEmpty())) {
			return 1;
		} else {
			return 2;
		}
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return;
		}

		BSTNode<T> nodeRotacionado = rotation(node);

		if (nodeRotacionado.getParent() == null) {
			super.root = nodeRotacionado;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node == null) {
			return;
		}
		// Alguns casos verifica como == 1 um invariante.
		if (calculateBalance(node) > 1) {
			rebalance(node);
		}

		rebalanceUp((BSTNode<T>) node.getParent());
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.rightRotation(node);
		if (node == this.root) {
			this.root = newNode;
		}

	}

	private BSTNode<T> rotation(BSTNode<T> node) {
		int alturaLeft = height((BSTNode<T>) node.getLeft());
		int allturaRight = height((BSTNode<T>) node.getRight());
		int diference = alturaLeft - allturaRight;
		if (diference > 0) {
			int alturaEsquerda = height((BSTNode<T>) node.getLeft().getLeft());
			int alturaDireita = height((BSTNode<T>) node.getLeft().getRight());

			int deference = alturaEsquerda - alturaDireita;

			if (deference < 0) {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				return Util.rightRotation(node);
			} else {
				return Util.rightRotation(node);
			}

		} else {
			int alturaEsquerda = height((BSTNode<T>) node.getRight().getLeft());
			int alturaDireita = height((BSTNode<T>) node.getRight().getRight());

			int deference = alturaEsquerda - alturaDireita;

			if (deference > 0) {
				Util.rightRotation((BSTNode<T>) node.getRight());
				return Util.leftRotation(node);
			} else {
				return Util.leftRotation(node);
			}
		}
	}
}
