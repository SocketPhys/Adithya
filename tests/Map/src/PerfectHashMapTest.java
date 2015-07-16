

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Random;

public class PerfectHashMapTest {

    @Test
    public void basicTest() {
	PerfectHashMap<Integer> map = new PerfectHashMap<Integer>();
	map.put("Kevin", 10);
	map.put("JamesD", 11);
	map.put("Andrew", 12);
	assertEquals(map.size(), map.SIZE);
	assertEquals((int) map.get("Kevin"), 10);
	assertEquals((int) map.get("JamesD"), 11);
	assertEquals((int) map.get("Andrew"), 12);
    }

    @Test
    public void removeTest() {
	PerfectHashMap<Integer> map = new PerfectHashMap<Integer>();
	map.put("Aaron", 10);
	try {
	    map.remove("Aaron");
	    assertTrue(false);
	} catch (Throwable t) {
	    assertTrue(true);
	}
    }

    @Test
    public void allInTest() {
	PerfectHashMap<Integer> map = new PerfectHashMap<Integer>();
	for (int i = 0; i < map.CONTENTS.length; i++) {
	    map.put(map.CONTENTS[i], i);
	}
	for (int i = 0; i < map.CONTENTS.length; i++) {
	    assertEquals((int) map.get(map.CONTENTS[i]), i);
	}
    }

    @Test
    public void performanceTest() {
	PerfectHashMap<Integer> map = new PerfectHashMap<Integer>();
	Random r = new Random();
	int TEST_SIZE = 100000;
	final long start_time = System.nanoTime();
	for (int i = 0; i < TEST_SIZE; i++) {
	    map.put(map.CONTENTS[r.nextInt(map.CONTENTS.length)], i);
	}
	final long end_time = System.nanoTime();
	assert(end_time - start_time < 1000000);
	
    }

}
