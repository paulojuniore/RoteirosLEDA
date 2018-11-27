package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return isEmpty() ? -1 : height(this.root);
	}

	private int height(BNode<T> node) {
		if (node.isLeaf())
			return 0;

		return 1 + height(node.getChildren().getFirst());
	}

	@SuppressWarnings("unchecked")
	@Override
	public BNode<T>[] depthLeftOrder() {
		BNode<T>[] array = new BNode[sizeOfNodes(root)];

		depthLeftOrder(root, array);

		return array;
	}

	private void depthLeftOrder(BNode<T> node, BNode<T>[] array) {
		setNewNode(node, array);

		for (BNode<T> nodeAux : node.getChildren()) {
			depthLeftOrder(nodeAux, array);
		}
	}

	private void setNewNode(BNode<T> node, BNode<T>[] array) {
		int i = 0;

		while (array[i] != null && i < array.length)
			i++;

		array[i] = node;
	}
	
	private int sizeOfNodes(BNode<T> node) {
		if (node.isEmpty()) {
			return 0;
		} else {
			int result = 1;

			for (BNode<T> nodeAux : node.getChildren())
				result += sizeOfNodes(nodeAux);
			
			return result;
		}
	}

	@Override
	public int size() {
		return size(this.root);
	}

	public int size(BNode<T> node) {
		if (node.isEmpty())
			return 0;

		int total = node.size();

		for (int i = 0; i < node.children.size(); i++) {
			total += size(node.children.get(i));
		}

		return total;
	}

	public int countNodes() {
		return countNodes(this.root);
	}

	private int countNodes(BNode<T> node) {
		if (node.isEmpty())
			return 0;

		int total = 1;

		for (int i = 0; i < node.children.size(); i++) {
			total += countNodes(node.children.get(i));
		}

		return total;
	}

	@Override
	public BNodePosition<T> search(T element) {
		if (element == null)
			return new BNodePosition<T>();

		return search(root, element);
	}

	private BNodePosition<T> search(BNode<T> node, T element) {
		int index = 0;

		while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
			index++;
		}

		if (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) == 0)
			return new BNodePosition<T>(node, index);

		if (node.isLeaf())
			return new BNodePosition<T>();

		return search(node.getChildren().get(index), element);
	}

	@Override
	public void insert(T element) {
		if (element == null)
			return;

		insert(root, element);
	}

	private void insert(BNode<T> node, T element) {
		int index = 0;

		while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
			index++;
		}

		if (node.isLeaf()) {
			node.addElement(element);
			node.addChild(index, new BNode<T>(this.order));

			if (node.size() > node.getMaxKeys()) {
				node.split();

				// atualiza o root
				while (node.parent != null) {
					node = node.parent;
				}

				this.root = node;
			}
		} else {
			insert(node.getChildren().get(index), element);
		}
	}

	private void split(BNode<T> node) {

		int median = node.size() / 2;
		T mid = node.getElementAt(median);

		BNode<T> left = node.copyLeftChildren(median);
		BNode<T> right = node.copyRightChildren(median);

		if (node == root) {
			BNode<T> newRoot = new BNode<T>(node.getOrder());
			newRoot.addElement(mid);
			node.setParent(newRoot);
			root = newRoot;

			for (int i = 0; i < node.getChildren().size(); i++) {
				if (i <= median) {
					left.addChild(i, node.getChildren().get(i));
				} else {
					right.addChild(i - median - 1, node.getChildren().get(i));
				}
			}
			newRoot.addChild(0, left);
			newRoot.addChild(1, right);
			newRoot.getChildren().get(0).setParent(newRoot);
			newRoot.getChildren().get(1).setParent(newRoot);
		} else {
			promote(node);
		}
	}

	private void promote(BNode<T> node) {

		BNode<T> parent = node.getParent();
		T mid = node.getElementAt(node.getOrder() / 2);
		parent.addElement(mid);

		int median = parent.getElements().indexOf(mid);
		parent.removeChild(node);

		node.getChildren().get(0).setParent(parent);
		node.getChildren().get(1).setParent(parent);

		node.getParent().removeChild(node);
		node.getParent().addChild(median, node.getChildren().get(1));
		node.getParent().addChild(median, node.getChildren().get(0));
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO

	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
