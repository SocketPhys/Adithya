/*
 * SimpleLinkedList
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

public class SimpleLinkedList<E> 
    implements Iterable<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    int size;
    Node<E> head;

    public SimpleLinkedList() {
	size = 0;
	head = null;
    }


    public int size() {
        return size;
    }

    private void boundsCheck(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException("index " + index + " was not available for an ArrayList of size " + size);
	}
    }

    public E get(int index) {
	boundsCheck(index);

	Node<E> iter = head;
	for (int i = 0; i < index; i++)
	    iter = iter.next;

	return (E) iter.element;
    }

    // return value is the old value at the location.
    public E set(int index, E element) {
	boundsCheck(index);

	Node<E> iter = head;
	for (int i = 0; i < index; i++)
	    iter = iter.next;

	final E previous_value = (E) iter.element;
	iter.element = element;
	return previous_value;
    }


    public void add(E element) {
	// add to end (to have same interface as SimpleArrayList)
	add(size, element);
    }

    public void add(int index, E element) {
	if (index == size) {
	    // okay
	} else {
	    boundsCheck(index);
	}

	// java doesn't have pointers-to-pointers, so I need to do two cases.
	if (index == 0) {
	    head = new Node(element, head);
	    size++;
	}
	else {
	    // NOTE: looping to index-1 here, instead of index
	    Node<E> iter = head;
	    for (int i = 0; i < index-1; i++)
		iter = iter.next;

	    iter.next = new Node(element, iter.next);
	    size++;
	}
    }

    public E remove(int index) {
	boundsCheck(index);

	E previous_value;
	// java doesn't have pointers-to-pointers, so I need to do two cases.
	if (index == 0) {
	    previous_value = head.element;
	    head = head.next;
	    size--;
	}
	else {
	    // NOTE: looping to index-1 here, instead of index
	    Node<E> iter = head;
	    for (int i = 0; i < index-1; i++)
		iter = iter.next;

	    previous_value = iter.next.element;
	    iter.next = iter.next.next;
	    size--;
	}

	return previous_value;
    }


    public Iterator<E> iterator() {
	return new Iter();
    }

    private class Iter
	implements Iterator<E> {

	Node<E> next_minus_2;
	Node<E> next_minus_1;
	Node<E> next;
	
	public Iter() {
	    next_minus_2 = null;
	    next_minus_1 = null;
	    next = head;
	}

	public boolean hasNext() {
	    return next != null;
	}

	public E next() {
	    next_minus_2 = next_minus_1;
	    next_minus_1 = next;
	    next = next.next;
	    return next_minus_1.element;
	}

	// Removes the item last returned by next()
	// Thus, removes next_minus_1
	public void remove() {
	    // throw new UnsupportedOperationException();
	    if (next_minus_1 == null) {
		throw new NoSuchElementException();
	    }
	    if (next_minus_2 == null) {
		// at head
		// next_minus_2 remains null
		next_minus_1 = null;
		head = next;
		size--;
	    } else {
		// next_minus_2 points to wrong node, until call to next()
		next_minus_2.next = next;
		next_minus_1 = next_minus_2;
		// next remains the same
		size--;
	    }
	}
    }
}
