class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Map<String, List<String>> cache = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (String str: wordDict) set.add(str);
        
        return wordBreak (s, cache, set);
        
    }
    
    public List<String> wordBreak (String s, Map<String, List<String>> cache, Set<String> dict ) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new LinkedList<>();
        
        if (dict.contains(s)) result.add(s);
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i), right = s.substring(i);
            if (dict.contains(left)) {
                for (String ss: wordBreak(right, cache, dict)) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}