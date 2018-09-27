package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T retorno = null;
		if(!this.isEmpty()) {
			retorno = array[0];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private void shiftLeft() {
		for(int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()) {
			array[++tail] = element;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!this.isEmpty()) {
			T result = array[0];
			shiftLeft();
			tail--;
			return result;
		}
		throw new QueueUnderflowException();
	}

}
