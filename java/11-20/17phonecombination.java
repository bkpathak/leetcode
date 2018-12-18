class Solution {
    public List<String> letterCombinations(String digits) {
    
        List<String> ans = new LinkedList<>();
        
        if (digits.length() == 0 || digits == null) {
            return ans;
        }
        
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        
        helper(ans, digits, map, "", 0);
        return ans;
    }
    
    private void helper(List<String> ans, String digits, Map<Integer, String> map, String curr, int pos) {
        if (pos == digits.length()) {
            ans.add(curr);
        }
        else {
            String dToC = map.get(digits.charAt(pos) - '0');
            for(char ch: dToC.toCharArray()){
                helper(ans, digits, map, curr + ch, pos + 1);
            }
        } 
    }
}