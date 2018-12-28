class Solution {
    public int change(int amount, int[] coins) {
        //return helper(amount, coins, 0);
        
        int[][] dp= new int[coins.length +1][amount +1];
        dp[0][0] = 1;
        
        for (int i =1; i <= coins.length; i++ ) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                // not including 
                int x = dp[i-1][j];
                // including
                int y = 0;
                if (j >= coins[i-1]) {
                    y = dp[i][j - coins[i-1]];
                }
                dp[i][j] =  x +y; 
               
            }
        }
        
        return dp[coins.length][amount];
        
        
    }
    
    public int helper(int amount, int[] coins, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;
        
        return helper(amount - coins[index], coins, index) + helper(amount, coins, index + 1);
    }
}