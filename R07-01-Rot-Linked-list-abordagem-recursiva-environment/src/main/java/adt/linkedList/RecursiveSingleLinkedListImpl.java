package adt.linkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno;
		if(data == null) {
			retorno = true;
		} else {
			retorno = false;
		}
		return retorno;
	}

	@Override
	public int size() {
		int retorno;
		if(isEmpty()) {
			retorno = 0;
		} else {
			retorno = 1 + next.size();
		}
		return retorno;
	}

	@Override
	public T search(T element) {
		T retorno;
		if(isEmpty()) {
			retorno = null;
		} else {
			if(this.data.equals(element)) {
				retorno = data;
			} else {
				retorno = next.search(element);
			}
		}
		return retorno;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			RecursiveSingleLinkedListImpl<T> node = 
					new RecursiveSingleLinkedListImpl<T>(element, new RecursiveSingleLinkedListImpl<>());
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(this.data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		list_toArray(0, result, this);
		return result;
	}
	
	private void list_toArray(int inicio, T[] array, RecursiveSingleLinkedListImpl<T> node) {
		if(!node.isEmpty()) {
			array[inicio] = node.getData();
			list_toArray(inicio++, array, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
