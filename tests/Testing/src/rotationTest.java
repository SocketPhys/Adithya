import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Random;

public class superreversedTest {

    @Test
    public void nullTest() {
	String ca_out = superreversed.reverse(null, 1);
	assertEquals(ca_out, null);
    }

    @Test
    public void emptyTest() {
	String s = "";
	String ca_out = superreversed.reverse("", 1);
	assertEquals(new String(ca_out), "");
    }

    @Test
    public void basicTest() {
	String ca_in = "12345";
	String ca_out = superreversed.reverse(ca_in, 4);
	assertEquals(new String(ca_out), "51234");
    }

    // Even number of chars may behave differently
    @Test
    public void basicEvenTest() {
	String ca_in = "123456";
	String ca_out = superreversed.reverse(ca_in,5);
	assertEquals(ca_out, "612345");
    }

    // Even number of chars may behave differently
    @Test
    public void outOfRangeTest() {
	try {
	    String ca_in = "12345";
	    String ca_out = superreversed.reverse(ca_in, -2);
	    assert(false);
	} catch (Exception e) {
	    assert(true);
	}
    }

    @Test
    public void outOfRange2Test() {
	try {
	 String ca_in = "12345";
	    String ca_out = superreversed.reverse(ca_in, 0);
	    assert(false);
	} catch (Exception e) {
	    assert(true);
	}
    }


    @Test
    public void invertedRangeTest() {
	try {
	    String ca_in = "12345";
	    String ca_out = superreversed.reverse(ca_in,1);
	    assert(false);
	} catch (Exception e) {
	    assert(true);
	}
    }


    @Test
    public void performanceTest() {
	Random r = new Random();
	String s = "";
	for (int i = 0; i < 1000; i++) {
	    s = s + ('a' +  r.nextInt(26));
	}

	final long start_time = System.nanoTime();
	for (int i = 0; i < 1000; i++) {
	    s = superreversed.reverse(s, i);
	    s = superreversed.reverse(s, i);
	    assertEquals(s, new String(s));
	}
	final long end_time = System.nanoTime();

	assert(end_time - start_time < 1000000);
    }
}
