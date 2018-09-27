package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		} else if(this.isEmpty()) {
			tail = 0;
			head = 0;
		} else {
			tail = (tail + 1) % array.length;
		}
		array[tail] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T retorno;
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			retorno = array[head];
			head = (head + 1) % array.length;
			elements--;
		}
		return retorno;
	}

	@Override
	public T head() {
		T retorno = null;
		if(!this.isEmpty()) {
			retorno = array[head];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
