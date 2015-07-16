/*
 * SimpleDynamicArray
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement a dynamic array
 */

import java.util.Iterator;

public class SimpleDynamicArray<E> 
    implements Iterable<E> {

    public final static int INITIAL_SIZE = 8;

    private Object[] data;
    private int used;

    public SimpleDynamicArray() {
	data = new Object[INITIAL_SIZE];
	used = 0;
    }

    public int size() {
	return used;
    }

    private void boundsCheck(int index) {
	if (index < 0 || index >= used) {
	    throw new IndexOutOfBoundsException("index " + index + " was not available for an ArrayList of size " + used);
	}
    }

    public E get(int index) {
	boundsCheck(index);

	return (E) data[index];
    }

    // return value is the old value at the location.
    public E set(int index, E element) {
	boundsCheck(index);

	final E previous_value = (E) data[index];
	data[index] = element;
	return previous_value;
    }


    // add to end
    public void add(E element) {
	add(used, element);
    }

    public void add(int index, E element) {
	if (index == used) {
	    // okay
	} else {
	    boundsCheck(index);
	}

	if (data.length == used) {
	    increaseSize();
	}

	used++;
	for (int i = used - 1; i-1 >= index; i--) {
	    data[i] = data[i-1];
	}
	data[index] = element;
    }

    public E remove(int index) {
	boundsCheck(index);

	E previous_value = (E) data[index];
	for (int i = index; i+1 < used; i++) {
	    data[i] = data[i+1];
	}
	used--;

	// OPTIONAL: Could decrease array's size here

	return previous_value;
    }

    //
    // Helper functions
    // 

    private void increaseSize() {
	Object[] new_data = new Object[2*data.length];
	for (int i = 0; i < used; i++)
	    new_data[i] = data[i];
	data = new_data;
    }


    public Iterator<E> iterator() {
	return new Iter();
    }

    private class Iter
	implements Iterator<E> {

	int index;
	
	public Iter() {
	    index = 0;
	}

	public boolean hasNext() {
	    return index < used;
	}

	public E next() {
	    index++;
	    return (E) data[index - 1];
	}

	// Removes the item last returned by next()
	// Thus, removes next_minus_1
	public void remove() {
	    SimpleDynamicArray.this.remove(index-1);
	    index--;
	}
    }

}
