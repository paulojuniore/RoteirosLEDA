package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		} else {
			top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T retorno = null;
		if(!isEmpty()) {
			retorno = top();
			top.removeFirst();
		} else {
			throw new StackUnderflowException();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T top() {
		return (T) this.top;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean isFull() {
		return this.size == top.size();
	}

}
