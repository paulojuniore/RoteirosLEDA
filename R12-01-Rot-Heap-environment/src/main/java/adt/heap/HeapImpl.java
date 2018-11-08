package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. Dessa
 * forma, dependendo do comparator, a heap pode funcionar como uma max-heap ou
 * min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é mudar
	 * apenas o comparator e mandar reordenar a heap usando esse comparator. Assim
	 * os metodos da heap não precisam saber se vai funcionar como max-heap ou
	 * min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento indexado
	 * pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento indexado
	 * pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (T elem : this.heap) {
			if (elem != null) {
				resp.add(elem);
			}
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode ser
	 * a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		if (!this.isEmpty() && !this.indexInvalido(position)) {
			int left = left(position);
			int right = right(position);
			int largest = position;

			int element = position;
			if (left < size() && this.comparator.compare(heap[left], heap[element]) > 0) {
				largest = left;
			}
			if (right < size() && this.comparator.compare(heap[right], heap[largest]) > 0) {
				largest = right;
			}
			if (largest != position) {
				Util.swap(heap, largest, position);
				heapify(largest);
			}
		}	
	}

	private boolean indexInvalido(int position) {
		return this.isEmpty() || index < 0 || index > this.index;
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		if (element != null) {
			heap[++index] = element;
			int i = this.index;
			while (i > 0 && comparator.compare(heap[parent(i)], heap[i]) < 0) {
				Util.swap(heap, parent(i), i);
				i = parent(i);
			}
		}
	}

	@Override
	public void buildHeap(T[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		this.index = array.length - 1;
		this.heap = Arrays.copyOf(array, array.length);
		for (int i = array.length / 2; i > -1; i--) {
			heapify(i);
		}
	}

	@Override
	public T extractRootElement() {
		if (this.isEmpty()) {
			return null;
		}
		T root = rootElement();
		Util.swap(heap, 0, index);
		heap[index] = null;
		this.index--;

		heapify(0);
		return root;
	}

	@Override
	public T rootElement() {
		if (isEmpty()) {
			return null;
		}
		return heap[0];
	}

	@Override
	public T[] heapsort(T[] array) {
		buildHeap(array);
		
		ArrayList<T> aux = new ArrayList<>();
		if(heap[0].compareTo(heap[index]) < 0) {
			while(!isEmpty()) {
				aux.add(extractRootElement());
			}
		} else {
			while(!isEmpty()) {
				aux.add(0, extractRootElement());
			}
		}
		return (T[]) aux.toArray(new Comparable[0]);
	}

	@Override
	public int size() {
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
