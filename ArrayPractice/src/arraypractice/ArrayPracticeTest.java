/**
 * Antonio Fabrizio
 * Monday, October 23rd, 2023
 * Array Practice
 * Write and fill in tests that deal with arrays
 */
package arraypractice;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayPracticeTest {
	/**
	 * Test of initialize method, of class ArrayPractice.
	 */
	
	@Test
	public void testInitialize() {
		System.out.println("initialize");
		int[] A = new int[5];
		int initialValue = 5;
		ArrayPractice.initialize(A, initialValue);
		assertArrayEquals(new int[] { 5, 5, 5, 5, 5 }, A);
	}

	/**
	 * Test of average method, of class ArrayPractice.
	 */
	@Test
	public void testAverage() {
		System.out.println("average");
		int[] A = { 10, 20, 30, 40, 50 };
		double expResult = 30.0;
		double result = ArrayPractice.average(A);
		assertEquals(expResult, result, 0.1);

		int B[] = { 31 };
		expResult = 31.0;
		result = ArrayPractice.average(B);
		assertEquals(expResult, result, 0.1);
	}

	/**
	 * Test of numOccurrences method, of class ArrayPractice.
	 */
	@Test
	public void testNumOccurrences() {
		System.out.println("numOccurrences");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int x = 16;
		int expResult = 3;
		int result = ArrayPractice.numOccurrences(A, x);
		assertEquals(expResult, result);

		x = 37;
		expResult = 0;
		result = ArrayPractice.numOccurrences(A, x);
		assertEquals(expResult, result);

		x = 21;
		expResult = 1;
		result = ArrayPractice.numOccurrences(A, x);
		assertEquals(expResult, result);
	}

	/**
	 * Test of find method, of class ArrayPractice.
	 */
	@Test
	public void testFind() {
		System.out.println("find");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int x = 37;
		int expResult = -1;
		int result = ArrayPractice.find(A, x);
		assertEquals(expResult, result);

		x = 16;
		expResult = 1;
		result = ArrayPractice.find(A, x);
		assertEquals(expResult, result);
	}

	/**
	 * Test of findLast method, of class ArrayPractice.
	 */
	@Test
	public void testFindLast() {
		System.out.println("findLast");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int x = 37;
		int expResult = -1;
		int result = ArrayPractice.findLast(A, x);
		assertEquals(expResult, result);

		x = 31;
		expResult = 3;
		result = ArrayPractice.findLast(A, x);
		assertEquals(expResult, result);

		x = 16;
		expResult = 11;
		result = ArrayPractice.findLast(A, x);
		assertEquals(expResult, result);
	}

	/**
	 * Test of largest method, of class ArrayPractice.
	 */
	@Test
	public void testLargest() {
		System.out.println("largest");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int expResult = 31;
		int result = ArrayPractice.largest(A);
		assertEquals(expResult, result);
	}

	/**
	 * Test of indexOfLargest method, of class ArrayPractice.
	 */
	@Test
	public void testIndexOfLargest() {
		System.out.println("indexOfLargest");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int expResult = 3;
		int result = ArrayPractice.indexOfLargest(A);
		assertEquals(expResult, result);
	}

	/**
	 * Test of indexOfLargestOdd method, of class ArrayPractice.
	 */
	@Test
	public void testIndexOfLargestOdd() {
		System.out.println("indexOfLargestOdd");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16 };
		int expResult = 3;
		int result = ArrayPractice.indexOfLargestOdd(A);
		assertEquals(expResult, result);

		int[] B = { 20, 16, 4, 32, 8, 2, 8, 2, 16, 4, 2, 16 };
		expResult = -1;
		result = ArrayPractice.indexOfLargestOdd(B);
		assertEquals(expResult, result);
	}

	/**
	 * Test of insert method, of class ArrayPractice.
	 */
	@Test
	public void testInsert() {
		System.out.println("insert");
		int[] A = { 21, 16, 5, 31, 8, 1, 9, 1, 0, 0, 0, 0 };
		int[] B = { 21, 4, 16, 5, 31, 8, 1, 9, 1, 0, 0, 0 };
		int n = 4;
		int index = 1;
		ArrayPractice.insert(A, n, index);
		assertArrayEquals(B, A);
	}

	/**
	 * Test of copyAll method, of class ArrayPractice.
	 */
	@Test
	public void testCopyAll() {
		System.out.println("copyAll");
		int[] A = { 10, 20, 30, 40, 50 };
		int[] B = { 60, 70, 80 };
		int[] expResult = { 10, 20, 30, 40, 50, 60, 70, 80 };
		int[] result = ArrayPractice.copyAll(A, B);
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of reverse method, of class ArrayPractice.
	 */
	@Test
	public void testReverse() {
		System.out.println("reverse");
		int[] A = { 10, 20, 30, 40, 50 };
		int[] B = { 50, 40, 30, 20, 10 };
		ArrayPractice.reverse(A);
		assertArrayEquals(B, A);

        int []C = {10};
        int []D = {10};
		ArrayPractice.reverse(C);
		assertArrayEquals(D, C);
	}

	/**
	 * Test of swap method, of class ArrayPractice.
	 */
	@Test
	public void testSwap() {
	    int[] arr = {10, 20, 30, 40, 50};
	    ArrayPractice.swap(arr, 1, 3);
	    int[] expected = {10, 40, 30, 20, 50};
	    assertArrayEquals(expected, arr);
	}

	/**
	 * Test of isOdd method, of class ArrayPractice.
	 */
	@Test
    public void testIsOdd() {
        assertTrue(ArrayPractice.isOdd(1));   // 1 is odd
        assertTrue(ArrayPractice.isOdd(3));   // 3 is odd
        assertFalse(ArrayPractice.isOdd(2));  // 2 is even
        assertFalse(ArrayPractice.isOdd(4));  // 4 is even
        assertTrue(ArrayPractice.isOdd(-5));  // -5 is odd
        assertFalse(ArrayPractice.isOdd(-8)); // -8 is even
    }
  
	/**
	 * EXTRA CREDIT: uncomment this and fill in your implementation
	 */
	@Test
    public void testGetCol() {
        int[][] matrix = {
            {10, 20, 30, 40},
            {11, 21, 31, 41},
            {12, 22, 32, 42}
        };

        int[] col0 = ArrayPractice.getCol(matrix, 0);
        int[] expectedCol0 = {10, 11, 12};
        assertArrayEquals(expectedCol0, col0);

        int[] col1 = ArrayPractice.getCol(matrix, 1);
        int[] expectedCol1 = {20, 21, 22};
        assertArrayEquals(expectedCol1, col1);

        int[] col2 = ArrayPractice.getCol(matrix, 2);
        int[] expectedCol2 = {30, 31, 32};
        assertArrayEquals(expectedCol2, col2);

        int[] col3 = ArrayPractice.getCol(matrix, 3);
        int[] expectedCol3 = {40, 41, 42};
        assertArrayEquals(expectedCol3, col3);

        // Test an invalid colNum
        int[] invalidCol = ArrayPractice.getCol(matrix, 4);
        assertNull(invalidCol);
    }
}
