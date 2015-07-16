/*
 * SimpleMap
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * An interface for a map.  Easier to work with than java.util.Map.
 *
 */

public interface SimpleMap<K,V> {
    int size();

    boolean containsKey(K key);

    V get(K key); 

    V put(K key, V value);

    V remove(K key);
}
