class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        
        if (sum % 2 == 1) return false;
        
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        
        for (int i =1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] =  dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        
        return dp[nums.length][sum];
        //return helper(nums, sum / 2, 0);
    }
    
    public boolean helper(int[] nums, int sum, int index) {
        if (sum == 0) return true;
        if (index == nums.length) return false;
        
        if (nums[index] > sum) return false;
        return helper(nums, sum - nums[index], index + 1) || helper(nums, sum, index + 1);
    }
}