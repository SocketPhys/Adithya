/*
 * Pair
 *
 * Version 1.0
 *
 * 2015-05-13
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Pair is the simple obvious implementation of Map.Entry
 */

import java.lang.NullPointerException;

import java.util.NoSuchElementException;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.ListIterator;


public class Pair<K,V>
    implements Map.Entry<K,V> {
    K key;
    V value;

    Pair(K key, V value) {
	this.key   = key;
	this.value = value;
    }

    public static void main(String[] args) {
	Pair<Integer, Float> p = new Pair<Integer, Float>(new Integer(5), new Float(3.0));
	
	p.getKey();   // returns 5
	p.getValue(); // returns 3

	if (p.equals(p)) {
	}

	Pair<Integer, Float> p2 = new Pair<Integer, Float>(new Integer(5), new Float(3.0));
	if (p.equals(p2)) {
	    
	}
    }

    public K getKey() {
	return key;
    }
    
    public V getValue() {
	return value;
    }

    public V setValue(V value) {
	V ret_val = this.value;
	this.value = value;
	return ret_val;
    }

    public boolean equals(Object o) {
	if (o == this) 
	    return true;
	if (o == null)
	    return false;
	if (!(o instanceof Pair))
	    return false;
	Pair p = (Pair) o;
	
	// trick - checks if both are null or both are not null.
	if ((key == null) != (p.key == null))
	    return false;
	if ((value == null) != (p.value == null))
	    return false;
	
	if (key != null && !key.equals(p.key))
	    return false;
	if (value != null && !value.equals(p.value))
	    return false;
	return true;
    }
    
    public int hashCode() {
	int hc = 0;
	if (key != null)
	    hc += key.hashCode();
	if (value != null)
	    hc += 2 * value.hashCode();
	return hc;
    }

    public String toString() {
	return key.toString() + ", " + value.toString();
    }
}
