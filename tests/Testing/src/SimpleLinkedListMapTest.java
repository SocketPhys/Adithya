/*
 * SimpleLinkedListMapTest
 *
 * Version 1.0
 *
 * 2015-06-25
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Unit tests for a LinkedListMap implementation
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class SimpleLinkedListMapTest {

    @Test
    public void basicTest() {
	SimpleLinkedListMap<Integer, Integer> map = new SimpleLinkedListMap<Integer, Integer>();
	map.put(0, 10);
	map.put(1, 11);
	map.put(2, 12);
	assertEquals(map.size(), 3);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
    }

    
    @Test
    public void putTest() {
	SimpleLinkedListMap<Integer, Integer> map = new SimpleLinkedListMap<Integer, Integer>();
	map.put(0, 10);
	map.put(1, 11);
	map.put(2, 12);
	assertEquals(map.size(), 3);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
	map.put(3, 13);
	assertEquals(map.size(), 4);
	assertEquals((int) map.get(3), 13);
	map.put(2, 22);
	assertEquals(map.size(), 4);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 22);
	assertEquals((int) map.get(3), 13);
    }
    
    @Test
    public void removeTest() {
	SimpleLinkedListMap<Integer, Integer> map = new SimpleLinkedListMap<Integer, Integer>();
	map.put(0, 10);
	map.put(1, 11);
	map.put(2, 12);
	assertEquals(map.size(), 3);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
	assertEquals((int) map.remove(2), 12);
	assertEquals(map.size(), 2);
	assertEquals((int) map.remove(0), 10);
	assertEquals(map.size(), 1);
	assertEquals((int) map.remove(1), 11);
	assertEquals(map.size(), 0);
    }
}
