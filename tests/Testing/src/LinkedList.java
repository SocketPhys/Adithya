
/*
 * LinkedList
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implements a linked list.
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<E> {

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

	int size;
	Node<E> head;
	Node<E> tail;
	


	// Construct a list with zero size
	public LinkedList() {
		size = 0;
		head = null;
		tail =null;
	}


	// The size of the list
	// That is, the number of adds minus the number of removes
	public int size() {
		return size;
	}


	// Add to the front of the list
	public void addHead(E element) {
		head = new Node(element, head);
		size++;
		if(head.next==null){
			//addTail(element);
		}else{
			head.next.prev = head;
		}
		if(size==1){
			tail = head;
		}
		
	}


	// Get the value at the front of the list
	// Throws IndexOutOfBoundsException on an empty list
	public E getHead() {
		if (size == 0)
			throw new IndexOutOfBoundsException("Tried to read head of an empty list.");

		return head.element;
	}


	// Remove the front of the list (and return its value)
	// Throws IndexOutOfBoundsException on an empty list
	public E removeHead() {
		if (size == 0)
			throw new IndexOutOfBoundsException("Tried to remove head of an empty list.");

		Node<E> tmp = head;
		size--;
		head = head.next;
		return tmp.element;
	}


	// If a list has at least 2 nodes, swaps the first two.
	// Otherwise, leaves the list as it is.
	public void swapFirstTwoNodes() {
		if(size<2)
			throw new IndexOutOfBoundsException("Tried to remove head of an empty list.");
		Node<E> temp = null;
		temp = new Node(0, temp);
		temp = head;
		head = head.next;
		temp.next = head.next;
		head.next = temp;
		
		
		
	}


	// Reverses the order of elements in the list
	public void reverse() {
		Node<E> temp = null;
		temp = new Node(0, temp);
		Node<E> temp2 = null;
		temp = new Node(0, temp2);
		temp = head;
		temp2 = head;
		for(int i=0;i<size-1;i++){
			head = head.next;
			temp2 = temp2.next;
		}
		for(int i=0;i<size-1;i++){
			temp2.next = temp2.prev;
			temp2 = temp2.prev;
		}
		
	}


	// Adds an element to the end of the list
	public void addTail(E element) {
		size++;
		tail = new Node(element, tail);
		if(size<=1){
			
			head = tail;
		}else{
			tail.prev = tail;
			
		}
		
		
			
	}


	// Gets the value at the end of the list
	public E getTail() {
		if (size == 0)
			throw new IndexOutOfBoundsException("Tried to read tail of an empty list.");

		return tail.element;
		
	}


	// Removes the value at the end of the list
	public E removeTail() {
		throw new UnsupportedOperationException();
	}


	
	
}