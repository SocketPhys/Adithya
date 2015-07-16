/*
 * DynamicArray
 *
 * Version 1.2
 *
 * 2015-07-05
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement a dynamic array
 */

import java.util.Iterator;

public class DynamicArray<E> 
    implements Iterable<E> {
	public int arraySize;
	public Object[]data;
	public int nextAddIndex = 0;

    // The size of the array to store data upon creation
    public final static int INITIAL_SIZE = 8;
	
    

    // Creates a dynamic array
    // initially, size() should return 0
    public DynamicArray() {
    	data = new Object[INITIAL_SIZE];
    	this.arraySize =0;
	
    }

    // Returns the size of the dynamic array, as seen by the user
    // size starts at 0, 
    //      is incremented by a call to add() and 
    //      is decrememted by a call to remove.
    public int size() {
    	return this.arraySize;
    }


    // Gets the value at an index
    // Throws IndexOutOfBoundsException when the index is invalid
    public E get(int index) {
    	if(index<0 || index >= this.arraySize){
    		throw new IndexOutOfBoundsException();
    	}
    	 final E e = (E) data[index];
         return e;
	
    }

    // Sets a value at an index
    // Returns the previous value at the location
    // Throws IndexOutOfBoundsException when the index is invalid
    public E set(int index, E element) {
    	if(index<0 || index >= this.arraySize){
    		throw new IndexOutOfBoundsException();
    	}
    	
    	E tempE = (E) data[index];

    	data[index]= element;
    	return tempE;
    }


    // Adds an element to the end of the dynamic array
    public void add(E element) {
 
    	if(this.arraySize == data.length){
    		Object[]temp = new Object[data.length *2];
    	
    	
    		for(int i =0;i<data.length;i++){
    			temp[i] = data[i];
    		}
    		temp[this.size()] = element;
    		data = temp;
    	}else{
    		data[this.size()] = element;
    	}
    	this.arraySize++;
    	
    	
    	
	
    }


    // Adds an element to the dynamic array
    // All elements starting at that index are shifted
    // upwards to make room for the new one
    public void add(int index, E element) {
    	int condition;
    	if(this.arraySize == data.length){
    		condition = data.length*2;
    	}else{
    		condition = data.length;
    	}
    	
    		Object[]temp = new Object[condition];
    	
    	
    		for(int i =0;i<index;i++){
    			temp[i] = data[i];
    		}
    		temp[index] = element;
    		for(int i = index+1; i<data.length;i++){
    			temp[i] = data[i-1];
    		}
    		data = temp;
    
    }

    // Removes an element from the dynamic array
    // All elements above that index are shifted 
    // down to fill the hole.
    // Returns the element removed from the array.
    public E remove(int index) {
	throw new UnsupportedOperationException();
    }



    // Returns the itertor
    public Iterator<E> iterator() {
	return new Iter();
    }

    private class Iter
	implements Iterator<E> {
	
	public Iter() {
	    throw new UnsupportedOperationException();
	}

	// Returns true if the loop body should execute
	// *does NOT increment the loop counter*
	public boolean hasNext() {
	    throw new UnsupportedOperationException();
	}

	// The value for this iteration of the loop.
	// *incrementing the counter happens here*
	public E next() {
	    throw new UnsupportedOperationException();
	}

	// Removes the item last returned by next()
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

}
