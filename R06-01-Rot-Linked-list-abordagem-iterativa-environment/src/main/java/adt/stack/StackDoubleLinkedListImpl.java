package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			top.insertFirst(element);
		}
		throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			top.removeFirst();
		}
		throw new StackUnderflowException();
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public boolean isFull() {
		return size == 0;
	}

}
