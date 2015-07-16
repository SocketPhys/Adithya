/*
 * LinkedListTest
 *
 * Version 1.2
 *
 * 2015-07-05
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Unit tests for the dynamic array implmentation
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class LinkedListTest {

    @Test
    public void emptyTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	assertEquals(list.size(), 0);
    }


    @Test
    public void basicAddGetTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(2);
	assertEquals((int) list.getHead(), 2);
    }


    @Test
    public void basicAddRemoveTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(2);
	list.addHead(3);
	assertEquals(list.size(), 2);
	assertEquals((int) list.getHead(), 3);
	assertEquals((int) list.removeHead(), 3);
	assertEquals(list.size(), 1);
	assertEquals((int) list.getHead(), 2);
	assertEquals((int) list.removeHead(), 2);
	assertEquals(list.size(), 0);
    }


    @Test
    public void getEmptyTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	try {
	    list.getHead();
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    @Test
    public void removeEmptyTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	try {
	    list.removeHead();
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    
    @Test
    public void swapZeroTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	try {
	    list.swapFirstTwoNodes();
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    @Test
    public void swapOneTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(2);
	try {
	    list.swapFirstTwoNodes();
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    @Test
    public void swapTwoTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(3);
	list.addHead(2);
	list.swapFirstTwoNodes();
	assertEquals((int) list.getHead(), 3);
	list.removeHead();
	assertEquals((int) list.getHead(), 2);
    }

   

    @Test
    public void swapThreeTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(4);
	list.addHead(3);
	list.addHead(2);
	list.swapFirstTwoNodes();

	assertEquals((int) list.getHead(), 3);
	list.removeHead();
	assertEquals((int) list.getHead(), 2);
	list.removeHead();
	assertEquals((int) list.getHead(), 4);
    }

    
    

    @Test
    public void reverseZeroTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.reverse();
	assertEquals(list.size(), 0);
    }


    @Test
    public void reverseOneTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(2);
	list.reverse();
	assertEquals((int) list.getHead(), 2);
    }


    @Test
    public void reverseThreeTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(4);
	list.addHead(3);
	list.addHead(2);
	list.reverse();
	assertEquals((int) list.getHead(), 4);
	list.removeHead();
	assertEquals((int) list.getHead(), 3);
	list.removeHead();
	assertEquals((int) list.getHead(), 2);
    }

    
   
    //  Tests for addTail() / getTail()
    //

    @Test
    public void tailTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(4);
	assertEquals((int) list.getHead(), 4);
	assertEquals((int) list.getTail(), 4);
	assertEquals(list.size(), 1);
    }


    @Test
    public void tailTwoTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(3);
	list.addTail(4);
	assertEquals((int) list.getHead(), 3);
	assertEquals((int) list.getTail(), 4);
	assertEquals(list.size(), 2);
    }


    
    /*
    //
    //  Tests for removeTail()
    //


    @Test
    public void tailRemoveTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(3);
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 0);
    }


    @Test
    public void tailRemove2Test() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(3);
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 0);
    }


    @Test
    public void tailRemove3Test() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addHead(3);
	list.addHead(4);
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 1);
	assertEquals((int) list.removeHead(), 4);
	assertEquals(list.size(), 0);
    }


    @Test
    public void tailRemove4Test() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(3);
	list.addHead(4);
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 1);
	assertEquals((int) list.removeTail(), 4);
	assertEquals(list.size(), 0);
    }


    //
    //  Did you forget the first part of the assignment? 
    //


    @Test
    public void muhahahahaTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(3);
	list.addHead(4);
	list.swapFirstTwoNodes();
	assertEquals((int) list.removeTail(), 4);
	assertEquals(list.size(), 1);
	assertEquals((int) list.getTail(), 3);
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 0);
    }


    @Test
    public void muhahahahahaTest() {
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.addTail(2);
	list.addTail(1);
	list.addHead(3);
	list.reverse();
	assertEquals((int) list.removeTail(), 3);
	assertEquals(list.size(), 2);
	assertEquals((int) list.removeTail(), 2);
	assertEquals(list.size(), 1);
	String s = "Ibqqz!Cjsuiebz-!Xftmfz\"";
	String t = "";
	for (int i = 0; i < s.length(); i++) {
	    t += (char) (s.charAt(i) - list.getHead());
	}
	System.out.println(t);
    }
    */
}