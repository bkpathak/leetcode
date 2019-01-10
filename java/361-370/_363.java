class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        for (int left = 0; left < n; left++) {
            // array to accumulate sums for each row from left to right
            int[] sums = new int[m];
            
            for (int right = left; right < n; right++) {
                // update sums to include value in current right column
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                // We use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
                TreeSet<Integer> set = new TreeSet<>();
                // add 0 to cover the single row case
                set.add(0);
                int currSum = 0;
                
                for (int sum: sums) {
                    currSum += sum;
                    // We use sum subtraction (currSum - sum) to get the subarray with sum <= k
                    // theredore we need to look for the smallest sum >= currSum - k
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) result = Math.max(result, currSum - num);
                    set.add(currSum);
                }
            }
        }
        
        return result;
        
    }
}