package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		head = new DoubleLinkedListNode();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
		newHead.setData(element);
		newHead.setNext(head);
		newHead.setPrevious(new DoubleLinkedListNode<>());
		if(head.isNIL()) {
			last = newHead;
		}
		head = newHead;
	}

	@Override
	public void removeFirst() {
		if(!head.isNIL()) {
			head = head.getNext();
			if(head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}
		}
	}

	@Override
	public void removeLast() {
		if(!last.isNIL()) {
			last = last.getPrevious();
			if(last.isNIL()) {
				head = last;
			}
			last.next = new DoubleLinkedListNode<>();
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
