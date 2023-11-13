/**
 * Antonio Fabrizio
 * Monday, October 23rd, 2023
 * Array Practice
 * Write and fill in tests that deal with arrays
 */

package arraypractice;

import java.util.Arrays;

public class ArrayPractice {
  /* sets every item in A[] to initialValue */
  public static void initialize(int A[], int initialValue) {
	  Arrays.fill(A, initialValue);
	  return;
  }

  /* returns the average of the items in A
   * Be careful: A[] is an array of int and the method returns
   * double. What do we do to handle this? */
  public static double average(int A[]) {
	  int sum = 0;
	  for(int i = 0; i <A.length; i++) {
		  sum += A[i];
	  }
	  if (A.length > 0) {
		  return (double) sum / A.length;
	  } else {
		  return 0.0;
	  }
  }

  /* returns the number of times that x appears in A[] */
  public static int numOccurrences(int A[], int x) {
	  int count = 0;
	  for (int element: A) {
		  if (element == x) {
			  count++;
		  }
	  }
    return count;
  }


  /* returns the index of the first occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int find(int A[], int x) {
	  for (int i = 0; i < A.length; i++) {
	        if (A[i] == x) {
	            return i;
	        }
	    }
	    return -1; 
  }

  /* returns the index of the last occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int findLast(int A[], int x) {
	  int index = -1;
	  for (int i = 0; i < A.length; i++) {
		  if (A[i] == x) {
			  index = i;
		  }
	  }
	  return index;
  }

  /* returns the largest item found in A */
  public static int largest(int A[]) {
    Arrays.sort(A);
    return A[A.length - 1];
  }
  

  /* returns the index of the largest item found in A */
  public static int indexOfLargest(int A[]) {
	  int largestIndex = 0;
      for (int i = 1; i < A.length; i++) {
          if (A[i] > A[largestIndex]) {
              largestIndex = i;
          }
      }
      return largestIndex;
  }

  /* returns true if x is odd or false otherwise
   * add a JUnit test to test this method in the
   * file ArrayPracticeTest.java  */
  public static boolean isOdd(int x) {
	    return x % 2 != 0; 
	}
  
  /* returns the index of the largest odd number
   * in A[] or -1 if A[] contains no odd numbers
   *
   * include a call to your isOdd(int) method in
   * your solution */
  public static int indexOfLargestOdd(int A[]) {
	  int largestOddIndex = -1;
	    int largestOddValue = Integer.MIN_VALUE;
	    for (int i = 0; i < A.length; i++) {
	        int currentValue = A[i];
	        if (isOdd(currentValue) && currentValue > largestOddValue) {
	            largestOddValue = currentValue;
	            largestOddIndex = i;
	        }
	    }
	    return largestOddIndex;
  }

  /* inserts n into A[] at A[index] shifting all */
  /* the previous items one place to the right. For example */
  /* if A is  */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */

  /*   and we call insert(A, 15, 1), A then becomes */

  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*  the element in A[] that's in the right-most */
  /*    position is removed.                      */
  /*                                              */
  /*  if index < 0 or index >= A.length-1, the method */
  /*                                    does nothing */
  public static void insert(int A[], int n, int index) {
	  if (index < 0 || index >= A.length - 1) {
	        return; // Index is out of bounds, do nothing
	    }
	    System.arraycopy(A, index, A, index + 1, A.length - index - 1);
	    A[index] = n;
  }

  /* returns a new array consisting of all of the
   * elements of A[] followed by all of the
   * elements of B[]. For example, if 
   A[] is: {10,20,30} and 
   B[] is: {5, 9, 38}, the method returns the
   array : {10,20,30,5,9,38} */
  public static int[] copyAll(int A[], int B[]) {
	    int lengthA = A.length;
	    int lengthB = B.length;
	    int[] result = new int[lengthA + lengthB];
	    System.arraycopy(A, 0, result, 0, lengthA);
	    System.arraycopy(B, 0, result, lengthA, lengthB);
	    return result;
	}

  /* exchanges the elements found at A[i] and A[j].
   * Does nothing if i or j is invalid
   *
   * Add a JUnit test to test this method to the
   * file ArrayPracticeTest.java */
  public static void swap(int []A, int i, int j) {
	  if (i < 0 || i >= A.length || j < 0 || j >= A.length) {
	        return; // i or j is invalid, do nothing
	    }
	    int temp = A[i];
	    A[i] = A[j];
	    A[j] = temp;
  }
  
  /* reverses the order of the elements in A[].
   * For example, if A[] is:
   {10,20,30,40,50}, after the method, A[] would
   be {50,40,30,20,10}
   * 
   * use your swap() method in your solution
   *
   * Note that this method sorts the array "in place", i.e.,
   * the original array is changed. No new array is created.
   */
  public static void reverse(int A[]) {
	  int left = 0; // Index of the left-most element
	    int right = A.length - 1; // Index of the right-most element
	    while (left < right) {
	        swap(A, left, right);
	        left++;
	        right--;
	    }
  }
  
  /* returns the specified column from [][]A as a single-dimensional
   * array, or null if colNum is invalid.
   *
   * for example, if A is
   * |---+----+----+----+----|
   * |   |  0 |  1 |  2 |  3 |
   * |---+----+----+----+----|
   * | 0 | 10 | 20 | 30 | 40 |
   * | 1 | 11 | 21 | 31 | 41 |
   * | 2 | 12 | 22 | 32 | 42 |
   * |---+----+----+----+----|
   *
   * and colNum is 1, the array returned is:
   *
   * |----+----+----|
   * |  0 |  1 |  2 |
   * |----+----+----|
   * | 20 | 21 | 22 |
   * |----+----+----|
   *
   * Extra credit: add a JUnit test for this method
   * to the file ArrayPracticeTest.java
   */
  public static int[] getCol(int [][]A, int colNum) {
		    if (colNum < 0 || colNum >= A[0].length) {
		        return null; // Invalid column
		    }
		    int numRows = A.length;
		    int[] col = new int[numRows];
		    for (int i = 0; i < numRows; i++) {
		        col[i] = A[i][colNum];
		    }
		    return col;
		}
}
