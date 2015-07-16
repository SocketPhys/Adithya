/*
 * SimpleLinkedListMap
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Implement the Map interface using a linked list
 *
 */

import java.util.Map;  // uses Map.Entry<K,V>
import java.lang.NullPointerException;
import java.util.NoSuchElementException;
import java.util.Iterator;


public class SimpleLinkedListMap<K,V> 
    implements Iterable<Map.Entry<K,V>>, SimpleMap<K,V> {

    SimpleLinkedList< Map.Entry<K,V> > list;

    public SimpleLinkedListMap(){
	list = new SimpleLinkedList();
    }


    public int size() {
	return list.size();
    }

    // NOTE: cannot use "return get(key) != null"
    // because the key may be in the table and mapped to null.
    public boolean containsKey(K key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	Iterator<Map.Entry<K,V>> iter = list.iterator();
	while (iter.hasNext()) {
	    Map.Entry<K,V> entry = iter.next();
	    if (key.equals(entry.getKey())) {
		return true;
	    }
	}

	// key not present in list
	return false;
    }


    // NOTE: Could have always put a new node in the list and 
    // defined the "true" value for the key to be the first
    // copy encountered.   
    public V put(K key, V value) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	Iterator<Map.Entry<K,V>> iter = list.iterator();
	while (iter.hasNext()) {
	    Map.Entry<K,V> entry = iter.next();
	    if (key.equals(entry.getKey())) {
		return entry.setValue(value);
	    }
	}

	// add at front of list
	list.add(0, new Pair<K,V>(key, value));
	return null;
    }


    public V get(K key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	Iterator<Map.Entry<K,V>> iter = list.iterator();
	while (iter.hasNext()) {
	    Map.Entry<K,V> entry = iter.next();
	    if (key.equals(entry.getKey())) {
		return entry.getValue();
	    }
	}

	// key not present in list
	return null;
    }

    public V remove(Object key) {
	// We could support a null key, but easier not to.
	if (key == null) 
	    throw new NullPointerException();

	Iterator<Map.Entry<K,V>> iter = list.iterator();
	while (iter.hasNext()) {
	    Map.Entry<K,V> entry = iter.next();
	    if (key.equals(entry.getKey())) {
		V ret_val = entry.getValue();
		iter.remove();
		return ret_val;
	    }
	}

	// key not present in list
	// ? Should we throw an exception in this case?
	return null;
    }

    public Iterator<Map.Entry<K,V>> iterator() {
	return list.iterator();
    }
}
