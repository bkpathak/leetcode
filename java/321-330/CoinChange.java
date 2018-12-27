class Solution {
    public int coinChange(int[] coins, int amount) {
        //return helper (coins, amount, 0, 0);
        int[] dp = new int[amount +1];
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE -1;
            for (int c: coins) {
                if(c <= i) {
                    dp[i] = Math.min(dp[i], dp[i -c] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE -1 ? -1 : dp[amount];
    }
    
    public int helper(int[] coins, int amount, int index, int count) {
        if (amount == 0) return count;
        if (amount < 0 || index == coins.length) return -1;
        int pick = helper(coins, amount - coins[index], index, count + 1);
        int unPick = helper(coins, amount, index + 1, count);
        
        if (pick == -1) return unPick;
        else if(unPick == -1 ) return pick;
        else {
            return Math.min(pick, unPick);
        }
        
        
    }
}