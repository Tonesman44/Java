// Antonio Fabrizio
// August 28th 2023
package inclass;

public class inClass {
	public static boolean same(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
	    /* check the lengths. if the lengths
	     * are different, the strings must be different */
	    if (s1.length() != s2.length()) {
	      return false;
	    }
	    /* compare the two strings letter by letter
	     * if we find a pair that are not the same
	     * return false */
	    for (int i = 0; i < s1.length(); i++) {
	      if (s1.charAt(i) != s2.charAt(i)) {
	        return false;
	      }
	    }

	    return true;
	  }
}