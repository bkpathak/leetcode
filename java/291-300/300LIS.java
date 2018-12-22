class Solution {
    public int lengthOfLISRecrsive(int[] nums) {
        return helper(nums, Integer.MIN_VALUE, 0);
    }
    
    private int helper(int[] nums, int prev, int pos){
        if (pos == nums.length) {
            return 0;
        }
        
        int maxI = 0, maxE = 0;
        
        if (nums[pos] > prev) {
            maxI = 1 + helper(nums, nums[pos], pos+1);
        }
        maxE =  helper(nums, prev, pos + 1);
        return Math.max(maxI, maxE);
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) { 
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[i -1]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}