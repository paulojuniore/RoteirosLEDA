package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> aux = this.head;
		int qtde = 0;
		while (!aux.isNIL()) {
			++qtde;
			aux = aux.getNext();
		}
		return qtde;
	}

	@Override
	public T search(T element) {
		T retorno = null;
		SingleLinkedListNode<T> atual = this.head;
		while (!atual.isNIL()) {
			if (atual.getData().equals(element)) {
				retorno = atual.getData();
			}
			atual = atual.getNext();
		}
		return retorno;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				SingleLinkedListNode<T> node = new SingleLinkedListNode<>(element, head);
				setHead(node);
			} else {
				SingleLinkedListNode<T> aux = head;
				while (!aux.getNext().isNIL()) {
					aux = aux.getNext();
				}
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				aux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (head.data.equals(element)) {
			setHead(head.next);
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = null;
			while (!aux.isNIL() && aux.data != element) {
				previous = aux;
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = head;
		T[] vetor = (T[]) new Object[this.size()];
		int i = 0;
		while (!aux.isNIL()) {
			vetor[i++] = aux.getData();
			aux = aux.getNext();
		}
		return vetor;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

	@Override
	public void swap(T element1, T element2) {
		SingleLinkedListNode<T> e1, e2;
		e1 = e2 = null;
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {
			if(aux.getData().equals(element1))
				e1 = aux;
			else if(aux.getData().equals(element2))
				e2 = aux;
			aux = aux.getNext();
		}
		if(e1 != null && e2 != null) {
			T auxi = e1.getData();
			e1.setData(e2.getData());
			e2.setData(auxi);
		}
	}

	@Override
	public T elementFromTheEnd(int k) {
		int i = 0;
		SingleLinkedListNode<T> nodeK =  this.head;
		T retorno = null;
		while(i != k && !nodeK.isNIL()) {
			nodeK = nodeK.getNext();
			i++;
		}
		if(i >= k) {
			SingleLinkedListNode<T> node = this.head;
			while(!nodeK.isNIL()) {
				nodeK = nodeK.getNext();
				node = node.getNext();
			}
			retorno = node.getData();
		}
		return retorno;
	}

}
