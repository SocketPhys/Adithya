import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class DynamicArrayTest {

    /////////////////////////////////////////
    // The tests below should work WITHOUT
    // changing the size of the array
    /////////////////////////////////////////

    @Test
    public void emptyTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
    }

    @Test
    public void basicSetGetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(2);
	list.set(0, 3);

	// don't check size() (yet)
	assertEquals((int) list.get(0), 3);
    }


    @Test
    public void loopSetGetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < list.INITIAL_SIZE; i++)
	    list.add(2);
	for (int i = 0; i < list.INITIAL_SIZE; i++)
	    list.set(i, 3+i);
 
	// don't check size() (yet)
	for (int i = 0; i < list.INITIAL_SIZE; i++)
	    assertEquals((int) list.get(i), 3+i);
    }


    @Test
    public void negativeIndexGetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(2);

	try {
	    list.get(-1);
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    @Test
    public void negativeIndexSetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(2);

	try {
	    list.set(-1, 3);
	    assertTrue(false);
	} catch (IndexOutOfBoundsException e) {
	    assertTrue(true);
	}
    }


    @Test
    public void basicSetReturnsOldValueTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(2);
	assertEquals(list.set(0, 3).intValue(), 2);
	assertEquals(list.set(0, 4).intValue(), 3);
	assertEquals(list.set(0, 5).intValue(), 4);
    }
    

    
    @Test
    public void sizeTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(i);
	    assertEquals(list.size(), i+1);
	}
    }



    @Test
    public void addGetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(3+i);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    assertEquals(list.get(i).intValue(), 3+i);
	}
    }


    @Test
    public void addGetSetGetTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(3+i);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    assertEquals(list.get(i).intValue(), 3+i);
	    list.set(i, -3-i);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    assertEquals(list.get(i).intValue(), -3-i);
	}
    }


    @Test
    public void boundsTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(3+i);

	    // these work for size i+1
	    assertEquals(list.get(0).intValue(), 3);
	    assertEquals(list.get(i/2).intValue(), 3+(i/2));
	    assertEquals(list.get(i).intValue(), 3+i);

	    // these don't work for size i+1
	    try {
		list.get(-1);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	    try {
		list.get(i+1);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	}
    }

    /*
    /////////////////////////////////////////
    // Tests below require add(E) (with one param)
    // and add(int, E)
    //
    // They don't require remove() or an 
    // iterator
    /////////////////////////////////////////

    @Test
    public void addInsertSizeTest() {
	Random r = new Random();

	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    int index = r.nextInt(i+1);  // upto 0 when i=0
	    list.add(index, i);
	    assertEquals(list.size(), i+1);
	}
    }


    @Test
    public void smallShiftTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(0);
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(2, 5);
	assertEquals(list.size(), 5);
	assertEquals(list.get(0).intValue(), 0);
	assertEquals(list.get(1).intValue(), 1);
	assertEquals(list.get(2).intValue(), 5);
	assertEquals(list.get(3).intValue(), 2);
	assertEquals(list.get(4).intValue(), 3);
    }


    @Test
    public void shiftTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(2);
	}
	for (int i = 19*list.INITIAL_SIZE - 1; i >= 0; i--) {
	    list.add(i, 3);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    assertEquals(list.get(2*i).intValue(),   3);
	    assertEquals(list.get(2*i+1).intValue(), 2);
	}
    }


    @Test
    public void addInsertBoundsTest() {
	Random r = new Random();

	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {

	    // okay to add any place from 0 to i
	    list.add(r.nextInt(i+1), 3);

	    // these don't work for size i+1
	    try {
		list.get(-1);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	    try {
		list.get(i+1);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	}
    }


    /////////////////////////////////////////
    // Tests below require add(E) (with one param),
    // add(int, E), and remove()
    //
    // They don't require an iterator
    /////////////////////////////////////////

    @Test
    public void removeSizeTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(i);
	    assertEquals(list.size(), i+1);
	}
	for (int i = 19*list.INITIAL_SIZE - 1; i >= 0; i--) {
	    list.remove(i);
	    assertEquals(list.size(), i);
	}
    }


    @Test
    public void removeBoundsTest() {
	Random r = new Random();

	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.add(i);
	}
	// now at size 19*list.INITIAL_SIZE
	for (int i = 19*list.INITIAL_SIZE-1; i >= 0; i--) {

	    // size is i+1
	    // okay to add any place from 0 to i
	    list.remove(r.nextInt(i+1));

	    // these don't work for size i
	    // NOTICE: Size changed with call to remove()
	    try {
		list.remove(-1);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	    try {
		list.remove(i);
		assertTrue(false);
	    } catch (IndexOutOfBoundsException e) {
		assertTrue(true);
	    }
	}
    }


    @Test
    public void removeSmallShiftTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(0);
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	assertEquals(list.remove(2).intValue(), 2);  // returns value removed
	assertEquals(list.size(), 4);
	assertEquals(list.get(0).intValue(), 0);
	assertEquals(list.get(1).intValue(), 1);
	assertEquals(list.get(2).intValue(), 3);
	assertEquals(list.get(3).intValue(), 4);
    }


    @Test
    public void removeShiftTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	assertEquals(list.size(), 0);
	for (int i = 0; i < 2*19*list.INITIAL_SIZE; i++) {
	    list.add(2 + i%2);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    list.remove(i);
	}
	for (int i = 0; i < 19*list.INITIAL_SIZE; i++) {
	    assertEquals(list.get(i).intValue(),   3);
	}
    }


    /////////////////////////////////////////
    // Tests below require add(E) (with one param),
    // add(int, E), remove(), and an iterator
    //
    // They don't require slaying the rainbow
    // dragon.
    /////////////////////////////////////////


    @Test
    public void iterEmptyTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	int count = 0;
	int sum = 0;
	for (Integer i : list) {
	    count++;
	    sum += i;
	}
	assertEquals(count, 0);
	assertEquals(sum, 0);
    }


    @Test
    public void iterTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}
	int count = 0;
	int sum = 0;
	for (Integer i : list) {
	    count++;
	    sum += i;
	}
	assertEquals(count, 10);
	assertEquals(sum, (10*9)/2);
    }


    @Test
    public void iterRemoveTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	list.add(0);
	list.add(1);
	list.add(2);
	list.add(3);

	Iterator<Integer> iter = list.iterator();
	iter.next();
	iter.next();
	iter.remove();

	assertEquals(list.size(), 3);
	assertEquals(list.get(0).intValue(), 0);
	assertEquals(list.get(1).intValue(), 2);
	assertEquals(list.get(2).intValue(), 3);
    }


    @Test
    public void iterRemoveLoopTest() {
	DynamicArray<Integer> list = new DynamicArray<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}
	int sum = 0;
	Iterator<Integer> iter = list.iterator();
	while (iter.hasNext()) {
	    if (iter.next() % 2 == 0) {
		iter.remove();
	    }
	}
	for (int i = 0; i < list.size(); i++) {
	    sum += list.get(i).intValue();
	}
	assertEquals(list.size(), 5);
	assertEquals(sum, 1+3+5+7+9);
    }


    /////////////////////////////////////////
    // Tests below require slaying the rainbow
    // dragon.
    /////////////////////////////////////////

    @Test
    public void performanceTest() {
	int num_of_loops = 100;
	int array_size = 10000;
	int actions_per_cell = 3;

	Random r = new Random();

	long array_start_time = System.nanoTime();
	for (int i = 0; i < num_of_loops; i++) {
	    int[] array = new int[array_size];
	    for (int j = 0; j < array_size*actions_per_cell; j++) {
		int index = r.nextInt(array_size);
		array[index] += 1;
	    }
	}
	long array_end_time = System.nanoTime();


	long darray_start_time = System.nanoTime();
	for (int i = 0; i < num_of_loops; i++) {
	    DynamicArray<Integer> darray = new DynamicArray<Integer>();
	    for (int j = 0; j < array_size; j++) {
		darray.add(0);
	    }
	    for (int j = 0; j < array_size*actions_per_cell; j++) {
		int index = r.nextInt(array_size);
		darray.set(index, 1 + darray.get(index).intValue());
	    }
	}
	long darray_end_time = System.nanoTime();

	long array_time = array_end_time - array_start_time;
	long darray_time = darray_end_time - darray_start_time;

	float ratio = darray_time / (float) array_time;

	System.out.println("Ratio was " + ratio);

	assertTrue(ratio < 20.0);
    }
    */
}
