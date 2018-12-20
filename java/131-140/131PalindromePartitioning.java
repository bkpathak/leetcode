class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        helper(ans, s, new LinkedList<String>(), 0);
        return ans;
    }
    public void helper(List<List<String>> ans, String s, List<String>path, int pos ) {
        if (pos == s.length()) {
            ans.add(new LinkedList(path));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPalindrome(s, pos, i)) {
                    path.add(s.substring(pos, i+1));
                    helper(ans, s, path, i+1);
                    path.remove(path.size() -1);
                }
                
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
             if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}