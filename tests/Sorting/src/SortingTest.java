

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class SortingTest {

    @Test
    public void emptySlowTest() {
	int[] array = {};
	Sorting.slowSort(array);
    }

    @Test
    public void oneSlowTest() {
	int[] array = {1};
	Sorting.slowSort(array);
	assertEquals(1, array[0]);
    }


    @Test
    public void twoSlowTest() {
	int[] array = {1,2};
	Sorting.slowSort(array);
	

	assertEquals(1, array[0]);
	assertEquals(2, array[1]);
    }

    @Test
    public void twoTwoSlowTest() {
	int[] array = {2,1};
	Sorting.slowSort(array);
	assertEquals(1, array[0]);
	assertEquals(2, array[1]);
    }

    @Test
    public void inOrderSlowTest() {
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	Sorting.slowSort(array);
	for (int i = 0; i < 10; i++)
	    assertEquals(i+1, array[i]);
    }

    @Test
    public void reverseSlowTest() {
	int[] array = {10,9,8,7,6,5,4,3,2,1};
	Sorting.slowSort(array);
	for (int i = 0; i < 10; i++)
	    assertEquals(i+1, array[i]);
    }


    @Test
    public void randomSlowTest() {
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	for (int i = 0; i < 1000; i++) {
	    Sorting.shuffle(array);
	    Sorting.slowSort(array);
	    
	    for (int j = 0; j < 10; j++){
	    	
	    	
	    	
	    		assertEquals(j+1, array[j]);
	    }
	}
    }


    @Test
    public void largeRandomSlowTest() {
	int[] array = new int[10000];
	for (int i = 0; i < array.length; i++) {
	    array[i] = i+1;
	}
	Sorting.shuffle(array);
	Sorting.slowSort(array);
	for (int j = 0; j < 10; j++) {
	    assertEquals(j+1, array[j]);
	}
    }



    @Test
    public void emptyFastTest() {
	int[] array = {};
	Sorting.fastSort(array);
    }

    @Test
    public void oneFastTest() {
	int[] array = {1};
	Sorting.fastSort(array);
	assertEquals(1, array[0]);
    }


    @Test
    public void twoFastTest() {
	int[] array = {1,2};
	Sorting.fastSort(array);
	assertEquals(1, array[0]);
	assertEquals(2, array[1]);
    }

    @Test
    public void twoTwoFastTest() {
	int[] array = {2,1};
	Sorting.fastSort(array);
	assertEquals(1, array[0]);
	assertEquals(2, array[1]);
    }

    @Test
    public void inOrderFastTest() {
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	Sorting.fastSort(array);
	for (int i = 0; i < 10; i++)
	    assertEquals(i+1, array[i]);
    }

    @Test
    public void reverseFastTest() {
	int[] array = {10,9,8,7,6,5,4,3,2,1};
	Sorting.fastSort(array);
	for (int i = 0; i < 10; i++)
	    assertEquals(i+1, array[i]);
    }


    @Test
    public void randomFastTest() {
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	for (int i = 0; i < 1000; i++) {
	    Sorting.shuffle(array);
	    Sorting.fastSort(array);
	    for (int j = 0; j < 10; j++)
		assertEquals(j+1, array[j]);
	}
    }


    @Test
    public void largeRandomFastTest() {
	int[] array = new int[1000000];
	for (int i = 0; i < array.length; i++) {
	    array[i] = i+1;
	}
	Sorting.shuffle(array);
	Sorting.fastSort(array);
	for (int j = 0; j < 10; j++) {
	    assertEquals(j+1, array[j]);
	}
    }

}
