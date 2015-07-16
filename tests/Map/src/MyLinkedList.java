/*
 * MyLinkedList
 *
 * Version 1.0
 *
 * 2015-05-12
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement the List interface using a linked list.
 *
 * Inherits a lot of the functionality from AbstractSequentialList.
 * To do that, it must implement size() and the iterator functionality.
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> 
    extends java.util.AbstractSequentialList<E> 
    implements java.util.List<E>
          /* , java.util.Deque<E> */ {


    // This was initially a singly-linked list.
    // Probably need to double check that prev is used correctly.

    private static class Entry<E> {
        E element;
        Entry<E> next;
        Entry<E> prev;

        Entry(E element) {
            this.element = element;
            this.next = null;
	    this.prev = null;
        }
    }

    int size;
    Entry<E> head;

    public MyLinkedList() {
	size = 0;
	head = null;
    }


    public int size() {
        return size;
    }


    public ListIterator<E> listIterator(int index) {
	if (index < 0 || index > size)
	    throw new IndexOutOfBoundsException("index " + index + " was not available for an MyLinkedList of size " + size);
	
	MyListItr iter = new MyListItr();
	for (int i = 0; i < index; i++)
	    iter.next();

	return iter;
    }


    // Iterator for the linked list.
    // 
    // Has to support N+1 locations in the list.  From "before"
    // the first element to "after" the last element.  
    // java.util.LinkedList accomplishes this with a sentinel.
    //
    // Here, I use an extra value "null", which indicates
    // that you're "before" the first element.  (It would be
    // cleaner for it to indicate "after" the last element, 
    // (because it would always be equal to the "next" pointer), 
    // but that would mean maintaining a pointer to the last
    // element of the list.)


    private class MyListItr implements java.util.ListIterator<E> {
	// This class is NOT static,
	// therefore, it has an implicit pointer to MyLinkedList
	
        private Entry<E> prevEntry;
	private int prevIndex;

        private Entry<E> lastReturned;  // ugly, but necessary for writes

        MyListItr() {
	    // before the first element
	    prevEntry = null;  
	    prevIndex = -1;
	    
	    // none has been seen yet
	    lastReturned = null; 
	}

        public boolean hasNext() {
	    if (head == null)
		return false;
	    else 
		return prevEntry == null || prevEntry.next != null;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

	    if (prevEntry == null) {
		prevEntry = head;
	    } else {
		prevEntry = prevEntry.next;
	    }
	    prevIndex++;

	    lastReturned = prevEntry;
            return lastReturned.element;
        }

        public boolean hasPrevious() {
	    return prevEntry != null;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
	    
	    // save pointer before modifying state
	    lastReturned = prevEntry;

	    prevEntry = prevEntry.prev;
	    prevIndex--;

            return lastReturned.element;
        }

        public int nextIndex() {
            return prevIndex + 1;
        }

        public int previousIndex() {
            return prevIndex;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.element = e;
        }

        public void add(E e) {
	    // next will remain the same, prev returns the new node

	    if (size == 0) {
		head = new Entry(e);
		size++;
		prevEntry = head;
		prevIndex = 0;
	    }
	    else if (prevEntry == null) {
		Entry new_entry = new Entry(e);
		new_entry.next = head;
		head.prev = new_entry;
		head = new_entry;
		size++;
		prevEntry = head;
		prevIndex = 0;
	    }
	    else {
		Entry new_entry = new Entry(e);

		new_entry.prev = prevEntry;
		new_entry.next = prevEntry.next;
		prevEntry.next = new_entry;
		if (new_entry.next != null) 
		    new_entry.next.prev = new_entry;
		size++;
		prevEntry = new_entry;
		prevIndex++;
	    }
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

	    Entry before = lastReturned.prev;
	    Entry after = lastReturned.next;
	    if (before != null)
		before.next = after;
	    if (after != null)
		after.prev = before;
	    size--;

	    if (lastReturned == head)
		head = after;
	    
	    if (lastReturned == prevEntry) {
		// the last call was to next()
		prevEntry = before;
		prevIndex -= 1;
	    } else {
		// the last call was to prev()
		// I think they stay the same ...
	    }
        }

	/*
        ListItr(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: "+index+
                                                    ", Size: "+size);
            if (index < (size >> 1)) {
                next = header.next;
                for (nextIndex=0; nextIndex<index; nextIndex++)
                    next = next.next;
            } else {
                next = header;
                for (nextIndex=size; nextIndex>index; nextIndex--)
                    next = next.previous;
            }
        }
	*/

	/*
	  If I added checks for multiple iterators,
	  this is the iterator to throw
	  throw new ConcurrentModificationException();
	*/
    }
}
