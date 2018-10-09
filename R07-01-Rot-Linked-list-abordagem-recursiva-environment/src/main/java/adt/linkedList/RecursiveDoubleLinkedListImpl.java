package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if(this.getPrevious() == null) {
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
		} 
		if (this.getPrevious().isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> atual = new RecursiveDoubleLinkedListImpl<T>(this.getData(), this.getNext(), this);
			this.setData(element);
			this.setNext(atual);
		} else {
			this.getPrevious().insertFirst(element);
		}
	}
	
	@Override
	public void insert(T element) {
		super.insert(element);
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
