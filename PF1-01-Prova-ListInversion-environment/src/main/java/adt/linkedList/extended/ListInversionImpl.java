package adt.linkedList.extended;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class ListInversionImpl extends SingleLinkedListImpl<Integer> implements ListInversion<Integer> {

	@Override
	public void reverseIterative() {
		SingleLinkedListNode<Integer> node;
		SingleLinkedListNode<Integer> aux = this.head;
		SingleLinkedListNode<Integer> novoHead = new SingleLinkedListNode<>();
		while(!aux.isNIL()) {
			node = aux.getNext();
			aux.setNext(novoHead);
			novoHead = aux;
			aux = node;
		}
		this.head = novoHead;
	}
	
	@Override
	public void reverseRecursive() {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	

	//NAO ALTERE NADA NESTE METODO. ELE SERA UTIL QUANDO VOCE QUISER TESTAR SUA IMPLEMENTACAO
	@Override
	public void insert(Integer element) {
		SingleLinkedListNode<Integer> auxHead = head;
		if(head.isNIL()){
			SingleLinkedListNode<Integer> newHead = new SingleLinkedListNode<Integer>(element,head);
			head = newHead;
		}else{
			while(!auxHead.getNext().isNIL()){
				auxHead = auxHead.getNext();
			}
			SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(element,auxHead.getNext());
			auxHead.setNext(newNode);
		}
	}

	
}
