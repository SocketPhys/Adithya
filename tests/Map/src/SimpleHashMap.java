/*
 * SimpleHashMap
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement the SimpleMap interface using a hashtable backed by SimpleLinkedListMap.
 *
 */

import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;


public class SimpleHashMap<K,V> 
    implements Iterable<Map.Entry<K,V>>, SimpleMap<K,V> {

    final int INITIAL_SIZE = 15;

    Object[] lists;
    int used;

    public SimpleHashMap(){
	//lists = new SimpleLinkedListMap<K,V>[INITIAL_SIZE];
	lists = new Object[INITIAL_SIZE];
	
	for (int i = 0; i < lists.length; i++)
	    lists[i] = new SimpleLinkedListMap<K,V>();
	used = 0;
    }

    public int size() {
	return used;
    }

    public boolean containsKey(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();
	// I can't do this check with a generic K.
	//if (!(key instanceof K))
	//    throw new IllegalArgumentException();

	SimpleLinkedListMap<K,V> the_list = getList((K) key);
	return the_list.containsKey((K) key);
    }

    public V get(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();
	// I can't do this check with a generic K.
	//if (!(key instanceof K))
	//    throw new IllegalArgumentException();

	SimpleLinkedListMap<K,V> the_list = getList((K) key);
	return the_list.get((K) key);
    }

    public V put(K key, V value) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	ifNecessaryRehash();

	SimpleLinkedListMap<K,V> the_list = getList(key);
	if (!the_list.containsKey(key)) {
	    used++;
	}
	return the_list.put(key, value);
    }

    public V remove(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();
	// I can't do this check with a generic K.
	//if (!(key instanceof K))
	//    throw new IllegalArgumentException();

	ifNecessaryRehash();

	// again, need all this to find if we really removed a value
	SimpleLinkedListMap<K,V> the_list = getList((K) key);
	if (the_list.containsKey((K) key)) {
	    used--;
	    return the_list.remove((K) key);
	}
	else {
	    return null;
	}
    }	

    public SimpleLinkedListMap<K,V> getList(K k) {
	int index = k.hashCode() % lists.length;
	if (index < 0)
	    index += lists.length;
	return (SimpleLinkedListMap<K,V>) lists[index];
    }

    public Iterator<Map.Entry<K,V>> iterator() {
	return new Itr();
    }

    class Itr
	implements java.util.Iterator<Map.Entry<K,V>> {

	int index;
	Iterator<Map.Entry<K,V>> listItr;
	    
	public Itr() {
	    index = 0; 
	    SimpleLinkedListMap<K,V> list = (SimpleLinkedListMap<K,V>) lists[index];
	    listItr = list.iterator();
	    advance();
	}

	public boolean hasNext() {
	    return index < lists.length;
	}

	public Map.Entry<K,V> next() {
	    Map.Entry<K,V> ret_val = listItr.next();
	    advance();
	    return ret_val;
	}
	
	/* Difficult to implement here, since we need advance
	   to compute hasNext().  Once we call it, getting
	   back to the old iterator is difficult.
        */
	//public void remove() {
	//    listItr.remove();
	//}

	// moves the iterator until it finds a list
	public void advance() {
	    while (true) {
		if (listItr.hasNext())
		    return;
		index++;
		if (index >= lists.length)
		    return;
		SimpleLinkedListMap<K,V> list = (SimpleLinkedListMap<K,V>) lists[index];
		listItr = list.iterator();
	    }
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
    }

    

    void ifNecessaryRehash() {
	if (used > 2*lists.length) {
	    // length is always 1 less than a power of two.
	    final int new_length = 2*(lists.length + 1) - 1;
	    rehash( new_length );
	}
    }

    void rehash(final int new_length) {
	// save old array of lists
	Object[] old_lists = lists;
	    
	// create new array of lists
	lists = new Object[new_length];
	for (int i = 0; i < lists.length; i++)
	    lists[i] = new SimpleLinkedListMap<K,V>();
	
	// copy everything from old to new
	for (int j = 0; j < old_lists.length; j++) {
	    SimpleLinkedListMap<K,V> old_list = (SimpleLinkedListMap<K,V>) old_lists[j];
	    for (java.util.Map.Entry<K,V> e : old_list) {
		getList(e.getKey()).put(e.getKey(), e.getValue());
	    }
	}
    }
}
