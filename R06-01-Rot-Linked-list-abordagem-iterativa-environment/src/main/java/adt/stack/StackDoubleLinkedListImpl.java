package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

   protected DoubleLinkedList<T> top;
   protected int size;

   public StackDoubleLinkedListImpl(int size) {
      this.size = size;
      this.top = new DoubleLinkedListImpl<T>();
   }

   @Override
   public void push(T element) throws StackOverflowException {
      if (!isFull()) {
         top.insertFirst(element);
      } else {
         throw new StackOverflowException();
      }
   }

<<<<<<< HEAD
   @Override
   public T pop() throws StackUnderflowException {
      if (!isEmpty()) {
         T retorno = (T) ((SingleLinkedListImpl<T>) top).getHead();
         top.removeFirst();
         return retorno;
      }
      throw new StackUnderflowException();
   }
=======
	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			@SuppressWarnings("unchecked")
			T retorno = (T) ((SingleLinkedListImpl<T>) top).getHead();
			top.removeFirst();
			return retorno;
		}
		throw new StackUnderflowException();
	}
>>>>>>> branch 'master' of https://github.com/paulojuniore/RoteirosLEDA.git

<<<<<<< HEAD
   @Override
   public T top() {
      if (!isEmpty()) {
         return (T) ((SingleLinkedListImpl<T>) top).getHead();
      }
      return null;
   }
=======
	@SuppressWarnings("unchecked")
	@Override
	public T top() {
		if(!isEmpty()) {
			return (T) ((SingleLinkedListImpl<T>) top).getHead();
		}
		return null;
	}
>>>>>>> branch 'master' of https://github.com/paulojuniore/RoteirosLEDA.git

<<<<<<< HEAD
   @Override
   public boolean isEmpty() {
      return ((SingleLinkedListImpl<T>) top).getHead().isNIL();
   }
=======
	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmpty() {
		return ((SingleLinkedListImpl<T>) top).getHead().isNIL();
	}
>>>>>>> branch 'master' of https://github.com/paulojuniore/RoteirosLEDA.git

   @Override
   public boolean isFull() {
      return size == top.size();
   }

}
