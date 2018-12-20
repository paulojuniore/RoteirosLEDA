package adt.linkedList.extended;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class ListInversionImpl extends SingleLinkedListImpl<Integer> implements ListInversion<Integer> {

	@Override
	public void reverseIterative() {
		SingleLinkedListNode<Integer> next;
		SingleLinkedListNode<Integer> aux = this.head;
		SingleLinkedListNode<Integer> novoHead = new SingleLinkedListNode<>();
		while(!aux.isNIL()) {
			next = aux.getNext();
			aux.setNext(novoHead);
			novoHead = aux;
			aux = next;
		}
		this.head = novoHead;
	}
	
	@Override
	public void reverseRecursive() {
		SingleLinkedListNode<Integer> node = this.head;
		SingleLinkedListNode<Integer> ultimo = new SingleLinkedListNode<>();
		while(!node.isNIL()) {
			ultimo = node;
			node = node.getNext();
		}
		inverteNode(this.head, new SingleLinkedListNode<>());
		this.head = ultimo;
	}
	

	private void inverteNode(SingleLinkedListNode<Integer> node, SingleLinkedListNode<Integer> anterior) {
		if(!node.getNext().isNIL()) {
			inverteNode(node.getNext(), node);
		}
		node.setNext(anterior);
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
