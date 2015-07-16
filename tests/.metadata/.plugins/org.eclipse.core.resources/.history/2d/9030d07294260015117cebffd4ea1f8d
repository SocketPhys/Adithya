

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import java.util.Random;


public class SimpleBSTMapTest {

    @Test
    public void basicTest() {
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);
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
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);
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
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);
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

    @Test
    public void basic2Test() {
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);
	map.put(3, 13);
	map.put(1, 11);
	map.put(0, 10);
	map.put(2, 12);
	map.put(5, 15);
	map.put(4, 14);
	map.put(6, 16);
	assertEquals(map.size(), 7);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
	assertEquals((int) map.get(3), 13);
	assertEquals((int) map.get(4), 14);
	assertEquals((int) map.get(5), 15);
	assertEquals((int) map.get(6), 16);

	map.remove(3);
	assertEquals(map.size(), 6);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
	assertEquals((int) map.get(4), 14);
	assertEquals((int) map.get(5), 15);
	assertEquals((int) map.get(6), 16);

	map.remove(5);
	assertEquals(map.size(), 5);
	assertEquals((int) map.get(0), 10);
	assertEquals((int) map.get(1), 11);
	assertEquals((int) map.get(2), 12);
	assertEquals((int) map.get(4), 14);
	assertEquals((int) map.get(6), 16);
    }


    @Test
    public void basicIteratorTest() {
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);
	map.put(3, 13);
	map.put(1, 11);
	map.put(0, 10);
	map.put(2, 12);
	map.put(5, 15);
	map.put(4, 14);
	map.put(6, 16);

	int count = 0;
	for (java.util.Map.Entry<Integer,Integer> e : map) {
	    //System.out.println("key=" + e.getKey());
	    assertEquals(e.getKey() + 10, (int) e.getValue());
	    assertEquals(count, (int) e.getKey());
	    count++;
	}
    }

    @Test
    public void iteratorTest() {
	Random random = new Random();
	SimpleBSTMap<Integer, Integer> map = new SimpleBSTMap<Integer, Integer>(null);

	boolean[] flags = new boolean[100];
	for (int i = 0; i < flags.length; i++)
	    flags[i] = false;
	int count = 0;

	for (int op_count = 0; op_count < 10000; op_count++) {
	    int index = random.nextInt(flags.length);
	    int op = random.nextInt(4);
	    if (op == 0) {
		if (flags[index]) {
		    //System.out.println("remove " + index);
		    assertEquals(index, (int) map.remove(index));
		    flags[index] = false;
		    count--;
		}
		else {
		    //System.out.println("put " + index);
		    assertEquals(null, map.put(index, index));
		    flags[index] = true;
		    count++;
		}
	    } else if (op == 1) {
		//System.out.println("get " + index);
		if (flags[index]) 
		    assertEquals(index, (int) map.get(index));
		else
		    assertEquals(null, map.get(index));
	    } else if (op == 2) {
		//System.out.println("size = " + count);
		assertEquals(map.size(), count);
	    } else {
		//System.out.println("iterator test");
		boolean[] flags2 = new boolean[flags.length];
		for (int i = 0; i < flags2.length; i++)
		    flags2[i] = false;
		for (java.util.Map.Entry<Integer, Integer> e : map) {
		    //System.out.println("  seen index " + e.getKey());
		    assertEquals(e.getKey(), e.getValue());
		    assertEquals(false, flags2[e.getKey()]);
		    flags2[e.getKey()] = true;
		}
		for (int i = 0; i < flags2.length; i++) {
		    //if (flags[i] || flags2[i]) System.out.println("  checking index " + i);
		    assertEquals(flags[i], flags2[i]);
		}
	    }
	}
    }
}
