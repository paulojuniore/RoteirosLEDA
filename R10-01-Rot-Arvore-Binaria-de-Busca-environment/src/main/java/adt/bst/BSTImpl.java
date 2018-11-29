package adt.bst;

import java.util.Arrays;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	private static final int FOLHA = 0;
	private static final int GRAU_UM = 1;
	private static final int GRAU_DOIS = 2;
	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public boolean detectBST(BSTNode<T> node) {
		if(node.isLeaf()) {
			return true;
		} else if(!node.isEmpty()){
			boolean var = true;
			if (node.getLeft().getData().compareTo(node.getData()) > 0) {
				var = false;
			}
			if (node.getRight().getData().compareTo(node.getData()) < 0) {
				var = false;
			}
			return var && detectBST((BSTNode<T>) node.getLeft()) && detectBST((BSTNode<T>) node.getRight());
		} else {
			return false;
		}
	}

	public Integer countLeaf() {
		return countLeaf(this.root);
	}

	private Integer countLeaf(BSTNode<T> node) {
		Integer toReturn = 0;
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				toReturn = 1;
			} else {
				toReturn = countLeaf((BSTNode<T>) node.getLeft()) + countLeaf((BSTNode<T>) node.getRight());
			}
		}
		return toReturn;
	}
	
	public boolean isEqualsBST(BSTImpl<T> bst2) {
		return isEqualsBST(root, bst2.getRoot());
	}

	private boolean isEqualsBST(BSTNode<T> node1, BSTNode<T> node2) {
		boolean toReturn = false;
		if(node1.isEmpty() && node2.isEmpty()) {
			toReturn = true;
		} else if (node1.getData().compareTo(node2.getData()) == 0) {
			toReturn = isEqualsBST(node1.getLeft(), node2.getLeft()) &&
					isEqualsBST(node1.getRight(), node2.getRight());
		}
		return toReturn;
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		if (isEmpty()) {
			return -1;
		}
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		if (node.isEmpty()) {
			return -1;
		}
		return 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		if (this.size() == 0) {
			BSTNode<T> nill = new BSTNode<T>();
			return nill;
		} else {
			if (this.root.getData().equals(element)) {
				return this.root;
			}
		}
		return search(this.root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				return node;
			} else {
				if (node.getData().compareTo(element) < 0) {
					return search((BSTNode<T>) node.getRight(), element);
				} else {
					return search((BSTNode<T>) node.getLeft(), element);
				}
			}
		}
		BSTNode<T> nill = new BSTNode<T>();
		return nill;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.root.setData(element);
			this.root.setLeft(new BSTNode<T>());
			this.root.setRight(new BSTNode<T>());
			this.root.setParent(null);
		} else {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.getData().compareTo(element) > 0) {
			if (node.getLeft().isEmpty()) {
				node.getLeft().setData(element);
				node.getLeft().setLeft(new BSTNode<T>());
				node.getLeft().setRight(new BSTNode<T>());
				node.getLeft().setParent(node);
			} else {
				insert((BSTNode<T>) node.getLeft(), element);
			}
		} else {
			if (node.getRight().isEmpty()) {
				node.getRight().setData(element);
				node.getRight().setLeft(new BSTNode<T>());
				node.getRight().setRight(new BSTNode<T>());
				node.getRight().setParent(node);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> nill = new BSTNode<T>();
		if (size() == 0) {
			return null;
		}
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight().isEmpty()) {
			return node;
		}
		return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (size() == 0) {
			return null;
		}
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) {
			return node;
		}
		return minimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				return minimum((BSTNode<T>) node.getRight());
			} else {
				return sucessor(node, element);
			}
		} else {
			return null;
		}
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		if (node.getParent() != null) {
			if (node.getParent().getData().compareTo(element) > 0) {
				return (BSTNode<T>) node.getParent();
			} else {
				return sucessor((BSTNode<T>) node.getParent(), element);
			}
		} else {
			return null;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				return maximum((BSTNode<T>) node.getLeft());
			} else {
				return predecessor(node, element);
			}
		} else {
			return null;
		}
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		if (node.getParent() != null) {
			if (node.getParent().getData().compareTo(element) < 0) {
				return (BSTNode<T>) node.getParent();
			} else {
				return predecessor((BSTNode<T>) node.getParent(), element);
			}
		} else {
			return null;
		}
	}

	@Override
	public void remove(T element) {
		if (element == null) {
			return;
		}
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return;
		}
		remove(node);
	}

	private void remove(BSTNode<T> node) {
		if (node.isEmpty()) {
			return;
		}
		switch (getDegreeNode(node)) {
		case FOLHA:
			removeLeaf(node);
			break;
		case GRAU_UM:
			removeGrauUm(node);
			break;
		case GRAU_DOIS:
			removeGrauDois(node);
			break;
		default:
			break;
		}
	}

	private int getDegreeNode(BSTNode<T> node) {
		if ((node.getLeft().isEmpty()) && (node.getRight().isEmpty())) {
			return FOLHA;
		} else if ((!node.getLeft().isEmpty()) && (node.getRight().isEmpty())) {
			return GRAU_UM;
		} else if ((node.getLeft().isEmpty()) && (!node.getRight().isEmpty())) {
			return GRAU_UM;
		} else {
			return GRAU_DOIS;
		}
	}

	private void removeLeaf(BSTNode<T> node) {
		node.setData(null);
	}

	private void removeGrauUm(BSTNode<T> node) {
		if (node.getParent() == null) {
			if (!(node.getRight().isEmpty())) {
				node.getRight().setParent(null);
				this.root = (BSTNode<T>) node.getRight();
			} else {
				node.getLeft().setParent(null);
				this.root = (BSTNode<T>) node.getLeft();
			}

		} else {
			BSTNode<T> aux = null;

			if (!(node.getLeft()).isEmpty()) {
				aux = (BSTNode<T>) node.getLeft();
			} else {
				aux = (BSTNode<T>) node.getRight();
			}

			aux.setParent(node.getParent());

			if (node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(aux);
			} else {
				node.getParent().setRight(aux);
			}
		}
	}

	private void removeGrauDois(BSTNode<T> node) {
		BSTNode<T> sucessor = sucessor(node.getData());

		if (sucessor != null) {
			T data = node.getData();

			node.setData(sucessor.getData());
			sucessor.setData(data);

			remove(sucessor);
		} else {
			BSTNode<T> predecessor = predecessor(node.getData());

			T data = node.getData();

			node.setData(predecessor.getData());
			predecessor.setData(data);

			remove(predecessor);
		}
	}

	@Override
	public T[] preOrder() {
		T[] array;
		if (size() == 0) {
			array = (T[]) new Comparable[] {};
			return array;
		}
		array = (T[]) new Comparable[size()];
		int index = 0;
		preOrder(array, index, root);
		return array;
	}

	private int preOrder(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			index++;
			index = preOrder(array, index, (BSTNode<T>) node.getLeft());
			index = preOrder(array, index, (BSTNode<T>) node.getRight());
			return index;
		} else {
			return index;
		}
	}

	@Override
	public T[] order() {
		T[] array;
		if (size() == 0) {
			array = (T[]) new Comparable[] {};
			return array;
		}
		array = (T[]) new Comparable[size()];
		int index = 0;
		order(array, index, root);
		return array;
	}

	private int order(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			index = order(array, index, (BSTNode<T>) node.getLeft());
			array[index] = node.getData();
			index++;
			index = order(array, index, (BSTNode<T>) node.getRight());
			return index;
		} else {
			return index;
		}
	}

	@Override
	public T[] postOrder() {
		T[] array;
		if (size() == 0) {
			array = (T[]) new Comparable[] {};
			return array;
		}
		array = (T[]) new Comparable[size()];
		int index = 0;
		postOrder(array, index, root);
		return array;
	}

	private int postOrder(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			index = postOrder(array, index, (BSTNode<T>) node.getLeft());
			index = postOrder(array, index, (BSTNode<T>) node.getRight());
			array[index] = node.getData();
			index++;
			return index;
		} else {
			return index;
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // inductive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

	public static void main(String[] args) {
		BSTImpl<Integer> tree = new BSTImpl<>();
		tree.insert(8);
		tree.insert(4);
		tree.insert(12);
		tree.insert(2);
		tree.insert(6);
		tree.insert(10);
		tree.insert(14);
		tree.insert(1);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		tree.insert(13);
		tree.insert(15);

		System.out.println(tree.size());
		System.out.println(tree.minimum());
		System.out.println(tree.maximum());
		System.out.println(Arrays.toString(tree.postOrder()));
		System.out.println(tree.countLeaf());
	}

}
