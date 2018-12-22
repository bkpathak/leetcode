class Solution {
    public int subarraySumNonNegative(int[] nums, int k) {
        // Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
        int ansCount = 0;
        int currSum = 0;
        
        int left = 0, right = 0;
        
        for (; right < nums.length; right++) {
            currSum += nums[right];
            
            while (currSum > k && left < right) {
                currSum -= nums[left];
                left++;
            }
            
            if (currSum == k) {
                ansCount++;
            } 
        }
        return ansCount; 
    }
    
     public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0, sum = 0;
        
         for (int i =0; i < nums.length; i++) {
             sum += nums[i];
             
             if (map.containsKey(sum - k)) {
                 count += map.get(sum -k);
             }
             
             map.put(sum, map.getOrDefault(sum, 0) + 1);
         }
         return count;
     }
}