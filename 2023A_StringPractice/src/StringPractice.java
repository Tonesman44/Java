/* Antonio Fabrizio
 * Assignment 05 - string practice
 * The purpose of this assignment is -
 * to gain additional practice with sequences, functions, and testing. */

public class StringPractice {

  public static boolean isPunct(char c) {
    // Define a set of punctuation marks
    String punctMarks = ".,;:!?'";
    
    // Check if the character is in the set of punctuation marks
    return punctMarks.contains(String.valueOf(c));
  }

  public static int numPunct(String s) {
    int count = 0;
    
    // Iterate through each character in the string and count punctuation marks
    for (char c : s.toCharArray()) {
      if (isPunct(c)) {
        count++;
      }
    }
    
    return count;
  }
  
  public static int numPunct(String s, int startIndex) {
    int count = 0;
    
    // Iterate through the characters in the string starting from the given index
    for (int i = startIndex; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isPunct(c)) {
        count++;
      }
    }
    
    return count;
  }

  public static int indexOfFirstPunct(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isPunct(c)) {
        return i;
      }
    }
    return -1;
  }

  public static int indexOfLastPunct(String s) {
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (isPunct(c)) {
        return i;
      }
    }
    return -1;
  }

  public static String substitute(String s, char oldChar, char newChar) {
    // Use the replace method to substitute oldChar with newChar
    return s.replace(oldChar, newChar);
  }

  public static String substitutePunct(String s) {
    // Iterate through the string and replace punctuation marks with spaces
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (isPunct(c)) {
        result.append(' ');
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }
  
  public static String withoutPunct(String s) {
    // Use the substitutePunct method to replace punctuation marks with empty strings
    substitutePunct(s);
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (isPunct(c)) {
        result.append("");
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static boolean foundIn(String s, char c) {
    // Use the indexOf method to check if the character is in the string
    return s.indexOf(c) != -1;
  }
  
  public static int numPunctAfterNonPunct(String s) {
	    int count = 0;
	    boolean prevCharIsNonPunct = false;

	    for (int i = 0; i < s.length(); i++) {
	        char currentChar = s.charAt(i);

	            if (isPunct(currentChar)) {
	                if (prevCharIsNonPunct) {
	                    count++;
	                    prevCharIsNonPunct = false; // Reset to avoid double-counting
	                }
	            } else {
	                prevCharIsNonPunct = true;
	            }
	        }

	        return count;
	  }

  
  public static boolean onlyPunct(String s) {
    // Check if the string contains only punctuation marks
    for (char c : s.toCharArray()) {
      if (!isPunct(c)) {
        return false;
      }
    }
    return !s.isEmpty();
  }

  public static boolean noPunct(String s) {
    // Check if the string contains no punctuation marks
    for (char c : s.toCharArray()) {
      if (isPunct(c)) {
        return false;
      }
    }
    return true;
  }

  public static boolean consecutivePuncts(String s) {
    boolean prevCharIsPunct = false;
    
    // Iterate through the string and check for consecutive punctuation marks
    for (char c : s.toCharArray()) {
      if (isPunct(c)) {
        if (prevCharIsPunct) {
          return true;
        }
        prevCharIsPunct = true;
      } else {
        prevCharIsPunct = false;
      }
    }
    
    return false;
  }
}