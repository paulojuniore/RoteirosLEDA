package adt.linkedList;

import java.util.Arrays;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> aux = this.head;
		int qtde = 0;
		while(!aux.isNIL()) {
			++qtde;
			aux = aux.getNext();
		}
		return qtde;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		SingleLinkedListNode<T> retorno = null;
		SingleLinkedListNode<T> atual = this.head;
		while(!atual.getNext().isNIL()) {
			if(atual.getData().equals(element)) {
				retorno = atual;
			}
			atual = atual.getNext();
		}
		return (T) retorno;
	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			SingleLinkedListNode<T> node = new SingleLinkedListNode<>(element, head);
			setHead(node);
		} else {
			SingleLinkedListNode<T> aux = head;
			while(!aux.getNext().isNIL()) {
				aux  = aux.getNext();
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			aux.setNext(newNode);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			SingleLinkedListNode<T> atual = head;
			while(!atual.getNext().isNIL()) {

			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = head;
		T[] vetor = (T[]) new Object[this.size()];
		int i = 0;
		while(!aux.isNIL()) {
			vetor[i] = aux.getData();
			i++;
		}
		return vetor;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
