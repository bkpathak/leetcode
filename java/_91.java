class Solution {
    public int numDecodings(String s) {        
        int[] dp = new int [s.length() +1];
        dp[0] = 1; // Empty String can be decoded one way
        for (int i = 0 ; i < s.length(); i++) {
            // If char at i is '0' it cannot be decode using individual character
            if (s.charAt(i) != '0') dp[i + 1] = dp[i];
            
            // If th eprevious character is not 0 and the number is less or equalt to 26 it can be decode using two string
            if (i > 0 && s.charAt(i - 1) != '0') {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            } 
        }
        return dp[s.length()];
    }
    
    
    public int helper(int i, String s) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        
        int result = helper( i +1, s);
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26 )  {
            result += helper(i + 2, s);
        }
        return result;
    }
}