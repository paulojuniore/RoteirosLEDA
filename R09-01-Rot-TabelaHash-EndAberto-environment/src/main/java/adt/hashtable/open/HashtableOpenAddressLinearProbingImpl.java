package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		int i = 0;
		while(i < this.table.length) {
			int j = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i);
			if(this.table[j] == null || this.table[j].equals(new DELETED())) {
				this.table[j] = element;
				this.elements++;
				return;
			} else {
				i++;
				this.COLLISIONS++;
			}
		}
		throw new HashtableOverflowException();
	}

	@Override
	public void remove(T element) {
		int i = 0;
		while(i < this.table.length) {
			int j = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i);
			if(this.table[j] == null) {
				break;
			} else if(this.table[j].equals(element)) {
				this.table[j] = new DELETED();
				this.elements--;
			} else {
				i++;
			}
		}
		
	}

	@Override
	public T search(T element) {
		int i = 0;
		T retorno = null;
		int j;
		while(i < this.table.length) {
			j = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i);
			if(this.table[j] == null) {
				break;
			} else if(this.table[j].equals(element)) {
				retorno = (T) this.table[j];
				break;
			}
			i++;
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int i = 0;
		int saida = -1;
		int j;
		do {
			j = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i);
			if(this.table[j].equals(element)) {
				saida = j;
				break;
			} else {
				i++;
			}
		} while (this.table[j] == null || i < this.table.length);
		return saida;	
	}

}
