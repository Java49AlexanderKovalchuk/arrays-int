package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import static telran.arrays.MyArraysInt.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MyArraysIntTests {

	@Test
	void testAddNumber() {
		int[] array = {1, 2, 3};
		int expected[] = {1, 2, 3, -1};
		int[]array1 = {};
		int expected1[] = {10};
		assertArrayEquals(expected, addNumber(array, -1));	
		assertArrayEquals(expected1, addNumber(array1, 10));		
	}
	

	@Test
	void testRemoveNumber() {  
		
		int[] array1 = {1, 2, 3, 4, 5};
		int[] expected1 = {2, 3, 4, 5};
		int[] array2 = {1, 2};
		int[] expected2 = {1};
		int[] array3 = {1, 2, 3, 4, 5};
		int[] expected3 = {1, 2, 3, 5};
		int[] array4 = {1};
		int[] expected4 = {};
		int[] array5 = {1, 2, 3};
		int[] expected5 = {1, 2, 3};
				
		assertArrayEquals(expected1, removeNumber(array1, 0));
		assertArrayEquals(expected2, removeNumber(array2, 1));
		assertArrayEquals(expected3, removeNumber(array3, 3));
		assertArrayEquals(expected4, removeNumber(array4, 0));
		assertArrayEquals(expected5, removeNumber(array5, -2));
		assertArrayEquals(expected5, removeNumber(array5, 25));
	}

	@Test
	void testInsertNumber() {
		int[] array1 = {1, 2, 3};
		int[] expected1 = {1, 2, 22, 3};
		int[] array2 = {1, 2, 3, 4};
		int[] expected2 = {11, 1, 2, 3, 4};
		int[] array3 = {1, 2, 3, 4};
		int[] expected3 = {1, 2, 3, 33, 4};
		// note: insert by last index do not works
		int[] array4 = {1, 2, 3};
		int[] expected4 = {1, 2, 3};
		
		assertArrayEquals(expected1, insertNumber(array1, 2, 22));
		assertArrayEquals(expected2, insertNumber(array2, 0, 11));
		assertArrayEquals(expected3, insertNumber(array3, 3, 33));
		assertArrayEquals(expected4, insertNumber(array4, 50, 2));
		assertArrayEquals(expected4, insertNumber(array4, -5, 0));
		
	}
	
	@Test
	void testCopyOf() {
		int array[] = {1, 2, 3};
		int expected1[] = {1, 2, 3};
		int expected2[] = {1};
		int expected3[] = {1, 2, 3, 0, 0, 0};
		assertArrayEquals(expected1, Arrays.copyOf(array, array.length));
		assertArrayEquals(expected2, Arrays.copyOf(array, 1));
		assertArrayEquals(expected3, Arrays.copyOf(array, 6));		  
		
	}
	@Test
	void testArraycopy() {
		int array[] = {1, 2, 3};
		int expected[] = {5, 10, 1, 2, 20}; 
		int arrayDest[] = new int[5];
		int array1[] = {2, 5, 10};
		System.arraycopy(array, 0, arrayDest, 2, 2);
		System.arraycopy(array1, 1, arrayDest, 0, 2);
		arrayDest[4] = 20;
		assertArrayEquals(expected, arrayDest);
	}
	@Test
	void testBinarySearchInt() {		
		int[] array = {10, -5, 0, 2, 7};
		Arrays.sort(array);  //sorted array -5, 0, 2, 7, 10
		assertEquals(4, Arrays.binarySearch(array, 10));
		assertEquals(0, Arrays.binarySearch(array, -5));
		assertEquals(1, Arrays.binarySearch(array, 0));
		int[] array1 = {2};
		assertEquals(0, Arrays.binarySearch(array1, 2));
		//for keys that no contains in the array, by documentation, there is 
		//insert point. In those cases, the return value depends on it and
		//at general it is negative:
		assertEquals(-4, Arrays.binarySearch(array, 6));
		assertEquals(-6, Arrays.binarySearch(array, 20));
		assertTrue(Arrays.binarySearch(array, -25) < 0);
		
	}
	@Test
	void testBinarySearchIntRange() {
		int[] array = {5, 2, 4, 0, 1, 3, -1}; 
		Arrays.sort(array); // -1, 0, 1, 2, 3, 4, 5
		assertEquals(3, Arrays.binarySearch(array, 1, 5, 2));
		assertEquals(1, Arrays.binarySearch(array, 1, 2, 0));
		assertTrue(Arrays.binarySearch(array, 2, 4, 3) < 0);
		
	}

}
