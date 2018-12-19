// Implement a regular expression function isMatch that supports the '.' and '*' symbols. 

class Solution {
  
    static boolean isMatch(String text, String pattern) {
      // your code goes here
      
      return helper(text, pattern, 0, 0);
      
      
    }
    
    static boolean helper(String text, String pattern, int ti, int pi){
      // base case - one of the indexex reached the end of the text or pattern
      if (ti >= text.length()) {
        if (pi >= pattern.length()) {
          return true;
        } else {
          if ( pi + 1 < pattern.length() && pattern.charAt(pi + 1) == '*') {
            return helper(text, pattern, ti, pi +2);
          } else {
            return false;
          }
        }
      }
      
      else if (pi >= pattern.length() && ti < text.length()) {
        return false;
      }
      
      // string matching for character followed by '*'
      else if (pi + 1 < pattern.length() && pattern.charAt(pi) == '*') {
        if (pattern.charAt(pi) == '.' || text.charAt(ti) == pattern.charAt(pi)) {
          // return true if it matches to 0 or more characters
          return helper(text, pattern, ti, pi + 2) || helper(text, pattern, ti + 1, pi);
        }
        else {
          return helper(text, pattern, ti, pi + 2);
        }
      }
      else if (pattern.charAt(pi) == '.' || text.charAt(ti) == pattern.charAt(pi)) {
        return helper(text, pattern, ti + 1, pi + 1);
       } else {
        return false;
       }
         
    }
}  