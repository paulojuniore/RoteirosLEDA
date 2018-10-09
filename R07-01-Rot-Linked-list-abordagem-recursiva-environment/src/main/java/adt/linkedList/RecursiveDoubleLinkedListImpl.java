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
		if(element != null && isEmpty()) {
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<>();
			if(previous == null) {
				this.previous = new RecursiveDoubleLinkedListImpl<>();
			}
		} else {
			next.insert(element);
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			this.data = next.data;
			if(!this.next.isEmpty()) {
				((RecursiveDoubleLinkedListImpl<T>)this.next.next).previous = this;
				this.next = this.next.next;
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.next.isEmpty()) {
			((RecursiveDoubleLinkedListImpl<T>) this.next.next).removeLast();
		} else {
			this.data = null;
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
